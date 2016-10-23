package org.ace;

import java.util.Map;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
   enum Color {
     READ("红") , GREEN("绿") , BULE("蓝");
        private String name;  
		private Color(String name){ // 必须上面构造方法参数对应 
		  this.setName(name);
		}  
       public void setName(String name){
	     this.name=name;
	   }
   };

 public class EnumDemo {
 
     public static void main(String args[]){
          Map<Color,String> map=null; // 定义MAP类
		  map = new EnumMap<Color,String>(Color.class); //实例化map对象
          map.put(Color.READ,"红色");
		  map.put(Color.GREEN,"绿色");
		  map.put(Color.BULE,"蓝色");
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
