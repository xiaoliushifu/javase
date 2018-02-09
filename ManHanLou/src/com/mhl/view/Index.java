/**
 * 实现项目启动的页面效果
 */
package com.mhl.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index extends JWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index idx=new Index();
	}
	
	public Index() { 
		int width=400;
		int height=250;
		this.setSize(width,height);
		int Screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int Screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
		//置为屏幕正中
		this.setLocation(Screenwidth/2-width/2, Screenheight/2-height/2);
		this.setVisible(true);
	}

}

class Pane extends JPanel implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}