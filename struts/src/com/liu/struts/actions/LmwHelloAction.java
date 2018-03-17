package com.liu.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

//action需要继承一个父类ActionSupport

public class LmwHelloAction extends ActionSupport{

	//我们重新父类的一个方法
	//execute
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hello 明伟啊");
		//return super.execute();
		return "success";
	}

}
