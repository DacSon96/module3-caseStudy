package controller.admin;

import model.Category;
import model.Product;
import service.category.CategoryService;
import service.category.ICategoryService;
import service.product.ProductService;
import service.product.IProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProductServlet", value = "/admin-product")
public class AdminProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "product-create": {
                showProductCreateForm(request, response);
                break;
            }
            case "product-update": {
                showProductUpdateForm(request, response);
                break;
            }
            case "product-delete": {
                showProductDeleteForm(request, response);
                break;
            }
            default: {
                showProductView(request, response);
            }
        }
    }

    private void showProductDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            Category category = categoryService.findById(id);
            request.setAttribute("category", category);
            dispatcher = request.getRequestDispatcher("admin/product/product-delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            List<Category> categories = categoryService.show();
            request.setAttribute("categories", categories);
            dispatcher = request.getRequestDispatcher("admin/product/product-update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product/product-create.jsp");
        try {
            List<Category> categories = categoryService.show();
            request.setAttribute("categories", categories);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductView(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> products;
        if (name == null || name.equals("")) {
            products = productService.show();
        } else {
            products = productService.searchProductByName(name);
        }
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product/product-view.jsp");
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
            case "product-create": {
                createNewProduct(request, response);
                break;
            }
            case "product-update": {
                updateProductInfo(request, response);
                break;
            }
            case "product-delete": {
                deleteOldProduct(request, response);
                break;
            }
        }
    }

    private void deleteOldProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDeleted = productService.delete(id);
        String message = "";
        if (isDeleted) {
            message = "Success!";
        } else {
            message = "Failed!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product/product-delete.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProductInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String size = request.getParameter("size");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        boolean isUpdated = productService.update(id, new Product(name, size, image, price, categoryId));
        String message = "";
        if (isUpdated) {
            message = "Success!";
        } else {
            message = "Failed!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product/product-update.jsp");
        request.setAttribute("message", message);
        List<Category> categories = categoryService.show();
        request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String size = request.getParameter("size");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        boolean isCreated = productService.create(new Product(name, size, image, price, categoryId));
        String message = "";
        if (isCreated) {
            message = "Success!";
        } else {
            message = "Failed!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product/product-create.jsp");
        request.setAttribute("message", message);
        List<Category> categories = categoryService.show();
        request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
