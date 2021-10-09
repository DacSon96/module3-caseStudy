package model;

public class Cart {
    private int id;
    private int productId;
    private int quantity;
    private double totalPrice;
    private int customerId;
    private Product product;
    private Customer customer;

    public Cart() {
    }

    public Cart(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Cart(int id, int productId, int quantity, double totalPrice, int customerId, Product product, Customer customer) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.customerId = customerId;
        this.product = product;
        this.customer = customer;
    }

    public Cart(int productId, int quantity, double totalPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Cart(int id, int productId, int quantity, double totalPrice) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Cart(int productId, int quantity, double totalPrice, Product product) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public Cart(int id, int productId, int quantity, double totalPrice, Product product) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public Cart(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
