/**
 * 跳水比赛，8个评委给运动员打分
 * 去掉一个最高分，去掉一个最低分，就是最终选手的得分
 * 能够：
 * 		哪个评委打分是最高分，哪个评委打分是最低分
 * 		得到最优的裁判，得到最差的裁判
 * 	最优裁判的打分最接近选手的最终得分，最差裁判则相差最远选手的得分。
 */
package com.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Judge judge=new Judge();
//		System.out.println("最低分是第"+(judge.getLowfenIndex()+1)+"个裁判");
//		System.out.println("最高分是第"+(judge.getHighfenIndex()+1)+"个裁判");
//		System.out.println("最后得分是"+judge.lastFen());
		
		//实例化多维数组时，当出现具体的元素时，不能出现数字，必须是[]
		int stus[][] = {{1002,22,33,44},{1003,55,36,47},{1004,29,83,94}};
		//字符型，不是字符串，字符型数据赋值时只能为0-127的字符
//		char c=97;
//		System.out.println(c);
		//命令行参数到底从哪里开始算呢？
		/*for(int i=0;i<args.length;i++) {
			System.out.println(i+"是"+args[i]);
		}*/
		//这样也能初始化数组呀
//		int arr[] = {1,3,5};  //等价于下一行
		int arr[] = new int[]{1,3,5};
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+"是"+arr[i]);
		}
		
		//这种方式声明字符串类型的变量，是相等的。在堆区存放一个空间，里面是abc。由a和b共同引用
		String a="abc";
		String b="abc";
		if(a==b) {//双等号比较的是地址，
			System.out.println("ok");
		}
		//这种方式声明字符串类型的变量,只能用equal或者equalIgnoreCase()
		//栈区和堆区各有一对
		String c=new String("abc");
		String d= new String("abc");
		if(c==d) {//双等号比较的是地址，
			System.out.println("ok");
		}
	}

}

class Judge 
{
	float fens[]=null;
	int size=3;
	
	public Judge()
	{
		fens=new float[size];
		int i=1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(i<=fens.length) {
				System.out.println("请输入您第"+i+"次的评分");
				fens[i-1]=Float.parseFloat(br.readLine());
				i++;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//最终得分
	public float lastFen()
	{
		float lastFen=0;
		int minIndex = this.getLowfenIndex();
		int maxIndex = this.getHighfenIndex();
		for(int i=0;i<fens.length;i++) {
			if(i != minIndex && i != maxIndex) {
				lastFen += fens[i];
			}
		}
		return lastFen;
	}
	
	//得到最低分的Index
	public int getLowfenIndex()
	{
		float low = fens[0];
		int  Index=0;
		for(int i=1;i<fens.length;i++) {
			//选择法
			if(fens[i] < low) {
				low=fens[i];
				Index=i;
			}
		}
		return Index;
	}
	//得到最高分的Index
	public int getHighfenIndex()
	{
		float high = fens[0];
		int  Index=0;
		for(int i=1;i<fens.length;i++) {
			//选择法
			if(fens[i] > high) {
				high=fens[i];
				Index=i;
			}
		}
		return Index;
	}
}	
