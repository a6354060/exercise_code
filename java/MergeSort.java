package org.ace;
import java.util.Arrays;
 //  ���η� �鲢����
public class MergeSort{
   
  // �ϲ�����
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

  public static void sort(int[] a,int q,int t){ // ��a[q]-a[t]���й鲢����
			 int m=0; 
			 int [] a1 =new int[a.length];      
			 if(q==t){return;}
			 else{
			   m=(q+t)/2;   // ����
			  
				
			   sort(a,q,m);  // �鲢ǰ���������
			
			   sort(a,m+1,t);   // �鲢����������
   
			    merge(a,a1,q,m,t);  // �ϲ�����������
				System.out.println(Arrays.toString(a1));
			   for(int i=q;i<=t;i++){
			         a[i]=a1[i];       // ������������
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