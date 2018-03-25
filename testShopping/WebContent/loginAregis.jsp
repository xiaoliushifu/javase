<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login and register</title>
<link href="css/head.css" rel="stylesheet" type="text/css" />
</head>
<body style="margin-top:0"  background="images/bg2.jpg">
<div align="center">
<table width="80%" border="1" align="center" class="myfont">
  <tr>
    <td align="center">
    	<jsp:include page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
  <form action="LoginCl?type=login" method="post" >
    <td><table width="100%" border="1" class="myfont">
      <tr>
        <td align="center">查看购物车----》登录注册----》填写购物信息----》订单完成</td>
      </tr>
      <tr>
        <td><table width="100%" border="1" bordercolor="#009900">
          <tr>
            <td colspan="4" align="center">会员登录</td>
            </tr>
          <tr>
            <td width="34%" rowspan="3">&nbsp;</td>
            <td width="11%" align="right" bordercolor="#009900">用户名：</td>
            <td width="13%" bordercolor="#009900"><input name="userName" type="text" size="16" /></td>
            <td width="42%" rowspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td align="right">密&nbsp;码：</td>
            <td><input name="pass" type="password" size="16" /></td>
          </tr>
          <tr>
            <td align="right"><input type="submit" name="Submit" value="登录" /></td>
            <td><input type="button" name="Submit2" value="注册" /></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center"></td>
      </tr>
      <tr>
        <td align="right">下一步</td>
      </tr>
    </table></td>
  </tr>
  </form>
  <tr>
    <td align="center">
    	<jsp:include page="tail.jsp"></jsp:include>
    </td>
  </tr>
</table>
</div>
</body>
</html>