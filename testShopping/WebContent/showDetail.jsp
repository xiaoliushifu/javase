<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
       	<jsp:include page="detail.jsp"></jsp:include>
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