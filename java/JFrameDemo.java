 package org.ace;
 import java.awt.*;
 import javax.swing.*;
 
  /* ���һ�����ڵı�ǩ ��С ���� ��ť �ȵ�

   */
  public class JFrameDemo {

	  public static void main(String args[]){
           JFrame f = new JFrame("�ҵĵ�һ������");   
		   f.setSize(300,200); // ��ƴ��ڴ�С
		   f.setLocation(100,100); // ��ƴ��ڵ�λ��
		   Icon ic = new ImageIcon("d:/1.jpg"); // Ϊ��ǩ��ͼƬ
		   JLabel l = new JLabel("123",ic,JLabel.CENTER); // ��ǩ���
		   Font fo = new Font("123",Font.ITALIC+Font.BOLD,55);
		   l.setFont(fo);
		  
		   f.add(l); // ������
           




			f.setVisible(true); // ���ڿɼ������
			
			
	    
	 }
  }