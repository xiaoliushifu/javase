/**
 * 功能  实现事件监听
 * 事件，有三个要素：被监听对象，事件对象，事件处理者
 * 实现事件机制的三个步骤：
 * 事件源添加事件监听者。比如按钮被监听，按钮注册某事件就行了 ， 
 * 事件对象，事件发生时系统自动产生，java后台自动传递给事件监听者的抽象方法里的参数e
 * 事件处理者，某个java类实现事件监听者接口ActionListener的一个抽象方法即可，该方法，就是事件处理者方法
 * 
 * 除了上述的ActionListener，还可以有KeyListener,MouseListener等事件监听接口
 */
package com.test1;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;//事件对象（事件发生时，java系统传入事件处理者方法里的参数）
import java.awt.event.ActionListener;//引入事件机制的包,一个接口ActionListener。

public class Demo9_3 extends JFrame implements ActionListener{

	JPanel mp=null;
	JButton jb1=null;
	JButton jb2=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_3 d=new Demo9_3();
	}
	
	public Demo9_3()
	{
		mp = new JPanel();
		jb1=new JButton("黑色");
		jb2=new JButton("红色");
		
		//为按钮绑定（注册）事件监听者，参数是实现了Action接口的java对象
		jb1.addActionListener(this);
		//当jb1事件源身上的事件发生时，可以传递给事件对象的参数
		jb1.setActionCommand("黑色");
		
		//按钮2 绑定事件监听者
		jb2.addActionListener(this);
		//当jb2身上的事件发生时，可以把"红色"传递给新生成的事件对象，也就可以在事件处理者里使用
		jb2.setActionCommand("红色");
		
		//创建一只猫
		Cat c = new Cat();
		//也让猫实例对象来监听。注意监听参数是对象，而非类
		jb1.addActionListener(c);
		
		
		this.add(jb1,BorderLayout.NORTH);
		mp.setBackground(Color.BLACK);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		this.setSize(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	//事件监听者方法，这是当前java类实现事件监听者接口ActionListener应该实现的抽象方法
	//实现了这个方法，才有资格成为事件监听者（处理）对象
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断是哪个按钮被点击了
		if(e.getActionCommand().equals("黑色")) {
			System.out.println("点击黑色按钮了");
			mp.setBackground(Color.BLACK);
		} else if(e.getActionCommand().equals("红色")) {
			System.out.println("点击红色按钮了");
			mp.setBackground(Color.RED);
		} else {
			System.out.println("不知道");
		}
	}

}
//小猫也要当事件监听者
class Cat implements ActionListener
{
	//事件监听者，必须要实现的抽象方法，其中的e为事件对象
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("黑色")) {
			System.out.println("小猫也知道，按下黑色按钮了");
		}
		
	}
}
