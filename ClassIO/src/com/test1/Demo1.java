/**
 * 功能： File类的基本用法
 * 可创建文件，删除文件，文件可读可写的判断，文件名，文件路径等文件基本信息的处理
 * 但是，File不能读写文件的内容，及读不出文件的内容，也不可往文件里写内容
 */
package com.test1;
import java.io.*;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个文件对象
//		File f= new File("D:\\aa.txt");
//		
//		//得到文件路径
//		System.out.println("文件路径"+f.getAbsolutePath());
//		
//		//文件大小 字节数，是文件所占大小，并非文件所占block大小
//		//一般磁盘最小块（block)分配大小为4kb。
//		//故文件大小是27字节，但是占用空间是4kb
//		System.out.println("文件大小"+f.length());
//		System.out.println("可读"+f.canRead());
//		System.out.println("可写"+f.canWrite());
		
		//创建文件和创建文件夹
		
		/*File f=new File("D:\\ff\\lmw.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("有文件，不能创建");
		}*/
		
		/*File f=new File("d:\\ff");
		if(f.isDirectory()) {
			System.out.println("有这个文件夹了");
		} else {
			f.mkdir();
		}*/
		
		//列出文件夹下的所有文件
		/*File f=new File("d:\\ff");
		if(f.isDirectory()) {
			File lists[]=f.listFiles();
			for(int i=0;i<lists.length;i++) {
				System.out.println(lists[i].getName());
			}
		}*/
	}

}
