package org.ace;
  // 快速排序
public class QuickSort{

      public static int partition(int []r ,int first, int end){
	     
             int i =first; int j=end;

          while(i<j){
		     
		    while(i<j && r[i]<=r[j]){
			   j--;
			}
             if(i<j){
			    int temp=r[j];
				r[j]=r[i];
				r[i]=temp;
				i++;
			 }

          while(i<j && r[i]<=r[j]){
		      i++;
		  }              
		     if(i<j){
			 int temp=r[j];
				r[j]=r[i];
				r[i]=temp;
				j--;
			 }

		  }
               return i;
	  
	  } 

   public static void quickSort(int []a,int first,int end){
        
      int p=0;
	if(first<end){
     		p = partition(a,first,end);
		quickSort(a,first,p-1);			 
		quickSort(a,p+1,end);
  	}
  }

  public static void main(String args[]){
	int a[]=new int[]{3,5,45,6,7,9,78,8};
	quickSort(a,0,a.length-1);
	for(int i=0;i<a.length;i++){
    		System.out.print(a[i]+",");
	}
  }
}
