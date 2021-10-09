<%@ page import="java.util.List" %>
<%@ page import="model.Category" %>
<%@ page import="service.category.CategoryService" %>
<%@ page import="service.category.ICategoryService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Pixie - Products</title>


    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="../assets/css/fontawesome.css">
    <link rel="stylesheet" href="../assets/css/tooplate-main.css">
    <link rel="stylesheet" href="../assets/css/owl.css">
</head>

<body>
<%
    ICategoryService categoryService = new CategoryService();
    List<Category> categories = categoryService.show();
%>

<!-- Pre Header -->
<div id="pre-header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <span>Website selling super discounted shirts - buy one get two pay triple</span>
            </div>
        </div>
    </div>
</div>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
        <a class="navbar-brand" href="/ProductServlet?action=home"><img src="../assets/images/header-logo.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/ProductServlet?action=home">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/ProductServlet?page=1">Products
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ProductServlet?action=about">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ProductServlet?action=contact">Contact Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ProductServlet?action=contact">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<!-- Items Starts Here -->
<div class="featured-page">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>Featured Items</h1>
                </div>
            </div>
            <div class="col-md-8 col-sm-12">
                <div id="filters" class="button-group" >
                    <button class="btn btn-primary" style="color: #007bff" >All Products</button>
                    <div class="btn-group" id="divNewNotifications"s>
                        <a class="btn btn-primary dropdown-toggle"  data-toggle="dropdown" style="color: #007bff">
                            Category
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/ProductServlet?action=productByCategory1" style="color: #007bff">Shirt</a></li>
                                <li><a class="dropdown-item" href="/ProductServlet?action=productByCategory2" style="color: #007bff">Hoodie</a></li>
                        </ul>
                    </div>
                    <button class="btn btn-primary" ><a href="/ProductServlet?action=sortLowToHigh">Low Price</a></button>
                    <button class="btn btn-primary" ><a href="/ProductServlet?action=sortHighToLow">High Price</a></button>
                </div>
            </div>
        </div>
        <form action="/ProductServlet" method="post">
            <div class="col-3" style="float: right">
                <div class="input-group">
                    <input type="search" name="name" class="form-control rounded" placeholder="Search" aria-label="Search"
                           aria-describedby="search-addon"/>
                    <button class="btn btn-outline-primary">search</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="featured container no-gutter">

    <div class="row posts">
        <c:forEach items="${products}" var="product">
            <div id="${product.id}" class="item new col-md-4">
                <a href="/ProductServlet?action=showAboutProduct&id=${product.id}">
                    <div class="featured-item">
                        <img src="${product.image}" alt="" width="250px" height="250px">
                        <h4>${product.name}</h4>
                        <h6>$${product.price}</h6>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>

<div class="page-navigation">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul>
                    <c:forEach begin="1" end="5" step="1" var="i">
                        <li class="current-page"><a href="/ProductServlet?page=${i}">${i}</a></li>
                    </c:forEach>
<%--                    <li class="current-page"><a href="/ProductServlet?page=1">1</a></li>--%>
<%--                    <li><a href="/ProductServlet?page=2">2</a></li>--%>
<%--                    <li><a href="/ProductServlet?page=3">3</a></li>--%>
<%--                    <li><a href="#"><i class="fa fa-angle-right"></i></a></li>--%>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Featred Page Ends Here -->


<!-- Subscribe Form Starts Here -->
<div class="subscribe-form">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>Subscribe on PIXIE now!</h1>
                </div>
            </div>
            <div class="col-md-8 offset-md-2">
                <div class="main-content">
                    <p>Need Help Payment And Delivery - Refunds. News and Offers: Enter Email AddressSign Up.</p>
                    <div class="container">
                        <form id="subscribe" action="" method="get">
                            <div class="row">
                                <div class="col-md-7">
                                    <fieldset>
                                        <input name="email" type="text" class="form-control" id="email"
                                               onfocus="if(this.value == 'Your Email...') { this.value = ''; }"
                                               onBlur="if(this.value == '') { this.value = 'Your Email...';}"
                                               value="Your Email..." required="">
                                    </fieldset>
                                </div>
                                <div class="col-md-5">
                                    <fieldset>
                                        <button type="submit" id="form-submit" class="button">Subscribe Now!</button>
                                    </fieldset>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Subscribe Form Ends Here -->


<!-- Footer Starts Here -->
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="logo" href="/ProductServlet?action=home">
                    <img src="../assets/images/header-logo.png" height="26" width="122"/></div>
            </div>
            <div class="col-md-12">
                <div class="footer-menu">
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Help</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">How It Works ?</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-12">
                <div class="social-icons">
                    <ul>
                        <li><a href="http://facebook.com/"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="https://mobile.twitter.com/"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="https://www.linkedin.com/"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="https://fontawesome.com/"><i class="fa fa-rss"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Ends Here -->


<!-- Sub Footer Starts Here -->
<div class="sub-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="copyright-text">
                    <p>Copyright &copy; 2021 Company Name

                        - Design: By Group one C0621H1</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Sub Footer Ends Here -->


<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
<!-- Additional Scripts -->
<script src="../assets/js/owl.js"></script>
<script src="../assets/js/isotope.js"></script>
<script src="../assets/js/custom.js"></script>


<script language="text/Javascript">
    cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
    function clearField(t) {                   //declaring the array outside of the
        if (!cleared[t.id]) {                      // function makes it static and global
            cleared[t.id] = 1;  // you could use true and false, but that's more typing
            t.value = '';         // with more chance of typos
            t.style.color = '#fff';
        }
    }
</script>


</body>

</html>