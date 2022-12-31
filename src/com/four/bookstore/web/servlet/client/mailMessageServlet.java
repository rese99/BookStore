package com.four.bookstore.web.servlet.client;

import com.four.bookstore.dao.UserDao;
import com.four.bookstore.domain.User;
import com.four.bookstore.utils.MailUtils;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class mailMessageServlet extends HttpServlet {
    private UserDao dao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mess;
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        String email = request.getParameter("email");
        String username = request.getParameter("name");
        String telephone = request.getParameter("phone");

        try {
            User user = dao.forget(username, telephone, email);
            if (user != null) {
                mess="{\"mess\":\"true\"}";
                int hashCode = java.util.UUID.randomUUID().toString().hashCode();
                if (hashCode < 0) {
                    hashCode = -hashCode;
                }
                String format = String.format("%010d", hashCode).substring(0, 5);
                request.getSession().setAttribute("mail",format);
                request.getSession().setAttribute("sendtime",new Date().getTime());
                MailUtils.sendMail("1211477093@qq.com", "你的验证码是["+format+"],五分钟内有效，请勿告诉他人！","找回密码");
            }else {
                mess="{\"mess\":\"false\"}";
            }
            response.getWriter().write(mess);
        } catch (SQLException | MessagingException throwables) {
            throwables.printStackTrace();
        }
    }
}

