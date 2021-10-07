package model;

public class Product {
    private int id;
    private String name;
    private String size;
    private String image;
    private double price;
    private int categoryId;
    private String description;
    Category category;

    public Product() {
    }

    public Product(String name, String size, String image, double price, int categoryId) {
        this.name = name;
        this.size = size;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Product(int id, String name, String size, String image, double price, int categoryId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Product(String name, String size, String image, double price, int categoryId, String description) {
        this.name = name;
        this.size = size;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
    }

    public Product(int id, String name, String size, String image, double price, int categoryId, String description) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
