package spring.test;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {

	private ApplicationContext applicationContext;
	
	/**
	 * 这是Junit可以配置的注解，在执行所有测试方法之前调用
	 */
	@Before
	public void init(){
		applicationContext	 = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void test01() throws SQLException {
		//按照bean的id获取monster对象
		DataSource obj = applicationContext.getBean(DataSource.class);
		System.out.println(obj.getConnection());
		System.out.println("bean"+ obj.toString());
	}
	
	@Test
	public void test02() throws SQLException {
		//按照bean的id获取monster对象
		JdbcTemplate obj = applicationContext.getBean(JdbcTemplate.class);
		//编写sql
		String sql = "insert into  `monster` VALUES(null,'你好','说话3')";
		//执行sql
		obj.execute(sql);
	}
}