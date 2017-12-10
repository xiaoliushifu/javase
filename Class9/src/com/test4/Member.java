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
 * 
 * 坦克碰撞原理：
 * 	总之一句话：当前坦克的坐标范围（比如左上角），是否在其他坦克的所占坐标的范围内，在即为碰撞；
 *  根据当前坦克的方向，有以下这么几种情况：
 *  	当前坦克朝上时：队友坦克有上下两个方向算一种情况；也有左右方向算一种情况；
 *  	根据当天坦克的左上角坐标和右上角坐标，是否在队友坦克的坐标范围内即可。
 *  当前坦克共有四种朝向，每种情况下队友都有两种情况，故4*2=8种情况
 */

package com.test4;

//多个子弹对象
import java.util.Vector;
import java.io.*;
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
 * 本次增加功能，实现敌人坦克移动时不可重叠的效果
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
	
	//定义一个向量，可以访问到面板里所有敌人的坦克
	Vector<Enemy> ves=new Vector<Enemy>();
	
	//得到面板里的所有敌人坦克
	public void setVes(Vector<Enemy> ve)
	{
		this.ves = ve;
	}
	
	public Enemy(int x, int y)
	{
		super(x,y);
		//初始方向都朝下
		this.setDirect(2);
	}
	
	/**
	 * 判断是否碰撞的方法,代码量多，但是逻辑较少
	 * 熟悉原理，当前坦克的四个方向即可
	 * @return
	 */
	public Boolean IsTouchOtherEnemy()
	{
		Boolean b=false;
		
		//分析碰撞的原理，就不在此处写了。这里是首先判断当前坦克的方向，再判断队友坦克的方向
		//根据我的方向和队友方向的不同，有这么几种组合
		switch(this.direct){
		//当前坦克的方向朝上,左上角坐标是（x,y),右上角坐标是（x+20,y)
		case 0:
			//遍历队友坦克，判断当前坦克坐标和队友坦克坐标的重叠性呗
			for(int i=0;i<ves.size();i++) {
				//取出队友的坦克
				Enemy e=ves.get(i);
				
				if(e!=this){//排除自己
					//开始判断队友坦克的方向,朝上或者朝下
					if(e.direct==0 || e.direct==2){
						//如果当前坦克的左上角坐标范围在队友坦克的坐标范围内的话
						if(this.x>=e.x && this.x<=e.x+20 && this.y>=e.y && this.y<=e.y+30) {
							return true;
						}
						//判断当前坦克的右上角坐标范围是否在队友坦克的坐标范围内
						if(this.x+20>=e.x && this.x+20<=e.x+20 && this.y>=e.y && this.y<=e.y+30){
							return true;
						}
					}
					//再判断队友的坦克方向，朝左或朝右
					if(e.direct==1 || e.direct==3) {
						//当前坦克的左上角
						if(this.x>=e.x && this.x<=e.x+30 && this.y>=e.y && this.y<=e.y+20 ){
							return true;
						}
						//当前坦克的右上角
						if(this.x+20>=e.x && this.x+20 <=e.x+30 && this.y>=e.y && this.y<=e.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 1:
			//当前坦克朝右边时，左上角坐标是(x+30,y),右上角坐标是（x+30,y+20)
			for(int i=0;i<ves.size();i++) {
				Enemy e=ves.get(i);
				if(e!=this){
					//开始判断队友坦克的方向,朝上或者朝下
					if(e.direct==0 || e.direct==2){
						//如果当前坦克的左上角坐标范围在队友坦克的坐标范围内的话
						if(this.x+30>=e.x && this.x+30<=e.x+20 && this.y>=e.y && this.y<=e.y+30) {
							return true;
						}
						//判断当前坦克的右上角坐标范围是否在队友坦克的坐标范围内
						if(this.x+30>=e.x && this.x+30<=e.x+20 && this.y+20>=e.y && this.y+20<=e.y+30){
							return true;
						}
					}
					//再判断队友的坦克方向，朝左或朝右
					if(e.direct==1 || e.direct==3) {
						//当前坦克的左上角
						if(this.x+30>=e.x && this.x+30<=e.x+30 && this.y>=e.y && this.y<=e.y+20 ){
							return true;
						}
						//当前坦克的右上角
						if(this.x+30>=e.x && this.x+30 <=e.x+30 && this.y+20>=e.y && this.y+20<=e.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 2:
			//当前坦克朝下时，左上角坐标是（x+20,y+30），右上角坐标是（x,y+30）
			for(int i=0;i<ves.size();i++) {
				Enemy e=ves.get(i);
				if(e!=this){
					//开始判断队友坦克的方向,朝上或者朝下
					if(e.direct==0 || e.direct==2){
						//如果当前坦克的左上角坐标范围在队友坦克的坐标范围内的话
						if(this.x+20>=e.x && this.x+20<=e.x+20 && this.y+30>=e.y && this.y+30<=e.y+30) {
							return true;
						}
						//判断当前坦克的右上角坐标范围是否在队友坦克的坐标范围内
						if(this.x>=e.x && this.x<=e.x+20 && this.y+30>=e.y && this.y+30<=e.y+30){
							return true;
						}
					}
					//再判断队友的坦克方向，朝左或朝右
					if(e.direct==1 || e.direct==3) {
						//当前坦克的左上角
						if(this.x+20>=e.x && this.x+20<=e.x+30 && this.y+30>=e.y && this.y+30<=e.y+20 ){
							return true;
						}
						//当前坦克的右上角
						if(this.x>=e.x && this.x<=e.x+30 && this.y+30>=e.y && this.y+30<=e.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 3:
			//当前坦克靠左时，左上角坐标为(x,y+20),右上角坐标（x,y)
			for(int i=0;i<ves.size();i++) {
				Enemy e=ves.get(i);
				if(e!=this){
					//开始判断队友坦克的方向,朝上或者朝下
					if(e.direct==0 || e.direct==2){
						//如果当前坦克的左上角坐标范围在队友坦克的坐标范围内的话
						if(this.x>=e.x && this.x<=e.x+20 && this.y+20>=e.y && this.y+20<=e.y+30) {
							return true;
						}
						//判断当前坦克的右上角坐标范围是否在队友坦克的坐标范围内
						if(this.x>=e.x && this.x<=e.x+20 && this.y>=e.y && this.y<=e.y+30){
							return true;
						}
					}
					//再判断队友的坦克方向，朝左或朝右
					if(e.direct==1 || e.direct==3) {
						//当前坦克的左上角
						if(this.x>=e.x && this.x<=e.x+30 && this.y+20>=e.y && this.y+20<=e.y+20 ){
							return true;
						}
						//当前坦克的右上角
						if(this.x>=e.x && this.x <=e.x+30 && this.y>=e.y && this.y<=e.y+20){
							return true;
						}
					}
				}
			}
		}
		return b;
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
					//故应该多移动，或者移动的时间长一些，切换方向的机会少一些，这样效果看起来好一点，平滑
					//坦克很有可能只移动了一步，就改变了方向。看起来的效果就是无头苍蝇不停地切换方向，移动却很少，甚至不移动。
					//于是让它多移动几步，并且休息一下
					//移动多步，制造平滑效果
					for(int i=0;i<10;i++) {
						//控制坦克的移动范围在面板里
						if(y>0 && !this.IsTouchOtherEnemy()) {
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
						if(x<400-30 && !this.IsTouchOtherEnemy()) {
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
						//控制坦克的移动范围在面板里
						if(y<300-30 && !this.IsTouchOtherEnemy()) {
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
						//控制坦克的移动范围在面板里
						if(x>0 && !this.IsTouchOtherEnemy()) {
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
			
			/*下面的逻辑是处理敌人坦克如何产生子弹并发射，然后在渲染时才能看到效果*/
			times++;
			if(times%2 == 0){
				//是否给坦克加入新的子弹
				if(isLive){
					//3说明可以连发2个子弹
					if(vs.size()<3){
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
						//敌人的每颗子弹都是单独的一个进程
						Thread ts=new Thread(s);
						ts.start();
						//添加到敌人的子弹集合里
						vs.add(s);
					}
				}
			}
			//坦克不断移动，新方向随机产生
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

/**
 * 记录类，记录玩家的设置和成绩
 * 坦克数量，子弹连发数量，坦克速度，子弹速度，关数等
 * @author Administrator
 *
 */
class Recorder
{
	//敌人当前的数量
	public static int enemyNum=20;
	//我的坦克消灭的坦克数量
	public static int hitEnemyNum=0;
	//我的坦克可以重生几次
	public static int mylifeNum=3;
	
	public static FileWriter fw=null;
	public static BufferedWriter bw=null;
	private static FileReader fr=null;
	private static BufferedReader br=null;
	
	public static void getRecording()
	{
		try {
			fr = new FileReader("d:\\record.txt");
			br= new BufferedReader(fr);
			String str = br.readLine();
			//字符串类型转换为整型
			hitEnemyNum = Integer.parseInt(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void keepRecording()
	{
		try {
			fw = new FileWriter("d:\\record.txt");
			bw = new BufferedWriter(fw);
			bw.write(hitEnemyNum+"\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	/**
	 * 保存敌人活着的坦克及方向和位置坐标
	 * 待触发保存动作时，传入当时坦克向量
	 */
	private static Vector<Enemy> ets=null;
	public static void keepRecordingEnemyAndPosition(Vector<Enemy> ets)
	{
		try {
			fw = new FileWriter("d:\\record.txt");
			bw = new BufferedWriter(fw);
			bw.write(hitEnemyNum+"\r\n");
			
			//保存当前存活的坦克
			for(int i=0;i<ets.size();i++){
				Enemy e=ets.get(i);
				if(e.isLive){
					//保存格式就是空格分开的字符串而已
					String pos=e.x+" "+e.y+" "+e.direct;
					bw.write(pos+"\r\n");
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	/**
	 * 从磁盘中读取上一局的记录，恢复到内存中，返回到MyTankGame4.java中
	 * @return
	 */
	public static Vector<Enemy> getEnemyAndPosition()
	{
		ets=new Vector<Enemy>();
		try {
			fr = new FileReader("d:\\record.txt");
			br= new BufferedReader(fr);
			String str = br.readLine();
			//字符串类型转换为整型
			hitEnemyNum = Integer.parseInt(str);
			
			//遍历读取坦克,保存到节点中
			while((str=br.readLine())!=null){
				String xyd[]=str.split(" ");
				Enemy e=new Enemy(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]));
				//设置恢复的坦克坐标及方向
				e.setDirect(Integer.parseInt(xyd[2]));
				ets.add(e);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ets;
	}

}


/**
 * 炸弹类，所谓爆炸类，就是执行那三张图片切换操作的一个类，它拥有着坦克爆炸时的坐标。
 * 待有一辆坦克爆炸时，才需要实例化出来，按照一定顺序和频率，在某位置切换图片以达到爆炸效果，仅此而已。
 * @author Administrator
 *
 */

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
	int speed = 2; //子弹的移动速度
	Boolean isLive = true;//子弹是否还在（击中坦克后，或者通过边界后就消失了）
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
			//有一个问题，子弹对象何时消失退出内存呢？画子弹时判断是否有效，无效则退出内存
			//direct.System.out.println("X坐标是"+x+" Y坐标是"+y);
			
			//判断该子弹是否到达面板的边缘
			if (x<0 || x>400 ||y<0 || y>300) {
				isLive = false;
				break;
			}
		}
	}
}