package spring.component;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Aspect 表示该java类是一个aspectj下的切面类
 * @Component  表示是spring下的一个组件
 * @author Administrator
 *
 */
@Aspect
@Component
public class SmartAspect {
	
	/**
	 * @Before 表示该方法showStartLog作为目标类的前置方法，“切人”到目标类的某方法的开始位置
	 * 具体切入到哪个方法，由切入表达式指出。
	 * execution()是固定写法
	 * public void spring.component.SmartDog.getSum(Integer,float)，就是目标类的具体目标方法
	 * 也支持通配符，即一个切面类的方法，应用到目标类的某个，某些或全部方法都是可以的
	 * 比如目标类的全部方法(参数用..表示)：public void spring.component.SmartDog.*(..)
	 */
	@Before(value = "execution(public void spring.component.SmartDog.*(..))")
	public void showStartLog(){
		System.out.println("前置通知1");
	}
	
	/**
	 * @After  表示showAfterLog方法切入到目标方法getSum的结尾处
	 */
	@After(value = "execution(public void spring.component.SmartDog.getSum(Integer, float))")
	public void showAfterLog(){
		System.out.println("后置通知2");
	}
	
	/**
	 * @AfterReturning  表示showReturnLog方法切入到目标方法return之前
	 */
	@AfterReturning(value = "execution(public void spring.component.SmartDog.getSum(Integer, float))")
	public void showReturnLog(){
		System.out.println("return通知3");
	}
	
	/**
	 * @AfterThrowing  表示showThrowLog方法切入到目标方法返回异常时通知
	 */
	@AfterThrowing(value = "execution(public void spring.component.SmartDog.getSum(Integer, float))")
	public void showThrowLog(){
		System.out.println("异常通知4");
	}
	
	
	
}
