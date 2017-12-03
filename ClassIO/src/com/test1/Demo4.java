/**
 * 功能： FileOutputStream类的基本用法
 * 属于文件流输出对象
 * 
 * 输入还是输出，都已内存为参考，数据往内存中走，就是输入流；往内存外走，就是输出流。
 * 文件流对象无论输入流还是输出流，都只是流对象，不能单独创建，都得基于文件对象。故应先创建File对象，
 * 输入流或输出流都是基于File对象这个前提才能创建。
 * 
 * 搞错了，输入流或输出流不用直接写File对象，写文件路径也可以.
 * 通过查看手册就知道，FileOutputStream和FileInputStream对象各自有三个构造函数呢。
 * 
 * 
 * 文件输入流和文件输出流整体应用：图片拷贝
 * 思路：图片文件属于二进制文件，故先使用FileInputStream把文件读入内存（代码中）
 * FileOutputStream
 */
package com.test1;
import java.io.*;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("D:\\a.jpg");
			fos=new FileOutputStream("E:\\b.jpg");
			//创建字节流缓冲区
			byte bytes[]=new byte[1024];
			//一次读取的字节数
			int n=0;
			//输入流读取
			while((n=fis.read(bytes)) != -1){
				//输出流写入到磁盘文件
				fos.write(bytes);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
