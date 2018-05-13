package spring.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import spring.bean.Monster;
import spring.controller.MonsterController;
import spring.dao.GoodsDao;
import spring.service.GoodsService;

public class JdbcTest {

	private ApplicationContext applicationContext;

	/**
	 * 这是Junit可以配置的注解，在执行所有测试方法之前调用
	 */
	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * 数据源对象的获取，这是后续数据库操作的基础
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test01() throws SQLException {

		DataSource obj = applicationContext.getBean(DataSource.class);
		System.out.println(obj.getConnection());
		System.out.println("bean" + obj.toString());
	}

	@Test
	public void test02() throws SQLException {
		// 按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		// 编写sql
		String sql = "insert into  `monster` VALUES(null,'你好','说话')";
		// 执行sql
		obj.execute(sql);
	}

	/**
	 * 使用jdbc更新 带有问号参数
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test03() throws SQLException {
		// 按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		// 编写sql
		String sql = "update `monster` set skill=? where id=?";
		// 执行sql
		Integer affectedNum = obj.update(sql, "吐苦水", 2);
		System.out.println(affectedNum);

		// 批量插入batchUpdate 支持问号
		// 编写sql
		sql = "INSERT INTO  `monster` VALUES(?,?,?)";
		// 准备数据,右边是子类，左边是父类
		// 注意，List好比是php的大的索引数组，
		// 而内部的二维数组也是索引数组，数组元素都是对象而已。
		// 注意对象数组，是说数组元素都是对象
		List<Object[]> ls = new ArrayList<Object[]>();
		ls.add(new Object[] { 10, "白蛇精", "水漫金山" });
		ls.add(new Object[] { 20, "青蛇精", "收五鬼" });

		// 批量插入
		obj.batchUpdate(sql, ls);

	}

	/**
	 * RowMapper对象，把数据库的一条记录，映射为一个模型对象 类似于Yii2的AR模型，非常棒 省略了直接写代码
	 * 实例化出模型然后通过set方法赋值的过程。
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test04() throws SQLException {
		// 按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		// 编写sql
		String sql = "SELECT id,name,skill FROM  `monster` where id=?";
		// 封装一个rowmapper接口，把查询结果封装到对象中
		RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<Monster>(Monster.class);

		// 执行查询并赋值到一个monster对象m
		Monster m = obj.queryForObject(sql, rowMapper, 10);
		System.out.println(m);

	}

	/**
	 * 查询返回有多行记录的方法
	 * 直接映射为一个集合
	 */
	@Test
	public void test05() {
		// 按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		// 编写sql
		String sql = "SELECT id,name,skill FROM  `monster` where id>?";
		// 封装一个rowmapper接口，把查询结果封装到对象中
		RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<Monster>(Monster.class);

		// 返回一个list集合
		List<Monster> list = obj.query(sql, rowMapper, 1);
		for (Monster m : list) {
			System.out.println(m);
		}
	}
	
	/**
	 * 返回单行单列的情况
	 * 
	 */
	@Test
	public void test06() {
		// 按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		// 编写sql
		/*String sql = "SELECT name FROM  `monster` where id=10";
		String name = obj.queryForObject(sql, String.class);
		System.out.println("一个妖怪的名字:"+ name);*/
		
		String sql = "SELECT count(*) FROM  `monster`";
		Integer count = obj.queryForObject(sql, Integer.class);
		System.out.println("妖怪数量:"+ count);
	}
	/**
	 * 使用另一个jdbcTemplate对象，可传递命名参数
	 * 使用具名参数而不是问号的方式向sql语句中注入参数
	 * 优点是参数顺序可调整
	 */
	@Test
	public void test07() {
		NamedParameterJdbcTemplate obj = applicationContext.getBean(NamedParameterJdbcTemplate.class);
		// 编写sql,带有名字的参数
		String sql = "INSERT INTO monster VALUES(:id,:name,:skill)";
		//使用map集合来给具名参数赋值
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 9);
		map.put("name", "螃蟹精2");
		map.put("skill", "~大钳子嘿哈~");
		//选择用update方法来完成【添加】操作
		obj.update(sql, map);
	}
	/**
	 * 直接以某个对象作为参数执行sql语句
	 * 但是对象的成员名字要和具名参数一致才行
	 */
	@Test
	public void test08() {
		NamedParameterJdbcTemplate obj = applicationContext.getBean(NamedParameterJdbcTemplate.class);
		// 编写sql,带有名字的参数
		String sql = "INSERT INTO monster VALUES(:id,:name,:skill)";
		
		//实例化一个对象，该对象的成员属性名称要和具名参数完全一致才行
		Monster m = new Monster("狐狸精",11,"美人计");
		//对象构造参数
		SqlParameterSource source= new BeanPropertySqlParameterSource(m);
		//选择用update方法来完成【添加】操作
		obj.update(sql, source);
	}
	/**
	 * 一个从上到下的设计
	 * 一个从下到上的编写
	 * 控制器---》业务层---》数据层
	 * 每层之间的配置使用基于注解的自动配置autowired。
	 */
	@Test
	public void test09() {
		// 按照bean的id获取monster对象
		MonsterController obj = applicationContext.getBean(MonsterController.class);
		obj.save(new Monster("大虾",30,"加自控"));
	}
	
	@Test
	public void test10() {
		// 按照bean的id获取monster对象
		GoodsService obj = applicationContext.getBean(GoodsService.class);
		obj.buyGoods(1, 1, 9);
	}
}