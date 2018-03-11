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
import java.util.*;


public class Welcome extends HttpServlet{

    //
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
        	
        	res.setCharacterEncoding("gbk");
            PrintWriter pw = res.getWriter();
            pw.println("<html>");
            pw.println("<body><center>");
            pw.println("<img src='images/ques.png' height='100px'/><BR>");
            HttpSession hs = req.getSession(true);
            String p = (String) hs.getAttribute("pass");
            String u = (String) hs.getAttribute("name");
            //ʹ���ж��Ƿ�Ϊ�վ��У������ϸ�p.equals("ok")
            if (p != null) {
                pw.println("hello ����û����ǣ�"+u+"<br>");
                
            } else {
            	//���cookie���ж�
            	if(checkCookie(req.getCookies(),res)){
            		return;
            	}
            	res.sendRedirect("login");//�þ�֮����Ȼ�����ִ�д���
            	return;
            }
            //===============���ӷ�ҳ����=========================================
            int pageSize=4;//ÿҳ��ʾ��������
            int pageNow=1; //��ǰ�ڼ�ҳ
            
            //��ò���
            String pn = req.getParameter("pageNow");
            if (pn != null) {
            	int num = Integer.parseInt(pn);
            	pageNow = num>0?num:1;
            }
            UserBeanCl ubl = new UserBeanCl();
            ArrayList al = ubl.getResultByPage(pageSize,pageNow);
            pw.println("<table border=1 ><br>");
            pw.println("<tr><th>���</th><th>����</th><th>����</th><th>����</th><th>����</th></tr>");
            for(int i=0; i<al.size(); i++){
            	UserBean ub = (UserBean)(al.get(i));
            	pw.println("<tr>");
            	pw.println("<td>"+ub.getId()+"</td>");
            	pw.println("<td>"+ub.getUname()+"</td>");
            	pw.println("<td>"+ub.getPass()+"</td>");
            	pw.println("<td>"+ub.getAge()+"</td>");
            	pw.println("<td><a href=''>�޸� | ɾ��</a></td>");
            	pw.println("</tr>");
            }
            pw.println("</table>");
            
            //��һҳ
            if (pageNow > 1) {
            	pw.println("<a href=welcome?pageNow="+(pageNow-1)+">��һҳ</a>");
            }
            //ѭ��������ҳ�ţ���ҳ��������ʼ�����ǵ�ǰҳ�����
            //����������pageSizeͬ
            for(int i=pageNow;i<=pageNow+pageSize-1;i++) {
            	pw.println("<a href=welcome?pageNow="+i+">"+i+"</a>");
            }
            
            //if(pageNow < pageCount) {
            	pw.println("<a href=welcome?pageNow="+(pageNow+1)+">��һҳ</a>");
            //}
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
    
    /**
     *���cookie
     */
    public boolean checkCookie(Cookie []cookie,HttpServletResponse res){
    	String name="",pass="";
    	boolean b=false;
    	for(int i=0;i<cookie.length;i++){
    		Cookie c = cookie[i];
    		if(c.getName().equals("name")){
    			name = c.getValue();
    		}
    		if(c.getName().equals("pass")){
    			pass = c.getValue();
    		}
    	}
    	try{
	    	//��Ϊ�գ�����ת������ҳȥ���
	    	if(!name.equals("") && !pass.equals("")) {
	    		res.sendRedirect("loginCl?username="+name+"&passwd="+pass);
	    		return true;
	    	}
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    	return b;
    }
    
}