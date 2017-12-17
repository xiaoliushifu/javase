/**
 * 数组：同类型的多个数据
 * 数组通过new的方式产生出来  所以，其实  数组在java中是一个系统定义好的类而已，所以可以使用new方式创建一个数组变量。
 * php直接声明即可
 * 
 */
package com.test1;

public class Demo5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//定义一个可以存放六个float类型的数组
		float arr[]=new float[6];
		
		//直接指定数组的下标赋值
		arr[0]=3;
		arr[1]=5;
		arr[2]=1;
		arr[3]=3.4f;
		arr[4]=2;
		arr[5]=50;
		
		float all=0;
		//计算总体重
		for(int i=0;i<6;i++)
		{
			all+=arr[i];
		}		
		System.out.println("all="+all);*/
		
		//定义size=5的int数组
		//先声明，再赋值，java中，数组的声明有三种样式，必须出现中括号[]
		//[]可以出现的位置有三处，
		//int[]  arr2;  //一种声明数组的方式  1类后面
		//int  []arr2;  //又一种声明数组的方式  2变量前
		int  arr2[];    //常用的方式   3变量后
		arr2=new int[5];
		System.out.println(arr2.length);
		
		//第三种初始化数组的方式
		//适合提前了解数组元素数量的时候,且数组大小无需指定，由后面的初始值决定
		float a[]={3,6,7.1f,1.1f,3};
		float all=0;
		for(int i=0;i<a.length;i++)
		{
			all+=a[i];
		}
		System.out.println
		("平均时间是："+(all/a.length));
	}

}
