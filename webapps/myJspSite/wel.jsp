<%@ page import="java.sql.*" %>
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
    String u = request.getParameter("u");
    String pn = request.getParameter("pageNow");
%>
<body>
<center>
    <h3>登录成功，欢迎你:<%=u%></h3>
    <a href="login.jsp">返回重新登录</a>
    <hr>
    <h3>用户信息列表</h3>
<%
    //自带分页
    int pageSize=3;
    int pageNow=1;

    if(pn != null) {
        pageNow = Integer.parseInt(pn);
    }
    int rowCount=1;
    int pageCount=0;

    //加载驱动
    Class.forName("com.mysql.jdbc.Driver");
    String jdbcURL="jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
    String USER="root";
    String PASS="";
    Connection conn = DriverManager.getConnection(jdbcURL,USER,PASS);

    //获得总条数，并计算页数量
    String sql="SELECT count(1) FROM mwdb";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
    if(!rs.next()){
        out.println("查询有误");
    }
    rowCount = rs.getInt(1);
    if(rowCount%pageSize == 0){
        pageCount = rowCount/pageSize;
    }else{
        pageCount = rowCount/pageSize+1;
    }


    //查询具体信息
    sql="SELECT * FROM mwdb limit "+pageSize+" offset "+((pageNow-1)*pageSize);
    stmt = conn.prepareStatement(sql);
    rs = stmt.executeQuery();
%>
    <table width="300" border="1" valign="middle" >
        <tr><th>编号</th><th>姓名</th><th>密码</th><th>年龄</th></tr>
<%
    while(rs.next()){
%>
        <tr><td><%= rs.getInt("id")%></td><td><%= rs.getString("uname")%></td>
            <td><%= rs.getString("pass")%></td><td><%= rs.getInt("age")%></td>
        </tr>
<%
    }
%>

    </table>
<%

    if(pageNow > 1){
        out.println("<a href=wel.jsp?pageNow="+(pageNow-1)+">上一页</a>");
    }

    //页号链接
    for(int i=1;i<pageCount;i++){
        out.println("<a href=wel.jsp?pageNow="+i+">"+i+"</a>");
    }
    if(pageNow < pageCount){
        out.println("<a href=wel.jsp?pageNow="+(pageNow+1)+">下一页</a>");
    }
%>
    </center>
</body>
</html>
