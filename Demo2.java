

public class Demo2
{
	public static void main(String arg[])
	{
		char c='a';

		switch(c)
		{
			case 'a':
				System.out.println("今天星期一，猴子穿新衣"); //注意，这里得是双引号，单引号会报错哟
				int a=1; int b=4;
				int d=a+b;
				System.out.println(d);
				break;//跳出switch
			case 'b':
				System.out.println("今天星期二，猴子当小二");
				break;
			case 'c':
				System.out.println("今天星期三，猴子爬雪山");
				break;
			default:
				System.out.println("不知道了");
		}
	}
}