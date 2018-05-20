package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.GoodsDao;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	public void save(){
		goodsDao.save();
	}
}
