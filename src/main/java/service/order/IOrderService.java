package service.order;

import model.Order;
import service.IGeneralService;

import java.util.List;

public interface IOrderService extends IGeneralService<Order> {
    List<Order> searchOrderById(String orderId);
}
