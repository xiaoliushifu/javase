package com.test2;

public class Test {
	public void test()
	{
		int index=1;
		switch(index){
		case 3:
			System.out.println("值是: "+index);
		case 2:
			System.out.println("值是a: "+index);
			break;
		//default相当于else,在所有case都不匹配的情况下，会执行这个；
		//default出现的位置没有关系，一般写在末尾，也可以写到开始的位置。
		//另外，还有一个特殊情况也会执行default，那就是如果某个case匹配后没有写break，
		//那么他将一直执行下去，不管遇到啥,即使遇到最后的default也执行。
		default:
			System.out.println("值是: default"+index);
		}
		
	}
}
