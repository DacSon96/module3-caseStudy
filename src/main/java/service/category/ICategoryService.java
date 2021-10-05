package service.category;

import model.Category;
import service.IGeneralService;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    List<Category> searchCategoryByName(String name);
}
