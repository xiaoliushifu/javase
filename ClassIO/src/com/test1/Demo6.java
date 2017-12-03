/**
 * 缓冲字符流使用
 * 所谓缓冲，是因为这个java类对象的名字带有Bufferedxxxx。
 * 比如BufferedReader,BufferedWriter。
 * 
 * 
 * 一个个读取字节或者字符，效率太低，故本次引入新的字符流：缓冲字符流BufferedReader
 * 这种对象可以按照行读取文件内容，因为他有readLine()方法，读入的数据类型就是字符串类型
 */
package com.test1;
import java.io.*;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//文件输入字符流对象
		FileReader fr=null;
		//缓冲输入字符流对象
		BufferedReader br=null;
		
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		try {
			fr=new FileReader("D:\\lmw.txt");
			//缓冲输入字符流对象的构造方法，必须传入文件输入流对象，不能是字符串。这一点要注意
			//所以，需要先创建文件输入流对象
			br=new BufferedReader(fr);
			
			//同理，缓冲输出流，也得先创建输出流对象
			fw=new FileWriter("D:\\bw.txt");
			bw=new BufferedWriter(fw);
			//缓冲输入流可以按照行读入，读入的数据类型就是字符串类，不必使用缓冲区了
			String s="";
			//查看手册可知readLine读取的行不包含行终止符比如\r,\n这样的，文件最终读取完毕后会返回null
			while((s=br.readLine()) != null) {
				//System.out.println("A");
				System.out.print(s);
				bw.write(s);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fr.close();
				br.close();
				
				//关闭的顺序还得注意，先关闭缓冲输出字符流，然后再关闭输出字符流
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
