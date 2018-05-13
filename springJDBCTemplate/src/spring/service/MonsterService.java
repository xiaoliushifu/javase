/**
 * 这是业务层，一般是可以复用的代码
 * 需要引用dao层对象，可以有多种
 */
package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.bean.Monster;
import spring.dao.MonsterDao;

@Service
public class MonsterService {
	
	@Autowired
	private MonsterDao monsterDao;
	public void save(Monster m){
		monsterDao.save(m);
	}
}
