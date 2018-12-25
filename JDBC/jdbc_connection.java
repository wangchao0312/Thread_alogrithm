package JDBC;

import java.sql.*;

public class jdbc_connection {
    private static final String URL="jdbc:mysql://localhost:3306/imooc";
    private static final String USER="root";
    private static final String PASSWORD="wangchao0404";
    private static Connection conn=null;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
             conn=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);

            System.out.println("数据库连接成功");

        Statement stmt=conn.createStatement();
      ResultSet re=  stmt.executeQuery("select user_name from imooc_goddess");

      while(re.next()){
          System.out.println(re.getString("user_name"));
      }
    }
}
