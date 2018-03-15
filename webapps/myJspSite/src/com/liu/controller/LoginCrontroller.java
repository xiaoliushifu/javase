/**
 * 控制器本身不完成业务逻辑，主要是调用model完成对数据处理
 */
package com.liu.controller;

import com.liu.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCrontroller extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户名和密码
        System.out.print("hello"+Math.random());
        String u= req.getParameter("username");
        String p=req.getParameter("passwd");

        //实例化该对象，用它的一个方法完成验证过程
        UserBeanCl ubl = new UserBeanCl();
        if(ubl.checkLogin(u,p)){
            //sendRedirect效率较低，生产环境不用它
            //response.sendRedirect("wel.jsp?u="+u);
            //直接转发，req还可以在下一页面中使用
            req.getRequestDispatcher("wel.jsp?u="+u).forward(req,resp);
        }else{
            //response.sendRedirect("login.jsp");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
