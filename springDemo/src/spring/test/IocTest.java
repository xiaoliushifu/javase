package spring.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {

	//从beans.xml中获取一个bean的java对象
	@Test
	public void test() {
		//一句代码，就是加载ioc容器,自动实例化配置好的bean对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		//按照bean的id获取monster对象
		Object obj = applicationContext.getBean("monster01");
		System.out.println("bean"+ obj.toString());
		
		
	}

}
