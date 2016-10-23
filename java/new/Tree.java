package org.ace;
import java.util.*;

public class Tree{

  class Nodes{
    Comparable a; // ����ڵ�ֵ
	private  Nodes  rchild , lchild;  //�ڵ����������
   
    public Nodes(Comparable a){ // ͨ�����췽��Ϊ�ڵ㸳ֵ
	     this.a=a;
	}
	// ��ӽڵ�
      public void add(Nodes node){
		            if(node.a.compareTo(this.a)<0){
					       if(this.lchild==null)
							   this.lchild=node;
						   else{
						        this.lchild.add(node);
						   }				
					}
			  if(node.a.compareTo(this.a)>=0){	// ����������
				if(this.rchild==null){
					this.rchild = node ;	// û���������򽫴˽ڵ����ó�������
				}else{
					this.rchild.add(node) ;	// ���������ж�
				}
			}
	  }
  // ��ӡ�ڵ�
	  public void printNode(){
	         //System.out.println(this.a+","); // ������ǰ�����  ������
			  if(this.lchild!=null){
			         this.lchild.printNode();
			  }  
	          System.out.println(this.a+","); // �������������  ������ 
			if(this.rchild!=null){
				this.rchild.printNode();
	        }
	    // System.out.println(this.a+","); // ������������� ������
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

 // ��ӡ�ڵ�
 public void print(){
         if(head==null){
                 System.out.println("û�ڵ�");
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
