package com.jihe;

import java.util.*;
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LinkedList,即可以看成是队列，也可以看成是栈
		LinkedList ll = new LinkedList();
		
		Emp emp = new Emp("sa1","aaa",34.56f);
		//在队列的前面增加一个元素
		ll.addLast(emp);
		
		Emp emp2 = new Emp("sa2","bbb",44.99f);
		ll.addLast(emp2);
		
		for(int i=0;i<ll.size();i++) {
			Emp emp1 =(Emp)ll.get(i);
			System.out.println("姓名:"+emp1.getName());
		}
		
		
		//向量
		/*Vector vv = new Vector();
		Emp emp3 = new Emp("vv1","aa",3.4f);
		vv.add(emp3);
		for(int i=0;i<vv.size();i++) {
			Emp temp = (Emp)vv.get(i);
		}*/
		
		//栈
		/*Stack st = new Stack();
		Emp emp4 = new Emp('st1',"ddd",44.5f);
		st.add();*/
		
	}

}
