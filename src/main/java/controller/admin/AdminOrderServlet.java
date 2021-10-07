package controller.admin;

import model.Order;
import service.order.IOrderService;
import service.order.OrderService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminOrderServlet", value = "/admin-order")
public class AdminOrderServlet extends HttpServlet {
    IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "order-delete": {
                deleteOrder(request, response);
                break;
            }
            default: {
                showOrderView(request, response);
            }
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findById(id);
        if (order == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            orderService.delete(id);
            try {
                response.sendRedirect("/admin-order");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showOrderView(HttpServletRequest request, HttpServletResponse response) {
        List<Order> orders = orderService.show();
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/jsp/order-view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
