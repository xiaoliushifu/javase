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
	 *�ú������ڳ�ʼ����Servlet����
	 *��ֻ�ᱻ����һ�Σ����û���һ�η���ʱ��
	 *
	 * @param parm1
	 *
	 @throws ServletException
	 *
	 */
	public void init(ServletConfig parm1) throws ServletException {
		// TODO: Add your code here
		//������������Tomcat�ĺ�̨���ܿ���
		System.out.println("init it");
	}

	/**
	 * Method getServletConfig
	 * �ݲ����
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
	 *�ú������ڴ���ҵ���߼�������Ա������
	 *��ʼд����ҵ��Ĵ���
	 *�û�ÿ�η��ʸ�servlet����ʱ���������
	 * @param req  ���ڻ�ÿͻ�����Ϣ
	 * @param res  ������ͻ��˷�����Ϣ
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
	 * �ݲ����
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
	 * ����servletʵ�����ͷ��ڴ棩
	 *1 reload
	 *2 �ر�tomcat
	 */
	public void destroy() {
		// TODO: Add your code here
		System.out.println("destroy it");
	}

}