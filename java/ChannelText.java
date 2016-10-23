package org.ace;
import java.nio.ByteBuffer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

public class ChannelText{
	public static void main(String args[]) throws Exception{	  
	  File file1 =new File("d:"+File.separator+"note.txt");
	  String[] arr={"java","图书","电子书"};  
      FileOutputStream output= null;  // 定义文件输出流
	  FileChannel fout=null; // 定义输出流通道
	  output= new FileOutputStream(file1); // 实例化输出流
      fout=output.getChannel(); // 得到输出流通道
	  ByteBuffer bb=ByteBuffer.allocate(1024) ;		// 得到字节缓冲区
	   for(int i=0;i<arr.length;i++){
	          bb.put(arr[i].getBytes()); //循环往添加内容			  
	   }
	   bb.flip(); // 写之前必须反转一下
	   fout.write(bb);	 
	   output.close();
	   fout.close();
	   
	   copyBuffer();
	}

   public static void copyBuffer() throws Exception{
         File file=new File("d:"+File.separator+"a.jpeg"); // 得到要读的文件
         File file2 = new File("d:"+File.separator+"c.jpeg");
		 FileInputStream in= null ; // 定义输入流
		 FileOutputStream output= null;  // 定义文件输出流
	     FileChannel fout=null; // 定义输出流通道
		 FileChannel fin=null; // 定义输入流通道
	     output= new FileOutputStream(file2); // 实例化输出流
		 in= new FileInputStream(file);
         fout=output.getChannel(); // 得到输出流通道
		 fin=in.getChannel(); // 得到输入流通道	
	     ByteBuffer bb=ByteBuffer.allocate(1024) ;// 得到字节缓冲区
		 int foot=0;
		 while((foot=fin.read(bb))!=-1){ // 相当于往缓冲区添加数据
		           bb.flip(); 
				   fout.write(bb);// 相当于输出操作
				   bb.clear();
		 }
		 System.out.println("大小"+fin.size());
		 in.close();
		 output.close();
		 fout.close();
		 fin.close();
   
   }

}