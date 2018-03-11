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
            //使用判断是否为空就行，不必严格p.equals("ok")
            if (p != null) {
                pw.println("hello 你的用户名是："+u+"<br>");
                
            } else {
            	//获得cookie再判断
            	if(checkCookie(req.getCookies(),res)){
            		return;
            	}
            	res.sendRedirect("login");//该句之后仍然会继续执行代码
            	return;
            }
            //===============增加分页功能=========================================
            int pageSize=4;//每页显示几条数据
            int pageNow=1; //当前第几页
            
            //获得参数
            String pn = req.getParameter("pageNow");
            if (pn != null) {
            	int num = Integer.parseInt(pn);
            	pageNow = num>0?num:1;
            }
            UserBeanCl ubl = new UserBeanCl();
            ArrayList al = ubl.getResultByPage(pageSize,pageNow);
            pw.println("<table border=1 ><br>");
            pw.println("<tr><th>编号</th><th>姓名</th><th>密码</th><th>年龄</th><th>操作</th></tr>");
            for(int i=0; i<al.size(); i++){
            	UserBean ub = (UserBean)(al.get(i));
            	pw.println("<tr>");
            	pw.println("<td>"+ub.getId()+"</td>");
            	pw.println("<td>"+ub.getUname()+"</td>");
            	pw.println("<td>"+ub.getPass()+"</td>");
            	pw.println("<td>"+ub.getAge()+"</td>");
            	pw.println("<td><a href=''>修改 | 删除</a></td>");
            	pw.println("</tr>");
            }
            pw.println("</table>");
            
            //上一页
            if (pageNow > 1) {
            	pw.println("<a href=welcome?pageNow="+(pageNow-1)+">上一页</a>");
            }
            //循环遍历出页号，供页面点击。初始连接是当前页码递增
            //链接数量与pageSize同
            for(int i=pageNow;i<=pageNow+pageSize-1;i++) {
            	pw.println("<a href=welcome?pageNow="+i+">"+i+"</a>");
            }
            
            //if(pageNow < pageCount) {
            	pw.println("<a href=welcome?pageNow="+(pageNow+1)+">下一页</a>");
            //}
            //===============增加分页功能=========================================
            
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
     *检测cookie
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
	    	//不为空，则跳转到控制页去检测
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