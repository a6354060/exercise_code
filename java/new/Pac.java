package org.ace;
 public class Pac{ 
   
     void force(int[][] a){
   
  int n=16;
  int m,t;
  for(int i=0;i<16;i++){
	  t=i;
  for(int j=3;j>=0;j--){
	   m=t%2;
	   a[i][j]=m;
	   t=t/2;
  
  
  }

  }
for(int i=0;i<16;i++){
	for(int j=0;j<4;j++){
  System.out.println(a[i][j]);
	
	}


  } 

}
 

  public static void main(String args[]){
	  int[][] a=new int[16][4];
         new Pac().force(a);
  }
 }
