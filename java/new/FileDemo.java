package org.ace;
import java.io.*;
import java.util.*;
public class FileDemo{
   
  static List<String> list ; //���������ļ�·��


    public FileDemo(){ // ͨ�����췽����ʼ��list
	
		this.list=new ArrayList<String>();

        }

	public static void main(String args[])throws Exception{
		    FileDemo fi =new FileDemo();
		     //File file = new File("c:"+File.separator+"Users\\hp\\Desktop\\Դ�� - ����"); //�����ļ��� ��ָ����·��
	          //fi.print(file);
           // for(String s1:list){		
             // fi.Conversions(s1);
			 //Thread.sleep(1000);
			  //System.out.println(s1  ); 
			//}
        
				   
	   }

      public  void print(File file){  //�г������ļ�·������ӵ�������     
		 
		  File[] f = file.listFiles();
		        
            for(int i=0;i<f.length;i++){
				  if(f[i].isFile()){
					     //if(f[i].toString().substring(f[i].toString().length()-4,f[i].toString().length()).matches("java"))
						// f[i].delete();
			      list.add(f[i].toString());
				    
				    }     // ��·����ӵ�������	        
				   if(f[i].isDirectory())  //�ж��Ƿ���Ŀ¼
					   print(f[i]);			// �ݹ����                       
				  }
   
   
   }
	
    public void Conversions(String str)throws Exception{ // �����ļ���·��
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

  // ��ӡ��

  public static Scanner getScanner()throws Exception{
       // PrintStream pw =null;
		//pw = new PrintStream(new FileOutputStream("D:"+File.separator+"co\\t.txt"));
		     Scanner scan = new Scanner(System.in);
                  return scan;
    } 

   public int getInt()throws Exception{
     Scanner s= FileDemo.getScanner();
        System.out.println("������������");
		s.next();
	  return  s.nextInt();

   }

public String getString()throws Exception{
     Scanner s= FileDemo.getScanner();
        System.out.println("�������ַ�����");
	  return  s.next();

   }

	}