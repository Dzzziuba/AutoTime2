package com.auto.time.servlets;

import com.auto.time.Model.Brand;
import com.auto.time.Model.Model;
import com.auto.time.Model.Variant;
import com.auto.time.dao.VariantDao;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Romachka on 22.04.16.
 */
@WebServlet("/AddNewVariant")
public class AddNewVariant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/AddVariant.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long brandId = Long.valueOf(req.getParameter("brand_id"));
        long modelId = Long.valueOf(req.getParameter("model_id"));
        Brand brand = new Brand();
        brand.setId(brandId);
        Model model = new Model();
        model.setId(modelId);
        String variantName = req.getParameter("variant_name").trim();
        String engine = req.getParameter("engine").trim();
        String expertRating = req.getParameter("expert_rating").trim();
        String fuelEconomy = req.getParameter("fuel_economy").trim();
        String horsePower = req.getParameter("horse_power").trim();
        String driveTrain = req.getParameter("drive_train").trim();
        String fuelType = req.getParameter("fuel_type").trim();
        if (!(variantName.compareTo("") == 0 || variantName.compareTo(" ") == 0 || variantName.compareTo("	") == 0) &&
                !(engine.compareTo("") == 0 || engine.compareTo(" ") == 0 || engine.compareTo("	") == 0) &&
                !(expertRating.compareTo("") == 0 || expertRating.compareTo(" ") == 0 || expertRating.compareTo("	") == 0) &&
                !(fuelEconomy.compareTo("") == 0 || fuelEconomy.compareTo(" ") == 0 || fuelEconomy.compareTo("	") == 0) &&
                !(horsePower.compareTo("") == 0 || horsePower.compareTo(" ") == 0 || horsePower.compareTo("	") == 0) &&
                !(driveTrain.compareTo("") == 0 || driveTrain.compareTo(" ") == 0 || driveTrain.compareTo("	") == 0) &&
                !(fuelType.compareTo("") == 0 || fuelType.compareTo(" ") == 0 || fuelType.compareTo("	") == 0)) {
            Variant variant = new Variant();
            variant.setBrand(brand);
            variant.setModel(model);
            variant.setVariantName(variantName);
            variant.setEngine(engine);
            variant.setExpertRating(expertRating);
            variant.setFuelEconomy(fuelEconomy);
            variant.setHorsePower(horsePower);
            variant.setDriveTrain(driveTrain);
            variant.setFuelType(fuelType);


            VariantDao variantDao = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(VariantDao.class);
            variantDao.addNewVariant(variant);


        }
        resp.sendRedirect("Pages/Variants.jsp?brand_id=" + brandId + "&brand_name=" +
                req.getSession().getAttribute("brand_name") + "&model_id=" + modelId +
                "&model_name=" + req.getSession().getAttribute("model_name"));

    }
}
