<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Pixie - Product Detail</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="../assets/css/fontawesome.css">
    <link rel="stylesheet" href="../assets/css/tooplate-main.css">
    <link rel="stylesheet" href="../assets/css/owl.css">
    <link rel="stylesheet" href="../assets/css/flex-slider.css">
    <!--
    Tooplate 2114 Pixie
    https://www.tooplate.com/view/2114-pixie
    -->
</head>

<body>

<!-- Pre Header -->
<div id="pre-header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <span>Suspendisse laoreet magna vel diam lobortis imperdiet</span>
            </div>
        </div>
    </div>
</div>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
        <a class="navbar-brand" href="/ProductServlet?action=home"><img src="assets/images/header-logo.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="products.html">Products
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.html">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.html">Contact Us</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<!-- Single Starts Here -->
<div class="single-product">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>Single Product</h1>
                </div>
            </div>
            <div class="col-md-6">
                <div class="product-slider">
                    <div id="slider" class="flexslider">
                        <ul class="slides">
                            <li>
                                <img src="${product.image}"/>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>
            <div class="col-md-6">
                <div class="right-content">
                    <h4>${product.name}</h4>
                    <h6>${product.price}</h6>
                    <p>${product.description}</p>
                    <span>7 left on stock</span>
                    <form href="/ProductServlet" method="post">
                        <label for="quantity">Quantity:</label>
                        <input name="quantity" type="quantity" required="" class="quantity-text" id="quantity">
                        <input type="submit" class="button" value="Order Now!">
                    </form>
                        <div class="down-content">
                            <div class="categories">
                                <h6>Category: <span><a href="#">Pants</a>,<a href="#">Women</a>,<a
                                        href="#">Lifestyle</a></span></h6>
                            </div>
                            <div class="share">
                                <h6>Share: <span><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i
                                        class="fa fa-linkedin"></i></a><a href="#"><i
                                        class="fa fa-twitter"></i></a></span></h6>
                            </div>
                        </div>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- Single Page Ends Here -->


<!-- Similar Starts Here -->
<div class="featured-items">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>You May Also Like</h1>
                </div>
            </div>
            <div class="col-md-12">
                <div class="owl-carousel owl-theme">
                    <c:forEach items="${productPropose}" var="product">
                        <a href="/ProductServlet?action=showAboutProduct&id=${product.id}">
                            <div class="featured-item">
                                <img src="${product.image}" alt="">
                                <h4>${product.name}</h4>
                                <h6>${product.price}</h6>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Similar Ends Here -->


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
                    <p>Godard four dollar toast prism, authentic heirloom raw denim messenger bag gochujang put a bird
                        on it celiac readymade vice.</p>
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
                    <img src="assets/images/header-logo.png" alt="">
                </div>
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
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-rss"></i></a></li>
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
                    <p>Copyright &copy; 2019 Company Name

                        - Design: <a rel="nofollow" href="https://www.facebook.com/tooplate">Tooplate</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Sub Footer Ends Here -->


<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


<!-- Additional Scripts -->
<script src="../assets/js/custom.js"></script>
<script src="../assets/js/owl.js"></script>
<script src="../assets/js/isotope.js"></script>
<script src="../assets/js/flex-slider.js"></script>


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
