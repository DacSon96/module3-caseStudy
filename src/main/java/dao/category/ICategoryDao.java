package dao.category;

import dao.IGeneralDao;
import model.Category;
import model.Product;

import java.util.List;

import java.util.List;

public interface ICategoryDao extends IGeneralDao<Category> {
    List<Category> searchCategoryByName(String name);
}
