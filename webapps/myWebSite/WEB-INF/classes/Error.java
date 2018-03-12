/**
 * @(#)Error.java
 *
 *
 * @author 
 * @version 1.00 2018/3/12
 */
package com.liu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.*;

public class Error extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
        	res.setCharacterEncoding("gbk");
            PrintWriter pw = res.getWriter();
            pw.println("<html>");
            pw.println("<body><center>");
            pw.println("<img src='images/ques.png' height='100px'/><BR>");
            pw.println("<h3>∫‹“≈∫∂£¨≤Ÿ◊˜ ß∞‹¡À</h3>");
            pw.println("</center></body>");
            pw.println("</html>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}