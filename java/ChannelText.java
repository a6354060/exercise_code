package org.ace;
import java.nio.ByteBuffer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

public class ChannelText{
	public static void main(String args[]) throws Exception{	  
	  File file1 =new File("d:"+File.separator+"note.txt");
	  String[] arr={"java","ͼ��","������"};  
      FileOutputStream output= null;  // �����ļ������
	  FileChannel fout=null; // ���������ͨ��
	  output= new FileOutputStream(file1); // ʵ���������
      fout=output.getChannel(); // �õ������ͨ��
	  ByteBuffer bb=ByteBuffer.allocate(1024) ;		// �õ��ֽڻ�����
	   for(int i=0;i<arr.length;i++){
	          bb.put(arr[i].getBytes()); //ѭ�����������			  
	   }
	   bb.flip(); // д֮ǰ���뷴תһ��
	   fout.write(bb);	 
	   output.close();
	   fout.close();
	   
	   copyBuffer();
	}

   public static void copyBuffer() throws Exception{
         File file=new File("d:"+File.separator+"a.jpeg"); // �õ�Ҫ�����ļ�
         File file2 = new File("d:"+File.separator+"c.jpeg");
		 FileInputStream in= null ; // ����������
		 FileOutputStream output= null;  // �����ļ������
	     FileChannel fout=null; // ���������ͨ��
		 FileChannel fin=null; // ����������ͨ��
	     output= new FileOutputStream(file2); // ʵ���������
		 in= new FileInputStream(file);
         fout=output.getChannel(); // �õ������ͨ��
		 fin=in.getChannel(); // �õ�������ͨ��	
	     ByteBuffer bb=ByteBuffer.allocate(1024) ;// �õ��ֽڻ�����
		 int foot=0;
		 while((foot=fin.read(bb))!=-1){ // �൱�����������������
		           bb.flip(); 
				   fout.write(bb);// �൱���������
				   bb.clear();
		 }
		 System.out.println("��С"+fin.size());
		 in.close();
		 output.close();
		 fout.close();
		 fin.close();
   
   }

}