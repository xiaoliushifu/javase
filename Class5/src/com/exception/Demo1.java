/**
 * 异常分类
 * 	检查性异常  java.lang.Exception
 * 	运行时异常  java.lang.runtimeException
 * 	错误              java.lang.Error
 * 最顶层就是java.lang.Throwable。检查性异常，运行异常，错误都是这个类的子孙类。
 * java.lang.Error 和java.lang.Exception是直接子类
 * java.lang.RuntimeException是java.lang.Exception的子类
 * 
 * 检查性异常：
 * 			程序正确，但因外在条件不满足引发。常见的有用户输入错误
 * 			及I/O问题---程序试图打开不存在的远程Socket,或者打开
 * 			不存在或不可读的文件。这不是程序本身逻辑错误，一般由输入错误的主机名，文件名等。
 * 			商用软件必须考虑这个问题，java编译器强制要求处理这类异常，若不处理
 * 			程序编译不通过
 *运行异常：
 *			这意味着程序存在bug,数组越界，0被除，参数不满足规范，这类异常要通过
 *			更改程序来避免。
 *错误：		一般很少见，也很难通过程序解决，一般是程序语言本身有错误
 *			更多的是环境问题，如内存耗尽。错误无需开发者处理，而是由
 *			运行环境来处理
 * 
 * 
 * 处理方式
 * 		try{}catch{}finally{}
 * 			这三者一般一块出现，但没有catch也行。面试时会问
 * 			finally一般会执行，并不是一定
 * 				比如finally也有异常了
 * 				程序线程kill掉
 * 				System.exit()
 * 				Cpu关闭
 * 			
 * 		throws
 * 			异常发生的方法里不处理，而是抛（throw)给上层的调用者;如果上层不处理也可以继续抛出
 * 			最终抛给java虚拟机
 * 
 * 多异常处理
 * 		自己定义自己的异常并抛出异常
 * 			$a = new XXXException()
 * 			throws $a;
 * 合在一起就是throws new XXXException("异常说明信息")。创建异常的好处就是可以保留创建异常
 * 的行信息及堆栈信息，异常被捕获时可以追踪异常发生地及缘由，有利调试。所以，现在的代码中，大多是throws new XXX
 * 的代码。这已然成为了事实的异常处理标准。
 * 异常一个行之有效的规则就是：
 * 一般在程序内部不处理异常而是throw抛出，而是由调用者处理。
 * 一句话，谁使用（调用），谁处理（异常）
 * 最终在命令行或者日志中查看
 */
package com.exception;

import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class Demo1 {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr=null;
		try{
			fr=new FileReader("d:\\javacode\\test.java");
			System.out.println("this is a line");
			//需要进行连接才能知道是否该连接存在，一般会因超时而出现连接 异常
			Socket st=new Socket("192.168.10.88",8880);
		}catch(Exception e) {
			System.out.println("进入异常的catch");
			e.printStackTrace();
			System.exit(-1);
		}finally{
			System.out.println("I am finally");
			//一般在finally中关闭已经打开过的资源：文件流，IO流，网络连接等
			if(fr != null) {
				try{
					fr.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			
			}
		}
		
		//不处理异常，而是在方法的开头（本例的方法是main)用throws抛给调用者
		fr= new FileReader("dd");
	}

}
