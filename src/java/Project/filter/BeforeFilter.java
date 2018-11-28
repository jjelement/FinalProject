/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.filter;

import Project.controller.BrandJpaController;
import Project.model.ShoppingCart;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Joeseph-PC
 */
@WebFilter(filterName = "BeforeFilter", urlPatterns = {"/*"})
public class BeforeFilter implements Filter {
    
    @PersistenceUnit(unitName = "LuiShopPU")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction utx;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        if(session.getAttribute("error") != null) {
            request.setAttribute("error", session.getAttribute("error"));
            session.setAttribute("error", null);
        }
        if(session.getAttribute("success") != null) {
            request.setAttribute("success", session.getAttribute("success"));
            session.setAttribute("success", null);
        }
        
        if(session.getAttribute("cart") == null) {
            ShoppingCart cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        
        BrandJpaController brandController = new BrandJpaController(utx, emf);
        request.setAttribute("brands", brandController.findBrandEntities());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
