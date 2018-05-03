/**
 * 引入一个包，使用注解技术
 * 每个注解都需要引入一个java类
 */
package spring.component;

import org.springframework.stereotype.Component;

/**
 * 注解@Component表示Mycomponent是一个组件，可被IOC容器扫描，并创建bean对象
 * @author Administrator
 * 我们知道bean对象都有一个id，通过注解方式扫描到的java类的beanid就是小写的类名
 * 也就是Mycomponent====》mycomponent
 * 但是也可以在注解里使用value来指定名字
 * @Component(value="lmwcom")或简写@Component("lmwcom")
 * 则lmwcom就是bean的名字
 *
 */
@Component("lmwcom")
public class Mycomponent {

}
