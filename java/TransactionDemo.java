package org.ace;
import java.sql.*;
public class TransactionDemo{
  // һ���һ�µ����ݷŵ�properties �ļ��� ���� �ڻ������ļ�ʱ �Ͳ��ø� ������
   private static String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private static String URL="jdbc:sqlserver://127.0.0.1:1433;database=students";
   private static String USERNAME="sa";
   private static String PASSWORD="";
   private static Connection conn=null;	

         // �õ����ݿ������
   public static Connection getConnection()throws Exception{
                Class.forName(DRIVER); // ��������
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
   
     };

    public static void main(String args[])throws Exception{
	         conn = TransactionDemo.getConnection(); // �õ����ݿ�����
	         conn.setAutoCommit(false);  // ȡ���Զ��ύ
			 Statement ps=conn.createStatement();
			 ps.addBatch("insert into cc values('1','����-1','��',18,'��Ϣϵ')");
             ps.addBatch("insert into cc values(''2','����-2','Ů',17,'�����ϵ')"); 
		     ps.addBatch("insert into cc values('3','����-3','��',19,'����ϵ')");
             ps.addBatch("insert into cc values('4','����-4','Ů',23,'��ѧϵ')");
             ps.addBatch("insert into cc values('5','����-5','��',20,'����ϵ')");
             ps.addBatch("insert into cc values('6','����-6','��',14,'����ϵ')");
			
              try{
                 ps.executeBatch(); 
				 conn.commit(); // �ݽ�����
			  }catch(SQLException e){
			        try{                              
					   conn.rollback(); // ��������쳣�ͻع�
 					}catch(SQLException e1){
					  e1.printStackTrace();
					}
			  }

	
	 }


}