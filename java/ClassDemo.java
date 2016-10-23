package org.ace;

import java.lang.reflect.*;
   class Person {
     private int age;  // ������������
	 private String name;	// ������������

    public Person(){}  // �����޲εĹ��췽��

	public Person(String name, int age){
	   this.age=age;
	   this.name=name;
	}
   public void setAge(int age){
        this.age=age;
      }
   public void setName(String name){
		this.name=name;
      }
   public int getAge(){
      return this.age;
      }
    public String getName(){
	     return this.name;
	  } 
    public String toString(int i){
		
		
    return "���䣺"+this.age+", ������"+this.name;
    
 }
  
   };
  
  public class ClassDemo {
  
   public void printParam(Class<?> c){ // ��ӡ�ֶ�����
       Field[] filed = c.getDeclaredFields(); // �õ������ֶ�
	   for(Field f:filed){
	       System.out.print("���η���"+Modifier.toString(f.getModifiers())+", �ֶ�����"+f.getName()+" , �ֶ����ͣ�"+
			  f.getGenericType()+" ");
	   }
	   System.out.println("---------------");
     
         Method[] method = c.getMethods();  // �õ����з�������
         for(Method m:method){
			 Class<?> r = m.getReturnType(); 
			 Class<?> p[]=m.getParameterTypes(); 
		    System.out.print(Modifier.toString(m.getModifiers())+"  ");
            System.out.print(r.getName()+"  ");
			System.out.print(m.getName()+" (");
			for(int i=0;i<p.length;i++){                    
			System.out.print(p[i].getName());
			if(i<p.length-1){
			  System.out.print(",");
			}
			}
			Class<?> ex[]=m.getExceptionTypes();
			if(ex.length==0){
			System.out.println(")");
			}else{
			  for(int i=0;i<ex.length;i++){
			    System.out.print(") throws"+ex[i].getName());
			  }
			}
			System.out.println();
		 }
   };
   public void invokeDemo(Class c){
	   Integer i=7;
        try{
		Method met = c.getMethod("toString",int.class);  // �������������� ���� Ҫһ��
        met.invoke(c.newInstance(),i);  
		}catch(Exception e){
		  e.printStackTrace();
		}
   };

     /**
        Obj �Ǹò����Ķ���
		att ��Ҫ�����������������
		values Ҫ���õ�����ֵ
		type  ���Ե�������

	 */
   public static void setter(Object obj, String att,Object value,Class<?> type)throws Exception{
         Method m = obj.getClass().getMethod("set"+initAtt(att),type);  
               m.invoke(obj,value);             
   }

   public static void getter(Object obj,String att)throws Exception{
   
       Method m = obj.getClass().getMethod("get"+initAtt(att));  
              System.out.println(m.invoke(obj));             
   
   }
   
   public static String initAtt(String str)throws Exception{
     String s=str.substring(0,1).toUpperCase()+str.substring(1);
       return s;
   }

   public static void main(String args[]){
        Class<?> c =null;  // ����Class����
	ClassDemo cla = new ClassDemo();
	     try{
		 c = Class.forName("org.ace.Person");
     Person o = (Person)c.newInstance();
		 cla.setter(o,"age",20,int.class);
		  cla.setter(o,"name","lixiaobo",String.class);
		  cla.getter(o,"age");
		  cla.getter(o,"name");
		 //cla.printParam(Person.class);
         // cla.invokeDemo(c);
		 }catch(Exception e){
		    e.printStackTrace();
		 
		 }
   }  
  
   }
  