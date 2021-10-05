package service.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import conflict.ConnectionDB;
import model.Customer;

public class CustomerService implements ICustomerService {
  Connection connection = ConnectionDB.connection();
  public static final String SELECT_CUSTOMER = "SELECT * FROM customer WHERE email =? and password =?";
  public static final String SELECT_ROLERCUSTOMER = "SELECT role from role customer on role.id_customer = custmer.id where email =?";

  @Override
  public Customer findByUserNameAndPassword(String email, String password){
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
      preparedStatement.setString(1, email);
      preparedStatement.setString(2, password);
      ResultSet resultSet = preparedStatement.executeQuery();

      Customer customer = null;
      if (resultSet.next()){
        customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setName(resultSet.getString("name"));
        customer.setRole(resultSet.getString("role"));
        customer.setEmail(email);
        customer.setPassword(password);
      }
      System.out.println("SELECT -->"+preparedStatement);
      connection.setAutoCommit(true);
      return customer;
    }catch (SQLException e){
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String roleCustomer(String username){
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLERCUSTOMER);
      preparedStatement.setString(1, username);
      ResultSet resultSet = preparedStatement.executeQuery();
      String role = null;
      while (resultSet.next()){
        role = resultSet.getString("role");
      }
      return role;
    }catch (SQLException throwables){
      throwables.printStackTrace();
    }
    return  null;
  }

  public boolean checkLogin(Customer customer){
    if ("admin".equals(customer.getUsername())&&"123456".equals(customer.getPassword())){
      return true;
    }else {
      return false;
    }
  }

  @Override
  public List<Customer> show() {
    return null;
  }

  @Override
  public boolean create(Customer customer) {
    return false;
  }

  @Override
  public boolean update(int id, Customer customer) {
    return false;
  }

  @Override
  public boolean delete(int id) {
    return false;
  }

  @Override
  public boolean save(Customer customer) {
    return false;
  }

  @Override
  public Customer findById(int id) {
    return null;
  }
}
