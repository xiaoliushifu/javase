package cn.itcast.demo;

public class RegexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//checkQQ();
		System.out.println(System.currentTimeMillis());
		
	}
	
	/**
	 * 检查QQ号码合法性
	 * 0不能开头，全数字，位数5,10位
	 */
	public static void checkQQ()
	{
		String QQ="123456";
		boolean b = QQ.matches("[1-9][0-9]{4,9}");
		System.out.println(b);
	}

}
