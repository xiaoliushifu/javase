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
 * 子弹出现的位置也需要考虑一下，跟坦克炮筒的位置有关。
 * 重要的思索：子弹也是进程，也需要渲染，子弹如何渲染呢？子弹在面板里画出的。故仍然需要面板来渲染
 * 			这里所以也让面板实现了Runnable接口，使之脱离了只靠事件监听者来触发，然后repaint的限制。
 * 
 * 子弹可以发出来了，本次要实现的是子弹连发。
 * 这个也简单，坦克对象使用一个集合来存储子弹对象。然后在paint方法里画子弹的位置
 * 修改为遍历集合里的子弹对象，然后分别画出自己的x,y坐标及朝向即可。其他无需大改。
 * 
 * 子弹可以连发了，不能太霸道，目前限制为最多5发。
 * 实现击中坦克的效果，击中的原理，就是子弹移动时的坐标，在坦克的坐标范围内就行。为此单独写一个方法hitTank()传入两个
 * 对象，一个是子弹，一个是敌人坦克。
 * 什么时候判断击中？或者何时调用hitTank()?。当然是无时不刻地判断了。所以，写在面板对象的run()方法里最合适。
 * 目前的笨方法，就是取出子弹，每个子弹与现有的敌军坦克遍历比较。NxM乘法原理
 * 
 * 当坦克被击中时，增加爆炸效果,所谓爆炸效果，就是三张（甚至多张）效果图片的切换而已（动画片就是这个原理）
 * 坦克被击中时，就要产生一个爆炸效果对象。由于面板是一个进程，无视不刻在画出面板里的元素，所以在面板里paint方法里
 * 遍历爆炸效果集合，每个效果对象都各自处理那三张图片的切换，切换速度要考虑好。
 * 可以为爆炸效果定义生命值，比如初始为9，每三个生命值切换一张图片，每次生命值减一直到生命值为0，爆炸效果对象消失
 * 爆炸效果的产生和爆炸效果的展示，不在同一个逻辑里。
 * 目前敌人坦克有三辆，但是第一个坦克（无论哪一个是第一个）被击中的爆炸效果不太明显，随后的两个倒是很明显，不知为何
 * 
 * 学习了文件IO对象后，替换三个图片文件对象imageIO，解决了第一个坦克没有爆炸效果的漏洞
 * 
 * 敌人的坦克可以随意移动，实现方式就是敌人的坦克也是一个线程
 * 坦克的移动方向是随机的，坦克的移动步调可以控制，如果坦克每移动一步就切换方向，这样的效果看起来不太好；
 * 所以，敌人坦克应该每移动多步后，再给一次切换坦克方向的机会（有可能方向相同），这样敌人坦克运行起来较为平滑
 * 
 * 控制敌人坦克的移动范围，应该在面板里。
 * 这个简单，控制坦克的坐标在指定的范围内才移动，否则不移动。
 * 
 * 敌人可以发送子弹，且子弹的数量可控。
 * 敌人的子弹的产生也是随机的，方案1：随着坦克的移动而产生，并不是一次循环产生。
 * 方案2：放在paint里，写两个循环嵌套，循环每个坦克的每个子弹。数量不够就一直产生。（继续考虑）
 * 坦克的死亡，是在画坦克时，如果坦克已经死亡就remove掉（坦克的子弹也就消失了）
 * 子弹的死亡，也是在画坦克时判断
 * 
 * 我的坦克被击中时，也要消失。如何做到呢？
 * 简单，就像判断我的子弹是否击中敌人坦克一样的逻辑；也分开判断敌人每个坦克的每个子弹，是否击中我就是了
 * 
 * 坦克的移动不能重叠（已实现，方法写在了敌人坦克类里了）
 * 游戏进行的时候可以暂停，可以继续
 * 线上玩家的成绩（打了多少坦克）
 * 加上音效
 * 
 * 加上游戏封面，即刚打开游戏时，需要展示第几关的一个页面而已。
 * 在这里就是一个简单的panel而已。用MystartPanel类单独写即可。
 * 闪烁？就是把封面的窗体也做成线程而已。
 * 有个开始按钮，那就做出个菜单
 */
