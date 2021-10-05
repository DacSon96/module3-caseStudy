package admin;

import customer.Customer;
import java.util.List;

public interface IAdminService {
  List<Customer> finAll();
  void saveCustomer();
  Customer getCustomerById(int id);
  void deleteCustomer(int id);
}
