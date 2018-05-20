package spring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao {
	
	public void save(){
		System.out.println("save a good");
	}
}
