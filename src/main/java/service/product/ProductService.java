package service.product;

import dao.product.ProductDao;
import model.Product;

import java.util.List;

public class ProductService implements IProductService {
    ProductDao productDao = new ProductDao();

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean save(Product product) {
        return false;
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
    public boolean findById(int id) {
        return false;
    }
}
