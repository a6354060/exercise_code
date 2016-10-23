package org.ace;
import java.sql.*;
import java.io.*;

public class SqlServer{
   private static String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private static String URL="jdbc:sqlserver://127.0.0.1:1433;database=students";
   private static String USERNAME="sa";
   private static String PASSWORD="";
   private static Connection conn=null;	

         // 得到数据库的链接
   public static Connection getConnection()throws Exception{
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
   
     }
  
   
      // 向数据库插入数据
	  public static void insert()throws Exception{
	     conn=SqlServer.getConnection(); //得到链接
		 Statement st=conn.createStatement();
	     String sql="insert  into C values('8','asp网页设计',4) ";
		 String sql1="update C set Cno='9' where ct=4 ";
		 st.execute(sql1);
	  
	  }
	 /* public static void cc(){
	  
	     conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			  // 3.通过链接对数据操作
			  Statement st = conn.createStatement();
			       String sql="select * from C "; // 设计SQL语句
				   ResultSet rs=st.executeQuery(sql); // 执行sql语句
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

	public static void main(String args[])throws Exception{ // 抛出所有异常
	          // 1.加载驱动
			  Class.forName(DRIVER);
	          // 2.链接数据库
				PreStatement();
             
 	} 
}