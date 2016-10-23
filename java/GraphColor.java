    package org.ace;
  public class GraphColor{
        static int color[];
	   static int [][]arc; // 表示图的邻接矩阵
	  static int n;      // N表示顶点的个数 
	   public GraphColor(int n){
          this.n=n;
		  this.arc = new int[][]{{0,1,1,0,0},{1,0,1,1,1},{1,1,0,0,1},
				 {0,1,0,0,1},{0,1,1,1,0}};  
	   }
	  public static void graphCorlor(int m){ //表示有M种颜色
           color=new int[n];  //表示有N个顶点
               int k=0;    // 给第k个顶点上颜色
            for(int i=0;i<n;i++){
				color[i]=0;   // 初始化颜色
			}
    
         while(k>=0){
		      
           color[k]=color[k]+1;  // 取下一种颜色
		   while(color[k]<=m){
		       if(ok(k)){
			     break;    
			   }else{
			    color[k]=color[k]+1; // 搜素下一个颜色
			   }
		   }
		  if(k==n-1&&color[k]<=m){ // 如果着色完了输出
		     
		      for(int i=0;i<n;i++){
			    System.out.print(color[i]+",");
			  }
    System.out.println();
		  } 
           
         if(color[k]<=m && k<n-1){
		     k=k+1;  // 取下个顶点
		 }else{
			 color[k--]=0;
		   }	 		   	 

		}


     }

      // 约束条件方法
 public static boolean ok(int k){
      for(int i=0;i<k;i++){
	 if(arc[k][i]==1&&color[k]==color[i])
	       return false;  // 冲突
	  }
	  return true;    // 不冲突
 }

  // 主方法 

    public static void main(String args[]){
	         GraphColor gc = new GraphColor(5);  
			  graphCorlor(3); // 表示有三种颜色

	     }


	}