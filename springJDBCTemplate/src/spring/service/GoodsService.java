package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.GoodsDao;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 用户购买商品
	 * @param uid
	 * @param gid
	 * @param goodsNum
	 * @Transactional 用上基于注解的声明式事务处理
	 * 不用写之前的try{}catch()代码了，不用写提交和回滚代码，方便不？
	 */
	@Transactional
	public void buyGoods(Integer uid,Integer gid,Integer goodsNum){
		Float price = goodsDao.queryPriceById(gid);
		//计算总价
		Float total = goodsNum * price;
		//更新总额
		goodsDao.updateBalance(uid, total);
		//更新商品数量
		goodsDao.updateMount(gid, goodsNum);
	}
	
	/**
	 * 使用hibernate方式里sessionFactory方式操作数据库
	 * @param uid
	 * @param gid
	 * @param goodsNum
	 */
	@Transactional
	public void buyGoods2(Integer uid,Integer gid,Integer goodsNum){
		Float price = goodsDao.queryPriceById(gid);
		//计算总价
		Float total = goodsNum * price;
		//更新总额
		goodsDao.updateBalance(uid, total);
		//更新商品数量
		goodsDao.updateMount(gid, goodsNum);
	}
}
