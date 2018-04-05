<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物列表页面</title>
</head>
<body>
	<h2>宠物列表页</h2>
	<table width="700px" border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>resume</th>
			<th>action</th>
		</tr>
		<s:iterator value="#request.petlist">
		<tr>
			<th>${id} </th>
			<th>${nickName} </th>
			<th>${resume} </th>
			<th><a href="#">删除</a>|<a href="#">更新</a></th>
		</tr>
		</s:iterator>
	</table>
</body>
</html>