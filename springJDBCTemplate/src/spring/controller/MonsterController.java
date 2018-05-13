/**
 * 控制器，直接处理业务层
 * 有一个对业务层的引用
 * 采用注解方式自动装配monsterService
 * 注意成员名的大小写问题
 */
package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.bean.Monster;
import spring.service.MonsterService;

@Controller
public class MonsterController {
	@Autowired
	private MonsterService monsterService;
	public void save(Monster m){
		monsterService.save(m);
	}
}
