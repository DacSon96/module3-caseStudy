package dao.customer;

import dao.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE id = ?";
    public static final String INSERT_NEW_CUSTOMER = "INSERT INTO customer (name, phone, address, username, password, role, email) VALUES (?,?,?,?,?,?,?)";
    public static final String UPDATE_CUSTOMER_BY_ID = "UPDATE customer SET name = ?, phone = ?, address = ?, username = ?, password = ?, role = ?, email = ? WHERE id = ?";
    public static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM customer WHERE id = ?";
    public static final String SELECT_CUSTOMER_BY_NAME = "SELECT * FROM customer WHERE name like ?";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Customer> show() {
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String email = resultSet.getString("email");
                customers.add(new Customer(id, name, phone, address, username, password, role, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean create(Customer customer) {
        boolean isCreated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_NEW_CUSTOMER);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getPhone());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getUsername());
            statement.setString(5, customer.getPassword());
            statement.setString(6, customer.getRole());
            statement.setString(7, customer.getEmail());
            isCreated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    public boolean customerPay(Customer customer) {
        boolean isCreated = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer (name, phone, address,cartId) VALUES (?, ?, ?,?)");
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getPhone());
            statement.setString(3, customer.getAddress());
            statement.setInt(4, customer.getCartId());
            isCreated =statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean update(int id, Customer customer) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getPhone());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getUsername());
            statement.setString(5, customer.getPassword());
            statement.setString(6, customer.getRole());
            statement.setString(7, customer.getEmail());
            statement.setInt(8, id);
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int keyId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String email = resultSet.getString("email");
                customer = new Customer(keyId, name, phone, address, username, password, role, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String keyName = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String email = resultSet.getString("email");
                customers.add(new Customer(id, keyName, phone, address, username, password, role, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
