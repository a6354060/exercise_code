package org.ace;
import java.nio.IntBuffer;
public class BufferText{
	public static void main(String args[]){
	     IntBuffer bb=IntBuffer.allocate(20); // 创建指定容量的缓冲区 
	     int[] b={1,3,5,7,9,11,13,15};
          System.out.println("添加数据之前：position, "+bb.position()+" ,limit"+bb.limit()+" ,capacity"+bb.capacity());
			 bb.put(2);
			 bb.put(b);
         System.out.println("添加数据之后：position, "+bb.position()+" ,limit"+bb.limit()+" ,capacity"+bb.capacity());
	        bb.flip(); // 内容反转 使得position等于零 limit等于position
		   System.out.println("添加数据反转之后：position, "+bb.position()+" ,limit"+bb.limit()+" ,capacity"+bb.capacity());
	     // 输出缓冲区的内容
		 while(bb.hasRemaining()){
		   System.out.print(bb.get()+","); 
		 }
		   System.out.println();
          /*
		   *修改缓冲区的内容 就要slice（部分的意思） 就是建立子缓冲去 因为数据是共享的子缓冲的修改的内容就是修改了主缓冲内容
		   * 主要是要修改position 和 limit 的值 建立子缓冲区
		   */ 
          bb.position(2);// 修改position
		  bb.limit(6);//   修改limit
		  int limit=bb.limit(); // 保存修改后的limit
          IntBuffer sub=bb.slice();
      for(int i=0;i<sub.capacity();i++){
	        int x=sub.get(i);
			sub.put(x+1);
	  }
          bb.flip();
		  bb.limit(limit);// 修改limit使得全部输出
		 System.out.println("修改后");
		 while(bb.hasRemaining()){
		   System.out.print(bb.get()+",");
		 }	   
	}
}