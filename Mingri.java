public class Mingri
{
	//一个主函数，程序入口
	public static void main(String args[])
	{

		char ch='2';
		switch(ch){
			case 2://case后的常量表达式，只能是整数或者字符。不能是实数，也不能是字符串
				System.out.println("匹配到2了");
				break;
			case 'a':
				System.out.println("匹配到a了");
				break;
			case 'b':
				System.out.println("匹配到b了");
				break;
			case '2':
				System.out.println("匹配到2e了");
				break;
		}
		String str = "java";
		int a = str.hashCode();//字符串的hashCode方法返回整型的哈希码。什么？？
		System.out.println("结束了"+a);
	}
}