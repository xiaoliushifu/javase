package com.liu.struts.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//action需要继承一个父类ActionSupport

public class LmwHelloAction extends ActionSupport {

	private Integer id;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public LmwHelloAction() {
		super();
		System.out.println("实例化");
		// TODO Auto-generated constructor stub
	}

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

	// 我们重新父类的一个方法
	// execute
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * struts.xml的一个<action>的method属性默认就是execute
	 * 所以该execute方法与struts.xml中没有写method属性的<action>映射
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("hello 明伟啊");
		return "success";
	}

	/**
	 * 自定义order方法 该方法就对应struts.xml中的一个<action method="order" name="xxx">
	 * 
	 * @return String 返回类型必须是String
	 */
	public String login() {
		// Action类中获取域对象的方式1

		// 首先获取ActionContext对象
		ActionContext context = ActionContext.getContext();

		// 获取application这个map对象
		Map<String, Object> application = context.getApplication();
		// 放入一对数据
		application.put("app1", "app1 value");

		// 获取session域对象
		Map<String, Object> session = context.getSession();
		session.put("ses1", "ses1 value");

		// queryString参数的域对象
		Map<String, Object> parameter = context.getParameters();
		// java这一点不太好，好多场景下需要强制转换类型
		String[] addresses = (String[]) parameter.get("address");
		for (String add : addresses) {
			System.out.println("address=" + add);
		}

		// 获取request域对象，有点特殊
		Map<String, Object> request = (Map<String, Object>) context.get("request");
		request.put("req1", "req1 value");

		System.out.println("username:" + username + " pass=" + pwd);
		// 查看接收参数id的数据类型自动由字符串转换为整型
		System.out.println("id=" + id + "数据类型是" + id.getClass().getName());
		if ("123".equals(pwd)) {
			return "loginOk";
		}
		return "loginError";

	}

}
