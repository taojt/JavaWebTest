<%--
  Created by IntelliJ IDEA.
  User: taojt
  Date: 2016/5/29
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>javabeane</title>
</head>
<body>
<%·
    Person p1 = new Person();
    p1.setName("wawa");
    p1.setAge(23);

%>
<%= p1.getName()%>
<%= p1.getAge()%>
</body>
</html>
