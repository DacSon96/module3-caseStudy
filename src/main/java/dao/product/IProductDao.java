package dao.product;

import dao.IGeneralDao;
import model.Product;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<Product> searchProductByName(String name);

    List<Product> searchProductByCategory(String name,int start, int end);

    List<Product> showLimit(int start, int end);


    List<Product> sortProductLowToHigh(int start, int end);

    List<Product> sortProductHighToLow(int start, int end);

}
