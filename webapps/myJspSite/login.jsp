<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/14
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body bgcolor="#CED3FE">
    <center>
    <form name="form1" action="loginCl" method="post">
        用户名：<input type="text"  name="username"><BR>
        密&nbsp;&nbsp;码：<input type="password" name="passwd"><BR>
            <input type="submit" value="登录" />
            <input type="reset" value="重置"/>
    </form>
    </center>
</body>
</html>
