/**
 * @(#)Login.java
 *hello
 *
 * @author 
 * @version 1.00 2018/3/10
 */
package com.liu;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;



public class Login extends HttpServlet{
    
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
        	res.setCharacterEncoding("gbk");//这个管用，但仍有疑惑
            PrintWriter pw = res.getWriter();
            //res.setContentType("text/html;charset=GBK");//这个的charset不管用
            
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<h3>Login Page<h3>");
            pw.println("<form action=loginCl method=post>");
            pw.println("用户名:<input type=text name=username><BR>");
            pw.println("密&nbsp;&nbsp;码:<input type=password name=passwd><BR>");
            pw.println("<input type=submit value=login><BR>");
            pw.println("</form>");
            pw.println("</body>");
            pw.println("</html>");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
    
}