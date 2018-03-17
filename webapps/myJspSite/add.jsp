<%--
  Created by IntelliJ IDEA.
  User:  liumingwei
  Date: 2018/3/17
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<center>
<h2>添加用户</h2>
<form action="user?flag=add" method="post">
    <table border="1">
        <tr><td>用户名：</td><td><input type="text"  name="uname"></td></tr>
        <tr><td>密&nbsp;&nbsp;码：</td><td><input type="password" name="passwd"></td></tr>
        <tr><td>年&nbsp;&nbsp;龄：</td><td><input type="number" name="age"></td></tr>
        <tr><td><input type="reset" value="重置"/></td>
            <td><input type="submit" value="添加" /></td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
