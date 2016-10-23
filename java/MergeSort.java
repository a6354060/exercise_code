package org.ace;
import java.util.Arrays;
 //  分治法 归并排序
public class MergeSort{
   
  // 合并数组
  public static void merge(int[] ar1,int[] ar2,int s,int m,int t){
      
	   int i=s,k=s,j=m+1;
	   
	   while(i<=m&&j<=t){
	       if(ar1[i]<=ar1[j]){ 
			   ar2[k++]=ar1[i++];
		   }else{
		    ar2[k++]=ar1[j++];
		   }
	   }
	   while(i<=m) {ar2[k++]=ar1[i++];}
       while(j<=t) {ar2[k++]=ar1[j++];}
      
  }

  public static void sort(int[] a,int q,int t){ // 对a[q]-a[t]进行归并排序
			 int m=0; 
			 int [] a1 =new int[a.length];      
			 if(q==t){return;}
			 else{
			   m=(q+t)/2;   // 划分
			  
				
			   sort(a,q,m);  // 归并前半个子序列
			
			   sort(a,m+1,t);   // 归并后半个子序列
   
			    merge(a,a1,q,m,t);  // 合并俩个子序列
				System.out.println(Arrays.toString(a1));
			   for(int i=q;i<=t;i++){
			         a[i]=a1[i];       // 保存有序数组
			   }  
			 }
         
  
  } 
  

   public static void main(String args[]){
     int[] a={1,4,455,94,105};
	 int[] b={3,4,6,4,75,80,86,202,5};
     sort(b,0,b.length-1);
  System.out.println(Arrays.toString(b));

   }

}