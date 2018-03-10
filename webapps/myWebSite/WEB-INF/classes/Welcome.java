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
import java.io.*;



public class Welcome extends HttpServlet{

    //
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            PrintWriter pw = res.getWriter();
            
            pw.println("hello ");
          }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        this.doGet(req,res);
    }
    
}