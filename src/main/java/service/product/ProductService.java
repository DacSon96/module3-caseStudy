package service.product;

import dao.category.CategoryDao;
import dao.category.ICategoryDao;
import dao.product.ProductDao;
import dao.product.IProductDao;
import model.Category;
import model.Product;

import java.util.List;

public class ProductService implements IProductService {
    IProductDao productDao = new ProductDao();
    ICategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Product> show() {
        List<Product> products = productDao.show();
        for (Product product : products) {
            Category category = categoryDao.findById(product.getCategoryId());
            product.setCategory(category);
        }
        return products;
    }

    @Override
    public List<Product> showLimit(int start, int end) {
        return productDao.showLimit(start,end);
    }

    @Override
    public boolean create(Product product) {
        return productDao.create(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDao.update(id, product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public Product findById(int id) {
        Product product = productDao.findById(id);
        Category category = categoryDao.findById(product.getCategoryId());
        product.setCategory(category);
        return product;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        name = "%" + name + "%";
        return productDao.searchProductByName(name);
    }

    @Override
    public List<Product> searchProductByCategory(String name,int start, int end) {
        name = "%" + name + "%";
        return productDao.searchProductByCategory(name,start,end);
    }

    @Override
    public List<Product> sortProductLowToHight(int start, int end) {
        return productDao.sortProductLowToHigh(start,end);
    }

    @Override
    public List<Product> sortProductHightToLow(int start, int end) {
        return productDao.sortProductHighToLow(start,end);
    }
}
