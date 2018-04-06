package com.liu.struts.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.liu.struts.bean.Pet;
import com.liu.struts.dao.PetDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PetAction extends ActionSupport implements RequestAware,ModelDriven<Pet>{
	
	private Pet pet = null;	
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
		//初始时pet对象只有id参数
		pet = petdao.get(this.pet.getId());
		ActionContext.getContext().getValueStack().push(pet);
		return "updateUI";
	}
	
	//执行post操作的更新
	public String update(){
		petdao.update(pet);
		return "list2";
	}
	
	/*
	 * 添加宠物的post操作
	 * */
	public String add(){
		//实例化一个宠物对象,无需实例化赋值过程，
		
		//直接教给dao去保存
		petdao.save(pet);
		return "list2";
	}
	
	//处理删除宠物
	public String delete(){
		petdao.delete(pet.getId());
		return "list2";
	}
	
	
	private Map<String,Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	/**
	 * 方便pet对象的赋值
	 * 我们实现modelDriven接口的方式来完成pet对象的赋值，这样这些id,nickName属性就
	 * 不会出现在我们的Action中了
	 * 这里仅仅是把Action类放入值栈中而已，赋值是在parameter拦截器中做的。
	 */
	@Override
	public Pet getModel() {
		pet = new Pet();
		return pet;
	}
}
