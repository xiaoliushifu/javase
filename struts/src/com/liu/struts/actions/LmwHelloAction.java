package com.liu.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

//action需要继承一个父类ActionSupport

public class LmwHelloAction extends ActionSupport{

	//我们重新父类的一个方法
	//execute
	/* (non-Javadoc)
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
	 * 自定义order方法
	 * 该方法就对应struts.xml中的一个<action method="order" xxx>
	 * @return String
	 * 返回类型必须是String
	 */
	public String order(){
		System.out.println("下订单成功2");
		return "orderError";
	}

}
