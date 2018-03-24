<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.liu.model.*,java.util.*"%>
<%
	String s_p = (String)request.getAttribute("abc");
	
	int pageNow=1;
	if(s_p!=null){
		pageNow=Integer.parseInt(s_p);
	}
	GoodsBeanBo gbb = new GoodsBeanBo();
	ArrayList al = gbb.getGoodsList(pageNow);
%>
<table width="100%" border="1" class="myfont">
  <tr>
    <td colspan="3" align="center">一个长图片广告条</td>
  </tr>
  <tr>
<%
	for(int i=0;i<2;i++) {
		//两次循环，每次循环三个（也许数量不够三个）
		for(int j=0+i*3;j<3+i*3;j++) {
			GoodsBean gb=null;
			//当数量不够的时候，就临时生成一个固定的
			if(j>=al.size()){
				gb= new GoodsBean();
				gb.setGoodsId(0);
				gb.setGoodsPrice(0.00f);
				gb.setGoodsIntro("没有了");
				gb.setGoodsName("谢谢光临");
				gb.setPhoto("none.jpg");
			}  else {
				gb = (GoodsBean)al.get(j);
			}
			%>
			<td width="33%">
				<table width="100%" height="168" border="1">
			      <tr>
			        <td width="11%" rowspan="3"><img src="images/<%=gb.getPhoto() %>" alt="p1" width="112" height="112" /></td>
			        <td width="89%" height="21"></td>
			      </tr>
			      <tr>
			        <td height="66" align="left" valign="top"><a href="DetailServlet?goodsId=<%=gb.getGoodsId()%>"><%=gb.getGoodsName() %></a></td>
			      </tr>
			      <tr>
			        <td height="2" align="left" valign="top">价格：￥<%=gb.getGoodsPrice() %></td>
			      </tr>
			      <tr>
			        <td colspan="2" align="left" valign="top"><%=gb.getGoodsIntro() %></td>
			        </tr>
			    </table>
		    </td>
			<%
		}
		//循环玩三个，给出一个分割线的tr
		if(i==0) {
			%>
			</tr>
			  <tr>
			    <td height="10" colspan="3" align="center" bgcolor="#FFCCCC">窄窄的分割线</td>
			  </tr>
			<tr>
			<%
		}else if(i==1){
			%>
			</tr>
			<%
		}
	}
%>
    
  <tr>
    <td colspan="3" align="center">
<%
    Integer pageCount = gbb.getPageCount();
    for(int i=1;i<=pageCount;i++){
%>
    <a href="DetailServlet?type=fenye&pageNow=<%=i%>"><%=i %></a>
<%
    }
%>
    </td>
  </tr>
</table>