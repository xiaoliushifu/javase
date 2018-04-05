<%@page import="com.liu.struts.bean.Sheep"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>没啥说的</title>
</head>
<body>
	<h2>恭喜您，登录成功</h2><BR>
	登录人的姓名 ${username }<BR>
	登录人的密码 ${pwd}
	<BR><a href="index">返回继续登录</a>
	<hr>
	<%
		request.setAttribute("grade", 68);
	%>
	<h2>struts2的标签库使用</h2>
	<h4>if--elseif--else</h4>
	<br>学生成绩是：
	<s:if test="#request.grade < 60">
		成绩不合格
	</s:if>
	<s:elseif test="#request.grade <80">
		成绩优良
	</s:elseif>
	<s:else>
		成绩优秀
	</s:else>
	<%
	ArrayList<Sheep> al = new ArrayList<Sheep>();
	al.add(new Sheep(10,"喜羊羊"));
	al.add(new Sheep(30,"沸羊羊"));
	request.setAttribute("sheeplist", al);
	%>
	<h4>iterator标签</h4>
	<s:iterator value="#request.sheeplist" var="oneSheep">
	<!-- id,name对应sheep对象的成员属性 -->
	<br>id:${id} | name:${name} |<s:property value="id"/>|<s:property value="name"/>
	|${oneSheep}
	</s:iterator>
</body>
</html>