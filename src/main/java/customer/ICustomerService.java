package customer;

public interface ICustomerService {
  Customer findByEmailAndPassword(String emai, String password);
  String roleCustomer(String email);
}
