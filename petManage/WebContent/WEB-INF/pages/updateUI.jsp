<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改宠物</title>
</head>
<body>
	<h3>debug看下值栈</h3>
	<!-- 打开调试模式，观察值栈 -->
	<s:debug></s:debug>
	
	<h2>修改宠物</h2>
	<s:form action="pet_update" method="post">
	<s:hidden name="id"></s:hidden>
	<!-- 由于pet对象已经压入值栈，那么这里的name就会从对象栈顶的对象的属性中寻找nickName，resume并自动赋值 -->
	<s:textfield name="nickName" label="宠物昵称"></s:textfield>
	<s:textarea name="resume" label="宠物介绍"></s:textarea>
	<s:submit value="修改宠物"></s:submit>
	</s:form>
	<a href="index.jsp">返回管理页</a>
</body>
</html>