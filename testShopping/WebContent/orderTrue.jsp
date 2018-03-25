<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.liu.model.*,java.util.*"%>
<%
	//用户登录信息在session中
	UserBean ub = (UserBean) session.getAttribute("userinfo");
	//存入订单表后还未删除的信息
	MycartBo mbo =(MycartBo) session.getAttribute("mycart");
	String orderId = request.getAttribute("orderId")+"";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/head.css" />
</head>
<body style="margin-top:0"  background="images/bg2.jpg">
<table width="80%" border="1" align="center" class="myfont">
  <tr>
    <td align="center"><jsp:include page="head.jsp"></jsp:include></td>
  </tr>
  <tr>
    <td><table width="100%" border="1">
      <tr>
        <td colspan="9" align="center">查看购物车----》登录注册----》填写购物信息----》订单完成</td>
        </tr>
      <tr>
        <td colspan="9" align="center">订单详细信息</td>
        </tr>
      <tr align="center">
        <td width="5%">订单号</td>
        <td width="13%">收货人</td>
        <td width="24%">收货地址</td>
        <td width="7%">邮编</td>
        <td width="11%">电话</td>
        <td width="7%">总价</td>
        <td width="9%">用户名</td>
        <td width="12%">邮箱</td>
        <td width="12%">--</td>
      </tr>
      <tr align="center">
        <td><%=orderId %></td>
        <td><%=ub.getTruename() %></td>
        <td><%=ub.getAddress() %></td>
        <td><%=ub.getPostcode() %></td>
        <td><%=ub.getPhone() %></td>
        <td><%=mbo.getAllPrice() %></td>
        <td><%=ub.getUsername() %></td>
        <td><%=ub.getEmail() %></td>
        <td><a href="">查看详情</a></td>
      </tr>
      <tr>
        <td colspan="9" align="center">您的订单已经完成，稍后服务器会向您的邮箱发送确认信息，请确认订单信息</td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center"><jsp:include page="tail.jsp"></jsp:include></td>
  </tr>
</table>
</body>
</html>