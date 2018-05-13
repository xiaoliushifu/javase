package spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.dao.GoodsDao;
import spring.service.GoodsService;

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
	
	/**
	 * 测试下dao中使用sessionFactory并操作数据库
	 */
	@Test
	public void test01() {
		GoodsDao gd = applicationContext.getBean(GoodsDao.class);
		Float price = gd.queryPriceById(1);
		System.out.println(price);
		//更新数量
		gd.updateMount(1, 10);
		
		//更新余额
		gd.updateBalance(1, 4.2f);
	}
	
	/**
	 * 测试下service中使用dao
	 */
	@Test
	public void test02() {
		GoodsService gs = applicationContext.getBean(GoodsService.class);
		gs.buyGoods2(1, 1, 1);
	}
}