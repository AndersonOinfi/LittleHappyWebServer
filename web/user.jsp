<%@ page import="cons.Constant" %><%--
  Created by IntelliJ IDEA.
  User: lanaBanana
  Date: 2018/3/19
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= Constant.WEB_TITLE%></title>
</head>
<body>
<a href="index.jsp">首页</a><br>
<ul>
    <li><a href="servlet.Bookmark?method=check">查看书签</a></li>
    <li><a href="servlet.Bookmark?method=add">添加书签</a></li>
    <li><a href="messageBoard.jsp">留言板</a></li>
</ul>
</body>
</html>
