<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.liu.model.*,java.util.*"%>
<%
//页面中得到控制层servlet的数据
ArrayList<GoodsBean> al = (ArrayList<GoodsBean>)request.getAttribute("goodsInfo");
MycartBo mbo = (MycartBo)request.getSession().getAttribute("mycart");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看购物车</title>
<link href="css/head.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function returnHall(){
		window.open("index.jsp","_self");
	}
	//使用js方式的跳转，是因为触发动作的表单元素是个按钮，其他则用a即可
	function delAll(){
		window.open("CartCl?type=delAll","_self");
	}
</script>
</head>
<body  style="margin-top:0"  background="images/bg2.jpg">
<div align="center">
<table width="80%" border="1" class="myfont">
  <tr>
    <td align="center" colspan="6">
    	<jsp:include page="head.jsp"></jsp:include>
    </td>
  </tr>
  <form action="CartCl?type=updateNum" method="post">
    <tr>
      <td colspan="6" align="center">查看购物车----》登录注册----》填写购物信息----》订单完成</td>
    </tr>
    <tr align="center">
      <td width="9%">编号</td>
      <td width="29%">名称</td>
      <td width="21%">单价</td>
      <td colspan="3">数量</td>
    </tr>
    <%
    for(int i=0;i<al.size();i++){
    	GoodsBean gb = al.get(i);
    %>
    <tr align="center">
      <td width="9%"><%=gb.getGoodsId() %></td>
      <td width="29%"><%=gb.getGoodsName() %></td>
      <td width="21%">￥<%=gb.getGoodsPrice() %></td>
      <td width="10%"><input type="hidden" name="goodsId" value="<%=gb.getGoodsId()%>"><input name="newNum" type="text" id="goodsNum" size="12" value="<%=gb.getGoodsNum() %>" /></td>
      <td width="15%"><a href="CartCl?type=del&goodsId=<%=gb.getGoodsId()%>">删除</a></td>
      <td width="16%"><a href="DetailServlet?type=show&goodsId=<%=gb.getGoodsId()%>">查看</a></td>
    </tr>
    <%} %>
    <tr>
      <td><div align="center"></div></td>
      <td><div align="center">
        <input type="button" name="Submit" onclick="delAll()" value="删除全部商品" />
      </div></td>
      <td><div align="center">
        <input type="submit" name="Submit2" value="修改数量" />
      </div></td>
      <td colspan="3"><div align="center"></div></td>
    </tr>
    <tr>
      <td colspan="6">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="6"><table width="100%" border="1">
        <tr>
          <td width="50%" align="left">您一共选择了￥<%=mbo.getAllPrice() %>的商品，点击<a href="index.jsp">此处</a>继续购物</td>
          <td align="right"><a href="LoginCl?type=checkLogin">下一步</a></td>
        </tr>
      </table></td>
    </tr>
    </form>
  <tr>
  	<td align="center" colspan="6">
  		<jsp:include page="tail.jsp"></jsp:include>
  	</td>
  </tr>
</table>
</div>
</body>
</html>