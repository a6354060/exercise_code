package org.ace;
import java.sql.*;
import java.io.*;

public class SqlServer{
   private static String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private static String URL="jdbc:sqlserver://127.0.0.1:1433;database=students";
   private static String USERNAME="sa";
   private static String PASSWORD="";
   private static Connection conn=null;	

         // �õ����ݿ������
   public static Connection getConnection()throws Exception{
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
   
     }
  
   
      // �����ݿ��������
	  public static void insert()throws Exception{
	     conn=SqlServer.getConnection(); //�õ�����
		 Statement st=conn.createStatement();
	     String sql="insert  into C values('8','asp��ҳ���',4) ";
		 String sql1="update C set Cno='9' where ct=4 ";
		 st.execute(sql1);
	  
	  }
	 /* public static void cc(){
	  
	     conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			  // 3.ͨ�����Ӷ����ݲ���
			  Statement st = conn.createStatement();
			       String sql="select * from C "; // ���SQL���
				   ResultSet rs=st.executeQuery(sql); // ִ��sql���
				   insert();
                   while(rs.next()){
                          
				         System.out.print(rs.getString("Cno")+",");
						 System.out.print(rs.getString("cn")+",");
						 System.out.println(rs.getInt("Ct"));
				   }
				   
				   if(conn!=null){
				    conn.close();
				   
				   }
	  };*/

	  public static void PreStatement()throws Exception{
	      conn=SqlServer.getConnection();
		   String sql ="insert into File1(note,fname,fcontext) values(?,?,?) " ;
	      PreparedStatement st=conn.prepareStatement(sql);
         
		  File f=new File("d:"+File.separator+"LinkDemo02.java");
		  InputStream in=new FileInputStream(f);    
			st.setAsciiStream(1,in);
			st.setString(2,"a.java");
			st.setBinaryStream(3,in);
			st.executeUpdate();
			st.close();
			in.close();
			conn.close();
	  
	  }

	public static void main(String args[])throws Exception{ // �׳������쳣
	          // 1.��������
			  Class.forName(DRIVER);
	          // 2.�������ݿ�
				PreStatement();
             
 	} 
}