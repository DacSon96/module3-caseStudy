<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <LINK REL="SHORTCUT ICON"  HREF="/iconweb.ico">
    <title>Quản lý đăng nhập</title>
    <style>
      .a {
        padding-right: 300px;
      }
    </style>
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">--%>
    <link rel="stylesheet" href="stylelogin.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
            integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"
            integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <!-- Button to Open the Modal -->

    <!-- The Modal -->
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Đăng ký</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form action="/homepage?action=signUp" method="post">
                        <label for="name">Name:</label>
                        <input class="a" type="text" id="name" name="fullName"
                        <c:if test="${customer!=null}">
                               value="${customer.fullName}"
                        </c:if>><br>
                        <label for="phoneNumber">Phone number:</label>
                        <input class="a" type="text" id="phoneNumber" name="phoneNumber"
                        <c:if test="${customer!=null}">
                               value="${customer.phone}"
                        </c:if>><br>
                        <label for="userName">User name:</label>
                        <input class="a" type="text" id="userName" name="userName"
                        <c:if test="${customer!=null}">
                               value="${customer.username}"
                        </c:if>><br>
                        <label for="password">Password:</label>
                        <input class="a" type="text" id="password" name="password"
                        <c:if test="${customer!=null}">
                               value="${customer.password}"
                        </c:if>><br>
                        <input type="submit" value="Đăng ký">
                    </form>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>

            </div>
        </div>
    </div>
</div>
<div class="container">
    <!-- Button to Open the Modal -->

    <!-- The Modal -->
    <div class="modal" id="myModal1">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Đăng Nhập</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form action="/homepage?action=login" method="post">
                        <label for="userName_1">Use Name:</label>
                        <input class="a" type="text" id="userName_1" name="userName"><br>
                        <label for="password">Password:</label>
                        <input class="a" type="text" id="password_1" name="password"><br>
                        <input type="submit" value="Đăng nhập">
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
<header class="row">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">
        Đăng Nhập
    </button>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
        Đăng ký
    </button>
    <c:if test="${message!=null}">
        <p>${message}</p>
    </c:if>
</header>
</body>
</html>