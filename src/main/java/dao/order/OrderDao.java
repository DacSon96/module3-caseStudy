package dao.order;

import model.Order;

import java.util.List;

public class OrderDao implements IOrderDao {
    @Override
    public List<Order> show() {
        return null;
    }

    @Override
    public boolean create(Order order) {
        return false;
    }

    @Override
    public boolean update(int id, Order order) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Order findById(int id) {
        return null;
    }
}
