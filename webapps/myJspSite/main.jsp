<%--
  Created by IntelliJ IDEA.
  User:  liumingwei
  Date: 2018/3/15
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>

</head>
<body bgcolor="#CED3FE">
<center>
    <!--
    注意，这里不是直接写wel.jsp，因为缺少数据带过去。
    所以，应该先跳转到UserController控制器获得显示wel.jsp页必要的数据后跳转回来
    -->
    <a href="user?pageNow=1&flag=admin">管理页面</a><BR>
    <a href="" >搜索页面</a><BR>
    <a href="add.jsp" >添加用户</a><BR>
    <a href="" >页面</a><BR>
</center>
</body>
</html>
