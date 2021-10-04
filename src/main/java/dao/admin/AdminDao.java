package dao.admin;

import dao.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements IAdminDao {
    public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> show() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String size = resultSet.getString("size");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                int categoryId = resultSet.getInt("categoryId");
                products.add(new Product(id, name, size, image, price, categoryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
