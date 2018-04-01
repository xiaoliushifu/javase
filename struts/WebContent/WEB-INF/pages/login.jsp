<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2>哥们，请登录</h2>
	<!-- 注意 get方法时会有乱码，post方法就没有，暂不知为何 -->
	<form action="login" method="post">
	<label>用户名</label><input name="username" type="text" size="10" ><BR>
	<label>密码</label><input name="pwd" type="password" size=10 ><BR>
	<input type="submit" value="login" />
	</form>
</body>
</html>