package dao.admin;

import dao.IGeneralDao;
import model.Product;

import java.util.List;

public interface IAdminDao extends IGeneralDao<Product> {
    List<Product> searchProductByName(String name);

    List<Product> searchProductByCategory(int categoryId);
}
