package com.test2;

import java.io.*;
public class MonkeySort {

	static FileReader fir=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.test();
		
		
		
		/*Monkey marr[]=new Monkey[5];
		try {
			//InputStreamReader是FileReader的父类，属于字符流
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			for(int i=0;i<marr.length;i++){
				System.out.println("请输入第"+(i+1)+"个猴子的身高");
				String h=br.readLine();
				marr[i]=new Monkey(i+1+"",Float.parseFloat(h));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//让老猴子排序
		Monkey oldMonkey=new Monkey("101",1.2f);
//		oldMonkey.bubbleSort(marr);
//		oldMonkey.SelectedSort(marr);
		oldMonkey.InsertSort(marr);
		oldMonkey.show(marr);*/
	}
	
	
	

}

class Monkey
{
	String MonkeyId;
	float height;
	
	public Monkey(String mid,float height)
	{
		this.MonkeyId=mid;
		this.height=height;
	}
	/**
	 * 冒泡排序
	 * java 数组也是对象，故在函数里的改变，会在函数外生效
	 * @param a
	 */
	public void bubbleSort(Monkey a[])
	{
		Monkey t=null;
		//外层循环次数，是固定,比队列长度少1
		for(int i=0;i<a.length-1;i++){
			//定义标志位
			int flag=0;
			//内层循环次数 是递减的，因为每排一次，都确定了一个最大值在最后，后续它不再参与排序
			//故循环次数就不断减少。
			for(int j=0;j<a.length-1-i;j++){
				
				if(a[j].height > a[j+1].height){
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
					flag=1;
				}
			}
			if(flag==0) {
				return;
			}
		}
	}
	
	/**
	 * 选择排序法
	 * 核心思想是：
	 * @param a
	 */
	public void SelectedSort(Monkey a[])
	{
		Monkey t=null;
		for(int i=0;i<a.length;i++){
			//认为第i个是最低身高
			int minIndex=i;
			for (int j=i+1;j<a.length;j++) {
				if(a[j].height < a[minIndex].height) {
					minIndex=j;
				}
			}
			//如果下标有变动
			if(i != minIndex){
				t=a[i];
				a[i]=a[minIndex];
				a[minIndex]=t;
			}
		}
	}
	
	/**
	 * 插入排序（说明请见Class5的com.test1.Demo5_3）
	 * @param a
	 */
	public void InsertSort(Monkey[] a)
	{
		//定义有序区的下标
		int sortAreaIndex;
		//定义基准元素变量,这里的基准元素就是猴子
		Monkey shotMonkey;
		for(int j=1;j<a.length;j++){
			//初始化这一轮的有序区的最右边下标
			sortAreaIndex=j-1;
			//这一轮的基准元素
			shotMonkey=a[j];
			
			while(sortAreaIndex >= 0 && shotMonkey.height < a[sortAreaIndex].height){
				a[sortAreaIndex+1]=a[sortAreaIndex];//有序区元素右移一个
				sortAreaIndex--;//有序区下标左移一次，准备和倒数第二个比较
			}
			//while循环结束时，要不是有序区全部比较完了，要不就是身高条件满足了
			//此时的sortAreaIndex+1才是要插入的位置（想想为啥）
			a[sortAreaIndex+1]=shotMonkey;
		}
	}
	public void show(Monkey a[])
	{
		for(int i=0;i<a.length;i++){
			System.out.println("猴子ID是"+a[i].MonkeyId+" ,身高是"+a[i].height);
		}
	}
}