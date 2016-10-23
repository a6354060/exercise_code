package org.ace;
public class Knapsack{
// 动态规划算法 求背包问题
  public static int knapsack(int w[],int v[] ,int n,int C){
         int vi[][]=new int[n+1][C+1];
	  for(int i=0;i<=n;i++){
           vi[i][0]=0;}  // 把i个物品装入容量为零的背包
     for(int c=0;c<=C;c++){
       vi[0][c]=0;}		// 把0个物品装入容量为c的背包

	 for(int i=1;i<=n;i++){
	    for(int j=1;j<=C;j++){
			 if(j<w[i-1]){  
			    vi[i][j]=vi[i-1][j] ; 
			 }else{
			    vi[i][j] = Math.max(vi[i-1][j],(vi[i-1][(j-w[i-1])]+v[i-1]));
			 }
		}
	 }
for(int i=0;i<=n;i++){
     for(int c=0;c<=C;c++){
		 if(vi[i][c]<10)
        System.out.print("0"+vi[i][c]+",");
		 else
        System.out.print(vi[i][c]+",");
	   }
	  System.out.println(); 
}
    int[] k=new int[n];
  for(int j=C,i=n;i>0;i--){
     if(vi[i][j]>vi[i-1][j]){
	        k[i-1]=1;
			j=j-w[i-1];
	 }else{
	    k[i-1]=0;
	 }
  
  }
      for(int i=0;i<n;i++){
	     System.out.println(k[i]+",");
	  
	  }  

    return vi[n][C];
  }

   public static void main(String args[]){
     int w[]={2,2,6,5,4,1};
	 int v[]={6,3,5,4,6,8};
	 int c=10;
    System.out.println(knapsack(w,v,w.length,c));
   
   }


}