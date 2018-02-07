package com.java.liu;
//Arrays是个类，里面提供了好多的静态方法。这让我看起来，就跟php的函数有点类似了
//不必实例化直接使用的方法
import java.util.StringJoiner;;
public class Test {
	public static void main(String[] args) {
		
		//获得内存，单位转换为MB.
		Long mem1 = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("内存用量是："+mem1);
		
	}
}
