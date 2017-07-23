package com.test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Mime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mime m = new Mime();
		System.out.println(m.test());
	}
	public int test() {	
		int i=0;
		try {
			FileInputStream isr = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("fine can't find");
			//注意这里很奇怪，竟然不返回，而是去执行finally了
			return i;
		}finally{
			i++;
			System.out.println("doing finally");
			return i;//最终在这返回
		}
	}

}
