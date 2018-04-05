package com.liu.struts.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.liu.struts.dao.PetDao;
import com.opensymphony.xwork2.ActionSupport;

public class PetAction extends ActionSupport implements RequestAware{
	
	private PetDao petdao = new PetDao();
	//准备使用通配符方法
	public String list(){
		ArrayList al = petdao.list();
		request.put("petlist", al);
		System.out.println("list....()");
		return "list";
	}
	private Map<String,Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
}
