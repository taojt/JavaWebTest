<%--
  Created by IntelliJ IDEA.
  User: taojt
  Date: 2016/5/29
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 声明测试</title>
</head>
<%!
    // 声明一个变量
    public int count;
    // 声明一个方法
    public String info(){
        return "Hello!";
    }

%>
<body>

<%
    // 输出count，每次加一
    out.println(count++);
%>
<%--// 使用表达式如下，功能同上--%>
<%--<%= count++%>--%>
<br>
<%
    // 输出info的返回值
    out.println(info());

%>
</body>
</html>
