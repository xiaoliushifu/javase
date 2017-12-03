/**
 * 开发一个小的记事本，需要用到窗体对象
 * 重要的是复习JAVA IO对象
 * 
 * 菜单条可以包含多个菜单，每个菜单可以包含多个菜单项
 * 菜单条就是JMenuBar
 * 菜单就是JMenu
 * 菜单项就是JMenuItem
 * 
 * 有菜单项的操作，就得有事件监听
 * 
 * 监听处理简单就是两个：
 * 一个是打开文件，根据对话框返回的文件路径，使用IO对象读取文件的内容，显示到文本域。
 * 一个是保存文件，根据对话框返回的文件路径，使用IO对象，创建文件并把文本域的内容保存到这个文件里
 */
package com.test2;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.JTextArea;


public class NotePad extends JFrame implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad np=new NotePad();
	}
	//文本域对象
	JTextArea jta=null;
	//菜单栏
	JMenuBar jmb=null;
	
	//一个菜单
	JMenu jm1=null;
	
	//两个一个菜单项
	JMenuItem jmi=null;
	JMenuItem jmi2=null;
	
	
	FileReader fr=null;
	BufferedReader br=null;
	
	FileWriter fw=null;
	BufferedWriter bw=null;
	
	//构造函数
	public NotePad(){
		
		//一个菜单框（横着的那种）
		jmb = new JMenuBar();
		//一个菜单栏
		jm1=new JMenu("文件");
		//助记符，就是快捷键（Alt+F)
		jm1.setMnemonic('F');
		
		//一个菜单项的处理
		jmi=new JMenuItem("打开",new ImageIcon("unread.png"));
		//为该菜单项注册监听
		jmi.addActionListener(this);
		
		//又一个菜单项的处理
		jmi2=new JMenuItem("保存");
		//注册监听
		jmi2.addActionListener(this);
		
		//菜单项添加到菜单栏
		jm1.add(jmi);
		jm1.add(jmi2);
		
		//菜单栏添加到这个菜单框中
		jmb.add(jm1);
		
		//菜单框添加到窗体,不是add哦
		this.setJMenuBar(jmb);
		
		
		//文本域对象
		jta=new JTextArea();
		this.add(jta);
		
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	/**
	 * 窗体对象，作为事件处理者，必须实现的方法
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getActionCommand());
		//哪个菜单项选中了，“打开菜单项”
		if(arg0.getActionCommand().equals("打开")) {
			System.out.println("open了");
			
			//文件选择对象JFileChooser
			JFileChooser jfc1=new JFileChooser();
			jfc1.setDialogTitle("请选择文件......");
			//不设置，则默认样式，打开某文件的对话框
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			
			//把用户选择的文件对象的内容，显示到jta文本域
			//得到用户选择的文件全路径
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				String s="";
				String allCon="";
				while((s=br.readLine()) != null) {
					allCon +=s+"\r\n";
				}
				//放到文本域中
				jta.setText(allCon);
			} catch (Exception e) {
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
		//保存处理
		if(arg0.getActionCommand().equals("保存")) {
			//出现保存对话框
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("另存为......");
			//按照默认方式显示,保存某文件的对话框
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			
			//得到用户在对话框里输入的路径
			String file=jfc.getSelectedFile().getAbsolutePath();
			try {
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				//自己优化，因为没有判断文件大小，是否二进制流等
				bw.write(jta.getText());
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
	}

}
