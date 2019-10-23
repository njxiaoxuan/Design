package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
       public static Connection  getConnection()
       {
           Connection con =null;
           try {
               Class.forName("com.mysql.jdbc.Driver");
               con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ocs"+ "?serverTimezone=GMT%2B8","root","root");
//               Properties info = new Properties();
//               info.put("user", "root");
//               info.put("password", "root");
//               con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql"+ "?serverTimezone=GMT%2B8",info);
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }catch (SQLException e) {
               e.printStackTrace();
           }finally {
               return  con;
           }

       }
       public static void main(String[] args)
       {
           System.out.println(DbUtil.getConnection());
       }
}
