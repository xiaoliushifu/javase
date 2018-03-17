/**
 * 用户的删除，修改，添加，分页显示
 */
package com.liu.controller;

import com.liu.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String flag = req.getParameter("flag");
        System.out.println("flag="+flag);
        if(flag.equals("admin")) {
            int pn = Integer.parseInt(req.getParameter("pageNow"));
            String u = req.getParameter("u");

            UserBeanCl ubl = new UserBeanCl();
            ArrayList al = ubl.getUserList(pn);
            int pc = ubl.getPageCount();
            req.setAttribute("pageCount", pc);
            req.setAttribute("result", al);
            //内部跳转
            req.getRequestDispatcher("wel.jsp?u=" + u + "&pageNow=" + pn).forward(req, resp);
        }else if(flag.equals("del")){
            int uid=Integer.parseInt(req.getParameter("uid"));
            UserBeanCl ubl = new UserBeanCl();
            if(ubl.delUser(uid)){
                req.getRequestDispatcher("suc.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("err.jsp").forward(req, resp);
            }
            return;
        }else if(flag.equals("add")){
            //获得客户端数据
            String uname=req.getParameter("uname");
            String passwd=req.getParameter("passwd");
            int age=Integer.parseInt(req.getParameter("age"));
            System.out.println("uname="+uname+" pass="+passwd+" age="+age);
            //调用模型操作
            UserBeanCl ubl = new UserBeanCl();
            if(ubl.addUser(uname,passwd,age)){
                req.getRequestDispatcher("suc.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("err.jsp").forward(req, resp);
            }
            return;
        }else {
            req.getRequestDispatcher("err.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
