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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.*;



public class LoginCl extends HttpServlet{

    //
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            PrintWriter pw = res.getWriter();
            
            //接收用户名和密码
            String u = req.getParameter("username");
            String p = req.getParameter("passwd");
            
            UserBeanCl ubl = new UserBeanCl();
            //调用方法查询数据库
            if(ubl.check(u,p)) {
            	//合法,将用户信息写入session
            	//得到session类
            	HttpSession hs = req.getSession(true);
            	//修改session的发呆时间
            	//hs.setMaxInactiveInterval(60);
            	//写入服务端空间中
            	hs.setAttribute("pass","ok");
            	hs.setAttribute("name",u);
            	String k=req.getParameter("keep");
            	if(k != null){
            		//姓名和密码写入cookie,一周
            		saveCookie("name",u,res);
            		saveCookie("pass",p,res);
            	}
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
    
    /**
     *向客户端注入cookie
     */
    public void saveCookie(String name,String value,HttpServletResponse res){
		Cookie c= new Cookie(name,value);
		c.setMaxAge(3600*24*7);//1周
		c.setHttpOnly(true);
		res.addCookie(c);
    }
    
}