package com.four.bookstore.web.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.four.bookstore.dao.UserDao;
import com.four.bookstore.utils.HttpUtils;
import org.apache.commons.beanutils.BeanUtils;

import com.four.bookstore.domain.User;
import com.four.bookstore.exception.RegisterException;
import com.four.bookstore.service.UserService;
import com.four.bookstore.utils.ActiveCodeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    UserDao dao = new UserDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8"); //转码
        String verify = request.getParameter("verify");
        String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
        String username = request.getParameter("username");
        User users = new User();
        try {
            users = dao.findUserByUsername(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (!verify.equals(checkcode_session)) {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('效验码错误！');");
            out.println("history.back();");
            out.println("</script>");
            return;
        } else if (users != null) {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('该用户名已存在！');");
            out.println("history.back();");
            out.println("</script>");
            return;
        } else {

            String name = request.getParameter("name");
            String ID = request.getParameter("ID");
            String value = "null";

//		校验身份是否合法
            String host = "https://idenauthen.market.alicloudapi.com";
            String path = "/idenAuthentication";
            String method = "POST";
            String appcode = "1bd66126b29e4d68919a452310c2c291";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            //根据API的要求，定义相对应的Content-Type
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            Map<String, String> querys = new HashMap<String, String>();
            Map<String, String> bodys = new HashMap<String, String>();
            bodys.put("idNo", ID);
            bodys.put("name", name);
            try {
                HttpResponse response1 = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response1.toString());
                //获取response的body
                value = EntityUtils.toString(response1.getEntity());
//            System.out.println(EntityUtils.toString(response1.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (value.indexOf("身份证信息匹配") > 1) {
//      将表单提交的数据封装到javaBean
//		新建一个user对象实现注册写入
                User user = new User();
                try {
                    BeanUtils.populate(user, request.getParameterMap());
                    // 封裝激活码
                    user.setActiveCode(ActiveCodeUtils.createActiveCode());

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

                // 调用service完成注册操作。
                UserService service = new UserService();
                try {
                    service.register(user);
                } catch (RegisterException e) {
                    e.printStackTrace();
                    response.getWriter().write(e.getMessage());
                    return;
                }
                // 注册成功，跳转到registersuccess.jsp
                response.sendRedirect(request.getContextPath() + "/client/registersuccess.jsp");
                return;
            } else {
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('身份信息不匹配！');");
                out.println("history.back();");
                out.println("</script>");
            }
        }
    }
}
