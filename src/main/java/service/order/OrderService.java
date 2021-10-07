package service.order;

import dao.cart.CartDao;
import dao.cart.ICartDao;
import dao.customer.CustomerDao;
import dao.customer.ICustomerDao;
import dao.order.IOrderDao;
import dao.order.OrderDao;
import model.*;

import java.util.List;

public class OrderService implements IOrderService {
    IOrderDao orderDao = new OrderDao();
    ICustomerDao customerDao = new CustomerDao();
    ICartDao cartDao = new CartDao();

    @Override
    public List<Order> show() {
        List<Order> orders = orderDao.show();
        for (Order order : orders) {
            Customer customer = customerDao.findById(order.getCustomerId());
            order.setCustomer(customer);
            Cart cart = cartDao.findById(order.getCartId());
            order.setCart(cart);
        }
        return orders;
    }

    @Override
    public boolean create(Order order) {
        return orderDao.create(order);
    }

    @Override
    public boolean update(int id, Order order) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return orderDao.delete(id);
    }

    @Override
    public Order findById(int id) {
        return orderDao.findById(id);
    }
}
