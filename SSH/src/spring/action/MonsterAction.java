package spring.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
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

import spring.entity.Monster;
import spring.service.MonsterService;

@Controller//action就是spring里的控制器
@Scope(value="prototype")//（ioc容器中单例配置）
public class MonsterAction extends ActionSupport implements RequestAware{
	
	/**
	 * 默认序列号，是咋回事，什么逻辑？
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MonsterService monsterService;
	
	public String list(){
		//获得数据，放到struts2封装过的request域对象里
		List<Monster> monsterlist = monsterService.list();
		requestMap.put("monsterlist", monsterlist);
		for (Monster monster : monsterlist) {
			System.out.println(monster);
		}
		return "monster_list";
	}

	private Map<String, Object> requestMap;
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		requestMap = arg0;
	}
}
