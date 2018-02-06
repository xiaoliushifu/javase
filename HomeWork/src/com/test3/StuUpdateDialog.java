package com.test3;

/**
 * 该对话框其实扮演者表单的角色，用来填写学生信息并保存之
 */
import javax.swing.JDialog;
import javax.swing.JFrame;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
class StuUpdateDialog extends JDialog implements ActionListener {
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	
	//传递StuModel对象与指定id
	public StuUpdateDialog(Frame owner,String title,boolean modal,StuModel sm,int rowNum){
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

		//整数转换成字符串的各种方法
		jtf1=new JTextField(sm.getValueAt(rowNum, 0).toString());
		jtf1.setEnabled(false);//不可修改
		jtf2=new JTextField((String) sm.getValueAt(rowNum, 1));
		jtf3=new JTextField((String) sm.getValueAt(rowNum, 2));
		jtf4=new JTextField(sm.getValueAt(rowNum, 3).toString());
		jtf5=new JTextField((String) sm.getValueAt(rowNum, 4));
		jtf6=new JTextField((String) sm.getValueAt(rowNum, 5));
		
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
		jb1 = new JButton("更新");
		jb1.addActionListener(this);
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
				String sql="update stus set stuName=?,stuSex=?,stuAge=?,"
						+ "stuJg=?,stuDept=? where StuId=?";
				String param[] = {jtf2.getText(),jtf3.getText(),jtf4.getText(),
						jtf5.getText(),jtf6.getText(),jtf1.getText()};
				StuModel temp = new StuModel();
				if(!temp.UpdStu(sql, param)){
					JOptionPane.showMessageDialog(this, "更新失败");
				}
				this.dispose();
		}
		if(e.getSource()==jb2){
			//关闭对话框
			this.dispose();
		}
	}
}
