package org.ace;
import java.nio.IntBuffer;
public class BufferText{
	public static void main(String args[]){
	     IntBuffer bb=IntBuffer.allocate(20); // ����ָ�������Ļ����� 
	     int[] b={1,3,5,7,9,11,13,15};
          System.out.println("�������֮ǰ��position, "+bb.position()+" ,limit"+bb.limit()+" ,capacity"+bb.capacity());
			 bb.put(2);
			 bb.put(b);
         System.out.println("�������֮��position, "+bb.position()+" ,limit"+bb.limit()+" ,capacity"+bb.capacity());
	        bb.flip(); // ���ݷ�ת ʹ��position������ limit����position
		   System.out.println("������ݷ�ת֮��position, "+bb.position()+" ,limit"+bb.limit()+" ,capacity"+bb.capacity());
	     // ���������������
		 while(bb.hasRemaining()){
		   System.out.print(bb.get()+","); 
		 }
		   System.out.println();
          /*
		   *�޸Ļ����������� ��Ҫslice�����ֵ���˼�� ���ǽ����ӻ���ȥ ��Ϊ�����ǹ�����ӻ�����޸ĵ����ݾ����޸�������������
		   * ��Ҫ��Ҫ�޸�position �� limit ��ֵ �����ӻ�����
		   */ 
          bb.position(2);// �޸�position
		  bb.limit(6);//   �޸�limit
		  int limit=bb.limit(); // �����޸ĺ��limit
          IntBuffer sub=bb.slice();
      for(int i=0;i<sub.capacity();i++){
	        int x=sub.get(i);
			sub.put(x+1);
	  }
          bb.flip();
		  bb.limit(limit);// �޸�limitʹ��ȫ�����
		 System.out.println("�޸ĺ�");
		 while(bb.hasRemaining()){
		   System.out.print(bb.get()+",");
		 }	   
	}
}