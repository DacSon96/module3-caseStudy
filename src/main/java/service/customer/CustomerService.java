package service.customer;

import dao.customer.CustomerDao;
import dao.customer.ICustomerDao;
import model.Category;
import model.Customer;
import model.Product;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerDao customerDao = new CustomerDao();

    @Override
    public List<Customer> show() {
        return customerDao.show();
    }

    @Override
    public boolean create(Customer customer) {
        return customerDao.create(customer);
    }

    public boolean CustomerPay(Customer customer){
        return customerDao.CustomerPay(customer);
    }
    @Override
    public boolean update(int id, Customer customer) {
        return customerDao.update(id, customer);
    }

    @Override
    public boolean delete(int id) {
        return customerDao.delete(id);
    }

    @Override
    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        name = "%" + name + "%";
        return customerDao.searchCustomerByName(name);
    }
}
