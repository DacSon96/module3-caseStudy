package service.product;

import dao.product.ProductDao;
import dao.product.IProductDao;
import model.Product;

import java.util.List;

public class ProductService implements IProductService {
    private IProductDao productDao = new ProductDao();

    @Override
    public List<Product> show() {
        return productDao.show();
    }

    @Override
    public boolean create(Product product) {
        return productDao.create(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        name = "%" + name + "%";
        return productDao.searchProductByName(name);
    }

    @Override
    public List<Product> searchProductByCategory(int categoryId) {
        return null;
    }

    @Override
    public List<Product> sortProductLowToHight() {
        return productDao.sortProductLowToHigh();
    }

    @Override
    public List<Product> sortProductHightToLow() {
        return productDao.sortProductHighToLow();
    }
}
