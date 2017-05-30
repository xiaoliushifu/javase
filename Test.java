public class Test
{
	public static void main(String args[])
	{
//		int a=3;
//		int b=4;

		//输入流，好比是绑定了键盘一样
		InputStreamReader isr =new InputStreamReader(System.in);

		//缓冲区，从输入流读取的数据流，要先放到缓冲区
		BufferedReader     br = new BufferedReader(isr);

		//给出提示
		System.out.println("请输入一个整数");
		//读入一个整数
		String a1 = br.readLine();

		System.out.println("请输入二个整数");
		String a2 = br.readLine();

		//输入的数字都是字符串，需要强制转换给float类型  String-->Float
		float a = Float.parseFloat(a1);
		float b = Float.parseFloat(a2);

		if (a==b) {
			System.out.println("相等");
		} else if (a>b) {
			System.out.println("a大于b");
		} else {
			System.out.println("a小于b");
		}
	}
}