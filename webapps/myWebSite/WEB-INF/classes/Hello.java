package com.liu;

import javax.servlet.*;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello  implements Servlet
{
	/**
	 * Method init
	 *该函数用于初始化该Servlet程序
	 *且只会被调用一次（当用户第一次访问时）
	 *
	 * @param parm1
	 *
	 @throws ServletException
	 *
	 */
	public void init(ServletConfig parm1) throws ServletException {
		// TODO: Add your code here
		//这里的输出是在Tomcat的后台才能看到
		System.out.println("init it");
	}

	/**
	 * Method getServletConfig
	 * 暂不理会
	 *
	 * @return
	 *
	 */
	public ServletConfig getServletConfig() {
		// TODO: Add your code here
		return null;
	}

	/**
	 * Method service
	 *
	 *该函数用于处理业务逻辑，程序员在这里
	 *开始写处理业务的代码
	 *用户每次访问该servlet程序时，都会调用
	 * @param req  用于获得客户端信息
	 * @param res  用于向客户端返回信息
	 *
	 @throws ServletException
	 @throws IOException
	 *
	 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO: Add your code here
		System.out.println("service it");
		PrintWriter pw = res.getWriter();
		pw.println("hello,world");
			
	}

	/**
	 * Method getServletInfo
	 * 暂不理会
	 *
	 * @return
	 *
	 */
	public String getServletInfo() {
		// TODO: Add your code here
		return "";
	}

	/**
	 * Method destroy
	 * 销毁servlet实例（释放内存）
	 *1 reload
	 *2 关闭tomcat
	 */
	public void destroy() {
		// TODO: Add your code here
		System.out.println("destroy it");
	}

}