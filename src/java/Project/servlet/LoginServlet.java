/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.servlet;

import Project.controller.UserJpaController;
import Project.model.User;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
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
        request.getRequestDispatcher("/login.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserJpaController userController = new UserJpaController(utx, emf);
        User user = userController.findUserByEmail(email);
        if(user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            session.setAttribute("success", "เข้าสู่ระบบเรียบร้อย");
            if(session.getAttribute("prevLocation") != null) {
                response.sendRedirect((String)session.getAttribute("prevLocation"));
            } else {
                response.sendRedirect("home");
            }
        } else {
            session.setAttribute("error", "ข้อมูลไม่ถูกต้อง กรุณาตรวจสอบอีกครั้ง");
            session.setAttribute("email", email);
            response.sendRedirect("login");
        }
    }

}
