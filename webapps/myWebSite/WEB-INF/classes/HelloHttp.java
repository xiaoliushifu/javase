/**
 * @(#)HelloHttp.java
 *这是第三种开发Servlet的方式
 *目前这种方式最常见
 *只需重写doGet(),doPost()方法即可
 *
 * @author 
 * @version 1.00 2018/3/10
 */
package com.liu;
import javax.servlet.http.*;
import java.io.*;

public class HelloHttp extends HttpServlet{
    
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            PrintWriter pw = res.getWriter();
            pw.println("hello,world http");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
     
}