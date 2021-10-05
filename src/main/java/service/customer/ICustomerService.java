package service.customer;

import model.Customer;
import service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
  Customer findByUserNameAndPassword(String username, String password);
  String roleCustomer(String email);
}
