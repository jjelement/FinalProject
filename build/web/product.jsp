<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/head.jsp" %>
    </head>

    <body>
        <%@include file="components/header.jsp" %>

        <main role="main" class="container">
            <h1 class="display-4">${product.name}</h1>
            <hr>
            <div class="row">
                <div class="col-md-5">
                    <img class="img-thumbnail mb-3" src="assets/image/product/${product.id}/1.jpg" alt="${product.name}">
                    <div class="row">
                        <div class="col-3">
                            <img class="img-fluid" src="assets/image/product/${product.id}/1.jpg" alt="${product.name}">
                        </div>
                        <div class="col-3">
                            <img class="img-fluid" src="assets/image/product/${product.id}/1.jpg" alt="${product.name}">
                        </div>
                        <div class="col-3">
                            <img class="img-fluid" src="assets/image/product/${product.id}/1.jpg" alt="${product.name}">
                        </div>
                        <div class="col-3">
                            <img class="img-fluid" src="assets/image/product/${product.id}/1.jpg" alt="${product.name}">
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <p>
                        ${product.detail}
                    </p>
                    <hr>
                    <h4 class="text-success">Price: <fmt:formatNumber value="${product.price}" minFractionDigits="2" /> Baht</h4>
                    <form action="product?id=${product.id}" method="POST" class="form-inline mt-3">
                        <button type="submit" class="btn btn-primary btn-sm ml-md-2 mb-2"><i class="fa fa-cart-arrow-down"></i> Add To Cart</button>
                    </form>
                </div>
            </div>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>

