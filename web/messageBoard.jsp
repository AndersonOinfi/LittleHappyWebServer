<%@ page import="cons.Constant" %><%--
  Created by IntelliJ IDEA.
  User: Asukaaaa~
  Date: 2018/4/18
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= Constant.WEB_TITLE%></title>
</head>
<body>
<a href="index.jsp">首页</a><br>
<h1>留言板</h1>
<form action="servlet.MessageBoard" method="post">
    你的留言: <textarea rows="10" cols="100" name="message"></textarea><br>
    你的名字: <input type="text" name="username"><br>
    你的头像: <select name="useravatar">
    <option value="1">1</option>
    <option value="2">2</option>
</select><br>
    <input type="submit"><br>
</form>
</body>
</html>
