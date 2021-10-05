package service.product;

import model.Product;
import service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> searchProductByName(String name);

    List<Product> searchProductByCategoryId(int categoryId);
}
