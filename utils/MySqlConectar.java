package utils;

import java.sql.Connection;
import java.sql.DriverManager;


/*
*/
public class MySqlConectar {
   public Connection getConnection() {
       Connection cn = null;
       try {
           String url, user, pass;
           // Driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           url = "jdbc:mysql://" + "127.0.0.1" + ":3306/municipalidad?useSSL=false";
           
           user = "root";
           pass = "joseernesto";
           cn = DriverManager.getConnection(url, user, pass);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return cn;
   }
}