<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>恭喜你，登录成功</h2><BR>
	登录人的姓名 ${username }<BR>
	登录人的密码 ${pwd}
	<a href="index">返回继续登录</a><BR>
	<a href="logout">注销</a>
	<hr>
	当前在线人数是：${application.onlineTotalNum }
</body>
</html>