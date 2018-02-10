/**
 * QQ好友列表
 */
package com.qq.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class QqFriendList extends JFrame implements ActionListener,MouseListener{

	//第一张卡片，好友列表
	JPanel jphy1,jphy1_2,jphy1_3;
	JButton jphy_jb1,jphy_jb2,jphy_jb3;
	JScrollPane jsp1;
	
	//第二张卡片，陌生人列表
	JPanel jpmsr1,jpmsr1_2,jpmsr1_3;
	JButton jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
	JScrollPane jsp2;
	
	//一个窗体里，需要使用卡片式布局，可以放多张卡片
	CardLayout cl =null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqFriendList qqlist = new QqFriendList();
	}
	//构造方法
	public QqFriendList(){
		
//第一张卡片，好友列表
		//第一个整体大面板，包含一个按钮,两个子面板
		jphy1=new JPanel(new BorderLayout());
		//假定有50个好友
		jphy1_2=new JPanel(new GridLayout(50,1,4,4));
		//子面板
		jphy1_3=new JPanel(new GridLayout(2,1));
		
		jphy_jb1 = new JButton("我的好友");
		jphy_jb2 = new JButton("陌生人");
		jphy_jb2.addActionListener(this);
		jphy_jb3 = new JButton("黑名单");
		

		//创建50个label,表示50个好友
		JLabel jbls[]=new JLabel[50];
		for(int i=0;i<jbls.length;i++){
			jbls[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls[i].addMouseListener(this);//鼠标事件，高亮功能
			jphy1_2.add(jbls[i]);//加入到面板里
		}
		//中间是个可滚动的，用JScrollPane嵌套jphy2
		jsp1 = new JScrollPane(jphy1_2);
		
		//第三个面板添加两行一列的按钮
		jphy1_3.add(jphy_jb2);
		jphy1_3.add(jphy_jb3);
		
		//大面板的北面，只一个按钮
		jphy1.add(jphy_jb1,"North");
		//添加一个子面板（滚动的）
		jphy1.add(jsp1,"Center");
		//添加一个子面板
		jphy1.add(jphy1_3,"South");
		
//第二张卡片，好友列表
		//整体大面板，包含一个按钮,两个子面板
		jpmsr1=new JPanel(new BorderLayout());
		//可包含两个按钮的子面板
		jpmsr1_2=new JPanel(new GridLayout(2,1));
		//假定有20个陌生人,第三个面板
		jpmsr1_3=new JPanel(new GridLayout(20,1,4,4));
		
		jpmsr_jb1 = new JButton("我的好友");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2 = new JButton("陌生人");
		jpmsr_jb3 = new JButton("黑名单");
		
		//子面板添加两行一列的按钮
		jpmsr1_2.add(jpmsr_jb1);
		jpmsr1_2.add(jpmsr_jb2);

		//创建20个label,表示20个陌生人
		JLabel jbls2[]=new JLabel[20];
		for(int i=0;i<jbls2.length;i++){
			jbls2[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls2[i].addMouseListener(this);//鼠标事件，高亮功能
			jpmsr1_3.add(jbls2[i]);//加入到面板里
		}
		//中间是个可滚动的，用JScrollPane嵌套jpmsr1_2
		jsp2 = new JScrollPane(jpmsr1_3);
		
		//大面板的北面，是包含两个按钮的子面板
		jpmsr1.add(jpmsr1_2,"North");
		//中间添加一个子面板（滚动的）
		jpmsr1.add(jsp2,"Center");
		//最南边是个按钮
		jpmsr1.add(jpmsr_jb3,"South");
		
		
		cl=new CardLayout();
		this.setLayout(cl);//卡式布局
		this.add(jphy1,"1");//第一个卡片
		this.add(jpmsr1,"2");//第二个卡片
		
		this.setSize(150,400);
		this.setVisible(true);
		this.setLocation(100, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//切换到陌生人卡片
		if(arg0.getSource()==jphy_jb2){
			//为啥不是this,而是getContentPane呢？
			cl.show(this.getContentPane(), "2");//卡式布局管理器线上第二个卡片
		}
		//切换到好友列表卡片
		if(arg0.getSource()==jpmsr_jb1){
			cl.show(this.getContentPane(), "1");//卡式布局管理器线上第二个卡片
		}
	}
	//双击某个用户（JLabel),开启套接字聊天
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount()==2){
			//得到该好友的编号
			String friendNo=((JLabel) arg0.getSource()).getText();
			System.out.println("希望和"+friendNo+"聊天");
		}
	}
	@Override
	//当鼠标进入时，改头像（label)高亮为红色
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)arg0.getSource();
		jl.setForeground(Color.red);
	}
	@Override
	//鼠标划出时，撤销高亮，恢复为黑色
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)arg0.getSource();
		jl.setForeground(Color.black);
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
