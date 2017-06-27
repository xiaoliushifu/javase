package com.test1;

public class Demo5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={4,9,2,-10,5,1};
		//int len =8;
		//int[] a=new int[len];
		/*for(int i=0;i<len;i++) {
			//Math也是java.util包里的类，无需new直接使用即可
			a[i]=(int)Math.random()*100;
		}*/
		Insertsort is = new Insertsort();
		is.sort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		BinaryFind bf =new BinaryFind();
		int index = bf.find(0,a.length-1,99,a);
		System.out.println("位置是"+index);
	}

}

/**
 * 二分查找，首先基准数组得是排好序的数组。
 * 递归思想，通过比较中间元素的大小，变换左右的下标，重新获取中间元素。
 * 注意，中间下标加1和减1的操作。（mid+1,r)和（l,mid-1);
 * 还有，左边的数不能比右边的数大，如果寻找的数，实际并没有在数组中。如果没有l<=r的限制，将会栈溢出
 * @author Administrator
 *
 */

class BinaryFind
{
	public int find(int l,int r,int val,int[] arr)
	{
		if (l<=r) {
			//找到中间的坐标
			int mid = (l+r)/2;
			//先比较中间的数和val的大小
			if (val > arr[mid]) {
				//递归去比较时，非常重要的一点，不是直接把mid传进去，如果mid放左边，就是mid+1
				return this.find(mid+1, r, val, arr);
			} else if(val < arr[mid]) {
				//如果mid放右边，就是mid-1.
				return this.find(l,mid-1,val,arr);
			} else {
				return mid;
			}
		} else {
			System.out.println("没有在数组中");
			return 0;
		}
	}
}