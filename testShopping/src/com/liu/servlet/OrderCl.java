package com.liu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.model.*;

/**
 * Servlet implementation class OrderCl
 */
@WebServlet("/OrderCl")
public class OrderCl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=req.getParameter("type");
		OrderBeanBo obb = new OrderBeanBo();
		MycartBo mb = (MycartBo) req.getSession().getAttribute("mycart");
		UserBean ub = (UserBean)req.getSession().getAttribute("userinfo");
		OrderInfoBean oib =obb.addOrder(mb, ub.getUserid()+"");
		if(oib != null){
			//传递数据
			req.setAttribute("orderId", oib.getOrdersId());
			//刷新浏览器会造成重复订单信息，这是内部跳转不好的地方
			req.getRequestDispatcher("orderTrue.jsp").forward(req, res);
		}else{
			req.getRequestDispatcher("order.jsp").forward(req, res);
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
