<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/14
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //接收用户名和密码完成校验
    String u= request.getParameter("username");
    String p=request.getParameter("passwd");

    /*********jdbc连接数据库的代码要会写**************************************************************************/
    String jdbcURL="jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
    String  USER="root";
    String  PASS="";
    //加载驱动
    Class.forName("com.mysql.jdbc.Driver");
    //建立连接
    Connection conn = DriverManager.getConnection(jdbcURL,USER,PASS);
    String sql="SELECT pass FROM  mwdb where uname=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,u);
    ResultSet rs = pstmt.executeQuery();
    if(rs.next()) {
        String db_pass = rs.getString(1);
        if(db_pass.equals(p)){
            response.sendRedirect("wel.jsp?u="+u);
            return;
        }
    }
    response.sendRedirect("login.jsp");
    /*if(u.equals("mingwei") && p.equals("123")){
        //合法跳转到welcome页面
        response.sendRedirect("wel.jsp?u="+u);
    } else{
        response.sendRedirect("login.jsp");
    }*/

%>
</body>
</html>
