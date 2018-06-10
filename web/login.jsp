<%@ page import="cons.Constant" %><%--
  Created by IntelliJ IDEA.
  User: lanaBanana
  Date: 2018/3/13
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= Constant.WEB_TITLE%></title>
</head>
<body>
<a href="index.jsp">首页</a><br>
<h1>一个并没有什么卵用的登陆页面</h1>
<form action="servlet.Test" method="post">
    <p>Username: <input type="text" name="username"></p>
    <p>Password: <input type="password" name="password"></p>
    <p>自动登陆<input type="checkbox" name="auto" checked="checked"></p>
    <input type="submit">
</form>
</body>
</html>
