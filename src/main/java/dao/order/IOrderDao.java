package dao.order;

import dao.IGeneralDao;
import model.Order;

import java.util.List;

public interface IOrderDao extends IGeneralDao<Order> {
    List<Order> searchOrderById(String orderId);
}
