/**
 * 数组存放同一类型数据
 * 数组大小必须事先指定
 * 数组名是指向数组首地址的引用
 * 数组下标从0开始编号，没有关联数组
 * 
 * 内部排序
 * 	把数组加载到内存中进行排序
 * 		（交换，选择，插入式排序）
 * 
 * 		交换排序法：
 * 				冒泡排序
 * 				快速排序法
 * 外部排序
 * 	数据量过大，无法全部加载到内存中，需要借助
 * 外部存储器进行排序，合并排序，直接合并排序
 * 排序一般分为从大到小，或者从小到大
 * 
 * 
 */
package com.test1;

import java.util.*;

public class Demo5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int b[]=new int[4];
		//
		//int a[]={10,2,8,1,-3,6};
		
		//产生len个元素的数组
		int len = 100000;
		int[] a=new int[len];
		for(int i=0;i<len;i++) {
			//产生随机的0--10000的数
			//Math也是java.util包里的类，无需new直接使用即可
			a[i]=(int)Math.random()*10000;
		}
		//排序 (selection)选择排序
		//比冒泡排序略好一点，在复杂度和性能上略胜一筹
		/**
		 * 每次从所有数中选择一个最小的，第二次就是次小的，依次类推，直到全部归位。
		 * 假设有5个数：
		 * 第一轮：假设第一个数A是最小的，从它开始向右比较，如果没有比它小的，证明假设正确，它的位置不动。也确定了它在最终有序队列的的位置。
		 * 		如果有发现确实比它小的数B，就临时标记一下B的位置，先不交换，继续向后比较，看还有没有比B更小的数C；如果有就再次标记C，依次类推。
		 * 		直到比较完，那么最后标记的数（有可能是B,或者C)就是最小的，我们把它和第一个数A交互即可。
		 * 第二轮：从左边第二个数开始（因为左边第一个数的位置是经过第一轮比较后放置的，它无需再参与比较了），再次从它开始向右比较。比较逻辑和第一轮所述一样。
		 * ......
		 * 每一轮比较之后，都会确定一个数的最终位置。
		 * 第四轮之后，确定了四个数的位置。刚才我们假设说有五个数，
		 * 第四轮之后还剩最后一个数，那么它的位置也就最终确定了，因为从它往右只有它自己，已经没有数了。也就无需比较了。
		 * 所以，5个数，还是需要4轮比较即可。
		 * 下面代码实现
		 */
		
		Select sel = new Select();
		//标记一个时间
		Calendar c = Calendar.getInstance();
		System.out.println("排序前"+c.getTime());
		sel.sort(a);
		//需要重新获得一次实例
		 c = Calendar.getInstance();
		System.out.println("排序后"+c.getTime());
		
		//比较完 了，输出即可
//		for(int i=0;i<a.length;i++) {
//			System.out.print(a[i]+" ");
//		} 
	}

}
class Select
{
	//这个是排序的方法，注意形参是数组如何表示,java中是 a[],不是PHP的array $a
	public void sort(int a[])
	{
		//刚开始，定义一个临时变量，保存本轮假设的最小的数的位置。
		int index;
		//又经过分析，还需要一个变量，在每一轮过后交换时使用
		int change = 0;
		//外层循环，就是代表每一轮。5个数需要4轮，N个数需要N-1轮。故是[0,a.length);
		for(int i=0;i<a.length;i++) {
			//每一轮开始，都要初始化基准数的位置
			index = i;
			//每一轮里，从基准数往右开始比较，都是基准数和其右边紧挨着的数开始。故其右边的紧挨着的第一个数的位置最初都是
			//j=i+1,直到最后的位置a.length-1,故是[i+1,a.length)
			for(int j=i+1;j<a.length;j++) {
				//依次和基准数a[index]比较,有比它小的就标记位置到index
				if(a[index] > a[j]) {
					index=j;
				}
			}
			//优化，如果i和index不相等，就说明本轮比较过程中发现了比基准数还小的数，必须交互
			if (i != index) {
				change = a[i];
				a[i] = a[index];
				a[index] = change;
			}
			//继续开始下一轮
		}
	}
}