package com.test4;

import javax.imageio.ImageIO;//图片使用
import java.io.*;//图片使用

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame4 extends JFrame implements ActionListener{

	MyPanel2 mp=null;
	MyStartPanel msp=null;
	//菜单栏
	JMenuBar jmb=null;
	//菜单
	JMenu jm1=null;
	//菜单项
	JMenuItem jmi=null;
	public static void main(String[] args) {
		//在这里写启动代码
		MyTankGame4 mtg = new MyTankGame4();
	}
	//公共类的构造函数
	public MyTankGame4()
	{
		//游戏封面
		msp=new MyStartPanel();
		Thread mspt= new Thread(msp);
		mspt.start();
		this.add(msp);
		
		//游戏封面的菜单栏
		jmb = new JMenuBar();
		jm1 = new JMenu("游戏(G)");
		jm1.setMnemonic('G');//快捷方式 Alt+G
		//响应这个按钮的操作，开始游戏。故需要事件监听
		jmi = new JMenuItem("开始新游戏(N)");
		jmi.addActionListener(this);
		jmi.setActionCommand("newGame");//设置命令文字
		jm1.add(jmi);
		jmb.add(jm1);
		this.setJMenuBar(jmb);//菜单栏添加到窗体里
		
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("newGame")){
			//鉴于游戏开始也是一个面板，和封面面板重叠。故先删除封面面板
			this.remove(msp);
			//this.remove(mp);//游戏中也可以重新开始
			mp = new MyPanel2();
			
			//启动游戏面板进程
			Thread t = new Thread(mp);
			t.start();
			
			//为当前窗体添加面板
			this.add(mp);
			//为当前窗体添加事件监听者，巧的是，事件监听者，也是这个窗体里的面板。
			//任何对象都可以添加事件监听者，应该针对对象的操作特性添加对应的事件监听者
			//面板里我的坦克的移动，发射子弹，都是通过按键来实现的，故添加（键盘）事件监听者，以监听面板对象里按键的操作
			this.addKeyListener(mp);
			
			//再次刷新一次当前窗体里的新面板
			this.setVisible(true);
			
		}
	}

}

//提示当前是第几关，就是一个初始的Panel而已
//加上闪烁效果，那就得做成线程 
class MyStartPanel extends JPanel implements Runnable
{
	//定义一个开关
	int times=0;
	public void paint(Graphics g){
		super.paint(g);
		//给出提示语就行,设置颜色与字体
		g.fillRect(0, 0, 400, 300);
		g.setColor(Color.YELLOW);
		if(times%2==0) {
			Font myfont=new Font("华文新魏",Font.BOLD,30);
			g.setFont(myfont);
			g.drawString("Stage 1", 150, 150);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//休眠
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			this.repaint();
		}
		
	}
}

//面板类 在其中画很多的坦克对象
class MyPanel2 extends JPanel implements KeyListener ,Runnable
{
	//面板里，定义一个坦克
	Hero hero = null;
	
	//定义三张图片，三张图片组成坦克消失的爆炸效果（图片按照一定顺序与频率切换，欺骗人眼）
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	//爆炸对象集合，每个爆炸对象各自处理那三张图片的切换
	Vector<Bomb> vbs = new Vector<Bomb>();
	
	//敌人的坦克，用集合
	Vector<Enemy> ves = new Vector<Enemy>();
	
	//初始化时控制敌人坦克的数量
	int enSize = 6;
	
