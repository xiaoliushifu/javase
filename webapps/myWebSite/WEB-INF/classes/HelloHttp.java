/**
 * @(#)HelloHttp.java
 *���ǵ����ֿ���Servlet�ķ�ʽ
 *Ŀǰ���ַ�ʽ���
 *ֻ����дdoGet(),doPost()��������
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