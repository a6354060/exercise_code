 
 import java.util.*;
 enum Color{
   BULE("��ɫ"){
     void a(){
	     System.out.println();
	     }
   },RED("��ɫ"){
	   void  a(){
	     System.out.println();
	      }
	  },YELLOW("��ɫ"){
		void  a(){
	     System.out.println();
	       }
	  }; 
   Color(String a){
    System.out.println("��ɫ"+a);
   }
    
  public void print(){
	    
	}
    abstract void a();
 }
 public class a{
	 public static void main(String args[]){
	    Color a=Color.BULE;
		Color b=Color.RED;
	    System.out.println(a.ordinal());
	    System.out.println(a.name());
	    System.out.println("_____________________");
	    int index=2;
		Color[] arr=Color.values();
	    System.out.println(arr[index].name()+"�±�"+arr[index].ordinal());
		System.out.println("123"+"456");
	     
        String name="RED" ;
		Color red=Color.valueOf(name);
		System.out.println(red.name());
		System.out.println(red.ordinal());
         
		 Car car=new Car();
      
          for(String str:car){
		    System.out.println(str);
		  } 

		 Iterator<String> i=car.iterator();
        while(i.hasNext()){
			System.out.println(i.next());
		}

	 }
  
 }

  class Car implements Iterable<String> {
     String arr[]={"1","2","3","4","5"} ; 
           
      class MyIterator  implements Iterator<String> {
              int index=0;
			 public boolean hasNext(){
				     if(arr.length<=index){
					    return false;
					 }else{
					   return true;
					 }
				  }
             public String next(){
				   String str=null;
			      if(arr.length>index){  
				    str=arr[index];						 
				  }
				   index++;	
  	              return str;    
			 }
	  }  
	  
            public Iterator<String> iterator(){
			
			    return new MyIterator();
			}

  }