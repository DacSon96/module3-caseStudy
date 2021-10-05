<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
          crossorigin="anonymous">
<body>

<%--Navbar--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin-product">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin-category">Category</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin-order">Orders</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br>


<%--Content--%>
<div class="container">
    <div class="card">
        <div class="card-header">

            <%--BreadCrumb--%>
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="/admin-product" style="text-decoration: none">Product</a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                        <a href="#" style="text-decoration: none">List</a>
                    </li>
                </ol>
            </nav>

            <%--Search--%>
            <form action="/admin-product">
                <div class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search by Name" name="name"
                           aria-label="Search">
                    <button type="submit" class="btn btn-secondary me-2">Search</button>
                </div>
            </form>
        </div>

        <%--Content--%>
        <div class="card-body">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Size</th>
                    <th scope="col">Image</th>
                    <th scope="col">Price</th>
                    <th scope="col">Category</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <th scope="row">${product.id}</th>
                        <td>${product.name}</td>
                        <td>${product.size}</td>
                        <td><img src="${product.image}" alt="image" width="50px"></td>
                        <td>${product.price}</td>
                        <td>${product.category.name}</td>
                        <td>
                            <a href="/admin-product?action=product-update&id=${product.id}">
                                <button type="button" class="btn btn-success btn-sm">Edit</button>
                            </a>
                        </td>
                        <td>
                            <a href="/admin-product?action=product-delete&id=${product.id}">
                                <button type="button" class="btn btn-danger btn-sm">Delete</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <%--Create--%>
        <div class="card-footer">
            <a href="/admin-product?action=product-create">
                <button class="btn btn-primary" style="float: right">Create New</button>
            </a>
        </div>
    </div>
</div>
<br>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous">
</script>
</body>
</html>