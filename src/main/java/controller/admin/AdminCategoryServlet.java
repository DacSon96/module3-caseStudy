package controller.admin;

import model.Category;
import model.Product;
import service.category.CategoryService;
import service.category.ICategoryService;
import service.product.IProductService;
import service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet", value = "/admin-category")
public class AdminCategoryServlet extends HttpServlet {
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default: {
                showCategoryView(request, response);
            }
        }
    }

    private void showCategoryView(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Category> categories;
        if (name == null || name.equals("")) {
            categories = categoryService.show();
        } else {
            categories = categoryService.searchCategoryByName(name);
        }
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/category/category-view.jsp");
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

        }
    }
}
