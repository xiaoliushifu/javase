package com.liu.struts.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.liu.struts.bean.Pet;

public class PetDao {
	private static Map<Integer,Pet> map= new HashMap<Integer,Pet>();
	private static Integer petId = 0;
	
	//只在第一次加载时执行到内存，以后不再调用
	static{
		map.put(++petId, new Pet(petId,"小米","这是一个米兔"));
		map.put(++petId, new Pet(petId,"小强","这是一个蟑螂"));
		map.put(++petId, new Pet(petId,"小花","这是一个小狗"));
	}
	
	public ArrayList list(){
		return new ArrayList(map.values());
	}
	
	public Pet get(Integer id){
		return map.get(id);
	}
	
	public void update(Pet pet){
		map.put(pet.getId(), pet);
	}
	
	public void save(Pet pet){
		pet.setId(++petId);
		map.put(petId, pet);
	}
	
	public void delete(Integer petId){
		map.remove(petId);
	}
}
