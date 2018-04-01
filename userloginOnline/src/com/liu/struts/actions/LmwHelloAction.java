package com.liu.struts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//action需要继承一个父类ActionSupport

public class LmwHelloAction extends ActionSupport implements ApplicationAware, SessionAware {

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

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 自定义order方法 该方法就对应struts.xml中的一个<action method="order" name="xxx">
	 * 
	 * @return String 返回类型必须是String
	 */
	public String login() {
		// 用contains（has)方法直接判断有无，无需取出来再判断是否是null
		if (session.containsKey("username")) {
			return "loginOk";
		}
		// 查看接收参数id的数据类型自动由字符串转换为整型
		if ("123".equals(pwd)) {
			session.put("username", username);
			Integer onlineTotalNum = (Integer) application.get("onlineTotalNum");
			if (onlineTotalNum == null) {
				onlineTotalNum = 0;
			}
			onlineTotalNum++;
			application.put("onlineTotalNum", onlineTotalNum);

			return "loginOk";
		}
		return "loginError";

	}

	public String logout() {
		if (session.containsKey("username")) {
			session.remove("username");
		}
		Integer onlineTotalNum = (Integer) application.get("onlineTotalNum");
		onlineTotalNum--;
		application.put("onlineTotalNum", onlineTotalNum);
		return "exit";
	}

	private Map<String, Object> application;

	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
	}

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session = arg0;
	}
}
