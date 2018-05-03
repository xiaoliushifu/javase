package spring.test;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.Master;
import spring.beans.Monster;
import spring.component.MyDao;
import spring.component.Mycomponent;

public class IocTest {

	private ApplicationContext applicationContext;
	
	/**
	 * 这是Junit可以配置的注解，在执行所有测试方法之前调用
	 */
	@Before
	public void init(){
		//一句代码，就是加载ioc容器,自动实例化配置好的bean对象（会执行构造方法）
		applicationContext	 = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	//从beans.xml中获取一个bean的java对象
	@Test
	public void test01() {
		//按照bean的id获取monster对象
		Object obj = applicationContext.getBean("master02");
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
	@Test
	public void test06() {
		//按照bean的类名方式获取monster对象
		Master obj = (Master)applicationContext.getBean("master03");
		System.out.println(obj.hashCode());
		//再次获取一个master03，打印它的hashCode()会发现两次打印不同。
		Master obj2 = (Master)applicationContext.getBean("master03");
		System.out.println(obj2.hashCode());
		Properties p = obj.getPro();
		//一种遍历Properties集合的for方法
		for(String key:p.stringPropertyNames()){
			System.out.println("key:"+ key+" value:"+p.getProperty(key));
		}
		
	}
	

	//创建调用构造方法，初始化调用init方法，关闭ioc容器调用destroy（未演示）
	@Test
	public void test07() {
		//按照bean的类名方式获取monster对象
		Object obj = applicationContext.getBean("cat1");
		System.out.println("bean:"+ obj.toString());
	}
	//基于注解的方式类配置spring的bean
	@Test
	public void test08() {
		//按照bean的类名方式获取monster对象
		Object bean = applicationContext.getBean(MyDao.class);
		//使用注解时，默认的bean名字（id)就是小写的类名mycomponent
		//Object bean2 = applicationContext.getBean("mycomponent");
		
		//System.out.println("class属性是："+ Mycomponent.class);
		System.out.println("bean:"+ bean);
	}

}
