package service.cart;

import dao.cart.CartDao;
import model.Cart;

import java.util.List;

public class CartService implements ICartService {
    CartDao cartDao = new CartDao();

    @Override
    public List<Cart> show() {
        return null;
    }

    @Override
    public int getByCartId() {
        return cartDao.getByCartId();
    }

    @Override
    public boolean create(Cart cart) {
        return cartDao.create(cart);
    }

    @Override
    public boolean update(int id, Cart cart) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Cart findById(int id) {
        return null;
    }
}
