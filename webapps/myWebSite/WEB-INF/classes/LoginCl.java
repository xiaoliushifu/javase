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
import java.io.*;



public class LoginCl extends HttpServlet{

    //
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            PrintWriter pw = res.getWriter();
            
            //接收用户名和密码
            String u = req.getParameter("username");
            String p = req.getParameter("passwd");
            
            //同一个包下的public类，无需import引入
            //实例化数据库连接
            DbConn db = new DbConn();
            //调用方法查询数据库
            if(db.check(u,p)) {
            	//合法,将用户信息写入session
            	//得到session类
            	HttpSession hs = req.getSession(true);
            	//修改session的发呆时间
            	hs.setMaxInactiveInterval(20);
            	//写入服务端空间中
            	hs.setAttribute("pass","ok");
            	
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
    
}