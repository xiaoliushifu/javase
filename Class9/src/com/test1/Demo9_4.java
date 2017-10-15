/**
 * 功能  
 * 	键盘事件的学习
 *  通过按钮实现小球不同方向的移动
 */
package com.test1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo9_4 extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_4 d = new Demo9_4();
	}
	
	public Demo9_4()
	{
		//实例化面板对象，并添加到窗体对象里
		MyPanel4 mp = new MyPanel4();
		this.add(mp);
		
		//为当前绘图窗体对象this添加一个事件监听对象
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
//一个面板类
class MyPanel4 extends JPanel implements KeyListener
{
	//初始化小球的初始化位置坐标，后期可动态变化的基础
	int x=10;
	int y=10;
	public void paint(Graphics g)
	{
		//面板对象里的paint()方法，画一个小实心球
		super.paint(g);
		g.fillOval(x, y, 30, 30);
	}
	
	/**
	 * 下面的三个方法，是实现键盘按键事件监听者接口KeyListener必须实现的抽象方法
	 */
	@Override
	//按键
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			y++;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			x--;
		} else if(e.getKeyCode() == KeyEvent.VK_UP){
			y--;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			x++;
		}
		//调用repaint()方法，重绘小球，使得坐标更改后重新生效，再次渲染
		this.repaint();
	}

	//按键释放
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * type 可以理解为键入（非功能键），比如英文字母，数字等
	 * pressed是按下键
	 */
	@Override
	//键入
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}