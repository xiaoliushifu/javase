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
            
            //�����û���������
            String u = req.getParameter("username");
            String p = req.getParameter("passwd");
            
            //ͬһ�����µ�public�࣬����import����
            //ʵ�������ݿ�����
            DbConn db = new DbConn();
            //���÷�����ѯ���ݿ�
            if(db.check(u,p)) {
            	//�Ϸ�,���û���Ϣд��session
            	//�õ�session��
            	HttpSession hs = req.getSession(true);
            	//�޸�session�ķ���ʱ��
            	hs.setMaxInactiveInterval(20);
            	//д�����˿ռ���
            	hs.setAttribute("pass","ok");
            	
            	res.sendRedirect("welcome");
            } else {
            	//���Ϸ�����ת��ȥ
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