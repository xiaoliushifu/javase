package com.liu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.model.MycartBo;

/**
 * Servlet implementation class CartCl
 */
@WebServlet("/CartCl")
public class CartCl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartCl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsId = req.getParameter("goodsId");
		
		//购物车要跟session关联，而不是每次都实例化。
		//否则购买一次都是新的购物车，只显示最后一个购物车的信息
		MycartBo mbo = (MycartBo)req.getSession().getAttribute("mycart");
		if(mbo == null) {
			mbo = new MycartBo();
			req.getSession().setAttribute("mycart", mbo);
		}
		//默认购买数量是1，后面可修改
		mbo.addGoods(goodsId, "1");
		
		//从购物车中拿到全部商品，交到jsp视图显示
		ArrayList al = mbo.showCart();
		req.setAttribute("goodsInfo", al);
		//内部跳转到购物车页面
		req.getRequestDispatcher("showMycart.jsp").forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
