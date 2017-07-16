package com.jihe;

import java.util.*;
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LinkedList,即可以看成是队列(addFirst,addLast)，也可以看成是栈(push,pop)
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
		
		//栈(push,pop,add)
		/*Stack st = new Stack();
		Emp emp4 = new Emp("st1","ddd",44.5f);
		st.push(emp4);*/
		
		//HashMap 对象。属于映射结构的集合类，类似php的关联数组
		HashMap hm = new HashMap();
		Emp emp1 = new Emp("hm1","灵阵",4.5f);
		//HashMap类似于关联数组
		hm.put("hm1", emp1);
		Emp emp3 = new Emp("hm3","花荣",5.6f);
		hm.put("hm3", emp3);
		Emp emp4 = new Emp("hm4","李逵",7.8f);
		//HashMap会覆盖重复的key
		hm.put("hm4", emp4);
		
		
		//查找
		if (hm.containsKey("hm1")) {
			System.out.println("有该员工");
			Emp temp = (Emp)hm.get("hm1");
			System.out.println("它是"+temp.getName());
		} else {
			System.out.println("没有");
		}
		
		//遍历HashMap,没有get(i)，故不能用for
		/*for(int i=0;i<hm.size();i++) {
			hm
		}*/
		//HashMap中需要key和value，迭代器上场
		//顺序不稳定
		System.out.println("迭代器遍历HashMap");
		Iterator it = hm.keySet().iterator();
		while(it.hasNext()) {
			//取得key
			String key=it.next().toString();//next获得的key是String对象，需要toString转成字符串
			//通过key取得value
			Emp temp2 = (Emp)hm.get(key);
			System.out.println("名字："+temp2.getName());
			System.out.println("工号："+temp2.getEmpno());
			System.out.println("工资："+temp2.getSalary());
			
		}
		
		//hashtable
		Hashtable ht=new Hashtable();
		/**
		 * HashMap和hashtable的异同
		 * 相同点：
		 * 	它们都是集合类，都能存放java对象。
		 * 历史原因
		 * 	hashtable是基于旧的Dictionary类，hashMap是基于Java 1.2引进的Map接口
		 * 不同点：
		 * 	同步性
		 * 		hashtable是支持同步机制的，或者说是线程安全的（锁机制支持）。有一个线程在操作hashtable时，其他也想操作hashtable的线程必须入队列等待
		 * 		缺点就是效率不高，即使当前只有一个线程操作，它也会判断线程队列是否有等待线程等等。
		 * 		hashMap不支持同步,因为java并不长用在编写服务器类的软件，故线程应用较少，一般是单机版的电脑软件。故无需考虑线程安全，为了效率
		 * 		考虑，hashMap使用较多
		 * 	值
		 * 		hashMap允许将null作为key和value
		 * 		hashtable不允许
		 */
		hm.put(null, null);
		System.out.println("null测试"+hm.get(null));
		
		
		/**
		 * ArrayList 和 Vector的区别
		 * 相同点：
		 * 	ArrayList和Vector都是java截获类，都能存放javaduix .
		 * 不同点：
		 * 	同步性：
		 * 		Vector是同步的，线程安全的
		 * 		ArrayList则是异步的，
		 * 	数据增长
		 * 		内部都是使用数组来控制集合中的对象，当向两者中新加入元素时，若元素数目的长度超过了了内部数组的长度，它们扩展内部数组的长度
		 * 		机制不一样，vector是增长原来的一倍，ArrayList是增长50%。所以，永远实际使用的空间没有这两者集合中所占用的空间大。
		 * 		如果应用程序需要操作大量的元素，建议使用Vector，减少内部数组长度的扩充次数
		 * 
		 */
		
		/**
		 * 进一步理解集合框架
		 * java涉及者提供了这么多的集合类，我们应该考虑何种场景下使用什么集合类，就是根据每个集合类的特点来考虑的
		 * 程序是否需要同步（线程安全）：
		 * 		线程安全：hashtable,vector
		 * 		无需：hashMap,ArrayList,LinkedList
		 * 是否保存数组(索引）
		 * 		ArrayList,LinkedList
		 * 是否保存映射（key value)  hashMap,hashtable
		 * 数据量
		 * 数据量大，又线程安全:  vector
		 */
	}

}
