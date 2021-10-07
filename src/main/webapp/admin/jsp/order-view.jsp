<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Admin Page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700"/>
    <link rel="stylesheet" href="/admin/css/fontawesome.min.css"/>
    <link rel="stylesheet" href="/admin/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/admin/css/templatemo-style.css">
</head>
<body id="reportsPage">

<%--NAV-BAR--%>
<nav class="navbar navbar-expand-xl">
    <div class="container h-100">
        <a class="navbar-brand">
            <h1 class="tm-site-title mb-0">Admin</h1>
        </a>
        <button
                class="navbar-toggler ml-auto mr-0"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars tm-nav-icon"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto h-100">
                <li class="nav-item">
                    <a class="nav-link" href="/admin-product">
                        <i class="fas fa-shopping-cart"></i> Product
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin-category">
                        <i class="fas fa-file-alt"></i> Category
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/admin-order">
                        <i class="fas fa-tachometer-alt"></i> Order
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin-customer">
                        <i class="far fa-user"></i> User
                    </a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link d-block" href="/">
                        Admin, <b>Logout</b>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%--BREADCRUMB--%>
<nav>
    <ol class="breadcrumb" style="background-color: #4e657a">
        <li class="breadcrumb-item">
            <a href="/admin-order" style="text-decoration: none; color: #fff">Order</a>
        </li>
        <li class="breadcrumb-item active" aria-current="page">
            <a href="#" style="text-decoration: none; color: #fff">List</a>
        </li>
    </ol>
</nav>

<%--CONTENT--%>
<div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col" style="margin: auto">
    <div class="tm-bg-primary-dark tm-block tm-block-products">
        <h2 class="tm-block-title">Orders</h2>
        <div class="tm-product-table-container">
            <table class="table table-hover tm-table-small tm-product-table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">CUSTOMER</th>
                    <th scope="col">PHONE</th>
                    <th scope="col">ADDRESS</th>
                    <th scope="col">PRODUCT_ID</th>
                    <th scope="col">QUANTITY</th>
                    <th scope="col">PRICE</th>
                    <th scope="col"> </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.customer.name}</td>
                    <td>${order.customer.phone}</td>
                    <td>${order.customer.address}</td>
                    <td>${order.cart.productId}</td>
                    <td>${order.cart.quantity}</td>
                    <td>${order.cart.totalPrice}</td>
                    <td class="text-center">
                        <a href="/admin-order?action=order-delete&id=${order.id}">
                            <i class="far fa-trash-alt tm-product-delete-icon"></i>
                        </a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--FOOTER--%>
<footer class="tm-footer row tm-mt-small">
    <div class="col-12 font-weight-light">
        <p class="text-center text-white mb-0 px-4 small">
            Copyright &copy; <b>2018</b> All rights reserved.
            Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
        </p>
    </div>
</footer>

<script src="/admin/js/jquery-3.3.1.min.js"></script>
<script src="/admin/js/bootstrap.min.js"></script>
</body>
</html>
