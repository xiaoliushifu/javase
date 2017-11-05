/**
 * 功能： 坦克游戏 4.0
 * 说明，先把坦克画出来
 * 坦克可以上下左右移动
 * 为窗口绑定事件监听者，事件监听者无须单独写，就是那个Panel。Panel自己监听其内部的组件
 * 因为事件监听者就是要修改坦克的移动方向，而坦克就是从Panel中而来。故只需让Panel
 * 实现事件监听者就行了，顺其自然
 * 
 * 使用KeyListener事件监听者接口。监听键盘按键w,d,s,a四个方向。
 * 因为按键有个特点，只要按下，就会一直不断地触发按键事件（按着键不动和不断地点击按键是一个效果）
 * 故在改变方向的同时，继续不断地触发按键事件，实现该方向上的移动（四个移动方法）x++,x--,y++,y--。
 * 移动的速度，也可以单独定义一个变量speed。默认是1。
 * 
 * 除了上述的修改之外，坦克本身也得修改，尤其是指坦克的朝向（炮筒的朝向）所以得画出四个不同方向的坦克。
 * 这个说来简单，但是要一点数学计算，只要在纸上画出四个朝向的坦克，自然就容易理解了
 * 
 * 这样上述几个步骤：   
 * 	1实例化坦克对象，并初始化为坦克设置好方向与速度属性成员（尚未在面板对象里画出）
 * 	2把坦克对象加入到面板里，并用每个坦克对象自身的方向和速度属性，在面板里画出具有各自朝向和初始位置的坦克
 * 	3面板对象调用paint方法，在面板里就可以渲染出第2步画出的坦克来了
 *  4不断地监听键盘事件（改变方向和移动的按键），调用repaint方法()重新渲染
 *  5重复上述的第4步骤
 *  
 * 继续开发，这次加入了子弹对象 ，子弹是坦克对象的子对象，也是通过按键监听来产生的，按键就是通俗地发射子弹呗
 * 子弹的位置也需要考虑一下，跟坦克炮筒的位置有关。
 * 重要的思索：子弹也是进程，也需要渲染，子弹如何渲染呢？子弹在面板里画出的。故仍然需要面板来渲染
 * 			这里所以也让面板实现了Runnable接口，使之脱离了只靠事件监听者来触发，然后repaint的限制。
 * 
 * 子弹可以发出来了，本次要实现的是子弹连发。
 * 这个也简单，坦克对象使用一个集合来存储子弹对象。然后在paint方法里画子弹的位置
 * 修改为遍历集合里的子弹对象，然后分别画出自己的x,y坐标及朝向即可。其他无需大改。
 * 
 * 子弹可以连发了，不能太霸道，目前限制为最多5发。
 * 实现击中坦克的效果，击中的原理，就是子弹的坐标，在坦克的坐标范围内就行。为此单独写一个方法hitTank()传入两个
 * 对象，一个是子弹，一个是敌人坦克。
 * 什么时候判断击中？或者何时调用hitTank()?。当然是无时不刻地判断了。所以，写在面板对象的run()方法里最合适。
 * 目前的笨方法，就是取出子弹，每个子弹与现有的敌军坦克遍历比较。NxM乘法原理
 */
