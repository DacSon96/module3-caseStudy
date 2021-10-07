package controller;

import service.customer.CustomerService;
import service.customer.ICustomerService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.Customer;

@WebServlet(name = "CustomerServlet", value = "/customerServlet")
public class CustomerServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "search":
        break;
      default:
        showformLogin(request, response);
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
      case "search":
        break;
      default:
        login(request, response);
    }
  }

  private void login(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String username = request.getParameter("email");
    String password = request.getParameter("password");
    ICustomerService customerService = new CustomerService();
    String destPage = "login.jsp";
    Customer customer = customerService.findByUserNameAndPassword(username, password);
    if (customer != null && customer.getRole().equals("1")){
      destPage = "/productServlet";
    }else if (customer != null && customer.getRole().equals("0")){
      destPage = "/adminServlet";
    }else {
      String message =  "Invalid username/password";
      request.setAttribute("message", message);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
      requestDispatcher.forward(request, response);
    }
    response.sendRedirect(destPage);
  }


  private void showformLogin(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.html");
    requestDispatcher.forward(request, response);
  }
}
