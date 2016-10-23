 package org.ace;
 import java.awt.*;
 import javax.swing.*;
 
  /* 设计一个窗口的标签 大小 布局 按钮 等等

   */
  public class JFrameDemo {

	  public static void main(String args[]){
           JFrame f = new JFrame("我的第一个窗口");   
		   f.setSize(300,200); // 设计窗口大小
		   f.setLocation(100,100); // 设计窗口的位置
		   Icon ic = new ImageIcon("d:/1.jpg"); // 为标签加图片
		   JLabel l = new JLabel("123",ic,JLabel.CENTER); // 标签组件
		   Font fo = new Font("123",Font.ITALIC+Font.BOLD,55);
		   l.setFont(fo);
		  
		   f.add(l); // 添加组件
           




			f.setVisible(true); // 窗口可见性设计
			
			
	    
	 }
  }