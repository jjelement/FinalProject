package Project.servlet;

import Project.controller.ProductOrderItemJpaController;
import Project.controller.ProductOrderJpaController;
import Project.controller.exceptions.RollbackFailureException;
import Project.model.LineItem;
import Project.model.ProductOrder;
import Project.model.ProductOrderItem;
import Project.model.ShoppingCart;
import Project.model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Joeseph-PC
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "LuiShopPU")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction utx;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        User user = (User)session.getAttribute("user");
        
        if(user == null) {
            session.setAttribute("error", "กรุณาเข้าสู่ระบบก่อน");
            session.setAttribute("prevLocation", "checkout");
            response.sendRedirect("login");
        } else if(cart.getTotalQuantity() == 0) {
            session.setAttribute("error", "คุณยังไม่มีสินค้าในตะกร้า");
            response.sendRedirect("cart");
        } else {
            request.getRequestDispatcher("/checkout.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        User user = (User)session.getAttribute("user");
        
        if(cart.getTotalQuantity() == 0) {
            session.setAttribute("error", "คุณยังไม่มีสินค้าในตะกร้า");
            response.sendRedirect("cart");
        } else {
            ProductOrderJpaController orderController = new ProductOrderJpaController(utx, emf);
            ProductOrderItemJpaController orderItemController = new ProductOrderItemJpaController(utx, emf);
            List<ProductOrderItem> products = new ArrayList<>();
            
            ProductOrder order = new ProductOrder();
            order.setId(orderController.getProductOrderCount()+1);
            order.setUserId(user);
            order.setTotalPrice(cart.getTotalPrice().doubleValue());
            order.setTotalQty(cart.getTotalQuantity());
            order.setCreatedAt(new Date());
            
            try {
                orderController.create(order);
            } catch (Exception ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(LineItem item : cart.getLineItems()) {
                ProductOrderItem product = new ProductOrderItem();
                product.setId(orderItemController.getProductOrderItemCount()+products.size()+1);
                product.setOrderId(order);
                product.setPrice(item.getTotalPrice().doubleValue());
                product.setProductId(item.getProduct());
                product.setQty(item.getQuantity());
                
                try {
                    orderItemController.create(product);
                    products.add(product);
                } catch (Exception ex) {
                    Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            order.setProductOrderItemList(products);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }
    }

}
