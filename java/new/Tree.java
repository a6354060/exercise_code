package org.ace;
import java.util.*;

public class Tree{

  class Nodes{
    Comparable a; // 定义节点值
	private  Nodes  rchild , lchild;  //节点的左右子树
   
    public Nodes(Comparable a){ // 通过构造方法为节点赋值
	     this.a=a;
	}
	// 添加节点
      public void add(Nodes node){
		            if(node.a.compareTo(this.a)<0){
					       if(this.lchild==null)
							   this.lchild=node;
						   else{
						        this.lchild.add(node);
						   }				
					}
			  if(node.a.compareTo(this.a)>=0){	// 放在右子树
				if(this.rchild==null){
					this.rchild = node ;	// 没有右子树则将此节点设置成右子树
				}else{
					this.rchild.add(node) ;	// 继续向下判断
				}
			}
	  }
  // 打印节点
	  public void printNode(){
	         //System.out.println(this.a+","); // 二叉树前序遍历  中左右
			  if(this.lchild!=null){
			         this.lchild.printNode();
			  }  
	          System.out.println(this.a+","); // 二叉树中序遍历  左中右 
			if(this.rchild!=null){
				this.rchild.printNode();
	        }
	    // System.out.println(this.a+","); // 二叉树后序遍历 左右中
	  }

  }
    private  Nodes head ;
   public void addNode(Comparable c){
	    Nodes node = new Nodes(c);
		 if(this.head==null){
		       this.head=node;
		 }else{
		      this.head.add(node);		    
		 }
   }

 // 打印节点
 public void print(){
         if(head==null){
                 System.out.println("没节点");
			  }else{  
        this.head.printNode();
		}
 };

public static void main(String args[]){
     Tree t = new Tree();
      t.addNode(12);
      t.addNode(15);
      t.addNode(9);
      t.addNode(7); t.addNode(14);
	 t.print();
}


}
