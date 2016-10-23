  package org.ace;
  import java.sql.*;
  import java.io.*;
  
  public class BlobAndClob {
  
   private static String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private static String URL="jdbc:sqlserver://127.0.0.1:1433;database=students";
   private static String USERNAME="sa";
   private static String PASSWORD="";
   private static Connection conn=null;	

         // 得到数据库的链接
   public static Connection getConnection()throws Exception{
                Class.forName(DRIVER); // 加载驱动
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
   
     };
     // CLOB 存放大的文本数据  BOLB 存放大的二进制数据 比如图片 音频 视频
	 public static void clobStore()throws Exception{
	        // 1. 得到数据库的链接 存数据 
			  conn = BlobAndClob.getConnection();
			  String sql ="insert into userclob(id,name,text,photo) values(?,?,?,?) ";
			  PreparedStatement ps=conn.prepareStatement(sql); 
               ps.setInt(1,1);
			   ps.setString(2,"name");
			    File f=new File("d:"+File.separator+"1.java") ; 
			    InputStream in = new FileInputStream(f);
                File f1=new File("d:"+File.separator+"1.jpg") ; 
			    InputStream in1 = new FileInputStream(f1);  
			   ps.setAsciiStream(3,in);
               ps.setBinaryStream(4,in1);
			   ps.executeUpdate();
			   ps.close();
			   conn.close();
			   in.close();
	 };

	 public static void  getValues()throws Exception{
	        // 取数据
		   conn = BlobAndClob.getConnection();
			  String sql ="select name,text,photo from userclob where id=?  ";
			  PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setInt(1,1);
			  ResultSet rs=ps.executeQuery();
			   while(rs.next()){
			     //System.out.println(rs.getInt(1));
				 System.out.println(rs.getString(1));
				  Clob c = rs.getClob(2);
                  System.out.println(c.getSubString(1,(int)c.length()));
				  Blob b = rs.getBlob(3);
				    InputStream in = b.getBinaryStream();
                    OutputStream out=null;
  					out = new FileOutputStream("d:"+File.separator+"123123.jpg");
                      int i=0; 
					 while((i=in.read())!=-1){
					       out.write(i);
					 }
					in.close();
			        out.close();
			   
			   }
			   conn.close();
			   ps.close();
			   
					
	 
	 
	 }





	  public static void main(String args[])throws Exception{
	     //clobStore();
		  //getValues();
	    
	  } 


  }
