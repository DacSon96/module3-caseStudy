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
//            case "product-create": {
//                showProductCreateForm(request, response);
//                break;
//            }
//            case "product-update": {
//                showProductUpdateForm(request, response);
//                break;
//            }
//            case "product-delete": {
//                deleteProduct(request, response);
//                break;
//            }
            default: {
                showOrderView(request, response);
            }
        }
    }

//    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = productService.findById(id);
//        if (product == null) {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            productService.delete(id);
//            try {
//                response.sendRedirect("/admin-product");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void showProductUpdateForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = productService.findById(id);
//        RequestDispatcher dispatcher;
//        if (product == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            request.setAttribute("product", product);
//            List<Category> categories = categoryService.show();
//            request.setAttribute("categories", categories);
//            dispatcher = request.getRequestDispatcher("admin/temp/product-update.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showProductCreateForm(HttpServletRequest request, HttpServletResponse response) {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/temp/product-create.jsp");
//        try {
//            List<Category> categories = categoryService.show();
//            request.setAttribute("categories", categories);
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }

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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "product-create": {
//                createNewProduct(request, response);
//                break;
//            }
//            case "product-update": {
//                updateProductInfo(request, response);
//                break;
//            }
        }
    }

//    private void updateProductInfo(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String size = request.getParameter("size");
//        String image = request.getParameter("image");
//        double price = Double.parseDouble(request.getParameter("price"));
//        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
//        String description = request.getParameter("description");
//        productService.update(id, new Product(name, size, image, price, categoryId, description));
//        List<Category> categories = categoryService.show();
//        request.setAttribute("categories", categories);
//        try {
//            response.sendRedirect("/admin-product");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
//        String size = request.getParameter("size");
//        String image = request.getParameter("image");
//        double price = Double.parseDouble(request.getParameter("price"));
//        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
//        String description = request.getParameter("description");
//        productService.create(new Product(name, size, image, price, categoryId, description));
//        List<Category> categories = categoryService.show();
//        request.setAttribute("categories", categories);
//        try {
//            response.sendRedirect("/admin-product");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
