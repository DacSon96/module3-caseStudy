package service.customer;

import model.Customer;
import model.Product;
import service.IGeneralService;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<Customer> searchCustomerByName(String name);
    boolean CustomerPay(Customer customer);
}