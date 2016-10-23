package org.ace;
public class Queen{
   static int[] a; // a[i] 第i个皇后摆在第a[i]的位置
   public static void queen(int n){
          a=new int[n];
		  int k=0;
     while(k>=0){
            a[k]=a[k]+1;
	     while(a[k]<=n&&(place(k))){
		     a[k]++;   // 冲突 放到下一列   
		 }
       if(a[k]<=n && (k==n-1)){  // 摆放完了 输出 所有可能解
		   for(int i=0;i<n;i++){
	        System.out.print(a[i]+",");
			}
			
       System.out.println();
	    }  
	   if(a[k]<=n && k<n-1){
	            k=k+1;     // 摆放下一个皇后
	   }else{
	      a[k--]=0;   // 回溯到上一个皇后
	    }
	 }
	 //System.out.println("无解");
   }

   // 约束条件
   public static boolean place(int k){
      for(int i=0;i<k;i++){ 
	     if((a[i]==a[k])||(Math.abs(i-k)==Math.abs(a[i]-a[k]))){
	              return true;
	    }
	 }
	 return false;
   }

// 主方法 
 public static void main(String args[]){
      Queen q = new Queen();
	  q.queen(4);
 }

}