/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.servlet;

import Project.controller.UserJpaController;
import Project.controller.exceptions.RollbackFailureException;
import Project.model.User;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "LuiShopPU")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction utx;
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
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
        
        if(session.getAttribute("email") != null) {
            request.setAttribute("email", session.getAttribute("email"));
            request.setAttribute("firstName", session.getAttribute("old"));
            request.setAttribute("lastName", session.getAttribute("lastName"));
            request.setAttribute("mobileNumber", session.getAttribute("mobileNumber"));
            
            session.setAttribute("email", null);
            session.setAttribute("firstName", null);
            session.setAttribute("lastName", null);
            session.setAttribute("mobileNumber", null);
        }
        request.getRequestDispatcher("/register.jsp").forward(request, response);
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
        String errorMessage = null;
        UserJpaController userController = new UserJpaController(utx, emf);
        
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String confirmPassword = request.getParameter("password_confirmation").trim();
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String mobileNumber = request.getParameter("mobileNumber").trim();

        if(!validate(email)) {
            errorMessage = "โปรดตรวจสอบรูปแบบของอีเมลล์ให้ถูกต้อง";
        } else if(password.length() < 6) {
            errorMessage = "รหัสผ่านต้องมีความยาวตั้งแต่ 6 ตัวอักษรขึ้นไป";
        } else if(!password.equals(confirmPassword)) {
            errorMessage = "กรุณายืนยันรหัสผ่านให้เหมือนกัน";
        } else {
            User user = userController.findUserByEmail(email);
            if(user != null) {
                errorMessage = "อีเมลล์นี้ถูกใช้งานแล้ว";
            }
        }
                
        if(errorMessage != null) {
            session.setAttribute("error", errorMessage);
            session.setAttribute("email", email);
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            session.setAttribute("mobileNumber", mobileNumber);
            response.sendRedirect("register");
        } else {
            User user = new User();
            try {
                user.setId(userController.getUserCount()+1);
                user.setEmail(email);
                user.setPassword(password);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setMobileNumber(mobileNumber);
                user.setCreatedAt(new Date());
                user.setUpdatedAt(new Date());
                userController.create(user);
            } catch (RollbackFailureException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                session.setAttribute("error", "เกิดข้อผิดพลาดในการสมัครสมาชิก");
                response.sendRedirect("register");
            } finally {
                session.setAttribute("user", user);
                session.setAttribute("success", "สมัครสมาชิกเรียบร้อย");
                response.sendRedirect("home");
            }
        }
        
    }
    

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
}
