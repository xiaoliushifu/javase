package com.liu.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

//action需要继承一个父类ActionSupport
public class MessageAction extends ActionSupport{

	
	public String sayHello() throws Exception {
		return SUCCESS;
	}
	
	public String go() throws Exception {
		System.out.println("go");
		return SUCCESS;
	}
}
