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



public class Welcome extends HttpServlet{

    //
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            PrintWriter pw = res.getWriter();
            HttpSession hs = req.getSession(true);
            String p = (String) hs.getAttribute("pass");
            //使用判断是否为空就行，不必严格p.equals("ok")
            if (p != null) {
                pw.println("hello "+p);
            } else {
            	res.sendRedirect("login");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
    
}