package service.admin;

import model.Product;
import service.IGeneralService;

import java.util.List;

public interface IAdminService extends IGeneralService<Product> {
    List<Product> searchProductByName(String name);

    List<Product> searchProductByCategory(int categoryId);
}
