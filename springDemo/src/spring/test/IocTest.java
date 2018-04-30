package spring.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.Monster;

public class IocTest {

	private ApplicationContext applicationContext;
	
	/**
	 * 这是Junit可以配置的注解，在执行所有测试方法之前调用
	 */
	@Before
	public void init(){
		//一句代码，就是加载ioc容器,自动实例化配置好的bean对象
		applicationContext	 = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	//从beans.xml中获取一个bean的java对象
	@Test
	public void test01() {
		//按照bean的id获取monster对象
		Object obj = applicationContext.getBean("monster01");
		System.out.println("bean"+ obj.toString());
	}
	/**
	 * 获取一个bean的java对象，用class的方式
	 * 这里注意的是beans.xml中的Monster类必须唯一
	 * 适用于单例场景
	 */
	@Test
	public void test02() {
		//按照bean的类名方式获取monster对象
		Object obj = applicationContext.getBean(Monster.class);
		System.out.println("bean class:"+ obj.toString());
	}
	
	//获取一个bean的java对象，用构造方法的方式index
	@Test
	public void test03() {
		//按照bean的类名方式获取monster对象
		Object obj = applicationContext.getBean("monster02");
		System.out.println("bean constructer:"+ obj.toString());
	}

	//获取一个bean的java对象，用构造方法的方式type
	@Test
	public void test04() {
		//按照bean的类名方式获取monster对象
		Object obj = applicationContext.getBean("monster03");
		System.out.println("bean constructer2:"+ obj.toString());
	}
	//获取一个bean的java对象，p命名空间方式
	@Test
	public void test05() {
		//按照bean的类名方式获取monster对象
		Object obj = applicationContext.getBean("monster04");
		System.out.println("bean p:"+ obj.toString());
	}

}
