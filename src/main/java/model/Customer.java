package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

  private int id;
  private String name;
  private String phone;
  private String address;
  private String username;
  private String password;
  private String role;
  private String email;

  public Customer() {
  }

  public Customer(int id, String name, String phone, String address, String email,
      String username, String password, String role) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.email = email;
    this.username = username;
    this.password = password;
    this.role = role;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}

