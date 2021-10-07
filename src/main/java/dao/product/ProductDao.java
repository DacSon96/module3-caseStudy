package dao.product;

import dao.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    public static final String INSERT_NEW_PRODUCT = "INSERT INTO product (name, size, image, price, categoryId, description) VALUES (?,?,?,?,?,?)";
    public static final String SELECT_LIMIT_PRODUCTS = "select * from product limit ?,?";
    public static final String SELECT_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name like ?";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";
    public static final String UPDATE_PRODUCT_BY_ID = "UPDATE product SET name = ?, size = ?, image = ?, price = ?, categoryId = ?, description = ? WHERE id = ?";
    public static final String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE id = ?";
    public static final String SORT_PRODUCT_LOW_TO_HIGH = "SELECT * FROM product ORDER BY price limit ?,?";
    public static final String SORT_PRODUCT_HIGH_TO_LOW = "SELECT * FROM product ORDER BY price DESC limit ?,?";
    public static final String SELECT_PRODUCT_FROM_CATEGORY = "select * from product inner join category c on product.categoryId = c.id and c.name like ? limit ?,?";

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
    public boolean create(Product product) {
        boolean isCreated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_NEW_PRODUCT);
            statement.setString(1, product.getName());
            statement.setString(2, product.getSize());
            statement.setString(3, product.getImage());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getCategoryId());
            statement.setString(6, product.getDescription());
            isCreated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean update(int id, Product product) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
            statement.setString(1, product.getName());
            statement.setString(2, product.getSize());
            statement.setString(3, product.getImage());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getCategoryId());
            statement.setString(6, product.getDescription());
            statement.setInt(7, id);
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
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String keyName = resultSet.getString("name");
                String size = resultSet.getString("size");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                int categoryId = resultSet.getInt("categoryId");
                String description = resultSet.getString("description");
                product = new Product(id, keyName, size, image, price, categoryId, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
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
                String description = resultSet.getString("description");
                products.add(new Product(id, keyName, size, image, price, categoryId, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> searchProductByCategory(String name,int start, int end) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_FROM_CATEGORY);
            statement.setString(1, name);
            statement.setInt(2, start);
            statement.setInt(3, end);
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
    public List<Product> sortProductLowToHigh(int start, int end) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SORT_PRODUCT_LOW_TO_HIGH);
            statement.setInt(1, start);
            statement.setInt(2, end);
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
    public List<Product> sortProductHighToLow(int start, int end) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SORT_PRODUCT_HIGH_TO_LOW);
            statement.setInt(1, start);
            statement.setInt(2, end);
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



