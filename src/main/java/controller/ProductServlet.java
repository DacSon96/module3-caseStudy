package controller;

import model.Product;
import service.product.IProductService;
import service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    List<Product> products = productService.show();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int choice;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "home":
                showIndex(request, response);
                break;
            case "about":
                showAbout(request, response);
                break;
            case "contact":
                showContact(request, response);
                break;
            case "sortHighToLow":
                sortHighToLowPrice(request, response);
                break;
            case "sortLowToHigh":
                sortLowToHighPrice(request, response);
                break;
            case "showAboutProduct":
                showAboutProduct(request, response);
                break;
            case "pay":
                showPayMent(request, response);
                break;
            case "productByCategory1":
                choice=1;
                showProductByCategory(request, response,choice);
                break;
            case "productByCategory2":
                choice=2;
                showProductByCategory(request, response,choice);
                break;
            default:
                showByPage(request, response);
                break;
        }
    }

    private void showProductByCategory(HttpServletRequest request, HttpServletResponse response,int choice) {
        String name;
        if (choice==1) {
            name = "shirt";
        } else {
            name = "hoodie";
        }
        int pageString = 1;
        int start;
        if (pageString == 1) {
            start = 0;
        } else {
            start = (pageString - 1) * 12;
        }
        List<Product> products = productService.searchProductByCategory(name, start, 12);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/products.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortLowToHighPrice(HttpServletRequest request, HttpServletResponse response) {
        int pageString = 1;
        int start;
        if (pageString == 1) {
            start = 0;
        } else {
            start = (pageString - 1) * 12;
        }
        List<Product> products = productService.sortProductLowToHight(start, 12);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/products.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortHighToLowPrice(HttpServletRequest request, HttpServletResponse response) {
        int pageString = 1;
        int start;
        if (pageString == 1) {
            start = 0;
        } else {
            start = (pageString - 1) * 12;
        }
        List<Product> products = productService.sortProductHightToLow(start, 12);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/products.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showPayMent(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/payment.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showAboutProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/single-product.jsp");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("product", products.get(id - 1));
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showContact(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/contact.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAbout(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/about.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showByPage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/products.jsp");
        int pageString = Integer.parseInt(request.getParameter("page"));
        int start;
        if (pageString == 1) {
            start = 0;
        } else {
            start = (pageString - 1) * 12;
        }
        List<Product> products = productService.showLimit(start, 12);
        request.setAttribute("products", products);
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
            default:
                showProductList(request, response);
                break;
        }

    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> products;
        if (name == null || name.equals("")) {
            products = productService.show();
        } else {
            products = productService.searchProductByName(name);
        }
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/products.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