package com.test3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame4 extends JFrame{

	MyPanel2 mp=null;
	public static void main(String[] args) {
		//在这里写启动代码
		MyTankGame4 mtg = new MyTankGame4();
	}
	//公共类的构造函数
	public MyTankGame4()
	{
		//在构造函数里，调用其他的类代码，其他类一般都是业务代码
		//调用自定义MyPanel2类，启动时会自动调用其paint方法
		mp = new MyPanel2();
		
		//启动面板进程
		Thread t = new Thread(mp);
		t.start();
		
		//为当前窗体添加面板
		this.add(mp);
		
		//为当前窗体添加事件监听者，巧的是，事件监听者，也是这个窗体里的面板。
		this.addKeyListener(mp);
		
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

//面板类 在其中画很多的坦克对象
class MyPanel2 extends JPanel implements KeyListener ,Runnable
{
	//面板里，定义一个坦克
	Hero hero = null;
	
	//敌人的坦克，用集合
	Vector<Enemy> ves = new Vector<Enemy>();
	
	int enSize = 3;
	
	//构造方法 只有修饰符
	public MyPanel2()
	{
		//初始化我的坦克，就一辆，直接new一次完事
		hero = new Hero(60,100);
		
		//敌军坦克不少，需要循环new出来，放到集合对象里
		for(int i=0;i<enSize;i++) {
			//创建一辆敌人坦克（面板上部，y轴固定为0，x轴往右一字排开）
			Enemy enemy = new Enemy((i+1)*50,0);
			//加入
			ves.add(enemy);
		}
	}
	
	//写一个方法，判断子弹是否击中敌人坦克
	//原理就是，只要子弹的坐标，在敌人坦克坐标的范围内，即为击中坦克。
	//但是，坦克始终是左上角为参考点，且坦克的坐标范围，随方向的不同，计算不同，故先需判断方向
	public void hitTank(Shot s,Enemy et)
	{
		//判断方向
		switch(et.direct)
		{
			case 0://上，下朝向的
			case 2:
				if(s.x>et.x && s.x<et.x+20 && s.y>et.y && s.y<et.y+30) {
					//击中
					//子弹消失
					s.isLive = false;
					//敌人坦克消失
					et.isLive = false;
				}
				break;
			case 1://左右朝向的
			case 3:
				if(s.x>et.x && s.x<et.x+30 && s.y>et.y && s.y<et.y+20) {
					//击中
					s.isLive = false;
					//敌人坦克消失
					et.isLive = false;
				}
		}
	}
	
	
	//JPanel重要的方法paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//首先把整个面板使用默认颜色
		g.fillRect(0, 0, 400, 300);
		//画自己坦克，方向传入，不再是固定的0，方向是按键决定的，动态地
		this.drawTank(hero.getX(), hero.getY(), g, hero.direct, 1);
		
		//这里得修改了，不能只画出一个子弹去paint，而应该使用循环
		for(int i=0;i<hero.vs.size();i++) {
			Shot myshot = hero.vs.get(i);
			if(myshot != null && myshot.isLive) {
				g.draw3DRect(myshot.x,myshot.y,1,1,false);
			}
			if(myshot.isLive == false) {
				//从vs中删除该子弹
				//注意，不要使用i而应该使用myshot。
				hero.vs.remove(myshot);
			}
		}
		//循环画出敌人坦克
		for(int i=0;i<ves.size();i++) {
			//判断是否这个坦克还活着
			Enemy et=ves.get(i);
			if(et.isLive) {
				this.drawTank(et.getX(), et.getY(), g, et.direct, 0);
			} /*else {
				ves.remove(et);
			}*/
		}
	}
	//画出一个坦克的方法
	/**
	 * 画出坦克的方法
	 * @param x 初始化坦克时的x坐标
	 * @param y 初始化坦克时的y坐标
	 * @param g 不清楚
	 * @param direction 初始化时坦克的朝向
	 * @param type  坦克类型  （1我的坦克  0敌军坦克）
	 */
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
		
		//判断坦克方向，需要纸上画出图来，才能好理解
		//向上和向右，其实就是矩阵的转换（x,y交互是什么来着？）
		switch(direction)
		{
			//向上 （炮筒向上） 
			case 0:
				//画出我的坦克(需要先在纸上画出，左轮，右轮，坦克矩形，坦克头，坦克炮头五个小组件
				//才能看明白下述的五个步骤）
				//1 画出左边的矩形
				g.fill3DRect(x, y, 5, 30,false);
				// 2 画出右边矩形，往右偏移15公分
				g.fill3DRect(x+15, y, 5, 30,false);
				// 3 画出中间矩形
				g.fill3DRect(x+5, y+5, 10, 20,false);
				// 4 画出中间圆形
				g.fillOval(x+5, y+10, 8, 8);
				//5 画出炮筒（直线）
				g.drawLine(x+8, y+10, x+8, y);
				break;
				
				//向右  炮筒向右
			case 1:
				//1 画出上边的矩形
				g.fill3DRect(x, y, 30, 5,false);
				// 2 画出下边矩形，往右偏移15公分
				g.fill3DRect(x, y+15, 30, 5,false);
				// 3 画出中间矩形
				g.fill3DRect(x+5, y+5, 20, 10,false);
				//4 画出中间圆形
				g.fillOval(x+10, y+5, 8, 8);
				//5 画出炮筒（直线）
				g.drawLine(x+10, y+8, x+30, y+8);
				break;
				
			//向下（与向上的区别，就是炮筒的方向而已）
			case 2:
				//画出我的坦克(需要先在纸上画出，左轮，右轮，坦克矩形，坦克头，坦克炮头五个小组件）
				//1 画出左边的矩形
				g.fill3DRect(x, y, 5, 30,false);
				// 2 画出右边矩形，往右偏移15公分
				g.fill3DRect(x+15, y, 5, 30,false);
				// 3 画出中间矩形
				g.fill3DRect(x+5, y+5, 10, 20,false);
				// 4 画出中间圆形
				g.fillOval(x+5, y+10, 8, 8);
				//5 画出炮筒（直线）
				g.drawLine(x+8, y+10, x+8, y+30);
				break;
				
				//向左
			case 3:
				//1 画出上边的矩形
				g.fill3DRect(x, y, 30, 5,false);
				// 2 画出下边矩形，往右偏移15公分
				g.fill3DRect(x, y+15, 30, 5,false);
				// 3 画出中间矩形
				g.fill3DRect(x+5, y+5, 20, 10,false);
				//4 画出中间圆形
				g.fillOval(x+10, y+5, 8, 8);
				//5 画出炮筒（直线）
				g.drawLine(x+10, y+8, x, y+8);
				break;

		}
	}


	/**
	 * 以事件监听者，分别判断按键，来达到方向和速度的控制
	 * w上	d右	s下	a左	
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_W) {
			this.hero.setDirect(0);
			this.hero.moveUp();
		} else if(e.getKeyCode() == KeyEvent.VK_D) {
			this.hero.setDirect(1);
			this.hero.moveRight();
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			this.hero.setDirect(2);
			this.hero.moveDown();
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		
		//单独拿个分支来判断子弹
		if (e.getKeyCode() == KeyEvent.VK_J) {
			//子弹如果连续发射就太霸道了，所以我们可以只让它最多五发子弹
			if(hero.vs.size()<=4) {
				this.hero.shotEnemy();
			}
		}
		
		//在更新了面板的元素位置，大小，颜色等后，重新渲染
		//不断地按键，不断地重新渲染(repaint()方法的底层其实还是会调用paint()，但是我们已经不能调用paint()了）
		this.repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//每隔100毫秒，去重新渲染。
		//最初的渲染，是通过事件监听者来实现的，在事件监听者方法的最后，通过this.repaint()来重新渲染的
		//这种渲染，只有触发了按键才能渲染，不触发就不渲染。
		//而这里使用进程方式让面板渲染，使之脱离了事件触发的限制
		//一旦启动面板进程，就一直渲染，无论事件是否触发。
		while(true)
		{
			
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			//在这里，时时刻刻判断，面板里的子弹是否击中了坦克
			//遍历子弹，每个子弹再遍历敌人坦克
			for (int i=0;i<hero.vs.size();i++) {
				//取出子弹
				Shot myShot = hero.vs.get(i);
				//子弹是否有效（想到上次线程完全的问题，子弹本身就是资源）
				if (myShot.isLive) {
					//再循环敌人坦克
					for (int j=0;j<ves.size();j++) {
						//取出子弹
						Enemy et = ves.get(j);
						if (et.isLive) {
							this.hitTank(myShot,et);
						}
					}
				}
			}
			this.repaint();
		}
	}
}
