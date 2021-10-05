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
    <form method="post">
        <div class="card">
            <div class="card-header">
                <%--BreadCrumb--%>
                <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="/admin-product" style="text-decoration: none">Product</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">
                            <a href="#" style="text-decoration: none">Edit</a>
                        </li>
                    </ol>
                </nav>
            </div>
            <div class="card-body">
                <%--Content--%>
                <form>
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" name="name" class="form-control" value="${product.name}" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Size</label>
                        <input type="text" name="size" class="form-control" value="${product.size}" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Image</label>
                        <input type="text" name="image" class="form-control" value="${product.image}" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Price</label>
                        <input type="text" name="price" class="form-control" value="${product.price}" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Category</label>
                        <select class="form-select" name="categoryId">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                </form>
            </div>
            <div class="card-footer">
                <div style="float: left">
                    <c:if test="${message != null}">
                        <p>${message}</p>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-primary" id="liveToastBtn" style="float: right">Edit</button>
            </div>
        </div>
    </form>
</div>
<br>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>