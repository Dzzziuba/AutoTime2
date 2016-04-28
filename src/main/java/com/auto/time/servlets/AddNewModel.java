package com.auto.time.servlets;

import com.auto.time.Model.Brand;
import com.auto.time.Model.Model;
import com.auto.time.dao.BrandDao;
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
 * Created by Romachka on 21.04.16.
 */
@WebServlet("/AddNewModel")
public class AddNewModel extends HttpServlet {
    //    @Autowired
//    BrandDao brandDao;
//    @Autowired
//    ModelDao modelDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/AddModel.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long brandId = Long.valueOf(req.getParameter("brand_id"));


        String modelName = req.getParameter("model_name").trim();
        if (!(modelName.compareTo("") == 0 || modelName.compareTo(" ") == 0 || modelName.compareTo("	") == 0)) {
            BrandDao brandDao = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BrandDao.class);

            Brand brand = brandDao.getById(brandId);

            Model model = new Model();
            model.setBrand(brand);
            model.setModelName(modelName);
            ModelDao modelDao = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(ModelDao.class);
            modelDao.addNewModel(model);
        }
        HttpSession session = req.getSession();
        resp.sendRedirect("Pages/Models.jsp?brand_id=" + brandId + "&brand_name=" + session.getAttribute("brand_name"));

    }
}
// Для брєнда сделать find by id добавіть туда model і только потом сетить бренд модели и добавлять модель
//сделать для дао обїектов автоваерд