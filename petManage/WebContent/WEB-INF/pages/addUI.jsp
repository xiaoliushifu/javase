<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加宠物</title>
</head>
<body>
	<h2>添加宠物</h2>
	<s:form action="pet_add" method="post">
	<s:textfield name="nickName" label="宠物昵称"></s:textfield>
	<s:textfield name="resume" label="宠物介绍"></s:textfield>
	<s:submit value="添加宠物"></s:submit>
	</s:form>
	<a href="index.jsp">返回管理页</a>
</body>
</html>