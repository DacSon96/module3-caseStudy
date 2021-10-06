package dao.customer;

import dao.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE id = ?";
    Connection connection = DBConnection.getConnection();

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
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int keyId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int phone = resultSet.getInt("phone");
                String address = resultSet.getString("address");
                customer = new Customer(keyId, name, phone, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
