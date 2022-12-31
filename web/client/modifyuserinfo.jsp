<%--
  Created by IntelliJ IDEA.
  User: 12114
  Date: 2022/12/24
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@taglib prefix="p" uri="http://www.itcast.cn/tag" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>电子书城</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/admin.js"></script>
    <script type="text/javascript">
        function success() {
            if (checkForm()) {
                var scan = $("input[name='radiobutton']:checked").val();
                var jsondata = {
                    "password": document.getElementById("password").value,
                    "Phone": document.getElementById("telephone").value,
                    "email": "${user.email}",
                    "username": "${user.username}",
                    "gender": scan
                }
                $.ajax({
                    type: "post", //用POST方式传输
                    url: "${pageContext.request.contextPath}/Success",
                    data: jsondata, //post携带数据
                    async: false,
                    success: function (data) {
                        if (data.mess == "修改成功") {
                            alert("修改成功,请重新登录");
                            window.location.href = "${pageContext.request.contextPath }/client/login.jsp";
                        } else {
                            alert("修改失败,请重试");
                        }
                    }, //请求成功时执行的函数
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert("修改失败,请重试");
                        // 状态码
                        console.log(XMLHttpRequest.status);
                        // 状态
                        console.log(XMLHttpRequest.readyState);
                        // 错误信息
                        console.log(textStatus);
                    }
                })
            }
        }
    </script>
</head>

<body class="main">
<p:user/>
<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>
<div id="divpagecontent">
    <table width="100%" border="0" cellspacing="0">
        <tr>
            <td width="25%">
                <table width="100%" border="0" cellspacing="0"
                       style="margin-top:30px">
                    <tr>
                        <td class="listtitle">我的帐户</td>
                    </tr>
                    <tr>
                        <td class="listtd">
                            <img src="${pageContext.request.contextPath }/client/images/miniicon.gif" width="9"
                                 height="6"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/client/modifyuserinfo.jsp">用户信息修改</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="listtd">
                            <img src="${pageContext.request.contextPath }/client/images/miniicon.gif" width="9"
                                 height="6"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/findOrderByUser">订单查询</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="listtd">
                            <img src="${pageContext.request.contextPath }/client/images/miniicon.gif" width="9"
                                 height="6"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/logout">用戶退出</a>
                        </td>
                    </tr>
                </table>
            </td>
            <td>
                <div style="text-align:right; margin:5px 10px 5px 0px">
                    <a href="${pageContext.request.contextPath }/index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath }/client/myAccount.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改
                </div>
                <table cellspacing="0" class="infocontent">
                    <tr>
                        <td>
                            <table width="100%" border="0" cellspacing="2" class="upline">
                                <tr>
                                    <td style="text-align:right; width:20%">会员邮箱：</td>
                                    <td style="width:40%; padding-left:20px">${user.email }</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td style="text-align:right">会员名：</td>
                                    <td style="padding-left:20px">${user.username }</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td style="text-align:right">修改密码：</td>
                                    <td><input type="password" class="textinput" id="password"
                                               onkeyup="checkPassword();"/></td>
                                    <td><span id="passwordMsg">密码设置至少6位，请区分大小写</span>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td style="text-align:right">重复密码：</td>
                                    <td><input type="password" class="textinput" id="repassword"
                                               onkeyup="checkConfirm();"/></td>
                                    <td><span id="confirmMsg"></span>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td style="text-align:right">性别：</td>
                                    <td colspan="2">&nbsp;&nbsp;
                                        <input type="radio" name="radiobutton"
                                               value="男" ${user.gender=='男'?'checked':'' }/> 男
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="radiobutton"
                                               value="女"  ${user.gender=='女'?'checked':'' }/> 女
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:right">联系方式：</td>
                                    <td>
                                        <input name="text2" type="text" value="${user.telephone}" class="textinput"
                                               id="telephone" onkeyup="checkPhone();"/>
                                    </td>
                                    <td><span id="PhoneMsg"></span><font color="#999999"></font></td>
                                </tr>
                                <tr>
                                    <td style="text-align:right">&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                            <p style="text-align:center">
                                <a href="javascript:void(0);">
                                    <img src="${pageContext.request.contextPath }/client/images/botton_gif_025.gif"
                                         border="0" onclick="success();"/>
                                </a>
                            </p>
                            <p style="text-align:center">&nbsp;</p>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>

