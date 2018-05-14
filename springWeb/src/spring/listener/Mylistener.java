/**
 * ServletContextListener是来自servlet-api.jar里的
 * 属于Servlet API体系中的，正如该接口的名字一样，ServletContextListener监听ServletContext的生命周期
 * 也就是Web应用的生命周期
 * 当ServletContext启动或终止时，会触发ServletContextEvent事件，而ServletContextEvent的时间
 * 需要ServletContextListener来处理
 * ServletContextListener提供了两个方法来处理这俩事件
 * 还是那句话，学好java web servlet得学好！
 */
package spring.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mylistener implements ServletContextListener{

	
	private ApplicationContext ac;
	
	public Mylistener(){
		
	}
	/**
	 * 在应用启动的时候，完成spring的ioc容器初始化工作
	 * 放入到ServletContext域中
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		arg0.getServletContext().setAttribute("my_ioc", ac);
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

}
