package org.ace;
import java.util.*;
import java.io.*;

public class PropertyDemo{
	public static void main(String args[]){
	     Properties pro = new Properties(); // ���� Porperties�� 
		  //pro.setProperty("lxb","lixiaobo"); // ���ü�ֵ
    	  //pro.setProperty("mxh","maxiaohong"); // ���ü�ֵ
		  //pro.setProperty("jyj","jiangyunjiang"); // ���ü�ֵ
		  //System.out.println("lxb��ֵ�ǣ�"+pro.getProperty("lxb"));  // �����ֵ 
          //File file = new File("d:"+File.separator+"li.xml");  // �����ļ��� 
            
          try{
          //pro.storeToXML(new FileOutputStream(file),"encoding");
          //pro.store(new FileOutputStream(file),"�ļ�");
		  pro.loadFromXML(new FileInputStream("d:"+File.separator+"li.XML"));
	   }catch(Exception e){
	      e.printStackTrace();
	   }
	   System.out.println("lxb��ֵ�ǣ�"+pro.getProperty("lxb"));  // �����ֵ 
} 
}