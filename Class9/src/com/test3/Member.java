/**
 * 单独从原来一个java文件中拎出来
 * 这个文件里单独定义坦克
 * 
 * 共性就是Tank
 * 我的坦克就是Hero
 * 敌人坦克就是Enemy。
 * 
 * 敌军的坦克有很多，数量不定，故应该使用集合而非数组。ArrayList,Vector都行。
 * 敌军坦克是销毁和产生不断变化的，就选择了Vector。为啥不是ArrayList?
 * 循环实例化敌军坦克，添加到Vector中
 * 在paint方法里，从Vector中循环画出坦克（颜色，方向是共同的，可以在构造函数里初始化完成）
 */

package com.test3;

//多个子弹对象
import java.util.Vector;

//坦克类
class Tank
{
	
	//坦克是否还有效（击中过了的坦克就是false）
	boolean isLive = true;
	//表示坦克横坐标
	int x=0;
	//纵坐标
	int y=0;
	//坦克方向
	// 0 上  1 右   2下  3左
	int direct = 0 ;
	
	//坦克颜色
	int color = 0;
	
	
	//坦克的速度（每次移动的像素数）
	int speed = 1;
	
	//构造函数，初始化坦克所在的位置
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
	/**
	 * @return the direct
	 */
	public int getDirect() {
		return direct;
	}
	/**
	 * @param direct the direct to set
	 */
	public void setDirect(int direct) {
		this.direct = direct;
	}
	
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}
}

/**
 * 敌人坦克
 * @author Administrator
 * 敌人坦克不受键盘控制，是独立运行的个体，故每个敌人坦克都是一个线程
 *
 */
class Enemy extends Tank implements Runnable
{
	//敌人产生坦克的频率
	int times=0;
	//一个子弹，用来添加到子弹集合中
	Shot s=null;
	
	//实现子弹连发，必须使用集合类
	Vector<Shot> vs = new Vector<Shot>();
	
