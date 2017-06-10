/**
 * 功能：约瑟夫环问题（丢手帕问题）
 */
package com.mingwei;

public class Demo4 {

	public static void main(String []args) {
		// TODO Auto-generated method stub
		CycLink l=new CycLink();
		//设置小孩数量
		l.setLen(5);
		//设置从第几个小孩开始数
		l.setK(2);
		//数到几才开始小孩退圈
		l.setM(2);
		//创建链表（关键!)
		l.createLink();
		//开始
		l.play();
		
	}
}

class Child
{
	int no;
	//自己类型的属性成员，是形成链表的关键
	Child nextChild;
	public Child(int no)
	{
		//给一个编号
		this.no=no;
	}
}

class CycLink
{
	//先定义一个引用
	//永远指向第一个小孩的指针
	Child firstChild=null;
	//移动指针，或者叫临时指针，一般就是动态地Current，一直指向当前的小孩
	Child temp=null;
	//几个小孩
	int len=0;
	//第几个小孩开始数
	int K=0;
	//总共数几个数
	int M=0;
	
	//设置链表的长度
	public void setLen(int len)
	{
		this.len=len;
	}
	
	public void setK(int k) 
	{
		this.K=k;
	}
	
	public void setM(int m) 
	{
		this.M=m;
	}
	
	//移动指针temp的作用非常明显
	public void createLink()
	{
		for(int i=1;i<=len;i++) {
			if (i==1) {
				Child ch=new Child(i); //问题，变量ch可以被重复声明和定义？
				this.firstChild=ch;
				this.temp=ch;
			} else if (i==len) {
				//最后一个小孩
				Child ch=new Child(i);
				//最后一个小孩，指向第一个节点
				ch.nextChild=this.firstChild;
				//和前一个节点连接
				this.temp.nextChild=ch;
			} else {
				Child ch=new Child(i);
				//节点连接
				this.temp.nextChild=ch;
				//指针移动
				this.temp=ch;
			}
		}
	}
	
	//打印环形链表
	public void show()
	{
		Child t=this.firstChild;
		do{
			System.out.println(t.no);
			t=t.nextChild;
		}while(t !=this.firstChild);
	}
	
	//开始数数
	public void play()
	{
		this.temp=this.firstChild;
		while(this.len>1){
			//先找到开始数数的小孩，第k个
			for(int i=1;i<this.K;i++)
			{
				this.temp=this.temp.nextChild;
			}
			//数m下,开始数的小孩算1
			for(int j=1;j<this.M;j++) 
			{
				//上一个小孩
				this.temp=this.temp.nextChild;
			}
			/*数到m的小孩，退出圈*/
			//没有前向指针，只能通过循环找到当前小孩的前边小孩
			Child cu=this.temp;
			while(cu.nextChild !=this.temp) {
				cu=cu.nextChild;
			}
			//退圈
			cu.nextChild=this.temp.nextChild;
			//链表长度减一
			this.len--;
			//输出退圈小孩的号码
			System.out.println(this.temp.no);
			//从下一个小孩继续开始数
			this.temp=this.temp.nextChild;
		}
		//输出最后的小孩的号码
		System.out.println("last is"+this.temp.no);
	}	
}