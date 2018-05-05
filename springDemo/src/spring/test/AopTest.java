package spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.component.SmartDog;

public class AopTest {
	
	private  ApplicationContext applicationContext;
	@Before
	public void init(){
		applicationContext	 = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	//基于注解的方式，使用切面编程
	@Test
	public void test() {
		//按照ioc容器方式获得java对象，才能启用aop功能
		SmartDog bean = applicationContext.getBean(SmartDog.class);
		//SmartDog bean = new SmartDog();//这种方式不会启动aop功能
		
		bean.getSum(3, 4f);
		System.out.println("------------------------");
		bean.getAvg();
	}
}
