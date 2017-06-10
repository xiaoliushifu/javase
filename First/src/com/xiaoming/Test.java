//文件开头，一般写包名
package com.xiaoming;
//导入java.util包里的所有内容（类，接口等）
import java.util.*;

//直接导入com.xiaoqiang.Test2类
import com.xiaoqiang.Test2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//在当前包的环境下，想要使用另一个包中的类，可以加包前缀“com.xiaoqiang”
		//com.xiaoqiang.Test2 t2=new com.xiaoqiang.Test2();
		
		//当然，也可以在文件开头处导入Test2类，然后直接使用
		Test2 t2=new Test2();
		//在这里，只有public修饰符修饰的a成员属性和ab1成员方法可以访问哟
		t2.a=3;
		t2.ab1();
	}

}

class Dog
{
	
}
