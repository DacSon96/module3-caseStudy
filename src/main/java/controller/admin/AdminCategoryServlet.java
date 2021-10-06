package controller.admin;

import model.Category;
import service.category.CategoryService;
import service.category.ICategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet", value = "/admin-category")
//@WebServlet(name = "AdminProductServlet", value = "/admin")





public class AdminCategoryServlet extends HttpServlet {
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "category-create": {
                showCategoryCreateForm(request, response);
                break;
            }
            case "category-update": {
                showCategoryUpdateForm(request, response);
                break;
            }
            case "category-delete": {
                showCategoryDeleteForm(request, response);
                break;
            }
            default: {
                showCategoryView(request, response);
            }
        }
    }

    private void showCategoryDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(id);
        RequestDispatcher dispatcher;
        if (category == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("category", category);
            dispatcher = request.getRequestDispatcher("/admin/category/category-delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCategoryUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(id);
        RequestDispatcher dispatcher;
        if (category == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("category", category);
            dispatcher = request.getRequestDispatcher("/admin/category/category-update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCategoryCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/category/category-create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
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





//        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/category/category-product-view.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product-view.jsp");





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
            case "category-create": {
                createNewCategory(request, response);
                break;
            }
            case "category-update": {
                updateCategoryInfo(request, response);
                break;
            }
            case "category-delete": {
                deleteOldCategory(request, response);
                break;
            }
        }
    }

    private void deleteOldCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDeleted = categoryService.delete(id);
        String message = "";
        if (isDeleted) {
            message = "Success!";
        } else {
            message = "Failed!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/category/category-delete.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCategoryInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean isUpdated = categoryService.update(id, new Category(name));
        String message = "";
        if (isUpdated) {
            message = "Success!";
        } else {
            message = "Failed!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/category/category-update.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewCategory(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        boolean isCreated = categoryService.create(new Category(name));
        String message = "";
        if (isCreated) {
            message = "Success!";
        } else {
            message = "Failed!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/category/category-create.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
