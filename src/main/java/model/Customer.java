package model;

public class Customer {
    private int id;
    private String name;
    private int phone;
    private String address;
    private String username;
    private String password;
    private int role;
    private String email;

    public Customer() {
    }

    public Customer(int id, String name, int phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String name, int phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Customer(int id, String name, int phone, String address, String username, String password, int role, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public Customer(String name, int phone, String address, String username, String password, int role, String email) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
