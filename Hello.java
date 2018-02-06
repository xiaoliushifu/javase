//一个程序，在控制台显示Hello World
//一个java文件只能有一个public类
//Hello 类名，公共类的类名必须和文件名一致

public class Hello
{
	//一个主函数，程序入口
	public static void main(String args[])
	{
		System.out.println("我能学会java");
		//控制台输出
		//System.out.println("Hello!");

/*		int a=10; //定义一个变量
		int b=20;
		int result=a+b;
		System.out.println("结果是"+result);
*/
		byte byte1=-128;

//		char char1='u';
//		System.out.println(char1);

		int test1='a'+'b';//转成ascii字符集里a字符的编码数值，b字符的编码数值，进行相加。
		char test2='a'+'b';//在java中，对char进行运算的时候，直接当做ascii编码表的编码数值来计算
//		char test3='中';
//		float a= 3.1f;
//		int a=(int)1.2;
//		int b=(int)1.9;
		int a=1;
		double b = 4.5;
		//a=b;
		//System.out.println("a="+a+" b="+b);
	}
}