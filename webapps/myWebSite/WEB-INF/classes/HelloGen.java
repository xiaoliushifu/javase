/**
 * @(#)HelloGen.java
 * �ڶ��ֿ���Servlet�ķ������̳�GenericServlet��
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
    
    //ֻ����дservice��������
    //���ῴ��init������destroy���������
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