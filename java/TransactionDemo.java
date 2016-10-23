package org.ace;
import java.sql.*;
public class TransactionDemo{
  // 一般把一下的数据放到properties 文件中 这样 在换驱动文件时 就不用改 程序了
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

    public static void main(String args[])throws Exception{
	         conn = TransactionDemo.getConnection(); // 得到数据库链接
	         conn.setAutoCommit(false);  // 取消自动提交
			 Statement ps=conn.createStatement();
			 ps.addBatch("insert into cc values('1','张三-1','男',18,'信息系')");
             ps.addBatch("insert into cc values(''2','张三-2','女',17,'计算机系')"); 
		     ps.addBatch("insert into cc values('3','张三-3','男',19,'语文系')");
             ps.addBatch("insert into cc values('4','张三-4','女',23,'数学系')");
             ps.addBatch("insert into cc values('5','张三-5','男',20,'法律系')");
             ps.addBatch("insert into cc values('6','张三-6','男',14,'生物系')");
			
              try{
                 ps.executeBatch(); 
				 conn.commit(); // 递交事物
			  }catch(SQLException e){
			        try{                              
					   conn.rollback(); // 如果产生异常就回滚
 					}catch(SQLException e1){
					  e1.printStackTrace();
					}
			  }

	
	 }


}