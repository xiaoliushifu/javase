package com.liu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.model.GoodsBeanBo;
import com.liu.model.GoodsBean;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = req.getParameter("type");
		if(type !=null && type.equals("fenye")) {
			req.setAttribute("abc", req.getParameter("pageNow"));
			req.getRequestDispatcher("index.jsp").forward(req, res);
			return;
		}
		//获得请求的ID
		String goodsId = req.getParameter("goodsId");
		//查询到bean
		GoodsBeanBo gbb = new GoodsBeanBo();
		GoodsBean gb = gbb.getGood(Integer.parseInt(goodsId));
		//带上参数，内部跳转
		req.setAttribute("goodsInfo", gb);
		req.getRequestDispatcher("showDetail.jsp").forward(req, res);
		//res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
