package service.admin;

import dao.admin.AdminDao;
import dao.admin.IAdminDao;
import model.Product;

import java.util.List;

public class AdminService implements IAdminService {
    private IAdminDao adminDao = new AdminDao();

    @Override
    public List<Product> show() {
        return adminDao.show();
    }

    @Override
    public boolean create(Product product) {
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
    public Product findById(int id) {
        return null;
    }
}
