package org.ace;
import java.io.*;
import java.util.zip.*;

public class JieZip {
   
    public static void jie(File file)throws Exception{
	    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(file));
		ZipEntry ze =null; 
		File outFile =null;
		int temp=0;
		ZipFile zip = new ZipFile(file); 
		while((ze=zipIn.getNextEntry())!=null){
			char c = ze.getName().charAt((ze.getName().length()-1));
		       if(c=='/'){
			     jieDir(ze.getName());
			   }else{
			      jieFile(ze,zip,ze.getName());
			   }

		   }
		}
		
	
public static void jieDir(String fileName)throws Exception{     
	       File f = new File("d:"+File.separator+fileName); 
	       f.mkdir();
	}

 public static void jieFile(ZipEntry ze,ZipFile zip,String fileName)throws Exception{
	  File outFile = new File("d:"+File.separator +fileName);		
         InputStream in = zip.getInputStream(ze);
         OutputStream out = new FileOutputStream(outFile);
		 int temp=0;
		   while((temp=in.read())!=-1){             		         
                    out.write(temp);                
      		   }
			   
           in.close();
		   out.close();
	}

  public static void main(String args[])throws Exception{
     File f=new File("C:/Users/hp/Documents/Tencent Files/1159575665/FileRecv/Êý¾Ý¿â¿Î¼þ.Zip");
	 jie(f);
    
  }
    
} 