<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2>注册页面</h2>
	<h4>s:form类的标签学习</h4>
	<s:form action="register" method="post">
		<s:textfield name="username" label="用户名"></s:textfield>
		<s:password name="pwd" label="密  码"></s:password>
		<s:radio list="#{1:'男',2:'女',3:'保密'}" name="sex" label="性  别"></s:radio>
		<s:checkboxlist list="#{'pg':'苹果','tz':'桃子','xj':'香蕉'}" name="fruit" label="爱吃的水果"></s:checkboxlist>
		<s:select list="#{'zq':'足球','ppq':'乒乓球'}" name="sport" label="喜爱的运动">
		</s:select>
		<s:submit value="注册用户" name="sub"></s:submit>
	</s:form>
</body>
</html>