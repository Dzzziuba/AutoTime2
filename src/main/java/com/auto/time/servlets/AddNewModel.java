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
import java.io.IOException;

/**
 * Created by Romachka on 21.04.16.
 */
@WebServlet("/AddNewModel")
public class AddNewModel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long brandId = Long.valueOf(req.getParameter("brand_id"));
        Brand brand = new Brand();
        brand.setId(brandId);
        String modelName = req.getParameter("model_name").trim();
        if (!(modelName.compareTo("") == 0 || modelName.compareTo(" ") == 0 || modelName.compareTo("	") == 0)) {
            Model model = new Model();
            model.setBrand(brand);
            model.setModelName(modelName);
            ModelDao modelDao = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(ModelDao.class);
            modelDao.addNewModel(model);
        }
        resp.sendRedirect("Pages/Models.jsp?brand_id=" + brandId + "&brand_name=" + req.getParameter("brand_id"));

    }
}
