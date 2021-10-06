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
                    <a class="nav-link" href="/admin-account">
                        <i class="far fa-user"></i> Account
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
                    <th scope="col">ORDER NO.</th>
                    <th scope="col">STATUS</th>
                    <th scope="col">OPERATORS</th>
                    <th scope="col">LOCATION</th>
                    <th scope="col">DISTANCE</th>
                    <th scope="col">START DATE</th>
                    <th scope="col">EST DELIVERY DUE</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row"><b>#122349</b></th>
                    <td>
                        <div class="tm-status-circle moving">
                        </div>
                        Moving
                    </td>
                    <td><b>Oliver Trag</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>485 km</b></td>
                    <td>16:00, 12 NOV 2018</td>
                    <td>08:00, 18 NOV 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122348</b></th>
                    <td>
                        <div class="tm-status-circle pending">
                        </div>
                        Pending
                    </td>
                    <td><b>Jacob Miller</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>360 km</b></td>
                    <td>11:00, 10 NOV 2018</td>
                    <td>04:00, 14 NOV 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122347</b></th>
                    <td>
                        <div class="tm-status-circle cancelled">
                        </div>
                        Cancelled
                    </td>
                    <td><b>George Wilson</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>340 km</b></td>
                    <td>12:00, 22 NOV 2018</td>
                    <td>06:00, 28 NOV 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122346</b></th>
                    <td>
                        <div class="tm-status-circle moving">
                        </div>
                        Moving
                    </td>
                    <td><b>William Aung</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>218 km</b></td>
                    <td>15:00, 10 NOV 2018</td>
                    <td>09:00, 14 NOV 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122345</b></th>
                    <td>
                        <div class="tm-status-circle pending">
                        </div>
                        Pending
                    </td>
                    <td><b>Harry Ryan</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>280 km</b></td>
                    <td>15:00, 11 NOV 2018</td>
                    <td>09:00, 17 NOV 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122344</b></th>
                    <td>
                        <div class="tm-status-circle pending">
                        </div>
                        Pending
                    </td>
                    <td><b>Michael Jones</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>218 km</b></td>
                    <td>18:00, 12 OCT 2018</td>
                    <td>06:00, 18 OCT 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122343</b></th>
                    <td>
                        <div class="tm-status-circle moving">
                        </div>
                        Moving
                    </td>
                    <td><b>Timmy Davis</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>218 km</b></td>
                    <td>12:00, 10 OCT 2018</td>
                    <td>08:00, 18 OCT 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122342</b></th>
                    <td>
                        <div class="tm-status-circle moving">
                        </div>
                        Moving
                    </td>
                    <td><b>Oscar Phyo</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>420 km</b></td>
                    <td>15:30, 06 OCT 2018</td>
                    <td>09:30, 16 OCT 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122341</b></th>
                    <td>
                        <div class="tm-status-circle moving">
                        </div>
                        Moving
                    </td>
                    <td><b>Charlie Brown</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>300 km</b></td>
                    <td>11:00, 10 OCT 2018</td>
                    <td>03:00, 14 OCT 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122340</b></th>
                    <td>
                        <div class="tm-status-circle cancelled">
                        </div>
                        Cancelled
                    </td>
                    <td><b>Wilson Cookies</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>218 km</b></td>
                    <td>17:30, 12 OCT 2018</td>
                    <td>08:30, 22 OCT 2018</td>
                </tr>
                <tr>
                    <th scope="row"><b>#122339</b></th>
                    <td>
                        <div class="tm-status-circle moving">
                        </div>
                        Moving
                    </td>
                    <td><b>Richard Clamon</b></td>
                    <td><b>London, UK</b></td>
                    <td><b>150 km</b></td>
                    <td>15:00, 12 OCT 2018</td>
                    <td>09:20, 26 OCT 2018</td>
                </tr>
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
