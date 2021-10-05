package service.category;

import dao.category.CategoryDao;
import dao.category.ICategoryDao;
import model.Category;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Category> show() {
        return categoryDao.show();
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
    public Category findById(int id) {
        return categoryDao.findById(id);
    }
}
