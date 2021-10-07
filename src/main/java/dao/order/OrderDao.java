package dao.order;

import dao.DBConnection;
import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao {
    public static final String SELECT_ALL_ORDERS = "SELECT * FROM `order`";
    public static final String DELETE_ORDER_BY_ID = "DELETE FROM `order` WHERE id = ?";
    public static final String SELECT_ORDER_BY_ID = "SELECT * FROM `order` WHERE id = ?";
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
        return false;
    }

    @Override
    public boolean update(int id, Order order) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_BY_ID);
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ORDER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int keyId = resultSet.getInt("id");
                int customerId = resultSet.getInt("customerId");
                int cartId = resultSet.getInt("cartId");
                order = new Order(keyId, customerId, cartId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
