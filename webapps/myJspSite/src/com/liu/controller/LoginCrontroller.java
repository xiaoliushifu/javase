/**
 * 控制器本身不完成业务逻辑，主要是调用model完成对数据处理
 */
package com.liu.controller;

import com.liu.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoginCrontroller extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户名和密码
        String u= req.getParameter("username");
        String p=req.getParameter("passwd");

        //实例化该对象，用它的一个方法完成验证过程
        UserBeanCl ubl = new UserBeanCl();
        u = new String(u.getBytes("ISO-8859-1"),"utf-8");
        System.out.print("u="+u+"p="+p);
        if(ubl.checkLogin(u,p)){

            //放入session中，以备后用
            HttpSession hs  = req.getSession();
            hs.setAttribute("myName",u);
            hs.setMaxInactiveInterval(60);


            //现在经过改进，不直接跳转到wel.jsp而是到main.jsp，所以下面的数据没必要了
            //在跳转到wel页面之前，把分页数据传递到request对象中，这样在wel.jsp中可以直接使用
            //ArrayList al = ubl.getUserList(1);
            //int pc = ubl.getPageCount();

            //放到request中
            //req.setAttribute("result",al);
            //req.setAttribute("pageCount",pc);
            req.getRequestDispatcher("main.jsp?pageNow=1").forward(req,resp);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
