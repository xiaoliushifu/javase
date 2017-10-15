/**
 * 功能  
 * 	键盘事件的学习
 *  通过按钮实现小球不同方向的移动
 */
package com.test1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo9_6 extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_6 d = new Demo9_6();
	}
	
	public Demo9_6()
	{
		//实例化面板对象，并添加到窗体对象里
		MyPanel6 mp = new MyPanel6();
		this.add(mp);
		
		//为当前绘图窗体对象this添加一个事件监听对象
		this.addKeyListener(mp);
		//this.addMouseListener(mp);
		//this.addMouseMotionListener(mp);
		this.addWindowListener(mp);
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
//一个面板里，知道鼠标按下，并且鼠标按下的位置（x,y）MouseListener
//进入面板后，鼠标的移动 与拖拽，MouseMotionListener
//键盘的几个事件（按下，松开，键入字符） KeyListener
class MyPanel6 extends JPanel implements MouseListener,KeyListener,MouseMotionListener,WindowListener
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
	//按键，按着不动，就会一直触发按键事件。
	//这与鼠标按下，只触发一次是不一样的
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("键按下了，没有释放");
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
//		this.repaint();
	}

	//按键释放，释放任何按键
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("按键释放了");
	}

	/**
	 * type 可以理解为键入（非功能键），比如英文字母，数字等
	 * pressed是按下键,按下任何键
	 */
	@Override
	//键入字符，一般是可显字符（比如英文字符，数字，换行等），大部分的功能键不会触发该事件
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("键入事件发生了 char="+e.getKeyChar());
	}

	/**
	 * 下面的五个方法，对应鼠标的不同操作，事件处理者方法
	 */
	@Override
	//鼠标点击
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标点击了,x="+e.getX()+" y="+e.getY());
		System.out.println("鼠标点击，就是鼠标按下和鼠标松开这两个连贯动作的结合");
	}

	@Override
	//鼠标进来
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标来了");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标走了");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标按下，没有松开");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标松开了，刚才有按下");
	}

	/**
	 * 鼠标拖拽，其实就是（鼠标按下不松开+鼠标移动）两个动作的结合
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标拖拽中，x="+e.getX());
	}
	/**
	 * 鼠标在面板了移动
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标移动中，x="+e.getX());
	}

	/**
	 * windowListener 有7个动作
	 */
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("窗口激活了");
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("窗口关闭了");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("窗口关闭中");
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("窗口沉睡了");
	}

	@Override
	//反图标了
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("窗口 DeIconified了");
	}

	@Override
	//最小化了，（最小化为一个图标了）
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("窗口   Iconified了");
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("窗口打开了，只在窗口启动时触发");
	}
}