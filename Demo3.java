public class Demo3
{
	public static void main(String arg[]) throws Exception
	{
		int lay=10;
		for(int i=1;i<=lay;i++) {

			//先打空格
			//1--3  2--2   3--1   4--0
			for(int m=1;m<=lay-i;m++){
				System.out.print(" ");
			}

			for(int j=1;j<=2*i-1;j++){

				//第一层和最后一层全部打*号
				if(i==1 || i==lay) {
					System.out.print("*");
				//中间层，只打第一个和最后一个*号
				} else if(j==1 || j==2*i-1) {
					System.out.print("*");
				//其他的打空格
				} else {
					System.out.print(" ");
				}
				
			}
			//打出一个换行
			System.out.println();
			
		}
	}
}
/*
	中间镂空的金字塔，怎么打呢？
          *
		 * *
		*   *
	   *******
	   我们观察，金字塔的顶端是完整的；金字塔的底端也是完整的。
	   这中间的都是镂空的，所以，我们应该在打印*号的那个for循环中做文章
*/