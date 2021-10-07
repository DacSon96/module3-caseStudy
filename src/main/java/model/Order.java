package model;

public class Order {
    private int id;
    private int customerId;
    private int cartId;
    Customer customer;
    Cart cart;

    public Order() {
    }

    public Order(int customerId, int cartId) {
        this.customerId = customerId;
        this.cartId = cartId;
    }

    public Order(int id, int customerId, int cartId) {
        this.id = id;
        this.customerId = customerId;
        this.cartId = cartId;
    }

    public Order(int customerId, int cartId, Customer customer, Cart cart) {
        this.customerId = customerId;
        this.cartId = cartId;
        this.customer = customer;
        this.cart = cart;
    }

    public Order(int id, int customerId, int cartId, Customer customer, Cart cart) {
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