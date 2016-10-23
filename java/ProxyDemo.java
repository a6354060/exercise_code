package org.ace;
import java.lang.reflect.*;

  interface Person{
	  public String say(String naem,int age);
  };

  class Subject implements Person{
	
	  public String say(String name ,int age){
	          String str=null;
			  System.out.println(str="姓名："+name +", 年龄："+age);
			  return str;
	  } 
  };
  class Subject1 implements Person{
	
	  public String say(String name ,int age){
	          String str=null;
			  System.out.println(str="姓名："+name +", 年龄："+age+" ----------------");
			  return str;
	  } 
  };
  
   class ProxyClass implements InvocationHandler {
         private Object p ; // 需要代理的对象
			/*
      public ProxyClass(Subject p){
	      this.p=p;
	     }
         public String say(String name ,int age){
		      return this.p.say(name,age);   // 静态代理方式
		 }   */
       public  Object  bind(Object obj){ // 传入yao代理的类
	           this.p=obj;
                     
		    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);   

	     }

         public Object invoke(Object porxy,Method met,Object[] args)throws Exception{
		       Object o=null;
			   System.out.println("dfjlkfjs");
			    o = met.invoke(this.p,args);   	  
				 return o;
		 }
   }

   public class  ProxyDemo  {
	   public static void main(String args[])throws Exception{
	      ProxyClass pc = new ProxyClass();
	      Person su = (Person)pc.bind(new Subject());
	       su.say("li",34);
	   }
   }
