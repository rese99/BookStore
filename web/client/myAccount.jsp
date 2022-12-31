<%--
  Created by IntelliJ IDEA.
  User: 12114
  Date: 2022/12/24
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>电子书城</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
</head>

<body class="main">
<jsp:include page="head.jsp" />
<jsp:include page="menu_search.jsp" />
<div id="divpagecontent">
    <table width="100%" border="0" cellspacing="0">
        <tr>
            <td width="25%">
                <table width="100%" border="0" cellspacing="0" style="margin-top:30px">
                    <tr>
                        <td class="listtitle">我的帐户</td>
                    </tr>
                    <tr>
                        <td class="listtd">
                            <img src="${pageContext.request.contextPath }/client/images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/client/modifyuserinfo.jsp">用户信息修改</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="listtd">
                            <img src="${pageContext.request.contextPath }/client/images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/findOrderByUser">订单查询</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="listtd">
                            <img src="${pageContext.request.contextPath }/client/images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/logout">用戶退出</a>
                        </td>
                    </tr>
                </table>
            </td>
            <td>
                <div style="text-align:right; margin:5px 10px 5px 0px">
                    <a href="${pageContext.request.contextPath }/index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
                    &nbsp;我的帐户&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;欢迎
                </div>
                <table cellspacing="0" class="infocontent">
                    <tr>
                        <td style="padding:20px"><p>
                            <img src="${pageContext.request.contextPath }/client/ad/myad.jpg" width="631" height="436" />
                        </p>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
<jsp:include page="foot.jsp" />
</body>
</html>

