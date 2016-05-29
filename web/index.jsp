<%--
  Created by IntelliJ IDEA.
  User: taojt
  Date: 2016/5/29
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Web 测试</title>
</head>
<body>
这是一个Java Web 测试程序，JSP的首页
<br>

<% for (int i = 0; i < 10; i++) {
    out.println(i);
    %>
<br><%
}
%>
</body>
</html>
