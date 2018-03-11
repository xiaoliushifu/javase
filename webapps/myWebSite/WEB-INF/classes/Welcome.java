/**
 * @(#)Welcome.java
 *hello
 *
 * @author 
 * @version 1.00 2018/3/10
 */
package com.liu;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;



public class Welcome extends HttpServlet{

    //
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
        	
        	//通过这个解决了gbk中文乱码问题,不加就乱码。但是在http响应头中没有看到Content-type
        	res.setCharacterEncoding("gbk");
            PrintWriter pw = res.getWriter();
            pw.println("<html>");
            pw.println("<body><center>");
            pw.println("<img src='images/ques.png' /><BR>");
            HttpSession hs = req.getSession(true);
            String p = (String) hs.getAttribute("pass");
            String u = (String) hs.getAttribute("name");
            //使用判断是否为空就行，不必严格p.equals("ok")
            if (p != null) {
                pw.println("hello 你的用户名是："+u+"<br>");
            } else {
            	res.sendRedirect("login");
            	return;
            }
            //===============增加分页功能=========================================
            String sql="";
            int pageSize=4;//每页显示几条数据
            int pageNow=1; //当前第几页
            //获得参数
            String pn = req.getParameter("pageNow");
            if (pn != null) {
            	int num = Integer.parseInt(pn);
            	pageNow = num>0?num:1;
            }
            int rowCount=0;//总共多少条记录(查库)
            int pageCount=0;//总共多少页（通过计算得到）
            DbConn db = new DbConn();
            rowCount = db.count("*");
            if(rowCount%pageSize==0) {
            	pageCount = rowCount/pageSize;
            } else {
            	pageCount = rowCount/pageSize+1;
            }
            System.out.println("总共"+pageCount+"页");
            ResultSet rs = db.selectAll((pageNow-1)*pageSize,pageSize);
            pw.println("<table border=1 ><br>");
            pw.println("<tr><th>编号</th><th>姓名</th><th>密码</th><th>年龄</th><th>操作</th></tr>");
            while(rs.next()) {
            	pw.println("<tr>");
            	pw.println("<td>"+rs.getInt("id")+"</td>");
            	pw.println("<td>"+rs.getString("uname")+"</td>");
            	pw.println("<td>"+rs.getString("pass")+"</td>");
            	pw.println("<td>"+rs.getInt("age")+"</td>");
            	pw.println("<td><a href=''>修改 | 删除</a></td>");
            	pw.println("</tr>");
            }
            pw.println("</table>");
            
            //循环遍历出页号，供页面点击。初始连接是当前页码递增
            //链接数量与pageSize同
            for(int i=pageNow;i<=pageNow+pageSize-1;i++) {
            	pw.println("<a href=welcome?pageNow="+i+">"+i+"</a>");
            }
            //===============增加分页功能=========================================
            
            pw.println("</center></body>");
            pw.println("</html>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
    
}