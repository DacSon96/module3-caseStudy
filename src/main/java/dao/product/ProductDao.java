package dao.product;

import model.ConnectionDB;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    public static final String INSERT_NEW_PRODUCT = "INSERT INTO product (name, size, image, price, categoryId) VALUES (?,?,?,?,?)";
    public static final String SELECT_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name like ?";
    Connection connection = ConnectionDB.connection();

    @Override
    public List<Product> show() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            setResultFromDB(products, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean create(Product product) {
        boolean isCreated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_NEW_PRODUCT);
            statement.setString(1, product.getName());
            statement.setString(2, product.getSize());
            statement.setString(3, product.getImage());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getCategoryId());
            isCreated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
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

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            statement.setString(1, name);
            setResultFromDB(products, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> searchProductByCategory(int categoryId) {
        return null;
    }

    private void setResultFromDB(List<Product> products, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String keyName = resultSet.getString("name");
            String size = resultSet.getString("size");
            String image = resultSet.getString("image");
            double price = resultSet.getDouble("price");
            int categoryId = resultSet.getInt("categoryId");
            products.add(new Product(id, keyName, size, image, price, categoryId));
        }
    }
}
