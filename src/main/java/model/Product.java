package model;

public class Product {
    private int id;
    private String name;
    private String size;
    private String image;
    private double price;
    private Category categoryId;

    public Product() {
    }

    public Product(int id, String name, String size, String image, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.image = image;
        this.price = price;
    }

    public Product(int id, String name, String size, String image, double price, Category categoryId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}
