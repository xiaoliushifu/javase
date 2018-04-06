/**
 * 这里尝试自定义一个拦截器玩玩
 * 可以继承一个抽象拦截器，也可以实现一个拦截器接口
 * 
 */
package com.liu.struts.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Myintercepter implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("my destroy...");
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("my init...");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("调用我的拦截器之前.....");
		
		//上述处理完成之后，调用invoke来继续往下进行其他拦截器处理，层层递进再层层递出
		//如果想再某个拦截器停止不再后续调用，则返回对应的一个result字符串即可
		/*
		//返回该字符串，将会找到一个result。
		//return "errors";
		*/
		String result = invocation.invoke();
		System.out.println("调用我的拦截器之后.....");
		return result;
	}

}
