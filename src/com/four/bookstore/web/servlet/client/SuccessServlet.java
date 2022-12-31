package com.four.bookstore.web.servlet.client;

import com.four.bookstore.dao.UserDao;
import com.four.bookstore.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class SuccessServlet extends HttpServlet {
    UserDao dao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String Phone = request.getParameter("Phone");
        String email = request.getParameter("email");
        String username = request.getParameter("username");

        try {
            int x = dao.UpdatePassword(username,email,password,Phone,gender);
            if (x > 0) {
                response.getWriter().write("{\"mess\":\"修改成功\"}");
                HttpSession session= request.getSession();
                session.removeAttribute("user");
            } else {
                response.getWriter().write("{\"mess\":\"修改失败\"}");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
