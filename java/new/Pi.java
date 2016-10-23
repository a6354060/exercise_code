package org.ace;
import java.util.*;
class Pi{
 static double pi;
  static List<Double> listx ,listy;
 public Pi(){

  this.listx=new ArrayList<Double>();
  this.listy=new ArrayList<Double>();

  } 

  public static void getxy(){
                
     for(int i=0;i<100000;i++){
          listx.add(Math.random());
		  listy.add(Math.random());
	 }
  }
 public void print(){
	 for(int i=0;i<listx.size();i++){
    System.out.println("x="+listx.get(i)+"  y=" +listy.get(i));
 
	 }
 }
 public double yuan(){
    double count=0.0;
	for(int i=0;i<100000;i++){
	    double d = listx.get(i);
        double d1= listy.get(i);
		double s = (d*d)+(d1*d1);
          if(Math.sqrt(s) < 1){
              count++;	  
		  } 

	}
	return count;
 }

 public double zheng(){
   
    return listx.size();
 }

 
 

 public static void main(String args[]){
    Pi p=new Pi();
	p.getxy();
	//p.print();
	double a=p.yuan();
	double q=p.zheng();
	pi =(4*a)/q;
	System.out.println(pi);
 }
 

}