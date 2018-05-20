package spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.entity.Monster;

@Repository
public class MonsterDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Monster> list()
	{
		//使用迫切左外连接FETCH（获得关联表，门派表的门派信息,详情查看hibernate相关知识）
		//记住hql语句必须一次写成，否则再改也没有用
		String hql = "From Monster m LEFT JOIN FETCH m.school";
		return getSession().createQuery(hql).list();
	}
}