	//构造方法 只有修饰符
	public MyPanel2()
	{
		//初始化我的坦克，就一辆，直接new一次完事
		hero = new Hero(60,100);
		
		//敌军坦克不少，需要循环new出来，放到集合对象里
		for(int i=0;i<enSize;i++) {
			//创建一辆敌人坦克（面板上部，y轴固定为0，x轴往右一字排开）
			Enemy enemy = new Enemy((i+1)*50,0);
			//每个敌人坦克，也是一个进程
			Thread t = new Thread(enemy);
			t.start();
			
			//加入到当前坦克的队友向量中,使得当前坦克可以判断周围队友的情况
			//虽然第一次加时，是空坦克，但是ves是引用，故最终每个坦克都有唯一的一个引用集合
			//包含了所有敌人的坦克，包括自己在内
			enemy.setVes(ves);
			
			//给敌人坦克添加一颗子弹,放到它的子弹集合里
			Shot s=new Shot(enemy.x,enemy.y,enemy.direct);
			enemy.vs.add(s);
			//它的子弹也是一个线程
			Thread ts= new Thread(s);
			ts.start();
			
			//加入到敌人坦克集合中
			ves.add(enemy);
		}
		//首先引入这三张爆炸效果图
		try {
			//注意，图片文件路径不是在包src内，而是在项目Class9目录下
			image1=ImageIO.read(new File("bomb_1.gif"));
			image2=ImageIO.read(new File("bomb_2.gif"));
			image3=ImageIO.read(new File("bomb_3.gif"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 遍历我的子弹，再遍历敌人的坦克
	 * 从而去判断是否击中敌人坦克。
	 */
	public void TraverseMyShotForEnemy()
	{
		//在这里，时时刻刻判断，面板里的子弹是否击中了敌人坦克
		//遍历子弹，每个子弹再遍历敌人坦克
		for (int i=0;i<hero.vs.size();i++) {
			//取出子弹
			Shot myShot = hero.vs.get(i);
			//子弹是否有效（想到上次线程完全的问题，子弹本身就是资源）
			if (myShot.isLive) {
				//再循环敌人坦克
				for (int j=0;j<ves.size();j++) {
					//取出一个坦克
					Enemy et = ves.get(j);
					if (et.isLive) {
						//是否击中坦克，单独写个方法，传入子弹和坦克对象
						this.hitTank(myShot,et);
					}
				}
			}
		}
	}
	
	/**
	 * 遍历敌人的坦克，再遍历每个坦克的子弹，查看我的坦克是否被击中
	 */
	private void traverseEnemyShotIsMe()
	{
		//遍历敌人坦克，再遍历该坦克的子弹
		for (int i=0;i<ves.size();i++) {
			//取出敌人坦克
			Enemy e = ves.get(i);
			//循环这个坦克的子弹
			for(int j=0;j<e.vs.size();j++){
				Shot eShot = e.vs.get(j);
				//子弹是否有效（想到上次线程完全的问题，子弹本身就是资源）
				if (eShot.isLive) {
					if (hero.isLive) {//我的坦克也还有效
						//是否击中坦克，单独写个方法（修改最初判断是否击中敌人坦克的方法而来）
						this.hitTank(eShot,hero);
					}
				}
			}
		}
	}
	
	
	//写一个方法，判断子弹是否击中敌人坦克
	//原理就是，只要子弹的坐标，在敌人坦克坐标的范围内，即为击中坦克。
	//但是，坦克始终是左上角为参考点，且坦克的坐标范围，随方向的不同，计算不同，故先需判断方向
	//扩展这个函数，也可以判断是否击中我的坦克，故升级第二个参数类型为Tank
	private void hitTank(Shot s,Tank et)
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
					//击中坦克，就要产生爆炸效果,放入集合中
					Bomb b=new Bomb(et.x,et.y);
					vbs.add(b);
				}
				break;
			case 1://左右朝向的
			case 3:
				if(s.x>et.x && s.x<et.x+30 && s.y>et.y && s.y<et.y+20) {
					//击中
					s.isLive = false;
					//敌人坦克消失
					et.isLive = false;
					//击中坦克，就要产生爆炸效果,放入集合中
					Bomb b=new Bomb(et.x,et.y);
					vbs.add(b);
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
		//既然我的坦克可以被敌人击中，那么我的坦克活着才可以被画出来
		if(hero.isLive) {
			this.drawTank(hero.getX(), hero.getY(), g, hero.direct, 1);
		}else{
			//hero=null;
		}
		
		//这里得修改了，不能只画出一个子弹去paint，而应该使用循环，因为我的坦克可以发送多颗子弹
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
		
		//画出击中图片,即爆炸效果，实现原理就是：一旦有坦克爆炸就实例化一个爆炸类，记住爆炸位置坐标
		//然后在该位置上按照顺序和频率切换这三张图片而已
		for(int i=0;i<vbs.size();i++) {
			Bomb b=vbs.get(i);
			if(b.life>6){
				g.drawImage(image1, b.x, b.y, 30,30,this);
			}else if(b.life>3){
				g.drawImage(image2, b.x, b.y, 30,30,this);
			}else{
				g.drawImage(image3, b.x, b.y, 30,30,this);
			}
			//生命力减少
			b.lifeDown();
			//生命力为0时，从向量中删除即可
			if(!b.isLive){
				vbs.remove(b);
			}
		}
		
		//循环画出敌人坦克
		for(int i=0;i<ves.size();i++) {
			Enemy et=ves.get(i);
			//判断是否这个坦克还活着
			if(et.isLive) {
				this.drawTank(et.getX(), et.getY(), g, et.direct, 0);
				//顺便画出它的子弹
				for(int j=0;j<et.vs.size();j++){
					Shot s= et.vs.get(j);
					//如果它的子弹还有效
					if(s.isLive) {
						g.draw3DRect(s.x,s.y,1,1,false);
					}else{
						//否则就清除它的子弹
						et.vs.remove(s);
					}
				}
			} else {
				ves.remove(et);//敌人的坦克消失
				//System.out.println("敌人坦克数量 2="+ves.size());
			}
			//System.out.println("敌人坦克数量="+ves.size());
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
	 * 
	 * 以事件监听者，分别判断按键，来达到方向和速度的控制
	 * w上	d右	s下	a左	
	 * 这是面板作为事件监听者（按键事件）必须实现的方法（多个方法）
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
		
		//单独拿个分支来判断我的坦克发射子弹的按键事件处理
		if (e.getKeyCode() == KeyEvent.VK_J) {
			//子弹如果连续发射就太霸道了，所以我们可以只让它最多五发子弹
			if(hero.vs.size()<=4) {
				this.hero.shotEnemy();
			}
		}
		
		//在更新了面板里的元素，元素坐标位置，大小，颜色等后，重新渲染
		//不断地按键，不断地重新渲染(repaint()方法的底层其实还是会调用paint()，但是我们已经不能再次调用paint()）
		//this.repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 面板作为一个进程，必须实现run方法
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//每隔100毫秒，去重新渲染。
		//最初的渲染，是通过事件监听者来实现的，在事件监听者方法的最后，通过this.repaint()来重新渲染的
		//这种渲染，只有触发了按键才能渲染，不触发就不渲染，因为当时尚不能发射子弹，仅是画出坦克，
		//坦克可以上下左右移动，仅此而已。这些都是按键后才会进行的操作效果，不按键就不动，故重新渲染和触发按键
		//两个逻辑在一块
		//而这里使用进程方式让面板自动渲染，使之脱离了事件触发的限制
		//一旦启动面板进程，就一直渲染，无论事件是否触发。因为开发到现在，面板里已经有坦克了，
		//重点是坦克可以发射子弹了，子弹的位置变化，击中坦克，敌人坦克的移动，都得实时渲染，才能看到效果。
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			this.TraverseMyShotForEnemy();
			//写个函数，敌人的子弹是否击中我的坦克
			this.traverseEnemyShotIsMe();
			//渲染
			this.repaint();
		}
	}
}
