<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.liu.model.*"%>
<%
	GoodsBean gb =(GoodsBean) request.getAttribute("goodsInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/head.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
<!--
	//返回大厅的js,
	//直接替换当前页面的方式_self
-->
	function returnHall(){
		window.open("index.jsp","_self");
	}
</script>
</head>
<body  margin-top="0"  background="images/bg2.jpg">
<div align="center">
   <table width="80%" border="1">
     <tr>
       <td height="63" colspan="2">
       <jsp:include page="head.jsp"></jsp:include>
       </td>
    </tr>
     <tr>
       <td align="left" valign="top">
       		<table width="100%" border="1" class="myfont">
			  <tr>
			    <td colspan="2"></td>
			  </tr>
			  <tr>
			    <td width="25%" rowspan="8"><img src="images/<%=gb.getPhoto() %>" alt="p4" width="144" height="155" /></td>
			    <td><%=gb.getGoodsName()%></td>
			  </tr>
			  <tr>
			    <td>价格 ￥<%=gb.getGoodsPrice()%> </td>
			  </tr>
			  <tr>
			    <td></td>
			  </tr>
			  <tr>
			    <td><%=gb.getGoodsId()%></td>
			  </tr>
			  <tr>
			    <td>类型1：<%=gb.getType()%></td>
			  </tr>
			  <tr>
			    <td>出版商：<%=gb.getPublisher()%></td>
			  </tr>
			  <tr>
			    <td>&nbsp;</td>
			  </tr>
			  <tr>
			    <td height="91" align="left" valign="top"><%=gb.getGoodsIntro()%></td>
			  </tr>
			  <tr>
			    <td colspan="2"><form id="form1" name="form1" method="post" action="">
			      <label>
			      <input name="btn1" type="button" id="btn1" value="购买" />
			      </label>
			      <input name="btn2" type="button" id="btn2" onclick="returnHall();" value="返回购物大厅" />
			    </form>
			    </td>
			  </tr>
			  <tr>
			    <td colspan="2">&nbsp;</td>
			  </tr>
			</table>
       </td>
     </tr>
     <tr>
       <td colspan="2">
       <jsp:include page="tail.jsp"></jsp:include>
       </td>
    </tr>
   </table>
 </div>
</body>
</html>