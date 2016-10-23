  package org.ace;
  import java.util.Arrays;
  class Demo{
     
   public static void main(String args[]){	
      String str ="           12.           345.67.89";
	  String s="12.345.67,89";
	 System.out.println(str==s);
	  char a = str.charAt(2);	//查找字符串指定位置的字符
      System.out.println(str);
      System.out.println(str.trim());//返回忽略前导空白和尾部空白的字符串
	   String[] a1 = s.split("\\.");
	  System.out.println(Arrays.toString(a1));
	  System.out.println(s.replace("345","1"));


        
		 
  }
 }