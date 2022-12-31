<%--
  Created by IntelliJ IDEA.
  User: 12114
  Date: 2022/12/26
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.id}</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        var town = document.title;
        $(document).ready(function () {
            if (town == "忘记密码") {
                $("#reply").html("点击我的账户，忘记密码，填写账号验证信息重置密码");
                return;
            }
            if (town == "无法激活") {
                $("#reply").html("尝试更改tomcat服务器地址或者联系管理员");
                return;
            }
            if (town == "无法注册") {
                $("#reply").html("查看信息输入是否符合规范，实名信息是否正确");
                return;
            }
            if (town == "书籍找不到") {
                $("#reply").html("检查信息是否有误，联系管理员增加图书");
                return;
            }
        });
    </script>
</head>
<body>
<span id="reply"></span>
</body>
</html>
