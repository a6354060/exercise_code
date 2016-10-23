package org.ace;
import java.io.*;
import java.util.*;
public class FileDemo{
   
  static List<String> list ; //用来保存文件路径


    public FileDemo(){ // 通过构造方法初始化list
	
		this.list=new ArrayList<String>();

        }

	public static void main(String args[])throws Exception{
		    FileDemo fi =new FileDemo();
		     //File file = new File("c:"+File.separator+"Users\\hp\\Desktop\\源码 - 副本"); //创建文件类 并指定其路径
	          //fi.print(file);
           // for(String s1:list){		
             // fi.Conversions(s1);
			 //Thread.sleep(1000);
			  //System.out.println(s1  ); 
			//}
        
				   
	   }

      public  void print(File file){  //列出所有文件路径并添加到集合中     
		 
		  File[] f = file.listFiles();
		        
            for(int i=0;i<f.length;i++){
				  if(f[i].isFile()){
					     //if(f[i].toString().substring(f[i].toString().length()-4,f[i].toString().length()).matches("java"))
						// f[i].delete();
			      list.add(f[i].toString());
				    
				    }     // 将路径添加到集合中	        
				   if(f[i].isDirectory())  //判断是否是目录
					   print(f[i]);			// 递归调用                       
				  }
   
   
   }
	
    public void Conversions(String str)throws Exception{ // 传递文件的路径
	       BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(str)));  
		   File file =new File(str);
		  FileWriter pw=new FileWriter(str.replaceAll("java","txt"));
			String s=null;
			while((s=br.readLine())!=null){    
			  pw.write(s);
			}			
	    br.close();
		pw.close();
	
	}

  // 打印流

  public static Scanner getScanner()throws Exception{
       // PrintStream pw =null;
		//pw = new PrintStream(new FileOutputStream("D:"+File.separator+"co\\t.txt"));
		     Scanner scan = new Scanner(System.in);
                  return scan;
    } 

   public int getInt()throws Exception{
     Scanner s= FileDemo.getScanner();
        System.out.println("请输入整数：");
		s.next();
	  return  s.nextInt();

   }

public String getString()throws Exception{
     Scanner s= FileDemo.getScanner();
        System.out.println("请输入字符串：");
	  return  s.next();

   }

	}