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
	<s:debug>
	</s:debug>
	<h2>添加宠物</h2>
	<s:form action="pet_add" method="post" theme="simple">
	宠物昵称:<s:textfield name="nickName"></s:textfield>
	<s:property value="errors.nickName[0]"></s:property><BR>
	宠物生日:<s:textfield name="birthDay" ></s:textfield>
	<!-- 服务端验证出错时，会把错误信息压入栈中Action对象的errors成员中 -->
	<s:property value="errors.birthDay[0]"></s:property><BR>
	宠物介绍:<s:textfield name="resume"></s:textfield><BR>
	<s:submit value="添加宠物"></s:submit>
	</s:form>
	<a href="index.jsp">返回管理页</a>
</body>
</html>