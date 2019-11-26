package com.jason.study.design.singleton;

import com.jason.study.design.MyThread;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton {
       public  static  void main(String[] args)
       {
           System.out.println("test");

           Thread thread1=new MyThread();
           thread1.start();
       }
       public static Connection  con=null;
       public static String url="jdbc:mysql://localhost:3306/ocs?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
       public static String driver="com.mysql.cj.jdbc.Driver";
       public static String username="root";
       public static String password="root";
       public static Connection getCon() {
           System.out.println("----------------");
           if(con==null)
           {
               try{
                   Class.forName(Singleton.driver);
                   con= DriverManager.getConnection(Singleton.url,Singleton.username,Singleton.password);
               }catch (Exception e)
               {
                   e.printStackTrace();
               }


               System.out.println(con);
           }
           return con;
       }
}
