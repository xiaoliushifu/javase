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
		System.out.println("init it");
	}

	/**
	 * Method getServletConfig
	 *
	 *
	 * @return
	 *
	 */
	public ServletConfig getServletConfig() {
		// TODO: Add your code here
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
		
	}

	/**
	 * Method getServletInfo
	 *
	 *
	 * @return
	 *
	 */
	public String getServletInfo() {
		// TODO: Add your code here
	}

	/**
	 * Method destroy
	 *
	 *
	 */
	public void destroy() {
		// TODO: Add your code here
	}

}