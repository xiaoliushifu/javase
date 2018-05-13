package spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springHibernate {

	private ApplicationContext applicationContext;
	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * 启动容器，就会创建bean对象，
	 * 也就创建了hibernate配置的实体类对应的表
	 */
	@Test
	public void test() {
		System.out.print("创建表");
	}
}