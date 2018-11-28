/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.servlet;

import Project.controller.BrandJpaController;
import Project.controller.ProductJpaController;
import Project.model.Brand;
import Project.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "BrandServlet", urlPatterns = {"/brand"})
public class BrandServlet extends HttpServlet {
    
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
            Integer id = Integer.parseInt(request.getParameter("id"));
            BrandJpaController brandController = new BrandJpaController(utx, emf);
            ProductJpaController productController = new ProductJpaController(utx, emf);
            
            request.setAttribute("name", request.getParameter("name") == null ? "" : request.getParameter("name"));
            request.setAttribute("price", request.getParameter("price") == null ? "0,10000" : request.getParameter("price"));
            
            String price = (String)request.getAttribute("price");
            String name = (String)request.getAttribute("name");
            String[] priceRange = price.split(",");
            
            Brand brand = brandController.findBrand(id);

            if(brand == null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("error", "ไม่พบแบรนด์สินค้านี้");
                response.sendRedirect("home");
            } else {
                List<Product> products = productController.searchProduct(brand, name, Integer.parseInt(priceRange[0]), Integer.parseInt(priceRange[1]));
                request.setAttribute("brand", brand);
                request.setAttribute("products", products);
                request.getRequestDispatcher("/brand.jsp").forward(request, response);
            }
        } catch(Exception e) {
            System.out.println(e);
            response.sendRedirect("home");
        }
    }
}
