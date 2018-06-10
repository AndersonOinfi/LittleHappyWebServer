<%@ page import="cons.Constant" %><%--
  Created by IntelliJ IDEA.
  User: lanaBanana
  Date: 2018/3/16
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= Constant.WEB_TITLE%></title>
</head>
<body>
<a href="index.jsp">首页</a><br>
<h1>澳门首家线上赌场上线了！</h1>
<h2><%= new java.util.Date()%></h2>
<p><font size="6" color="red">FBI WARNING! DO NOT OPEN THIS FIRST CASINO ONLINE IN MACAO WITHOUT PROTECTION!</font></p><br>
<p>your ip address <%= request.getRemoteAddr()%>. Location is <%--todo--%></p>
<p>you are using <%= request.getHeader("User-Agent")%> with a display resolution of <%--todo--%></p>
<p>your query string :<%= request.getQueryString()%></p>
<ul>
    <li><a href="servlet.Hello">Hello!</a></li>
    <li><a href="servlet.Test">LoginTest</a></li>
    <li><a href="servlet.Verify">VerifyCode</a></li>
</ul>
</body>
</html>

