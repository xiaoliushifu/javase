/**
 * @(#)HelloGen.java
 * 第二种开发Servlet的方法（继承GenericServlet）
 *
 * @author liushifu
 * @version 1.00 2018/3/10
 */
package com.liu;

import  javax.servlet.GenericServlet;
import 	javax.servlet.ServletRequest;
import 	javax.servlet.ServletResponse;
import java.io.*;

public class HelloGen extends GenericServlet{

    public HelloGen() {
    }
    
    //只需重写service方法即可
    //不会看到init方法和destroy方法的输出
    public void service(ServletRequest req,ServletResponse res) {
    	
    	try{
    		PrintWriter pw = res.getWriter();
    		pw.println("hello,world generic");
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    }
}