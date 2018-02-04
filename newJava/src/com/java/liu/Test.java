package com.java.liu;
import java.util.Date;
import java.util.Scanner;
public class Test {

	static int ONE = 1;
	
	public static void main(String[] args) {
		
		for(String tmp:args) {
			System.out.println(tmp);
		}
		
		String s=new String();//空字符串
		String s2=new String("good");//初始化为good
		
		char a1[]={'a','b','c','d'};
		String s3=new String(a1);//用一个字符数组初始化
		
		String s4="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaa";
		String s5="we are students";
		String a[] = s5.split(" ");
		//for(String tmp:a)
			//System.out.println(tmp);
		//System.out.println(s5.charAt(4));
		
		Date today=new Date();
		System.out.println(String.format("%tF", today));
		
		//正则表达式  需要字符串的matches方法
		//matches方法判断正则返回的是boolean，符合就是true,不符合正则就是false
		String s6="Hell345";
		//PHP中有没有匹配大写字母的元字符呢？不是[A-Z]这样的。
		System.out.println(s6.matches("\\p{Upper}\\p{Lower}{3}\\d{3}"));
		
		//频繁对字符串的拼接去修改，最好用StringBuilder类而不是String类，单线程。
		//多线程时，可以使用StringBuffer
		StringBuilder sb=new StringBuilder("hello");
		
		String s7="你好Tom";
		char c[] = s7.toCharArray();//按照单个字符拆分一个字符串
		byte b[] = s7.getBytes();//把内码转成字节数组返回，utf-8一个中文是三个字节
		for(byte tmp:b)
			System.out.println(tmp);
		
		/*for(char tmp:c) {
			System.out.println(tmp);
			System.out.println((int)tmp);//整型的unicode码
			System.out.println(Integer.toHexString((int)tmp));//16进制的unicode码
		}*/
		
	
	}
}
