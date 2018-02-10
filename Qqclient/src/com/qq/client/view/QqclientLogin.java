/**
 * 客户端登录界面
 */
package com.qq.client.view;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.User;
public class QqclientLogin extends JFrame implements ActionListener {

	/**
	 * 定义登录界面北部的组件
	 * 定义登录中部的组件
	 * 定义南部的组件
	 * @param args
	 */
	//背面
	JLabel jbl1;
	
	//中部,三个JPanel,选项卡
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	
	
	//南部
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqclientLogin qc = new QqclientLogin();

	}
	
	public QqclientLogin(){
		//北面的
		jbl1 = new JLabel(new ImageIcon("image/tou.gif"));
		
		//中部是选项卡
		jp2 = new JPanel(new GridLayout(3, 3));//网格布局
		jp2_jbl1 = new JLabel("QQ号码",JLabel.CENTER);//标签居中
		jp2_jbl2 = new JLabel("QQ密码",JLabel.CENTER);
		jp2_jbl3 = new JLabel("忘记密码",JLabel.CENTER);
		jp2_jbl3.setForeground(Color.blue);//标签设置前景色
		jp2_jbl4 = new JLabel("申请密码保护");
		jp2_jb1 = new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf = new JTextField();
		jpf = new JPasswordField();
		jp2_jcb1 = new JCheckBox("隐身登陆");
		jp2_jcb2 = new JCheckBox("记住密码");
		//加入到jp2，第一行
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		//第二行
		jp2.add(jp2_jbl2);
		jp2.add(jpf);
		jp2.add(jp2_jbl3);
		//第三行
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		
		jtp = new JTabbedPane();
		jtp.add("QQ号码", jp2);
		jp3 = new JPanel();
		jtp.add("手机号码", jp3);
		jp4 = new JPanel();
		jtp.add("电子邮件", jp4);
		
		//南部的,默认就是流式布局
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("image/denglu.gif"));
		jp1_jb1.addActionListener(this);//登录按钮事件绑定
		jp1_jb2 = new JButton(new ImageIcon("image/quxiao.gif"));
		jp1_jb3 = new JButton(new ImageIcon("image/xiangdao.gif"));
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		
		this.add(jp1,"South");
		this.add(jtp,"Center");
		this.add(jbl1,"North");
		this.setSize(350,240);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jp1_jb1) {
			//教给QqClientUser去验证
			QqClientUser qcu = new QqClientUser();
			User u=new User();
			u.setUserId(jp2_jtf.getText().trim());//用户编号
			//用户密码的获得，不是getText()
			u.setPasswd(new String(jpf.getPassword()).trim());
			if(qcu.checkUser(u)) {
				new QqFriendList();
				//关闭当前的登录页面
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "QQ号或者密码错误");
			}
			System.out.println("登录过程结束");
		}
	}

}
