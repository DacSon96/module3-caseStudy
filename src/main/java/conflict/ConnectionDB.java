package conflict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

  private static Connection connection;
  private static String URL = "jdbc:mysql://localhost:3306/demo";
  private static String USERNAME = "root";
  private static String PASSWORD = "hanh1234";

  public static Connection connection(){
    if(connection ==null){
      try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connect success!");
      } catch (ClassNotFoundException | SQLException e){
        System.out.println("Connect MYSQL failed!");
        e.printStackTrace();
      }
    }
    return connection;
  }
}

