package spring.action;

/**
 * 这里的action由于集成了spring，所以可以利用spring的注解
 * 配置控制器，自动装配等
 * 当然控制器注解也可以不配置，只需struts2的过滤器就可以发挥功能
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

//struts2的action都得继承它，是不是快忘记了
import com.opensymphony.xwork2.ActionSupport;

import spring.service.GoodsService;

@Controller//action就是spring里的控制器
@Scope(value="prototype")//（ioc容器中单例配置）
public class MonsterAction extends ActionSupport{
	
	/**
	 * 默认序列号，是咋回事，什么逻辑？
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GoodsService goodsService;
	
	public String test(){
		goodsService.save();
		return SUCCESS;
	}
}
