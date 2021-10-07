package dao.customer;

import dao.IGeneralDao;
import model.Customer;

import java.util.List;

public interface ICustomerDao extends IGeneralDao<Customer> {
    List<Customer> searchCustomerByName(String name);

    boolean CustomerPay(Customer customer);
}