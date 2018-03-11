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
        	
        	//ͨ����������gbk������������,���Ӿ����롣������http��Ӧͷ��û�п���Content-type
        	res.setCharacterEncoding("gbk");
            PrintWriter pw = res.getWriter();
            pw.println("<html>");
            pw.println("<body><center>");
            pw.println("<img src='images/ques.png' /><BR>");
            HttpSession hs = req.getSession(true);
            String p = (String) hs.getAttribute("pass");
            String u = (String) hs.getAttribute("name");
            //ʹ���ж��Ƿ�Ϊ�վ��У������ϸ�p.equals("ok")
            if (p != null) {
                pw.println("hello ����û����ǣ�"+u+"<br>");
            } else {
            	res.sendRedirect("login");
            	return;
            }
            //===============���ӷ�ҳ����=========================================
            String sql="";
            int pageSize=4;//ÿҳ��ʾ��������
            int pageNow=1; //��ǰ�ڼ�ҳ
            //��ò���
            String pn = req.getParameter("pageNow");
            if (pn != null) {
            	int num = Integer.parseInt(pn);
            	pageNow = num>0?num:1;
            }
            int rowCount=0;//�ܹ���������¼(���)
            int pageCount=0;//�ܹ�����ҳ��ͨ������õ���
            DbConn db = new DbConn();
            rowCount = db.count("*");
            if(rowCount%pageSize==0) {
            	pageCount = rowCount/pageSize;
            } else {
            	pageCount = rowCount/pageSize+1;
            }
            System.out.println("�ܹ�"+pageCount+"ҳ");
            ResultSet rs = db.selectAll((pageNow-1)*pageSize,pageSize);
            pw.println("<table border=1 ><br>");
            pw.println("<tr><th>���</th><th>����</th><th>����</th><th>����</th><th>����</th></tr>");
            while(rs.next()) {
            	pw.println("<tr>");
            	pw.println("<td>"+rs.getInt("id")+"</td>");
            	pw.println("<td>"+rs.getString("uname")+"</td>");
            	pw.println("<td>"+rs.getString("pass")+"</td>");
            	pw.println("<td>"+rs.getInt("age")+"</td>");
            	pw.println("<td><a href=''>�޸� | ɾ��</a></td>");
            	pw.println("</tr>");
            }
            pw.println("</table>");
            
            //ѭ��������ҳ�ţ���ҳ��������ʼ�����ǵ�ǰҳ�����
            //����������pageSizeͬ
            for(int i=pageNow;i<=pageNow+pageSize-1;i++) {
            	pw.println("<a href=welcome?pageNow="+i+">"+i+"</a>");
            }
            //===============���ӷ�ҳ����=========================================
            
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