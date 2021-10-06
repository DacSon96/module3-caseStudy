package model;

public class OrderDetail {
    private int id;
    private int customerId;
    private int cartId;
    Customer customer;
    Cart cart;

    public OrderDetail() {
    }

    public OrderDetail(int customerId, int cartId) {
        this.customerId = customerId;
        this.cartId = cartId;
    }

    public OrderDetail(int id, int customerId, int cartId) {
        this.id = id;
        this.customerId = customerId;
        this.cartId = cartId;
    }

    public OrderDetail(int customerId, int cartId, Customer customer, Cart cart) {
        this.customerId = customerId;
        this.cartId = cartId;
        this.customer = customer;
        this.cart = cart;
    }

    public OrderDetail(int id, int customerId, int cartId, Customer customer, Cart cart) {
        this.id = id;
        this.customerId = customerId;
        this.cartId = cartId;
        this.customer = customer;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
