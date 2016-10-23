package org.ace;
import java.util.zip.*;
import java.io.*;

public class Zip{

	public static void main(String args[])throws Exception{
		  Zip zi =new Zip();
		File file =new File("c:"+File.separator+"users/hp/desktop/数据库课件");	// 找到要压缩的文件
          zi.zip(file);
	};


  public void zip(File file)throws Exception{
        ZipOutputStream zipOut =new ZipOutputStream(new FileOutputStream("d:"+File.separator+"数据库课件.zip")) ;	// 声明压缩流对象

        if(file.isDirectory()) // 判断是否是文件夹
	    {
			// 压缩目录
		    zipDir(file,zipOut,file.getName()+"/"); // 关键   
		}else{
              // 压缩文件
		  zipFile(file,zipOut,new File(file.getParent()).getName() + "/" +file.getName());
		}  
     zipOut.closeEntry();
     zipOut.close();
  }

   
   public void zipDir(File file, ZipOutputStream zos,String target)throws Exception{   //压缩文件  	
		   zos.putNextEntry((new ZipEntry(target))) ;// 设置ZipEntry对象 
		   File lists[] = file.listFiles() ;// 列出全部文件
		      
			for(File f:lists){
		   if(f.isDirectory())
			   {// 判断是否是文件夹
                zipDir(f,zos,target+f.getName()+"/"); // 压缩目录              
				}
				else{ 
					// 压缩文件
				zipFile(f,zos,target+f.getName());				
				}
			}
			   
   };

   public void zipFile(File file, ZipOutputStream zos,String target)throws Exception{
       BufferedReader in =null;	//定义输入流
	   ZipEntry ze = new ZipEntry(target);  
		  in =  new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		zos.putNextEntry(ze); // 设置ZipEntry对象
         String temp=null;
		 while((temp=in.readLine())!=null)
         {
			 zos.write(temp.getBytes("utf-8"));
         }
      in.close();
   };

   

    
}