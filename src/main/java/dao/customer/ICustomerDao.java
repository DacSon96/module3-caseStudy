package dao.customer;

import dao.IGeneralDao;
import java.util.List;
import model.Customer;

public class ICustomerDao implements IGeneralDao<Customer> {


  @Override
  public List<Customer> show() {
    return null;
  }

  @Override
  public boolean create(Customer customer) {
    return false;
  }

  @Override
  public boolean update(int id, Customer customer) {
    return false;
  }

  @Override
  public boolean delete(int id) {
    return false;
  }

  @Override
  public boolean save(Customer customer) {
    return false;
  }

  @Override
  public Customer findById(int id) {
    return null;
  }
}
