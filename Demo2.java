

//导入某些包
import java.io.*;
public class Demo2
{
	public static void main(String arg[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		switch(a)
		{
			//编译不通过。报错原因：需要整型，找到布尔型。
			//switch里的a是整型，而case后的逻辑表达式计算后是布尔型。类型不一致。
			  //也就是说，switch里面的数据类型，要和case 后的数据类型一致才可以。
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