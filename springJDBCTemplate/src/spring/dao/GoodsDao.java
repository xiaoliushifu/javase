package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据商品ID获取商品的价格
	 * @param id
	 * @return
	 */
	public float queryPriceById(Integer id){
		String sql="SELECT price FROM goods WHERE goods_id=?";
		Float price = jdbcTemplate.queryForObject(sql,Float.class,id);
		return price;
	}
	
	/**
	 * 扣除用户的余额
	 * @param uid
	 * @param money
	 */
	public void updateBalance(Integer uid,float money){
		String sql="UPDATE user_account set money=money-? where user_id=?";
		jdbcTemplate.update(sql,money,uid);
	}
	
	/**
	 * 更新商品的数量
	 * @param goodsId
	 * @param goodsNum
	 */
	public void updateMount(Integer goodsId,Integer goodsNum){
		String sql="UPDATE goods_amount set goods_num=goods_num-? where goods_id=?";
		jdbcTemplate.update(sql,goodsNum,goodsId);
	}
}
