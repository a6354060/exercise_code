package org.ace;
import java.util.zip.*;
import java.io.*;

public class Zip{

	public static void main(String args[])throws Exception{
		  Zip zi =new Zip();
		File file =new File("c:"+File.separator+"users/hp/desktop/���ݿ�μ�");	// �ҵ�Ҫѹ�����ļ�
          zi.zip(file);
	};


  public void zip(File file)throws Exception{
        ZipOutputStream zipOut =new ZipOutputStream(new FileOutputStream("d:"+File.separator+"���ݿ�μ�.zip")) ;	// ����ѹ��������

        if(file.isDirectory()) // �ж��Ƿ����ļ���
	    {
			// ѹ��Ŀ¼
		    zipDir(file,zipOut,file.getName()+"/"); // �ؼ�   
		}else{
              // ѹ���ļ�
		  zipFile(file,zipOut,new File(file.getParent()).getName() + "/" +file.getName());
		}  
     zipOut.closeEntry();
     zipOut.close();
  }

   
   public void zipDir(File file, ZipOutputStream zos,String target)throws Exception{   //ѹ���ļ�  	
		   zos.putNextEntry((new ZipEntry(target))) ;// ����ZipEntry���� 
		   File lists[] = file.listFiles() ;// �г�ȫ���ļ�
		      
			for(File f:lists){
		   if(f.isDirectory())
			   {// �ж��Ƿ����ļ���
                zipDir(f,zos,target+f.getName()+"/"); // ѹ��Ŀ¼              
				}
				else{ 
					// ѹ���ļ�
				zipFile(f,zos,target+f.getName());				
				}
			}
			   
   };

   public void zipFile(File file, ZipOutputStream zos,String target)throws Exception{
       BufferedReader in =null;	//����������
	   ZipEntry ze = new ZipEntry(target);  
		  in =  new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		zos.putNextEntry(ze); // ����ZipEntry����
         String temp=null;
		 while((temp=in.readLine())!=null)
         {
			 zos.write(temp.getBytes("utf-8"));
         }
      in.close();
   };

   

    
}