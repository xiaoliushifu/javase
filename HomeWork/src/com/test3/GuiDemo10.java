package com.test3;

/**
 * 修改为小型的学生管理系统
 * 
 * 实现增删改查功能
 * 
 * 查询，就是一个按钮，绑定点击事件，触发时获得文本域的字符，去数据库查询，返回数据，重新生成JTable
 * 
 * 
 * 
 * 连接数据库
 * 加载驱动
 * 建立连接
 * 根据sql创建预处理对象ps
 * 执行sql
 * 	循环
 * 	验证sql准确否
 */
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class GuiDemo10 extends JFrame implements ActionListener{

	JPanel jp1,jp2;
	//label标签
	JLabel jl1;
	//文本域
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4;
	JTable jt=null;
	JScrollPane jsp=null;
	StuModel sm;//防止内存泄漏，把sm定义为成员变量
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/spdb1?useSSL=false&characterEncoding=utf8";
	//数据库用户名
	static final String USER="root";
	static final String PASS="";
	Connection conn = null;
	Statement stat = null;
	PreparedStatement ps = null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo10 t1=new GuiDemo10();
	}
	
	//构造函数
	public GuiDemo10(){
		
		jp1 = new JPanel();
		//应xiaolong的需求，修改布局为左对齐
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jl1=new JLabel("请输入名字");
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		//交由当前对象监听
		jb1.addActionListener(this);
		
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		//第二个面板
		jp2 =new JPanel();
		jb2= new JButton("添加");
		jb2.addActionListener(this);
		jb3= new JButton("修改");
		jb3.addActionListener(this);
		jb4= new JButton("删除");
		jb4.addActionListener(this);
		//往面板里添加按钮
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		//中间部分，就是JTable
		sm = new StuModel();
		jt = new JTable(sm);
		//初始化JScrollPane，需要JTable对象作为构造函数的参数,可以有滚动条面板，需要另个组件或面板来融入。
		jsp = new JScrollPane(jt);
		
		//把jsp放到JFrame中
		this.add(jsp);
		//本身就是自上向下的布局，加个North，往最上面走
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//查询按钮
		if(arg0.getSource() == jb1) {
			//事件发生是，直接在jtf对象上获得文本即可
			String name=this.jtf.getText().trim();
			String sql = "select * from stus where StuName='"+name+"'";
			sm = new StuModel(sql);
			//JTable是有数据模型的，所以这次使用set方法更新为新的数据模型即可
			jt.setModel(sm);
			
		}
		//添加按钮
		if(arg0.getSource() == jb2) {
			StuAddDialog sa = new StuAddDialog(this,"添加一个学生",true);
			//当实例化一个对话框时，程序到这就暂停了，进程转移到对话框中。“来了吗”不会打印，直到关闭对话框
			System.out.println("来了吗");
			sm = new StuModel();
			jt.setModel(sm);
		}
		//删除按钮
		if(arg0.getSource()==jb4){
			int rownum = this.jt.getSelectedRow();
			if(rownum==-1){
				//提示信息对话框
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			//模型指定行的0列
			String StuId=sm.getValueAt(rownum,0).toString();
			String sql = "delete from stus where StuId=?";
			String param[]={StuId};
			StuModel temp = new StuModel();
			temp.UpdStu(sql, param);
			sm = new StuModel();
			jt.setModel(sm);
		}
		//更新按钮
		if(arg0.getSource()==jb3){
			int rownum = this.jt.getSelectedRow();
			if(rownum==-1){
				//提示信息对话框
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			StuUpdateDialog sud=new StuUpdateDialog(this,"修改记录",true,sm,rownum);
			sm = new StuModel();
			jt.setModel(sm);
		}
		
	}

}
