<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liu.model.UserBean" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/14
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
</head>
<%
    String u = (String)session.getAttribute("myName");
    if(u==null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String pn = request.getParameter("pageNow");

%>
<body>
<center>
    <h3>登录成功，欢迎你:<%=u%></h3>
    <a href="login.jsp">返回重新登录</a>
    <hr>
    <h3>用户信息列表</h3>
<%

    int pageNow=1;
    if(pn != null) {
        pageNow = Integer.parseInt(pn);
    }

    //使用getAttribute来获取从控制器转发而来的数据,不是从UserBeanCl中获取
    ArrayList al;
    al = (ArrayList)(request.getAttribute("result"));
%>
    <table width="300" border="1" valign="middle" >
        <tr><th>编号</th><th>姓名</th><th>密码</th><th>年龄</th></tr>
<%
    for(int i=0;i<al.size();i++){
        UserBean ub = (UserBean) al.get(i);
%>
        <tr><td><%= ub.getId()%></td><td><%= ub.getuName()%></td>
            <td><%= ub.getPass()%></td><td><%= ub.getAge()%></td>
        </tr>
<%
    }
%>

    </table>
<%

    if(pageNow > 1){
        out.println("<a href=user?pageNow="+(pageNow-1)+">上一页</a>");
    }

    //使用getAttribute而不是getParameter来获取从控制器转发而来的数据
    int pageCount = (Integer)request.getAttribute("pageCount");
    //页号链接
    for(int i=1;i<pageCount;i++){
        out.println("<a href=user?pageNow="+i+">"+i+"</a>");
    }
    if(pageNow < pageCount){
        out.println("<a href=user?pageNow="+(pageNow+1)+">下一页</a>");
    }
%>
    </center>
</body>
</html>