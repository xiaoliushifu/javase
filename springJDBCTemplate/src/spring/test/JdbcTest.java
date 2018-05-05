package spring.test;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}