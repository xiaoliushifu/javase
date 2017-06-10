package com.xiaoqiang;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog1=new Dog();
		//在同一个包中：
		//dog1对象即使没在该文件里定义，而是在Test2.java中定义，可以无需加包前缀
		//java会自动载入，无需手动处理文件包含的问题（php需要处理自动包含问题)
		
		//同一个包下，除了private的成员外，下面三个类型的成员都能访问到
		System.out.println(dog1.a);
		System.out.println(dog1.color);
		System.out.println(dog1.name);
	}

}
