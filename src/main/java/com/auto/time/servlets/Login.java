package com.auto.time.servlets;

import com.auto.time.Model.User;
import com.auto.time.dao.UserDao;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Romachka on 20.04.16.
 */
@WebServlet("/admin")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = String.valueOf(req.getParameter("login"));
        String password = String.valueOf(req.getParameter("password"));

        User user = new User();

        user.setUserLogin(login);
        user.setUserPassword(password);

        UserDao userDAO = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(UserDao.class);

        if (userDAO.login(user)) {
            resp.sendRedirect("Pages/Brands.jsp");
            HttpSession session = req.getSession(true);

            session.setAttribute("Login", true);


        } else {
            resp.sendRedirect("Pages/Login.jsp");
        }


    }
}
