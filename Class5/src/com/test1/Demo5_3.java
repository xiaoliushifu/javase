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
		int a[]={10,2,8,1,-3,6};
		
		//产生len个元素的数组
		//int len = 100000;
		//int[] a=new int[len];
		/*for(int i=0;i<len;i++) {
			//产生随机的0--10000的数
			//Math也是java.util包里的类，无需new直接使用即可
			a[i]=(int)Math.random()*10000;
		}*/
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
		
		//Select sel = new Select();
		Insertsort sel = new Insertsort();
		//标记一个时间
		Calendar c = Calendar.getInstance();
		System.out.println("排序前"+c.getTime());
		sel.sort(a);
		//需要重新获得一次实例
		 c = Calendar.getInstance();
		System.out.println("排序后"+c.getTime());
		
		//比较完 了，输出即可
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		} 
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

//插入排序
/*思想：把一些待排序的元素看成是无序区和有序区两个部分。每次从无序区里取出第一个元素和有序区的元素们一一比较
 * 直到找到合适的位置,把这个元素插入到有序区。使得有序区的元素数加1，无序区的元素数减1。
 * 如何一一比较？
 * 首先无序区元素A和有序区最右边元素B比较，如果A大于等于B,则说明A比有序区所有的元素都大，A放到B的右边下一位置即可（也就是A最初的位置）；
 * 这里有序区一般是默认从小到大排序
 * 如果A小于B,则B向右移（说明A与B地比较完成，不符合条件，当然第一次就是B覆盖A最初的位置，或者称为占据），同时有序区的下标继续左移，A继续和有序区右数第二个比较。比较情况和B一样。
 * A大于B2,则A放到B2的前面,否则下标继续左移，比较过的B2右移。
 * 
 * 循环上述的步骤，直到无序区的元素为0时，也就是有序区的元素数达到N时结束。
 * 刚开始的时候，有序区的元素数是1，无序区的元素数是N-1。从无序区第一个元素开始和有序区的元素数比。所以无序区下标j的选取范围是[1,N)，
 * 有序区要从右往左看，有序区最右边的一个和无序区最左边的一个是紧挨着的。故有序区随着数量的增长，最右边下标i是j-1。
*/
class Insertsort
{
	/**
	 * 从实现上来看，
	 * 最外层的for循环长度，是无序区的长度，因为下标0默认是有序区的，无序区就是[1,j]了
	 * for循环的开始，一般是首先确定两件事：
	 * 	1有序区最右边的下标
	 * 	2无序区最左边的下标
	 * 第二层的while循环是条件式循环，并不是数字式的for循环。
	 * 	因为第二层循环是把无序区的最左边元素作为基准元素（准备插入到有序区的元素）和有序区的元素一一比较
	 *只要满足条件即可，不一定要和有序区的元素都比较。所以使用常见的while而不是for(虽然while和for在实现上都是可以的）
	 * 	每一轮的基准元素，都是第一层循环里就确定了；有序区的最右边下标，也是在第一层循环里就确定了。
	 * 	所以第二层循环的主要目的，就是完成比较，基准元素和有序区的比较。
	 * @param a
	 */
	public void sort(int a[])
	{
		int i,insertVal;
		for (int j=1;j<a.length;j++) {
			//有序区最右边的元素下标，因为每一轮的比较，都是从有序区的最右边开始
			i=j-1;
			//临时保存从无序区中取得的第一个元素，准备插入到有序区的值,基准元素
			insertVal = a[j];
			//使用while循环来实现无序区第一个元素依次和有序区元素从右往左的比较。
			//这时体现出while比for的优势来了啊
			while (i>=0 && a[i] > insertVal) {
				//有序区比较过的数,不符合条件，右移
				a[i+1]=a[i];
				//下标左移，继续和左边的兄弟再比较
				i--;
			}
			//当循环走完后，有两种可能：1i>=0不满足条件了，i<=-1了，说明走到有序区的最左边了，有序区里任何一个都大于当前这个元素，
			//这时，基准元素放到i+1的位置即可
			//2 在有序区里找到了一个比当前元素小的。及a[i]<=a[j]了。还是，把基准元素放到i+1的位置
			a[i+1]=insertVal;
		}
	}
}


/**
 * 快速排序速度快。但是非常耗内存。典型的牺牲空间（内存大小）换取时间的思想
 * 比 冒泡--选择--插入排序都快。
 * 快速排序思想：
 * 首先找到一个基准数（第一个，或者中间一个随便无所谓)，通过一趟比较，把序列分成两部分：
 * 基准数左边部分的数都不大于它，基准数右边部分的数都不小于它。且基准数的位置得到了确定，它正好位于左右两边的交界处。
 * 再分别对左边的数采取同样的方式继续分为两部分；右边的数采取同样的方式继续分为两部分；
 * 每一次的趟数里，都确定了一个基准数的位置。
 * 注意，这里没有说具体如何比较
 * @author Administrator
 *
 */
class QuikSort
{
	//暂时没有实现，因为一时找不到java中数组动态添加元素的办法
	public void sort(int a[])
	{
		int right[] = new int[5];
		int left[] = new int[5];
		int tag = a[0];
		int r=0;
		int l=0;
		for(int i=1;i<a.length;i++) {
			if (a[i] > tag) {
				right[r]=a[i];
				r++;
			} else  {
				left[l]=a[i];
				l++;
			}
		}
		//larr = this.sort(left);
		//rarr = this.sort(right);
		//return larr+rarr;
	}
}