	public Enemy(int x, int y)
	{
		super(x,y);
		//方向都朝下
		this.setDirect(2);
	}
	@Override
	//敌人坦克作为一个线程，必须实现的run方法
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				//每个坦克切换运动时休息50毫秒，也就是说敌人坦克将在1秒内切换20次
				//这样初始看起来，敌人的坦克切换方向非常快，像个无头苍蝇乱转，没有平滑移动效果
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//坦克方向移动，上右下左
			switch(this.direct){
				case 0:
					//说明坦克正在向上移动。
					//但是这样写效果有点问题，因为是移动一次，就去随机方向。在移动和切换方向之间转换非常快，
					//故应该多移动，或者移动的时间长一些，切换方向的机会少一些，这样效果好一点
					//坦克很有可能只移动了一步，就改变了方向，看起来的效果就是无头苍蝇不停地切换方向，移动却很少。
					//于是让它多移动几步，并且休息一下
					//移动多步，制造平滑效果
					for(int i=0;i<10;i++) {
						if(y>0) {
							y-=speed;
						}
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				case 1:
					for(int i=0;i<10;i++) {
						//防止超过边界范围
						if(x<400-30) {
							x +=speed;
						}
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				case 2:
					for(int i=0;i<10;i++) {
						if(y<300-30) {
							y +=speed;
						}
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				case 3:
					for(int i=0;i<10;i++) {
						if(x>0) {
							x -=speed;
						}
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
			times++;
			if(times%2 == 0){
				//是否给坦克加入新的子弹
				if(isLive){
					//3说明可以连发2个子弹
					if(vs.size()<5){
						//没有子弹就要重新产生子弹（根据此时坦克的方向）
						switch(direct){
						case 0://上（注意，x坐标是坦克的坐上角）
							s = new Shot(x+10,y,0);
							break;
						case 1://右
							s = new Shot(x+30,y+10,1);
							break;
						case 2://下
							s = new Shot(x+10,y+30,2);
							break;
						case 3://左
							s = new Shot(x,y+10,3);
							break;
						}
						Thread ts=new Thread(s);
						ts.start();
						//添加到敌人的子弹集合里
						vs.add(s);
					}
				}
			}
			//坦克随机产生新的方向
			this.direct =(int)(Math.random()*4);
			//判断敌人坦克是否死亡
			if(!this.isLive){
				break;
			}
		}
	}
}


/**
 * 我的坦克
 * @author Administrator
 *
 */
class Hero extends Tank
{
	//子弹也是java对象，是坦克的一个子对象
	Shot s = null;
	//实现子弹连发，必须使用集合类
	Vector<Shot> vs = new Vector<Shot>();
	
	//子类必须写构造函数(因为父类没有定义默认的构造函数）
	public Hero(int x,int y)
	{
		super(x,y);
	}
	
	
	//坦克具有发射子弹（开火）的能力
	//但也不是随意创建，取决于当前坦克的方向及位置
	//目前来做，坦克只有一个子弹
	public void shotEnemy()
	{
		//根据坦克此时所处的方向，来实例化出子弹对象
		switch(this.direct)
		{
		case 0://上（注意，x坐标是坦克的坐上角）
			s = new Shot(x+10,y,0);
			break;
		case 1://右
			s = new Shot(x+30,y+10,1);
			break;
		case 2://下
			s = new Shot(x+10,y+30,2);
			break;
		case 3://左
			s = new Shot(x,y+10,3);
			break;
		}
		vs.add(s);
		//启动子弹线程，每个子弹都是一个单独地进程
		Thread t = new Thread(s);
		t.start();
	}
	
	//坦克向上移动，必须首先知道java面板里有一个坐标，以左上角为(0,0)原点，
	//以此为基础的x，y变化（增大或减小）才能实现坦克的移动
	public void moveUp()
	{
		y-=speed;
	}
	//坦克下移动
	public void moveDown()
	{
		y+=speed;
	}
	//坦克向左移动
	public void moveLeft()
	{
		x-=speed;
	}
	//坦克向右移动
	public void moveRight()
	{
		x+=speed;
	}
	
}

//炸弹类
class Bomb
{
	//炸弹的坐标属性
	int x,y;
	//炸弹生命力
	int life=9;
	//炸弹是否激活 
	boolean isLive=true;
	public Bomb(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//减少生命值
	public void lifeDown()
	{
		if (life>0) {
			life--;
		} else {
			isLive=false;
		}
		
	}
	
}



//子弹类,以后会慢慢修改，增加功能
//子弹一旦发射出来，就会按照初始的方向，直线运动
//故子弹单独也是一个进程
class Shot implements Runnable
{
	int x = 0;  //初始子弹x坐标
	int y = 0;  //初始子弹y坐标
	int direct =0 ; //子弹移动方向
	int speed = 3; //子弹的移动速度
	Boolean isLive = true;//子弹是否还在
	public Shot(int x,int y,int direct)
	{
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
	
	public void run()
	{
		
		//子弹一旦创建，就按照既定的方向，直线运动下去
		while(true)
		{
			try {
			//在敌人的坦克有多颗子弹时。注意：循环画出子弹的时机，要比渲染的频率要快。
				//否则在渲染时，坦克尚未运动，这样即使画出了多颗子弹，子弹的坐标也是一样，也看不出子弹移动效果，
				//看起来和一颗子弹是一样的效果。
				//而且，子弹可以连发，但是不应该一直连发，可以让同一辆坦克的两颗子弹的间距随机起来
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct)
			{
			case 0://上
				y-=speed;
				break;
			case 1://上
				x+=speed;
				break;
			case 2://上
				y+=speed;
				break;
			case 3://上
				x-=speed;
				break;
			}
			//有一个问题，子弹对象何时消失退出内存呢？
			//direct.System.out.println("X坐标是"+x+" Y坐标是"+y);
			
			//判断该子弹是否到达面板的边缘
			if (x<0 || x>400 ||y<0 || y>300) {
				isLive = false;
				break;
			}
		}
	}
}