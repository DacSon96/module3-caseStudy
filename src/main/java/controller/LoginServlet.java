package controller;

import dao.customer.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import service.customer.CustomerService;
import service.customer.ICustomerService;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private CustomerService customerService = new CustomerService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
    requestDispatcher.forward(request, response);
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "signup":
        signup(request, response);
        break;
      case "login":
        login(request, response);
        break;
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
      case "signup":
        signup(request, response);
        break;
      case "login":
        login(request, response);
        break;
    }
  }


  private void signup(HttpServletRequest request, HttpServletResponse response)
      throws UnsupportedEncodingException {
//    response.setContentType("text/html;charset=UTF-8");
//    request.setCharacterEncoding("utf-8");
//    RequestDispatcher dispatcher = request.getRequestDispatcher(
//        "/homepage?action=&username=&password=");
//    String name = request.getParameter("name");
//    String phone = request.getParameter("phone");
//    String username = request.getParameter("username");
//    String password = request.getParameter("password");
//    boolean status = true;
//    Customer customer = new Customer(name,
//        phone,
//        email,
//        password,
//        status);
//    String message;
//    Validate validate = Validate.getInstance();
//    if (validate.validate(name, validate.regexEmail)
//        && validate.validate(phone, validate.regexPhone)
//        && validate.validate(password, validate.regexPassword)) {
//      customer.save(customer);
//      request.setAttribute("message", message);
//    } else {
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
    String destPage = "index.jsp";
    Customer customer = customerService.findByUserNameAndPassword(username, password);
    if (customer != null && customer.getRole().equals("1")){
      destPage = "/productServlet";
    }else if (customer != null && customer.getRole().equals("0")){
      destPage = "/admin";
    }else {
      String message =  "Invalid username/password";
      request.setAttribute("message", message);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
      requestDispatcher.forward(request, response);
    }
    response.sendRedirect(destPage);
  }
}
