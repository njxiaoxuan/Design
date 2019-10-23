package com.jason.common.dbutil;

import java.sql.*;
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


       public String  queryUserInfoByName(String name)
       {
           String sql="select id,name,age,sex,remark   from  ocs_user   where name=?";
           PreparedStatement ps=null;
           String info="";
           try {
               ps =DbUtil.getConnection().prepareStatement(sql);
               ps.setString(1,name);

              ResultSet rs=ps.executeQuery();

              while(rs.next())
              {
                  info+="#"+ rs.getInt(1)+"#"+rs.getString(2)+"#"+rs.getInt(3)+"#"+rs.getInt(4)+"#"+ rs.getString(5);

//                 System.out.println( rs.getInt(1));"
//                  System.out.println( rs.getString(2));
//                  System.out.println( rs.getInt(3));
//                  System.out.println( rs.getInt(4));
//                  System.out.println( rs.getString(5));
              }
           } catch (SQLException e) {
               e.printStackTrace();
           }finally {
               return info;
           }
       }
       public static void init()
       {
           String sql="insert into ocs_user(id,name,age,sex,remark) values(?,?,?,?,?)";
           PreparedStatement ps=null;
           try {
                ps =DbUtil.getConnection().prepareStatement(sql);
                ps.setInt(1,100);
                ps.setString(2,"jerry");
                ps.setInt(3,10);
                ps.setInt(4,1);
                ps.setString(5,"shop the world");
                int i=ps.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }

       }
       public static void main(String[] args)
       {
//           System.out.println(DbUtil.getConnection());
//           init();

             DbUtil util =new DbUtil();
             System.out.println(util.queryUserInfoByName("jerry"));
       }
}
