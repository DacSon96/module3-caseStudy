package admin;

import customer.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConnectionDB;

public class AdminService {
  Connection connection = ConnectionDB.connection();
  public static final String INSERT_INTO_CUSTOMER = ("insert into customer"
      + "(name, email, password)VALUES" + "(?,?,?);");
  public static final String SELECT_ID_CUSTOMER = "SELECT id from customer where email = ?;";
  public static final String SELECT_ALL_CUSTOMER = "select*from customer;";
  public static final String DELETE_FROM_CUSTOMER = "delete from customer where id = ?;";
  public static final String DELETE_FROM_ROLE = "delete from role where id = ?;";

  public List<Customer> findAll(){
    List<Customer> customerList = new ArrayList<>();
    try (
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)){
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
          int id = resultSet.getInt("id");
          String nameCustomer = resultSet.getString("nameCustomer");
          int age = resultSet.getInt("age");
          String phone = resultSet.getString("phone");
          String address = resultSet.getString("address");
          String email = resultSet.getString("email");
          String password = resultSet.getString("password");
          String role = resultSet.getString("role");
          boolean status = resultSet.getBoolean("status");
          Customer customer = new Customer(id, nameCustomer, age, phone, address, email, password, role, status);
          customerList.add(customer);
        }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return customerList;
  }

  public void saveCustomer(String name, String phone, String email, String password, boolean status){
    try {
      connection.setAutoCommit(false);
      PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, email);
      preparedStatement.setString(3, password);
      preparedStatement.executeUpdate();
      PreparedStatement pre = connection.prepareStatement(SELECT_ID_CUSTOMER);
      pre.setString(1, email);
      ResultSet resultSet = pre.executeQuery();
      int id_customer = 0;
      while (resultSet.next()){
        id_customer = resultSet.getInt("id");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public List<Customer> findAllCustomer(){
    List<Customer> customerList = new ArrayList<>();
    try (
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)){
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String phone = resultSet.getString("phone");
        String address = resultSet.getString("address");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");
        boolean status = resultSet.getBoolean("status");
        Customer customer = new Customer(id, name, age, phone, address, email, password, role, status);
        customerList.add(customer);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return customerList;
  }

  public void deleteCustomer(int id){
    try {
      connection.setAutoCommit(false);
      PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_ROLE);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();

      PreparedStatement pre = connection.prepareStatement(DELETE_FROM_CUSTOMER);
      pre.setInt(1, id);
      pre.executeUpdate();

      connection.commit();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
