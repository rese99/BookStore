<%--<%@ page import="com.four.bookstore.utils.MailUtils" %>--%>
<%--<%@ page import="javax.mail.MessagingException" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: 12114--%>
<%--  Date: 2022/12/27--%>
<%--  Time: 9:25--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    System.out.println(basePath);
%>
<html>
<head>
    <title>忘记密码</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/client/js/forget.js"
            charset="UTF-8"></script>
    <script>
        function getBasePath() {
            return '<%=basePath%>';
        }
    </script>
    <script type="text/javascript">
        function changeImage() {
            // 改变验证码图片中的文字
            document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
                + new Date().getTime();
        }
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            var flag;
            var email;
            var name;
            var phone;
            var ordertime = 30   //设置再次发送验证码等待时间
            var timeleft = ordertime
            var btn = $(".yzm");
            flag = setInterval(sure, 1000);

            function sure() {
                if (checkEmail() && checkUsername() && checkPhone()) {
                    btn.removeAttr("disabled")
                    email = document.getElementById("email").value;
                    name = document.getElementById("username").value;
                    phone = document.getElementById("telephone").value;
                    clearInterval(flag);
                } else {
                    btn.attr("disabled", true)
                }
            }

            //计时函数
            function timeCount() {
                timeleft -= 1
                if (timeleft > 0) {
                    btn.val(timeleft + " 秒后重发");
                    setTimeout(timeCount, 1000)
                } else {
                    btn.val("重新发送");
                    timeleft = ordertime   //重置等待时间
                    btn.removeAttr("disabled");
                }
            }

            //事件处理函数
            btn.on("click", function () {
                $(this).attr("disabled", true); //防止多次点击
                //此处可添加 ajax请求 向后台发送 获取验证码请求
                var jsondata = {//前端可以发送数据给后端，json形式
                    "name": name,
                    "email": email,
                    "phone": phone
                }
                $.ajax({
                    type: "post", //用POST方式传输
                    url: "${pageContext.request.contextPath}/mailMessage",
                    data: jsondata, //post携带数据
                    success: function (data) {
                        if (data.mess == "false") {
                            alert("身份信息不匹配，验证码发送失败");
                            flag = setInterval(sure, 1000);
                        } else if (data.mess == "true")
                            alert("验证码发送成功");
                    }, //请求成功时执行的函数
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        // 状态码
                        console.log(XMLHttpRequest.status);
                        // 状态
                        console.log(XMLHttpRequest.readyState);
                        // 错误信息
                        console.log(textStatus);
                    }
                });
                timeCount(this);
            })

        })
    </script>
    <script type="text/javascript">
        function must() {
            var flags = checkForm();
            if (flags) {
                var jsondata = {//前端可以发送数据给后端，json形式
                    "mailMessage": document.getElementById("mailMessage").value,
                    "verify": document.getElementById("verify").value,
                    "password": document.getElementById("password").value,
                    "username": document.getElementById("username").value,
                    "email": document.getElementById("email").value,
                    "Phone": document.getElementById("telephone").value
                }
                $.ajax({
                    type: "post", //用POST方式传输
                    url: "${pageContext.request.contextPath}/CheckSure",
                    data: jsondata, //post携带数据
                    async: false,
                    success: function (data) {
                        if (data.mess != "密码重置成功") {
                            alert(data.mess);
                            flags = false;
                        } else {
                            alert("密码重置成功,即将跳转至登陆页面");
                            flags = true;
                        }
                    }, //请求成功时执行的函数
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        flags = false;
                        alert("请先获取邮件验证码")
                        // 状态码
                        console.log(XMLHttpRequest.status);
                        // 状态
                        console.log(XMLHttpRequest.readyState);
                        // 错误信息
                        console.log(textStatus);
                    }
                })
            }
            return flags;
        }
    </script>
</head>
<body class="main">
<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>
<div id="divcontent">
    <form action="${pageContext.request.contextPath}/client/login.jsp" method="post" onsubmit="return must();">
        <table width="850px" border="0" cellspacing="0">
            <tr>
                <td style="padding: 30px;text-align: center"><h1>忘记密码</h1>
                    <table width="70%" border="0" cellspacing="2" class="upline" style="margin-left: 200px">
                        <tr>
                            <td style="text-align: right; width: 20%">会员邮箱：</td>
                            <td style="width: 40%">
                                <input type="text" class="textinput" id="email" name="email" onkeyup="checkEmail();"/>
                            </td>
                            <td colspan="2"><span id="emailMsg"></span><font color="#999999"></font></td>
                        </tr>
                        <tr>
                            <td style="text-align: right">会员名：</td>
                            <td><input type="text" class="textinput" id="username" name="username"
                                       onkeyup="checkUsername();"/>
                            </td>
                            <td colspan="2"><span id="usernameMsg"></span><font color="#999999"></font></td>
                        </tr>
                        <tr>
                            <td style="text-align: right">联系电话：</td>
                            <td><input type="text" class="textinput" id="telephone" name="telephone"
                                       onkeyup="checkPhone();"/>
                            </td>
                            <td><span id="PhoneMsg"></span><font color="#999999"></font></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td style="text-align: right">新密码：</td>
                            <td><input type="password" class="textinput" id="password" name="password"
                                       onkeyup="checkPassword();"/></td>
                            <td><span id="passwordMsg"></span><font color="#999999"></font></td>
                        </tr>
                        <tr>
                            <td style="text-align: right">重复密码：</td>
                            <td>
                                <input type="password" class="textinput" id="repassword" name="repassword"
                                       onkeyup="checkConfirm();"/>
                            </td>
                            <td><span id="confirmMsg"></span>&nbsp;</td>
                        </tr>
                        <tr>
                            <td style="text-align: right">验证码：</td>
                            <td><input type="text" class="textinput" name="mailMessage" id="mailMessage"/>
                            </td>
                            <td>
                                <input type="button" value="获取邮箱验证码" name="yzm" class="yzm" id="yzm"
                                       disabled="disabled">
                            </td>
                            <td><span id="mailMessageMsg"></span>&nbsp;</td>
                            <td>
                                <%--                                <a href="${pageContext.request.contextPath}/mailMessage">获取邮箱验证码</a>--%>
                            </td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                    <h1>校验</h1>
                    <table width="70%" border="0" cellspacing="2" class="upline" style="margin-left: 200px">
                        <tr>
                            <td style="text-align: right; width: 20%">输入校验码：</td>
                            <td style="width: 50%">
                                <input type="text" class="textinput" id="verify" onkeyup="checkVerify();"/>
                            </td>
                            <td><span id="verifyMsg"></span>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td style="text-align: right; width: 20%;">&nbsp;</td>
                            <td rowspan="2" style="width: 50%">
                                <img src="${pageContext.request.contextPath}/imageCode" width="180"
                                     height="30" class="textinput" style="height: 30px;" id="img"/>&nbsp;&nbsp;
                                <a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
                            </td>
                        </tr>
                    </table>

                    <table width="70%" border="0" cellspacing="0" style="margin-left: 200px">
                        <tr>
                            <td style="padding-top: 20px; text-align: center">
                                <input type="image" src="images/signup.gif" name="submit" border="0" onclick=""/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>




