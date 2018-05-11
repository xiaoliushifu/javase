package spring.test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.bean.Monster;

public class JdbcTest {

	private ApplicationContext applicationContext;
	
	/**
	 * 这是Junit可以配置的注解，在执行所有测试方法之前调用
	 */
	@Before
	public void init(){
		applicationContext	 = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 数据源对象的获取，这是后续数据库操作的基础
	 * @throws SQLException
	 */
	@Test
	public void test01() throws SQLException {
		
		DataSource obj = applicationContext.getBean(DataSource.class);
		System.out.println(obj.getConnection());
		System.out.println("bean"+ obj.toString());
	}
	
	@Test
	public void test02() throws SQLException {
		//按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		//编写sql
		String sql = "insert into  `monster` VALUES(null,'你好','说话')";
		//执行sql
		obj.execute(sql);
	}
	
	/**
	 * 使用jdbc更新  带有问号参数
	 * @throws SQLException
	 */
	@Test
	public void test03() throws SQLException {
		//按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		//编写sql
		String sql = "update `monster` set skill=? where id=?";
		//执行sql
		Integer affectedNum = obj.update(sql,"吐苦水",2);
		System.out.println(affectedNum);
		
		
		//批量插入batchUpdate  支持问号
		//编写sql
		sql = "INSERT INTO  `monster` VALUES(?,?,?)";
		//准备数据,右边是子类，左边是父类
		//注意，List好比是php的大的索引数组，
		//而内部的二维数组也是索引数组，数组元素都是对象而已。 
		//注意对象数组，是说数组元素都是对象
		List<Object[]> ls = new ArrayList<Object[]>();
		ls.add(new Object[]{10,"白蛇精","水漫金山"});
		ls.add(new Object[]{20,"青蛇精","收五鬼"});
		
		//批量插入
		obj.batchUpdate(sql, ls);
	
	}
	
	/**
	 * RowMapper对象，把数据库的一条记录，映射为一个模型对象
	 * 类似于Yii2的AR模型，非常棒
	 * 省略了直接写代码 实例化出模型然后通过set方法赋值的过程。
	 * @throws SQLException
	 */
	@Test
	public void test04() throws SQLException {
		//按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		//编写sql
		String sql = "SELECT id,name,skill FROM  `monster` where id=?";
		//封装一个rowmapper接口，把查询结果封装到对象中
		RowMapper<Monster> rowMapper = 
				new BeanPropertyRowMapper<Monster>(Monster.class);
		
		//执行查询并赋值到一个monster对象m
		Monster m = obj.queryForObject(sql, rowMapper, 10);
		System.out.println(m);
		
	}
}