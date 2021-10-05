package dao.category;

import dao.IGeneralDao;
import model.Category;

import java.util.List;

public interface ICategoryDao extends IGeneralDao<Category> {
    List<Category> searchCategoryByName(String name);
}
