package com.liu.struts.actions;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//action需要继承一个父类ActionSupport

public class LmwHelloAction extends ActionSupport{

	private String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	private String pwd;

	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 自定义order方法 该方法就对应struts.xml中的一个<action method="order" name="xxx">
	 * 
	 * @return String 返回类型必须是String
	 */
	public String login() {
		System.out.println("username:" + username + " pass=" + pwd);
		// 查看接收参数id的数据类型自动由字符串转换为整型
		if ("123".equals(pwd)) {
			return "ok";
		}
		return "loginError";
	}
}
