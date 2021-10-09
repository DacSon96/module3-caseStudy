package dao.cart;


import dao.IGeneralDao;
import model.Cart;

import java.util.List;

public interface ICartDao extends IGeneralDao<Cart> {
    int getByCartId();
}

