package org.ace;
public class Queen{
   static int[] a; // a[i] ��i���ʺ���ڵ�a[i]��λ��
   public static void queen(int n){
          a=new int[n];
		  int k=0;
     while(k>=0){
            a[k]=a[k]+1;
	     while(a[k]<=n&&(place(k))){
		     a[k]++;   // ��ͻ �ŵ���һ��   
		 }
       if(a[k]<=n && (k==n-1)){  // �ڷ����� ��� ���п��ܽ�
		   for(int i=0;i<n;i++){
	        System.out.print(a[i]+",");
			}
			
       System.out.println();
	    }  
	   if(a[k]<=n && k<n-1){
	            k=k+1;     // �ڷ���һ���ʺ�
	   }else{
	      a[k--]=0;   // ���ݵ���һ���ʺ�
	    }
	 }
	 //System.out.println("�޽�");
   }

   // Լ������
   public static boolean place(int k){
      for(int i=0;i<k;i++){ 
	     if((a[i]==a[k])||(Math.abs(i-k)==Math.abs(a[i]-a[k]))){
	              return true;
	    }
	 }
	 return false;
   }

// ������ 
 public static void main(String args[]){
      Queen q = new Queen();
	  q.queen(4);
 }

}