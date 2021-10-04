package controller;

import model.Product;
import service.admin.AdminService;
import service.admin.IAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    private IAdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default: {
                showAdminView(request, response);
            }
        }
    }

    private void showAdminView(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = adminService.show();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/show.jsp");
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
