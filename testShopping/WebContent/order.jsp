<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.liu.model.*,java.util.*"
%>
<%
	ArrayList<GoodsBean> al = (ArrayList<GoodsBean>)request.getAttribute("mycartlist");
	//在jsp页面直接使用session，也可以request.getSession()
	UserBean ub = (UserBean)session.getAttribute("userinfo");
	MycartBo mbo =(MycartBo)session.getAttribute("mycart");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/head.css" />
<script >
	//返回修改购物车信息
	function backToCart(){
		window.open("CartCl?type=showCart","_self");
	}
	
	function next(){
		window.open("OrderCl?type=true","_self");
	}
</script>
</head>
<body style="margin-top:0"  background="images/bg2.jpg">
<table width="80%" border="1" align="center" class="myfont">
  <tr>
    <td align="center">
    	<jsp:include page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1">
      <tr>
        <td align="center">查看购物车----》登录注册----》填写购物信息----》订单完成</td>
      </tr>
      <tr>
        <td><table width="60%" border="1" align="center">
          <tr>
            <td colspan="2" align="center">购买人信息</td>
            </tr>
          <tr>
            <td align="right">*用&nbsp;户名：</td>
            <td><input name="textfield" type="text" size="15"  value="<%=ub.getUsername() %>"/></td>
          </tr>
          <tr>
            <td align="right">*真实姓名：</td>
            <td><input name="textfield2" type="text" size="15"   value="<%=ub.getTruename() %>" /></td>
          </tr>
          <tr>
            <td align="right">*家庭地址：</td>
            <td><input name="textfield3" type="text" size="15"   value="<%=ub.getAddress() %>"/></td>
          </tr>
          <tr>
            <td align="right">*联系电话：</td>
            <td><input name="textfield4" type="text" size="15"  value="<%=ub.getPhone() %>" /></td>
          </tr>
          <tr>
            <td align="right">*电子邮件：</td>
            <td><input name="textfield5" type="text" size="15"   value="<%=ub.getEmail() %>"/></td>
          </tr>
          <tr>
            <td align="right">*邮&nbsp;&nbsp;编：</td>
            <td><input name="textfield6" type="text" size="15"   value="<%=ub.getPostcode() %>"/></td>
          </tr>
          <tr>
            <td align="right"><input type="button" name="Submit" value="完成订单" /></td>
            <td><input type="button" name="Submit2" value="修改信息" /></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center"><table width="60%" border="1">
          <tr>
            <td colspan="4" align="center">我的购物车情况</td>
            </tr>
          <tr>
            <td width="13%" align="center">编号</td>
            <td width="37%" align="center">商品</td>
            <td width="25%" align="center">单价</td>
            <td width="25%" align="center">数量</td>
          </tr>
          <%
          	for(int i=0;i<al.size();i++){
          		GoodsBean gb = al.get(i);
          %>
          <tr>
            <td width="13%"><%=gb.getGoodsId() %></td>
            <td align="center"><%=gb.getGoodsName() %></td>
            <td align="center">￥<%=gb.getGoodsPrice() %></td>
            <td align="center"><%=gb.getGoodsNum() %></td>
          </tr>
          <%
          	}
          %>
          <tr>
            <td colspan="4" align="left">您总共选择了价值￥<%=mbo.getAllPrice() %>的商品</td>
            </tr>
          <tr>
            <td colspan="4" align="center"><input type="button" name="Submit3" onclick="backToCart()" value="返回更改购物车" /></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td align="right"><input type="submit" name="Submit32" value="上一步" />
          <input type="button" name="Submit33" onclick="next()" value="下一步" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    	<jsp:include page="tail.jsp"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>