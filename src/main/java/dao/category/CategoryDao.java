package dao.category;

import customer.Customer;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConnectionDB;

public class CategoryDao implements ICategoryDao {

  public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category";
  Connection connection = ConnectionDB.connection();

  @Override
  public List<Category> show() {
    List<Category> categories = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        categories.add(new Category(id, name));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return categories;
  }

  @Override
  public boolean create(Category category) {
    return false;
  }

  @Override
  public boolean update(int id, Category category) {
    return false;
  }

  @Override
  public boolean delete(int id) {
    return false;
  }

  @Override
  public boolean save(Category category) {
    return false;
  }

  @Override
  public Category findById(int id) {
    return null;
  }

}
