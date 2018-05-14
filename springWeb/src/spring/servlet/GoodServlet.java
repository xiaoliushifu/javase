/**
 * 这就是原生的java web开发，servlet和tomcat交互
 * jsp生成servlet
 */
package spring.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import spring.service.GoodsService;

/**
 * Servlet implementation class GoodServlet
 * servlet就好比是控制器
 * 又回到servlet了
 */
public class GoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GoodsService goodsService;
    private ApplicationContext ac;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(){
    	//从ServletContext中获得 监听器里存储好的spring ioc容器
    	ac = (ApplicationContext) this.getServletContext().getAttribute("my_ioc");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GoodsService gs = ac.getBean(GoodsService.class);
		gs.save();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
