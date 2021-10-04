<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Product Management</title>
<body>

<div>
    <table>
        <th>#</th>
        <th>Name</th>
        <th>Size</th>
        <th>Image</th>
        <th>Price</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.size}</td>
                <td><img src="${product.image}" alt="image" width="50px"></td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>