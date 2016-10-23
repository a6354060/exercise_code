package org.ace;
  class Info<k,v>{
  private k name;
  private v content;
  static int i;
  boolean flag=false;
 
   public Info(){
   }
   public Info(k name,v content){
        this.name=name;
		this.content=content;
   }
   public synchronized void set(k name , v content) {
	      
       
       if(!flag){
		   try{
		  super.wait();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   }
       this.setName(name);
		try{
		  Thread.sleep(200);
		}catch(InterruptedException e){
		  e.printStackTrace();
		}
		this.setContent(content);		    		
         flag=false;
		super.notify();
   }
     public void setName(k name){
	      this.name=name;
	 
	 }

	 public void setContent(v content){
	    this.content=content;
	 }

   public k getName(){
     return name;
   }

public v getContent(){
    return content;
}
public  synchronized void get() {
    if(flag){
		try{
    super.wait();
	}catch(Exception e){
	 e.printStackTrace();
	}
	}
     try{
		  Thread.sleep(200);
		}catch(InterruptedException e){
		  e.printStackTrace();
		}
   System.out.println(this.getName()+ "-->  "+this.getContent()+(i++));
     flag=true;
	 super.notify();
  }

 } 
 
 class Producer implements Runnable{  
	private Info<String,String> info ;
     public Producer(Info<String,String> info){
	    this.info=info;

	 }
    public void run(){
		boolean flag=false;
		for(int i=0;i<50;i++){
			try{
				if(flag) {
                this.info.set("Àî","java");
                     flag=false;
                }else{
				 this.info.set("mldn","php");
				 flag=true;
				}

         
        }catch(Exception e){
		  e.printStackTrace();
		 }
	}
	}
 }
 class Comtor implements Runnable{
  private Info<String,String> info =null;
 public Comtor(Info<String,String> info){
	    this.info=info;
	 }
   public void run(){
	   for(int i=0;i<50;i++){
		this.info.get();
   }
   }
}	

class a{


  public static void main(String args[])throws Exception{
          Info<String,String> info =new Info<String,String>();
		  Producer p =new Producer(info);
		  Comtor c =new Comtor(info);
		   new Thread(p).start();
		   new Thread(c).start();
         

  }
public static void fun(Info info){
      
	   System.out.println("123456789");
}

}


