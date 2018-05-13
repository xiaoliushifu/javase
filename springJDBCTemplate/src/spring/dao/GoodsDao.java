package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.entity.Goods;

@Repository
public class GoodsDao {
	
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	
	//因为本次是spring整合hibernate操作数据库，故使用sessionfactory
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	/**
	 * 使用事务时必须是同一个session，也就是使用
	 * getCurrentSession()方法获得session
	 * @return
	 */
	public Session getSession(){
		//使用事务时用这个,且必须使用事务，待使用service再用该种方式
		return sessionFactory.getCurrentSession();
		//使用下面这个的话，事务不起作用，测试dao的某个方法时可以使用这个
		//return sessionFactory.openSession();
	}
	
	/**
	 * 根据商品ID获取商品的价格
	 * 使用hibernate方式
	 * @param id
	 * @return
	 */
	public float queryPriceById(Integer id){
		session = getSession();
		Goods good = (Goods) session.get(Goods.class, id);
		return good.getPrice();
	}
	
	/**
	 * 扣除用户的余额
	 * 如何写sql，并用hibernate传参方式
	 * @param uid
	 * @param money
	 */
	public void updateBalance(Integer uid,float money){
		session = getSession();
		//hql语句不是sql语句，有区别
		String hql="UPDATE User u set u.money=u.money-? where u.userId=?";
		session.createQuery(hql)
		.setFloat(0, money)
		.setInteger(1, uid)
		.executeUpdate();
		
	}
	
	/**
	 * 更新商品的数量
	 * 还是使用hibernate方式
	 * @param goodsId
	 * @param goodsNum
	 */
	public void updateMount(Integer goodsId,Integer goodsNum){
		session = getSession();
		//注意表名是Goods,对应实体类名
		//goods_id应该写成实体类的属性成员名goodsID
		//千万注意，hql语句和sql语句是不同的
		String hql="UPDATE Goods g set g.amount=g.amount-? where g.goodsID=?";
		session.createQuery(hql)
		.setInteger(0, goodsNum)
		.setInteger(1, goodsId)
		.executeUpdate();
	}
}
