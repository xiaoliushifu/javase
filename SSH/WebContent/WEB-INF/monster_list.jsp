<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello monster list</title>
</head>
<body>
	<h2>各路妖怪都在这儿了</h2>
	<table width="800" border="1" align="center">
		<th>ID</th>
		<th>name</th>
		<th>email</th>
		<th>birthday</th>
		<th>entryday</th>
		<th>修改</th>
		<th>删除</th>
		<s:iterator value="#request.monsterlist">
		<tr>
			<td>${monsterId }</td>
			<td>${monsterName}</td>
			<td>${email}</td>
			<td>${birthday}</td>
			<td>${entryDate}</td>
			<td><a href="#">修改</a></td>
			<td><a href="#">删除</a></td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>