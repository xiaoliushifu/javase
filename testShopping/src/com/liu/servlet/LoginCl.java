package com.liu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.model.MycartBo;
import com.liu.model.UserBean;
import com.liu.model.UserBeanBo;

/**
 * Servlet implementation class LoginCl
 */
@WebServlet("/LoginCl")
public class LoginCl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=req.getParameter("type");
		if(type.equals("checkLogin")) {
			//从session中读取信息，查看用户是否登录
			UserBean ub = (UserBean) req.getSession().getAttribute("userinfo");
			if(ub==null) {
				req.getRequestDispatcher("loginAregis.jsp").forward(req, res);
			} else {
				//获得购物车信息，转交下个页面
				MycartBo mbo = (MycartBo)req.getSession().getAttribute("mycart");
				req.setAttribute("mycartlist", mbo.showCart());
				req.getRequestDispatcher("order.jsp").forward(req, res);
			}
		}else if(type.equals("login")) {
			UserBeanBo ubo = new UserBeanBo();
			String uname= req.getParameter("userName");
			String pass = req.getParameter("pass");
			if(ubo.Login(uname, pass)) {
				UserBean ub = ubo.getUserBean(uname);
				//用户信息放到session中
				req.getSession().setAttribute("userinfo", ub);
				
				//获得购物车信息，转交下个页面
				MycartBo mbo = (MycartBo)req.getSession().getAttribute("mycart");
				req.setAttribute("mycartlist", mbo.showCart());
				
				req.getRequestDispatcher("order.jsp").forward(req, res);
			}else{
				req.getRequestDispatcher("loginAregis.jsp").forward(req, res);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
