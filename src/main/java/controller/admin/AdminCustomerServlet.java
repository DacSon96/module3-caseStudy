package controller.admin;

import model.Customer;
import service.customer.CustomerService;
import service.customer.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCustomerServlet", value = "/admin-customer")
public class AdminCustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "customer-create": {
                showCustomerCreateForm(request, response);
                break;
            }
            case "customer-update": {
                showCustomerUpdateForm(request, response);
                break;
            }
            case "customer-delete": {
                deleteCustomer(request, response);
                break;
            }
            default: {
                showCustomerView(request, response);
            }
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        if (customer == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            customerService.delete(id);
            try {
                response.sendRedirect("/admin-customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCustomerUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("admin/jsp/customer-update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/jsp/customer-create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerView(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customers;
        if (name == null || name.equals("")) {
            customers = customerService.show();
        } else {
            customers = customerService.searchCustomerByName(name);
        }
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/jsp/customer-view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "customer-create": {
                createNewCustomer(request, response);
                break;
            }
            case "customer-update": {
                updateCustomerInfo(request, response);
                break;
            }
        }
    }

    private void updateCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));
        String email = request.getParameter("email");
        customerService.update(id, new Customer(name, phone, address, username, password, role, email));
        try {
            response.sendRedirect("/admin-customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));
        String email = request.getParameter("email");
        customerService.create(new Customer(name, phone, address, username, password, role, email));
        try {
            response.sendRedirect("/admin-customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
