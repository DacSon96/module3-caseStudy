package dao.order;

import dao.DBConnection;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao {
    public static final String SELECT_ALL_ORDERS = "SELECT * FROM `order`";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Order> show() {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ORDERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customerId");
                int cartId = resultSet.getInt("cartId");
                orders.add(new Order(id, customerId, cartId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean create(Order order) {
        boolean created = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO case_study_module_3.orderdetail (customerId, cartId) VALUES ( ?,?)");
            statement.setInt(1, order.getCustomerId());
            statement.setInt(2, order.getCartId());
            created = statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public boolean update(int id, Order order) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Order findById(int id) {
        return null;
    }
}