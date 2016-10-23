package org.ace;
import java.util.*;
import java.text.*;
class Formatt{
 
  public static void main(String args[]){
     ResourceBundle rs = ResourceBundle.getBundle("Abs");
             String str = rs.getString("info");
           //MessageFormat mf = new MessageFormat(str);
	           	
		  System.out.println(MessageFormat.format("我是{0}，{1}人",new Formatt(),"中国"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,hh,mm.ss");
			String s = sdf.format(new Date());
			   System.out.println(s);
  }


}
