/**
 * 功能： File类的基本用法
 * 可创建文件，删除文件，文件可读可写的判断，文件名，文件路径等文件基本信息的处理
 * 但是，File不能读写文件的内容，即File读不出文件的内容，也不可往文件里写内容
 * 
 * 如果需要读取文件内容的话，就需要文件流对象了
 * 
 * FileInputStream是文件读入流对象，可以读取文件内容，以字节方式
 * FileOutputStream是文件写入流对象，以字节方式写入到文件中
 * 
 * FileInputStream  具有文件内容读取能力，可以把磁盘里的文件已字节流方式读入内存（代码里）
 * FileOutputStream 具有文件内容写能力，可以把内存中的内容写入到指定文件里
 */
package com.test1;
import java.io.*;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个文件对象
		File f= new File("D:\\aa.txt");
		FileInputStream fis=null;
		//因为File对象没有读写文件的能力，只得依靠新的javaIO对象
		try {
			fis = new FileInputStream(f);
			//定义一个字节数组
			byte bytes[]=new byte[1024];
			int n=0;
			//read会按照缓冲区的大小读取文件，知道缓冲区bytes占满。或者文件提前读取完毕，这两种情况
			//并不会一个个字节去读，而是首先按照缓冲区的大小bytes来读
			while((n=fis.read(bytes)) != -1) {
				String s=new String(bytes,0,n);
				System.out.println(n);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
