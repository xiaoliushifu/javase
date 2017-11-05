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

package com.test2;

//坦克类
class Tank
{
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
 *
 */
class Enemy extends Tank
{
	public Enemy(int x, int y)
	{
		super(x,y);
		//方向都朝下
		this.setDirect(2);
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
		//启动子弹线程
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

//子弹类,以后会慢慢修改，增加功能
//子弹一旦发射出来，就会按照初始的方向，直线运动
//故子弹单独也是一个进程
class Shot implements Runnable
{
	int x = 0;  //初始子弹x坐标
	int y = 0;  //初始子弹y坐标
	int direct =0 ; //子弹移动方向
	int speed = 1; //子弹的移动速度
	public Shot(int x,int y,int direct)
	{
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
	
	public void run()
	{
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//子弹一旦创建，就按照既定的方向，直线运动下去
		while(true)
		{
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
			System.out.println("X坐标是"+x+" Y坐标是"+y);
		}
	}
}