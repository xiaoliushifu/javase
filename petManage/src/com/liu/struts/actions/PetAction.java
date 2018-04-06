package com.liu.struts.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.liu.struts.bean.Pet;
import com.liu.struts.dao.PetDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PetAction extends ActionSupport implements RequestAware{
	
	private Integer id;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}

	/**
	 * @param resume the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}


	private String  nickName;
	private String resume;
	
	
	private PetDao petdao = new PetDao();
	//准备使用通配符方法
	public String list(){
		ArrayList<Pet> al = petdao.list();
		request.put("petlist", al);
		return "list";
	}
	
	//一个仅仅给出ui页面的方法（编辑页，添加页等）
	public String addUI(){
		return "addUI";
	}
	
	//一个仅仅给出ui页面的方法（编辑页，添加页等）
	public String updateUI(){
		Pet pet = petdao.get(id);
		//两种方式返回到updateUI.jsp
			//1把pet对象压人值栈的root/对象栈顶
		ActionContext.getContext().getValueStack().push(pet);
		
			//2
		return "updateUI";
	}
	
	//执行post操作的更新
	public String update(){
		Pet pet = new Pet(id, nickName, resume);
		petdao.update(pet);
		return "list2";
	}
	
	/*
	 * 添加宠物的post操作
	 * */
	public String add(){
		//实例化一个宠物对象
		Pet p = new Pet(null,nickName,resume);
		//教给dao去保存
		petdao.save(p);
		return "list2";
	}
	
	//处理删除宠物
	public String delete(){
		petdao.delete(id);
		return "list2";
	}
	
	
	private Map<String,Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
}
