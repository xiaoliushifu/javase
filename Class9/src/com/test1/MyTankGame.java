/**
 * 功能： 坦克游戏 1.0
 * 说明，先把坦克画出来
 */
package com.test1;
import javax.swing.*;
import java.awt.*;

public class MyTankGame extends JFrame{

	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//在这里写启动代码
		MyTankGame mtg = new MyTankGame();
	}
	//公共类的构造函数
	public MyTankGame()
	{
		//在构造函数里，调用其他的类代码，其他类一般都是业务代码
		//调用自定义Mypanel类，启动时会自动调用器paint方法
		mp = new MyPanel();
		this.add(mp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

//我的面板
class MyPanel extends JPanel
{
	//面板里，定义一个坦克
	Hero hero = null;
	public MyPanel()
	{
		//初始化我的坦克
		hero = new Hero(20,20);
	}
	
	
	//JPanel重要的方法paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//首先把整个面板使用默认颜色
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
	}
	//画出一个坦克
	public void drawTank(int x,int y,Graphics g,int direction,int type)
	{
		//判断敌我坦克的颜色不同
		switch(type)
		{
			case 0:
				g.setColor(Color.cyan);
				break;
			case 1:
				g.setColor(Color.yellow);
				break;
		}
		
		//判断坦克方向
		switch(direction)
		{
		//向上
		case 0:
			//画出我的坦克(需要先在纸上画出，左轮，右轮，坦克矩形，坦克头，坦克炮头五个小组件）
			//1 画出左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			// 2 画出右边矩形，往右偏移15公分
			g.fill3DRect(x+15, y, 5, 30,false);
			// 3 画出中间矩形
			g.fillRect(x+5, y+5, 10, 20);
			// 4 画出中间圆形
			g.setColor(Color.blue);
			g.fillOval(x+5, y+10, 8, 8);
			//5 画出炮筒（直线）
			g.drawLine(x+8, y+10, x+8, 15);
		}
	}
}


//坦克类
class Tank
{
	//表示坦克横坐标
	int x=0;
	//纵坐标
	int y=0;
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}

class Hero extends Tank
{
	//子类必须写构造函数(因为父类没有定义默认的构造函数）
	public Hero(int x,int y)
	{
		super(x,y);
	}
	
}