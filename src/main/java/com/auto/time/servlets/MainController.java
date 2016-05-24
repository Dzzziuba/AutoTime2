package com.auto.time.servlets;

import com.auto.time.Model.Brand;
import com.auto.time.Model.Model;
import com.auto.time.Model.Variant;
import com.auto.time.dao.BrandDao;
import com.auto.time.dao.ModelDao;
import com.auto.time.dao.UserDao;
import com.auto.time.dao.VariantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Romachka on 04.05.16.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    UserDao userDao;
    @Autowired
    BrandDao brandDao;
    @Autowired
    ModelDao modelDao;
    @Autowired
    VariantDao variantDao;

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String redirectLogin(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/Login.jsp";
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public String logsuccess(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/Pages/Brands.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/Pages/Brands.jsp";
    }


    //    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    //
    //    public String sayHello(HttpServletRequest request, HttpServletResponse response, @ModelAttribute User user) {
    //
    //
    //        String login = request.getParameter("j_username");
    //        String password = request.getParameter("j_password");
    //        user.setUserPassword(password);
    //        user.setUserLogin(login);
    //        User us = userDao.login(user);
    //
    //        if (us != null) {
    //            HttpSession session = request.getSession(true);
    //            session.setAttribute("Login", true);
    //            session.setAttribute("UserName", us.getUserName());
    //            try {
    //                response.sendRedirect("/Pages/Brands.jsp");
    //            } catch (Exception e) {
    //                e.printStackTrace();
    //            }
    //            return "/Pages/Brands.jsp";
    //
    //        } else {
    //            return "/WEB-INF/Login.jsp";
    //
    //        }
    //    }

    @RequestMapping(value = "/admin/AddBrand", method = RequestMethod.GET)
    public String redirectBrand(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/AddBrand.jsp";
    }

    @RequestMapping(value = "/admin/AddBrand", method = RequestMethod.POST)
    public String addBrand(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Brand brand) {
        String brandName = request.getParameter("brand");
        brandName = brandName.trim();
        if (!(brandName.compareTo("") == 0 || brandName.compareTo(" ") == 0 || brandName.compareTo("	") == 0)) {
            brand.setBrandName(brandName);
            brandDao.addNewBrand(brand);
        }
        try {
            response.sendRedirect("/Pages/Brands.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/Pages/Brands.jsp";
    }


    @RequestMapping(value = "/admin/DeleteBrand", method = RequestMethod.GET)
    public String deleteBrand(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Brand brand) {
        HttpSession session = request.getSession();
        long brandId = Long.valueOf((Long) session.getAttribute("brand_id"));
        brand.setId(brandId);
        brandDao.deleteBrand(brand);
        try {
            response.sendRedirect("/Pages/Brands.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/Pages/Brands.jsp";
    }


    @RequestMapping(value = "/admin/AddModel", method = RequestMethod.GET)
    public String redirectModel(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/AddModel.jsp";
    }

    @RequestMapping(value = "/admin/AddModel", method = RequestMethod.POST)
    public String addModel(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Model model) {
        long brandId = Long.valueOf(request.getParameter("brand_id"));
        String modelName = request.getParameter("model_name").trim();
        if (!(modelName.compareTo("") == 0 || modelName.compareTo(" ") == 0 || modelName.compareTo("	") == 0)) {
            Brand brand = brandDao.getById(brandId);
            model.setBrand(brand);
            model.setModelName(modelName);
            modelDao.addNewModel(model);
        }

        HttpSession session = request.getSession();
        try {
            response.sendRedirect("/Pages/Models.jsp?brand_id=" + brandId + "&brand_name=" + session.getAttribute("brand_name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/Pages/Models.jsp?brand_id=" + brandId + "&brand_name=" + session.getAttribute("brand_name");
    }


    @RequestMapping(value = "/admin/DeleteModel", method = RequestMethod.GET)
    public String delModel(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Model model) {
        HttpSession session = request.getSession();
        long modelId = Long.valueOf((Long) session.getAttribute("model_id"));
        long brandId = Long.valueOf((Long) session.getAttribute("brand_id"));
        Brand brand = brandDao.getById(brandId);
        model.setId(modelId);
        model.setModelName((String) session.getAttribute("model_name"));
        model.setBrand(brand);
        modelDao.deleteModel(model);
        try {
            response.sendRedirect("Pages/Models.jsp?brand_id=" + brand.getId() + "&brand_name=" + brand.getBrandName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Pages/Models.jsp?brand_id=" + brand.getId() + "&brand_name=" + brand.getBrandName();
    }


    @RequestMapping(value = "/admin/AddVariant", method = RequestMethod.GET)
    public String redirectVariant(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/AddVariant.jsp";
    }


    @RequestMapping(value = "/admin/AddVariant", method = RequestMethod.POST)
    public String addVariant(HttpServletRequest request, HttpServletResponse response, @ModelAttribute @Valid Variant variant, BindingResult result) {

        long brandId = Long.valueOf(request.getParameter("brand_id"));
        long modelId = Long.valueOf(request.getParameter("model_id"));
        if (result.hasErrors()) {
            try {
                response.sendRedirect("/Pages/Variants.jsp?brand_id=" + brandId + "&brand_name=" +
                                              request.getSession().getAttribute("brand_name") + "&model_id=" + modelId +
                                              "&model_name=" + request.getSession().getAttribute("model_name"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            Brand brand = new Brand();
            brand.setId(brandId);
            Model model = new Model();
            model.setId(modelId);
            variant.setBrand(brand);
            variant.setModel(model);
            variantDao.addNewVariant(variant);
            try {
                response.sendRedirect("/Pages/Variants.jsp?brand_id=" + brandId + "&brand_name=" +
                                              request.getSession().getAttribute("brand_name") + "&model_id=" + modelId +
                                              "&model_name=" + request.getSession().getAttribute("model_name"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "/Pages/Variants.jsp?brand_id=" + brandId + "&brand_name=" +
                       request.getSession().getAttribute("brand_name") + "&model_id=" + modelId +
                       "&model_name=" + request.getSession().getAttribute("model_name");
    }

    @RequestMapping(value = "/admin/EditVariant", method = RequestMethod.GET)
    public String redirectVariant(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Variant variant) {
        HttpSession session = request.getSession();
        return "/WEB-INF/EditVariant.jsp?variant_id=" + session.getAttribute("variant_id");
    }

    @RequestMapping(value = "/admin/EditVariant", method = RequestMethod.POST)
    public String editVariant(HttpServletRequest request, HttpServletResponse response, @ModelAttribute @Valid Variant variant, BindingResult result) {
        HttpSession session = request.getSession();
        Variant variant2 = variantDao.getVariantById((Long) session.getAttribute("variant_id"));

        if (result.hasErrors()) {
            try {
                response.sendRedirect("/Pages/Variant.jsp?model_id=" + session.getAttribute("model_id") + "&model_name=" + session.getAttribute("model_name") +
                                              "&variant_id=" + session.getAttribute("variant_id") + "&variant_name=" + request.getParameter("variant_name"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            variant.setId(variant2.getId());
            variant.setBrand(variant2.getBrand());
            variant.setModel(variant2.getModel());
            variantDao.editVariant(variant);
            try {
                response.sendRedirect("/Pages/Variant.jsp?model_id=" + session.getAttribute("model_id") + "&model_name=" + session.getAttribute("model_name") +
                                              "&variant_id=" + session.getAttribute("variant_id") + "&variant_name=" + variant.getVariantName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "/Pages/Variant.jsp?model_id=" + session.getAttribute("model_id") + "&model_name=" + session.getAttribute("model_name") +
                       "&variant_id=" + session.getAttribute("variant_id") + "&variant_name=" + request.getParameter("variant_name");
    }
}


//Придумать что-то с pathvariable для того, чтобы изменить rewrite url, так как очень галимо получилось и не гибко