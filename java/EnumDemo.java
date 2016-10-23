package org.ace;

import java.util.Map;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
   enum Color {
     READ("��") , GREEN("��") , BULE("��");
        private String name;  
		private Color(String name){ // �������湹�췽��������Ӧ 
		  this.setName(name);
		}  
       public void setName(String name){
	     this.name=name;
	   }
   };

 public class EnumDemo {
 
     public static void main(String args[]){
          Map<Color,String> map=null; // ����MAP��
		  map = new EnumMap<Color,String>(Color.class); //ʵ����map����
          map.put(Color.READ,"��ɫ");
		  map.put(Color.GREEN,"��ɫ");
		  map.put(Color.BULE,"��ɫ");
   		  for(Color c :Color.values()){
			  System.out.println(map.get(c)+","); 
		  }
		   Set<Color> set= map.keySet();
           for(Color c: set){
		     System.out.println(c);
		   }
        System.out.println();
   }
 }
