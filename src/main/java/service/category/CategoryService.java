package service.category;

import dao.category.CategoryDao;
import dao.category.ICategoryDao;
import model.Category;
import model.Product;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Category> show() {
        return categoryDao.show();
    }

    @Override
    public boolean create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public boolean update(int id, Category category) {
        return categoryDao.update(id, category);
    }

    @Override
    public boolean delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public List<Category> searchCategoryByName(String name) {
        name = "%" + name + "%";
        return categoryDao.searchCategoryByName(name);
    }

}
