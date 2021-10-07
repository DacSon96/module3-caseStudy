package service.product;

import model.Product;
import service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> searchProductByName(String name);

    List<Product> searchProductByCategory(String name,int start, int end);

    List<Product> showLimit(int start, int end);

    List<Product> sortProductLowToHight(int start, int end);

    List<Product> sortProductHightToLow(int start, int end);
}
