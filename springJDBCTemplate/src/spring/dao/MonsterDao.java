/**
 * 这个是dao 也就是database access object
 * 好比是模型，对应一个业务，或者一张表吧
 */
package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.bean.Monster;

@Repository
public class MonsterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void save(Monster m){
		String sql = "INSERT INTO monster VALUES(?,?,?)";
		jdbcTemplate.update(sql,m.getId(),m.getName(),m.getSkill());
	}
}
