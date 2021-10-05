package customer;

public class Customer {
  private int id;
  private String name;
  private int age;
  private String phone;
  private String address;
  private String email;
  private String password;
  private String role;
  private boolean status;

  public Customer() {
  }

  public Customer(String name, String phone, String email, String password, boolean status) {
    this.name = this.name;
    this.phone = this.phone;
    this.email = this.email;
    this.password = this.password;
    this.status = this.status;
  }

  public Customer(int id, String name, int age, String phone, String address, String email,
      String password, String role, boolean status) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.address = address;
    this.email = email;
    this.password = password;
    this.role = role;
    this.status = status;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
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

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}

