package org.ace;
import java.util.*;
import java.io.*;

public class PropertyDemo{
	public static void main(String args[]){
	     Properties pro = new Properties(); // 定义 Porperties类 
		  //pro.setProperty("lxb","lixiaobo"); // 设置键值
    	  //pro.setProperty("mxh","maxiaohong"); // 设置键值
		  //pro.setProperty("jyj","jiangyunjiang"); // 设置键值
		  //System.out.println("lxb的值是："+pro.getProperty("lxb"));  // 输出键值 
          //File file = new File("d:"+File.separator+"li.xml");  // 定义文件类 
            
          try{
          //pro.storeToXML(new FileOutputStream(file),"encoding");
          //pro.store(new FileOutputStream(file),"文件");
		  pro.loadFromXML(new FileInputStream("d:"+File.separator+"li.XML"));
	   }catch(Exception e){
	      e.printStackTrace();
	   }
	   System.out.println("lxb的值是："+pro.getProperty("lxb"));  // 输出键值 
} 
}