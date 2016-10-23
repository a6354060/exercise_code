package org.ace;
 // 动态规划算法  求最长公共子序列  
public class SequenceDemo{
   static int[][] si;
   static int[][] l;
   static char[] ch;
   static char[] ch1;
	static int n;
	static int m;
	 static char[] z;
 	public SequenceDemo(String str,String str1){
	     this.ch=str.toCharArray();
	     this.ch1=str1.toCharArray();
          this.n=str.length();
		  this.m=str1.length();
		  this.si=new int[n+1][m+1];
		  this.l=new int[n+1][m+1];
	}
   public int sequence(char[] a,int n,char[] b,int m,int [][] l,int [][] s){
	    for(int i=0;i<=n;i++)
		    l[i][0]=0;
			for(int j=0;j<=m;j++)
			 l[0][j]=0;
			          
    for(int i=1;i<=n;i++){
	   for(int j=1;j<=m;j++){
	         if(a[i-1]==b[j-1]){
			     l[i][j]=l[i-1][j-1]+1; s[i][j]=1;
			 } else if(l[i][j-1]>=l[i-1][j]){
			       l[i][j]=l[i][j-1]; s[i][j]=2;
			 } else{
			     l[i][j]=l[i-1][j]; s[i][j]=3;
		   }
	      
	     }	
	  }	
     int k=l[n][m];
	   z=new char[k]; int i=n;int j=m;
     while(i>0&&j>0){
	    if(s[i][j]==1){
          z[k-1]=a[i-1];i--;j--;k--;		   
		  }
         else if(s[i][j]==2)
			 i--;
		  else
           j--;
	 }
  
	  return l[n][m];
    }
  
  public static void main(String args[]){
       SequenceDemo sd =new SequenceDemo("jfkd1","dfgdfk1");
      System.out.println(sd.sequence(ch,n,ch1,m,l,si));
            for(int i=0;i<=n;i++){
		                       
			for(int j=0;j<=m;j++)
				{
			          System.out.print(l[i][j]+",");
			
			  }
			  System.out.println();
			
			} 

       for(int i=0;i<z.length;i++){
	       System.out.println(z[i]);
	   }
  }


}