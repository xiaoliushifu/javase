/**
 * @(#)UserDel.java
 *  删除用户
 *
 * @author 
 * @version 1.00 2018/3/10
 */
package com.liu;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserDel extends HttpServlet{

    //
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            //接收用户名和密码
            String u = req.getParameter("uid");
            
            UserBeanCl ubl = new UserBeanCl();
            //调用ubl执行用户处理的方法
            if(ubl.delUser(u)) {
            	res.sendRedirect("ok");
            } else {
            	//给一个跳转页
            	res.sendRedirect("error");
            	return;
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