package dao.cart;

import dao.DBConnection;
import model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartDao implements ICartDao {
    public static final String SELECT_CART_BY_ID = "SELECT * FROM cart WHERE id = ?";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Cart> show() {
        return null;
    }

    @Override
    public boolean create(Cart cart) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO case_study_module_3.cart (productId, quatity) VALUES ( ?, ?)");
            statement.setInt(1, cart.getProductId());
            statement.setInt(2, cart.getQuantity());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Cart cart) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Cart findById(int id) {
        Cart cart = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CART_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int keyId = resultSet.getInt("id");
                int productId = resultSet.getInt("productId");
                int quantity = resultSet.getInt("quantity");
                double totalPrice = resultSet.getDouble("totalPrice");
                cart = new Cart(keyId, productId, quantity, totalPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }
}