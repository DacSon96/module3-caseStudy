package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import service.customer.CustomerService;
import service.customer.ICustomerService;
import validate.Validate;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

  private CustomerService customerService = new CustomerService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
    requestDispatcher.forward(request, response);
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "registration":
        registration(request, response);
        break;
      case "login":
        login(request, response);
        break;
      default:
        showHomepage(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "registration":
        registration(request, response);
        break;
      case "login":
        login(request, response);
        break;
      default:
        showHomepage(request, response);
    }
  }



  private void registration(HttpServletRequest request, HttpServletResponse response)
      throws UnsupportedEncodingException {
//    response.setContentType("text/html;charset=UTF-8");
//    request.setCharacterEncoding("utf-8");
//    RequestDispatcher dispatcher = request.getRequestDispatcher("/home?action");
//    int id = request.getIntHeader("id");
//    String name = request.getParameter("name");
//    int age = request.getIntHeader("age");
//    String phone = request.getParameter("phone");
//    String address = request.getParameter("address");
//    String email = request.getParameter("email");
//    String username = request.getParameter("username");
//    String password = request.getParameter("password");
//    String role = request.getParameter("role");
//    Customer customer = new Customer(id, name, age, phone, address, email, username, password,
//        role);
//    String message;
//    Validate validate = Validate.getInstance();
//    if (validate.validate(username, validate.regexEmail)
//        && validate.validate(phone, validate.regexPhone)
//        && validate.validate(password, validate.regexPassword)) {
//      customerService.save(customer);
//      message = "Sign Up Success!!";
//      request.setAttribute("message", message);
//    } else {
//      message = "Registration failed, please re-enter!";
//      request.setAttribute("message", message);
//      request.setAttribute("customer", customer);
//    }
//    try {
//      dispatcher.forward(request, response);
//    } catch (ServletException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }

  private void login(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String username = request.getParameter("email");
    String password = request.getParameter("password");
    ICustomerService customerService = new CustomerService();
    String destPage = "login.jsp";
    Customer customer = customerService.findByUserNameAndPassword(username, password);
    if (customer != null && customer.getRole().equals("1")) {
      destPage = "/productServlet";
    } else if (customer != null && customer.getRole().equals("0")) {
      destPage = "/adminServlet";
    } else {
      String message = "Invalid username/password";
      request.setAttribute("message", message);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
      requestDispatcher.forward(request, response);
    }
    response.sendRedirect(destPage);
  }

  private void showHomepage(HttpServletRequest request, HttpServletResponse response)
      throws UnsupportedEncodingException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("utf-8");
    RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
