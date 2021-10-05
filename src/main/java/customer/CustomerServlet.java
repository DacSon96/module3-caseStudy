package customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "create":
        break;
      case "edit":
        break;
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
      case "create":
        break;
      case "edit":
        break;
      case "search":
        break;
      default:
        showformLogin(request, response);
    }
  }

  private void login(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    ICustomerService customerService = new CustomerService();
    String destPage = "login.jsp";
    Customer customer = customerService.findByEmailAndPassword(email,password);
    String role = customerService.roleCustomer(email);
    if(customer !=null && role.equals("customer")){
      destPage = "/customer";
    }if(customer !=null && role.equals("admin")){
      destPage = "/admin";
      request.setAttribute("customer",customer);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin.jsp");
      dispatcher.forward(request,response);
    }if(customer !=null && role.equals("admin")){
      destPage = "/admin";
    }else{
      String message = "Invalid email/password";
      request.setAttribute("message", message);

      RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
      dispatcher.forward(request, response);

    }
    response.sendRedirect(destPage);
  }

  private void showformLogin(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
    requestDispatcher.forward(request, response);
  }
}
