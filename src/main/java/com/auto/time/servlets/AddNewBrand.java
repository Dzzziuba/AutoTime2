package com.auto.time.servlets;

import com.auto.time.Model.Brand;
import com.auto.time.dao.BrandDao;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Romachka on 17.04.16.
 */
@WebServlet("/AddNewBrand")
public class AddNewBrand extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String brandName = req.getParameter("brand");
        brandName = brandName.trim();
        if (!(brandName.compareTo("") == 0 || brandName.compareTo(" ") == 0 || brandName.compareTo("	") == 0)) {
            Brand brand = new Brand();
            brand.setBrandName(brandName);
            BrandDao brandDAO = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BrandDao.class);
            brandDAO.addNewBrand(brand);
        }
        resp.sendRedirect("Pages/Brands.jsp");

    }
}
