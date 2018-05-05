package spring.component;

import org.springframework.stereotype.Component;

@Component
public class SmartDog {
	
	/**
	 * 计算总和
	 */
	public void getSum(Integer a,float b){
		System.out.println("狗开始计算了");
		System.out.println("狗1111 2222 4444333");
		System.out.println("狗结束计算了");
	}
	
	/**
	 * 计算平均数
	 */
	public void getAvg(){
		
		System.out.println("狗计算平均值");
	}
}
