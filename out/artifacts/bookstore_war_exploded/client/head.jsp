<%--
  Created by IntelliJ IDEA.
  User: 12114
  Date: 2022/12/24
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="divhead">
    <table cellspacing="0" class="headtable">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath }/index.jsp">
                    <img src="${pageContext.request.contextPath}/client/images/logo.png" width="200" height="60" border="0" />
                </a>
            </td>
            <td style="text-align:right">
                <img src="${pageContext.request.contextPath}/client/images/cart.gif" width="26" height="23" style="margin-bottom:-4px" />&nbsp;<a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a>
                | <a href="${pageContext.request.contextPath}/client/help.jsp">帮助中心</a>
                | <a href="${pageContext.request.contextPath}/myAccount">我的帐户</a>
                | <a href="${pageContext.request.contextPath}/client/register.jsp">新用户注册</a>
                <%-- 				<br><br><br>欢迎您： ${user.username} --%>
            </td>
        </tr>

    </table>
</div>