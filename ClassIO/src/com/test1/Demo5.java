/**
 * 文件字符流使用
 * 注意区别，字节流是前面所学的FileInputStream,FileOutputStream类;
 * 字符流一般就是文本类的FileReader和FileWriter
 */
package com.test1;
import java.io.*;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//文件输入字符流对象
		FileReader fr=null;
		//文件输出字符流对象
		FileWriter fw=null;
		
		try {
			fr=new FileReader("D:\\lmw.txt");
			fw=new FileWriter("D:\\fw.txt");
			//定义字符数组缓冲区
			char c[]=new char[1024];
			//一次读取的字符数
			int n=0;
			while((n=fr.read(c)) != -1) {
				System.out.println(n);
				System.out.println(c);
				//写入时，由于缓冲区大小是1024，还有部分空空间，故写入文件后的最后是乱码
				//故两种解决办法：
				//1转成字符串再写入 
				//fw.write(new String(c,0,n));
				//  2缓冲区实际占用内容大小写入
				fw.write(c,0,n);//写入时是覆盖写
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
