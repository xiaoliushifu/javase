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

        int pn= Integer.parseInt(req.getParameter("pageNow"));
        String u = req.getParameter("u");

        UserBeanCl ubl = new UserBeanCl();
        ArrayList al = ubl.getUserList(pn);
        int pc = ubl.getPageCount();
        req.setAttribute("pageCount",pc);
        req.setAttribute("result",al);
        //内部跳转
        req.getRequestDispatcher("wel.jsp?u="+u+"&pageNow="+pn).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
