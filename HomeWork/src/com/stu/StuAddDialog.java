package com.stu;

/**
 * 该对话框其实扮演者表单的角色，用来填写学生信息并保存之
 */
import javax.swing.JDialog;
import javax.swing.JLabel;//编写用户表单，等页面元素的类库
import javax.swing.JOptionPane;
import javax.swing.JButton;//编写用户表单，等页面元素的类库
import javax.swing.JTextField;//编写用户表单，等页面元素的类库
import javax.swing.JPanel;//编写用户表单，等页面元素的类库

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class StuAddDialog extends JDialog implements ActionListener {
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	
	//构造方法初始化,父窗口，窗口名，模态框
	public StuAddDialog(Frame owner,String title,boolean modal){
		//父方法实现
		super(owner,title,modal);
		jl1 = new JLabel("学号");
		jl2 = new JLabel("名字");
		jl3 = new JLabel("性别");
		jl4 = new JLabel("年龄");
		jl5 = new JLabel("籍贯");
		jl6 = new JLabel("系别");

		//加入到面板里
		jp1 = new JPanel();
		//面板1设置布局,六行一列
		jp1.setLayout(new GridLayout(6,1));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);

		//第二个
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		
		//面板设置布局
		jp2 = new JPanel();
		//网格布局六行一列
		jp2.setLayout(new GridLayout(6,1));
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		//第三个面板里的元素
		jb1 = new JButton("添加");
		jb1.addActionListener(this);//监听是可以重复的
		//jb1.addActionListener(this);//监听是可以重复叠加的,并不会覆盖之前的。
		jb2 = new JButton("取消");
		jb2.addActionListener(this);
		
		jp3 = new JPanel();
		jp3.add(jb1);
		jp3.add(jb2);
		
		//三个面板添加到窗体里，三个面板整体的布局，是边界布局，
		//但是jp1内部是网格布局，jp2内部也是网格布局，jp3是默认的布局。
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		this.setSize(300, 200);
		this.setLocation(300, 200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			String sql="insert into stus values(?,?,?,?,?,?)";
			String param[]={jtf1.getText(),jtf2.getText(),jtf3.getText(),
					jtf4.getText(),jtf5.getText(),jtf6.getText(),};
			StuModel temp=new StuModel();
			if(!temp.UpdStu(sql, param)){
				JOptionPane.showMessageDialog(this, "添加失败");
			}
			this.dispose();
		}
		if(e.getSource()==jb2){
			//关闭对话框
			this.dispose();
		}
	}
}
