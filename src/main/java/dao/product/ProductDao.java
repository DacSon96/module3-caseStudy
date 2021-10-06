package dao.product;

import dao.DBConnection;
import model.Product;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    public static final String SELECT_LIMIT_PRODUCTS = "select * from product limit ?,?";
    public static final String INSERT_NEW_PRODUCT = "INSERT INTO product (name, size, image, price, categoryId) VALUES (?,?,?,?,?,?)";
    public static final String SELECT_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name like ?";
    public static final String SORT_PRODUCT_LOW_TO_HIGH = "SELECT * FROM product ORDER BY price ";
    public static final String SORT_PRODUCT_HIGH_TO_LOW = "SELECT * FROM product ORDER BY price DESC";
    public static final String SEARCH_PRODUCT_BY_ID = "SELECT * FROM product WHERE category like ?";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> show() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> showLimit(int start, int end) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_LIMIT_PRODUCTS);
            statement.setInt(1, start);
            statement.setInt(2, end);
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
            statement.setString(6,product.getDescription());
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> searchProductByCategory(int findCategoryId) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SEARCH_PRODUCT_BY_ID);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public List<Product> sortProductLowToHigh() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SORT_PRODUCT_LOW_TO_HIGH);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> sortProductHighToLow() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SORT_PRODUCT_HIGH_TO_LOW);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
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
            String description = resultSet.getString("description");
            products.add(new Product(id, keyName, size, image, price, categoryId,description));
        }
    }


}
