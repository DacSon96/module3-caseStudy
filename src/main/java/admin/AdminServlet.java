package admin;

import customer.Customer;
import customer.CustomerService;
import customer.ICustomerService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import validate.Validate;

@WebServlet(name = "AdminServlet", value = "/login")
public class AdminServlet extends HttpServlet {

  private AdminService adminService = new AdminService();
  private CustomerService customerService = new CustomerService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "login":
        login(request, response);
        break;
      default:
        showHomePage(request, response);
        break;
    }
  }

  private void showHomePage(HttpServletRequest request, HttpServletResponse response)
      throws UnsupportedEncodingException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("utf-8");
    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
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
      case "login":
        login(request, response);
        break;
      case "signup":
        signup(request, response);
        break;
      default:
        showHomepage(request, response);
        break;
    }
  }

  private void showHomepage(HttpServletRequest request, HttpServletResponse response)
      throws UnsupportedEncodingException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("utf-8");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
    try {
      requestDispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  private void signup(HttpServletRequest request, HttpServletResponse response)
      throws UnsupportedEncodingException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("utf-8");
    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/homepage?action=&username=&password=");
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    boolean status = true;
    Customer customer = new Customer(name,
        phone,
        email,
        password,
        status);
    String message;
    Validate validate = Validate.getInstance();
    if (validate.validate(name, validate.regexEmail)
        && validate.validate(phone, validate.regexPhone)
        && validate.validate(password, validate.regexPassword)) {
      customer.save(customer);
      message = "Đăng ký thành công.";
      request.setAttribute("message", message);
    } else {
      message = "Đăng ký không thành công mời nhập lại!!";
      request.setAttribute("message", message);
      request.setAttribute("customer", customer);
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void login(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    ICustomerService customerService = new CustomerService();
    String destPage = "login.jsp";
    Customer customer = customerService.findByEmailAndPassword(email, password);
    String role = customerService.roleCustomer(email);
    if (customer != null && role.equals("customer")) {
      destPage = "/customer";
    }
    if (customer != null && role.equals("admin")) {
      destPage = "/admin";
      request.setAttribute("customer", customer);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
      dispatcher.forward(request, response);
    }
    if (customer != null && role.equals("admin")) {
      destPage = "/admin";
    } else {
      String message = "Invalid email/password";
      request.setAttribute("message", message);

      RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
      dispatcher.forward(request, response);

    }
    response.sendRedirect(destPage);
  }
}
