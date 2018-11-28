/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.servlet;

import Project.controller.ProductJpaController;
import Project.model.Product;
import Project.model.ShoppingCart;
import java.io.IOException;
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
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    
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
        try {
            Integer productId = Integer.parseInt(request.getParameter("id"));
            ProductJpaController productController = new ProductJpaController(utx, emf);
            Product product = productController.findProduct(productId);
            
            if(product == null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("error", "ไม่พบสินค้านี้");
                response.sendRedirect("home");
            } else {
                request.setAttribute("product", product);
                request.getRequestDispatcher("/product.jsp").forward(request, response);
            }
        } catch(Exception e) {
            System.out.println(e);
            response.sendRedirect("home");
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
        Integer productId = null;
        try {
            productId = Integer.parseInt(request.getParameter("id"));
            ProductJpaController productController = new ProductJpaController(utx, emf);
            Product product = productController.findProduct(productId);
            
            HttpSession session = request.getSession(true);
            
            if(product == null) {
                session.setAttribute("error", "ไม่พบสินค้านี้");
                response.sendRedirect("home");
            } else {
                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                cart.add(product);
                session.setAttribute("cart", cart);
                session.setAttribute("success", "เพิ่มสินค้าลงตะกร้าแล้ว");
            response.sendRedirect("product?id="+productId);
            }
        } catch(Exception e) {
            System.out.println(e);
            response.sendRedirect("home");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
