package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.MonsterDao;
import spring.entity.Monster;

@Service
public class MonsterService {
	
	@Autowired
	private MonsterDao monsterDao;
	
	@Transactional(readOnly=true)
	public List<Monster> list(){
		return monsterDao.list();
	}
}
