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
        <a class="navbar-brand" href="../index.html">
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
                    <a class="nav-link" href="../index.html">
                        <i class="fas fa-tachometer-alt"></i> Dashboard
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="/admin-product">
                        <i class="fas fa-shopping-cart"></i> Product
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/admin-category">
                        <i class="fas fa-file-alt"></i> Category
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="../accounts.html">
                        <i class="far fa-user"></i> Accounts
                    </a>
                </li>

            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link d-block" href="../login.html">
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
            <a href="/admin-product" style="text-decoration: none; color: #fff">Product</a>
        </li>
        <li class="breadcrumb-item active" aria-current="page">
            <a href="#" style="text-decoration: none; color: #fff">Add new product</a>
        </li>
    </ol>
</nav>

<%--CONTENT--%>
<div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col" style="margin: auto">
    <form method="post" class="tm-edit-product-form">
        <div class="row">
            <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                    <div class="row">
                        <div class="col-12">
                            <h2 class="tm-block-title d-inline-block">Product details</h2>
                        </div>
                    </div>
                    <div class="row tm-edit-product-row">
                        <div class="col-xl-6 col-lg-6 col-md-12">
                            <div class="form-group mb-3">
                                <label class="form-label">Name</label>
                                <input type="text" name="name" class="form-control" required>
                            </div>
                            <div class="row">
                                <div class="form-group mb-3 col-xs-12 col-sm-6">
                                    <label class="form-label">Price</label>
                                    <input type="text" name="price" class="form-control" required>
                                </div>
                                <div class="form-group mb-3 col-xs-12 col-sm-6">
                                    <label class="form-label">Size</label>
                                    <input type="text" name="size" class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <label class="form-label">Category</label>
                                <select class="custom-select tm-select-accounts" name="categoryId">
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group mb-3">
                                <label class="form-label">Description</label>
                                <textarea name="description" class="form-control" rows="2" required></textarea>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                            <div class="tm-product-img-dummy mx-auto">
                                <i
                                        class="fas fa-cloud-upload-alt tm-upload-icon"
                                        onclick="document.getElementById('fileInput').click();"
                                ></i>
                            </div>
                            <div class="custom-file mt-3 mb-3">
                                <input id="fileInput" type="file" style="display:none;"/>
                                <input
                                        type="button"
                                        class="btn btn-primary btn-block mx-auto"
                                        value="UPLOAD PRODUCT IMAGE"
                                        onclick="document.getElementById('fileInput').click();"
                                />
                            </div>
                        </div>
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary btn-block text-uppercase">Add Product Now
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
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
