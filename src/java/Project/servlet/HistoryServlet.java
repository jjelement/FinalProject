/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.servlet;

import Project.controller.UserJpaController;
import Project.model.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "HistoryServlet", urlPatterns = {"/history"})
public class HistoryServlet extends HttpServlet {
    
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
        User user = (User) session.getAttribute("user");
        
        if(user != null) {
            UserJpaController userController = new UserJpaController(utx, emf);
            user = userController.findUser(user.getId());
            session.setAttribute("user", user);
            if(request.getParameter("id") != null) {
                try {
                    request.setAttribute("order", user.getProductOrderList().get(Integer.parseInt(request.getParameter("id"))-1));
                    request.getRequestDispatcher("/history.jsp").forward(request, response);
                } catch(Exception e) {
                    response.sendRedirect("history");
                }
                
            } else {
                request.setAttribute("orderList", user.getProductOrderList());
                request.getRequestDispatcher("/historyList.jsp").forward(request, response);
            }
        } else {
            session.setAttribute("error", "กรุณาเข้าสู่ระบบก่อน");
            session.setAttribute("prevLocation", "checkout");
            response.sendRedirect("login");
        }
    }

}
