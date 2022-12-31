package com.four.bookstore.web.servlet.client;

import com.four.bookstore.dao.UserDao;
import com.four.bookstore.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

public class CheckSureServlet extends HttpServlet {
    private UserDao dao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String Phone = request.getParameter("Phone");
        String mailMessage = request.getParameter("mailMessage");
        String verify = request.getParameter("verify");
        String mail = (String) request.getSession().getAttribute("mail");
        long time = (long) request.getSession().getAttribute("sendtime");
        String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
        time = System.currentTimeMillis() - time;
        if (!mailMessage.equals(mail)) {
            response.getWriter().write("{\"mess\":\"邮箱验证码输入错误\"}");
            return;
        } else if (time / 1000 / 60 > 5) {
            response.getWriter().write("{\"mess\":\"邮箱验证码已超时\"}");
            return;
        } else if (!verify.equals(checkcode_session)) {
            response.getWriter().write("{\"mess\":\"效验码输入错误\"}");
            return;
        } else {
            response.getWriter().write("{\"mess\":\"密码重置成功\"}");
            try {
                dao.UpdateUser(password, username, email, Phone);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return;
        }
    }
}
