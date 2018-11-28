package Project.servlet;

import Project.controller.BrandJpaController;
import Project.model.Brand;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Joeseph-PC
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    
    @PersistenceUnit(unitName = "LuiShopPU")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction utx;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BrandJpaController brandJpaController = new BrandJpaController(utx, emf);
        
        List<Brand> brands = brandJpaController.findBrandEntities(3, 0);
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
