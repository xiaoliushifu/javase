/**
 * @(#)LoginCl.java
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



public class LoginCl extends HttpServlet{

    //
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            PrintWriter pw = res.getWriter();
            
            //接收用户名和密码
            String u = req.getParameter("username");
            String p = req.getParameter("passwd");
            
            if (u.equals("sp") && p.equals("123")) {
            	//合法
            	res.sendRedirect("welcome");
            } else {
            	//不合法，跳转回去
            	res.sendRedirect("login");
            }
            
            
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
    
}