package com.auto.time.servlets;

import com.auto.time.Model.Brand;
import com.auto.time.Model.Model;
import com.auto.time.dao.ModelDao;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Romachka on 25.04.16.
 */
@WebServlet("/DeleteModel")
public class DeleteModel extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Brand brand = new Brand();

        long modelId = Long.valueOf((Long)session.getAttribute("model_id"));

        long brandId = Long.valueOf((Long)session.getAttribute("brand_id"));

        brand.setId(brandId);

        Model model = new Model();

        model.setId(modelId);

        model.setBrand(brand);

        ModelDao modelDao = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(ModelDao.class);

        modelDao.deleteModel(model);

        resp.sendRedirect("Pages/Models.jsp");
    }
}
