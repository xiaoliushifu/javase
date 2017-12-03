/**
 * 功能： FileOutputStream类的基本用法
 * 属于文件流输出对象
 * 
 * 输入还是输出，都已内存为参考，数据往内存中走，就是输入流；往内存外走，就是输出流。
 * 文件流对象无论输入流还是输出流，都只是流对象，不能单独创建，都得基于文件对象。故应先创建File对象，
 * 输入流或输出流都是基于File对象这个前提才能创建。
 * 
 */
package com.test1;
import java.io.*;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个文件对象
		File f= new File("D:\\lmw.txt");
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(f);
			String s="刘师傅ok,hello,world\r\n";
			String s1="中国强大";
			//定义一个字节数组
			byte bytes[]=new byte[1024];
			//需要以字节方式写入，故需要字符串转字节，且是从文件开头写入，所以其实是覆盖写
			//之前文件不存在就创建，文件内容有无write都会以这次所写内容覆盖之前的。
			fos.write(s.getBytes());
			fos.write(s1.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
