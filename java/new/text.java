 package org.ace;
 import java.util.*;
 public class text{
    public static void main(String args[]){
	   Map<Person,String> map = new HashMap<Person,String>();
	     
          map.put(new Person("1","2"),"snows"); 
		   String str = map.get(new Person("1","2"));
	   System.out.println(str); //��ӡstr
	} 
};

/**
����Person��

*/
class Person{

	private String name;

	private  String age;
	
	public Person(String name,String age){
			this.name=name;
			this.age=age;
	
	}
   public String toString(){
     return  "������"+this.name+"  ���䣺"+this.age;
     
   }

   public boolean equals(Object obj){
        if(this==obj){
		    return true;
		}
      if(!(obj instanceof Person)){
	          return false;
	  } 
    Person p =(Person)obj;
          if(this.name.equals(p.name)&&this.age.equals(p.age)){
		        return true;
		  }else{
				return false;
		  
		  }
   }

  /**
   ��дhashCode
  
  */
  public int hashCode(){
  
    return this.name.hashCode()*this.age.hashCode();
  }



}