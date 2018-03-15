<%@ page import="com.liu.*" %>
<%@ page import="com.liu.model.UserBeanCl" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/14
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%


    //实例化该对象，用它的一个方法完成验证过程
    UserBeanCl ubl = new UserBeanCl();
    if(ubl.checkLogin(u,p)){
        response.sendRedirect("wel.jsp?u="+u);
    }else{
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>
