    package org.ace;
  public class GraphColor{
        static int color[];
	   static int [][]arc; // ��ʾͼ���ڽӾ���
	  static int n;      // N��ʾ����ĸ��� 
	   public GraphColor(int n){
          this.n=n;
		  this.arc = new int[][]{{0,1,1,0,0},{1,0,1,1,1},{1,1,0,0,1},
				 {0,1,0,0,1},{0,1,1,1,0}};  
	   }
	  public static void graphCorlor(int m){ //��ʾ��M����ɫ
           color=new int[n];  //��ʾ��N������
               int k=0;    // ����k����������ɫ
            for(int i=0;i<n;i++){
				color[i]=0;   // ��ʼ����ɫ
			}
    
         while(k>=0){
		      
           color[k]=color[k]+1;  // ȡ��һ����ɫ
		   while(color[k]<=m){
		       if(ok(k)){
			     break;    
			   }else{
			    color[k]=color[k]+1; // ������һ����ɫ
			   }
		   }
		  if(k==n-1&&color[k]<=m){ // �����ɫ�������
		     
		      for(int i=0;i<n;i++){
			    System.out.print(color[i]+",");
			  }
    System.out.println();
		  } 
           
         if(color[k]<=m && k<n-1){
		     k=k+1;  // ȡ�¸�����
		 }else{
			 color[k--]=0;
		   }	 		   	 

		}


     }

      // Լ����������
 public static boolean ok(int k){
      for(int i=0;i<k;i++){
	 if(arc[k][i]==1&&color[k]==color[i])
	       return false;  // ��ͻ
	  }
	  return true;    // ����ͻ
 }

  // ������ 

    public static void main(String args[]){
	         GraphColor gc = new GraphColor(5);  
			  graphCorlor(3); // ��ʾ��������ɫ

	     }


	}