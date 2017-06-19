package com.test1;

public class Demo5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp=0;
		int a[]={2,8,4,-3,6};
		//排序（Bubble)
		//总共几趟呢？n个元素的数组，两两比较，第一趟走完，确定了一个最大的数放到了最后
		//剩下n-1个数，再走一趟，确定了一个次大的数放到了倒数第二
		//......
		//剩下2个数，走一趟，确定了，第二位置的数
		//剩下1个数，还用走吗？不用了。
		//综上所述，n个数排序，需要n-1趟即可。
		
		//接着想，由于每一趟中，被确定位置的元素数依次减一，所以，两两比较的次数也在减一。
		//n个元素数，两两比较了n-1次。
		//n-1个元素，两两比较了n-2次。
		//....
		//2个元素，两两比较了1次
		//1个元素，无需比较。
		//比较次数也是递减的
		
		//外层循环，趟数  (a.length是元素个数n,n-1就是a.length-1)
		for(int i=0;i<a.length-1;i++) {
			//内存循环，比较次数
			for(int j=0;j<a.length-1-i;j++) {
				if(a[j]>a[j+1]) {
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		//比较完 了，输出即可
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		} 
	}

}
