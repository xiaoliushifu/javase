/**
 * @(#)UserDel.java
 *  ɾ���û�
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
            //�����û���������
            String u = req.getParameter("uid");
            
            UserBeanCl ubl = new UserBeanCl();
            //����ublִ���û�����ķ���
            if(ubl.delUser(u)) {
            	res.sendRedirect("ok");
            } else {
            	//��һ����תҳ
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