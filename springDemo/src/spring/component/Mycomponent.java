/**
 * 引入一个包，使用注解技术
 * 每个注解都需要引入一个java类
 */
package spring.component;

import org.springframework.stereotype.Component;

/**
 * 注解@Component表示Mycomponent是一个组件，可被IOC容器扫描，并创建bean对象
 * @author Administrator
 *
 */
@Component
public class Mycomponent {

}
