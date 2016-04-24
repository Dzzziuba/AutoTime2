package com.auto.time.servlets;

import com.auto.time.Model.Brand;
import com.auto.time.dao.BrandDao;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Romachka on 23.04.16.
 */
@WebServlet("/DeleteBrand")
public class DeleteBrand extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();



        long brandId = Long.valueOf((Long)session.getAttribute("brand_id"));

        Brand brand = new Brand();

        brand.setId(brandId);

        BrandDao brandDAO = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BrandDao.class);

        brandDAO.deleteBrand(brand);

        resp.sendRedirect("Pages/Brands.jsp");
    }
}
