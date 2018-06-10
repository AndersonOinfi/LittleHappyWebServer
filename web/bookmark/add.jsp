<%@ page import="cons.Constant" %><%--
  Created by IntelliJ IDEA.
  User: lanaBanana
  Date: 2018/3/21
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= Constant.WEB_TITLE%>></title>
</head>
<body>
<button><a href="index.jsp">首页</a></button><br>
<h>添加书签</h>
<form action="servlet.Bookmark?username=jack&method=add&"+
        <%= request.getParameter("name")+ request.getParameter("url")%> method="post">
    Name: <input type="text" name="name"><br>
    URL: <input type="text" name="url"><br>
    <input type="submit">
</form>
</body>
</html>