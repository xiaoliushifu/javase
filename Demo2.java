

//导入某些包
import java.io.*;
public class Demo2
{
	public static void main(String arg[]) throws Exception
	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//int a = Integer.parseInt(br.readLine());
		double a=3.4;
		switch(a)
		{
			//switch里的数据类型是有限制的，不是随便都能的，允许的数据类型有：
			//byte,short,int,char,enum等。  float,double是不行的。
			case a<=100 && a>=90:
				System.out.println("优秀");
				break;
			case a<=89 && a>=80:
				System.out.println("良好");
				break;
			case a<=79 && a>=60:
				System.out.println("及格");
				break;
			default:
				System.out.println("不行啊，孩子，要努力呀！");
		}
	}
}