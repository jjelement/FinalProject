<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/head.jsp" %>
        <style>
            :root {
                --jumbotron-padding-y: 3rem;
            }
            .bgimg-1, .bgimg-2, .bgimg-3, .bgimg-top {
                position: relative;
                opacity: 0.65;
                background-attachment: fixed;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;

            }
            .bgimg-top {
                background-image: url("assets/image/brand/${brand.name}.jpg");
            }
        </style>
    </head>

    <body>
        <%@include file="components/header.jsp" %>

        <main role="main">
            <div class="bgimg-top">
                <section class="jumbotron text-center">
                    <div class="container text-light">
                        <h1 class="jumbotron-heading"><span class="px-4 py-2 text-light bg-secondary">${brand.name}</span></h1>
                        <p class="lead text-muted">
                            <hr>
                            Find your sneaker at "LUI SHOP"
                        </p>      
                    </div>
                </section>
            </div>

            <div class="album">
                <div class="container py-4">
                    <form method="GET" action="#" class="mb-2">
                        <input type="hidden" id="id" name="id" value="${brand.id}">
                        <div class="row">
                            <div class="col-md-1 offset-md-1">
                                <label for="price"><b>Price: </b></label>
                            </div>
                            <div class="col-md-3">
                                <input id="price" name="price" type="text" value="" data-slider-min="0" data-slider-max="10000" data-slider-step="500" data-slider-value="[${price}]"/>
                            </div>
                            <div class="col-md-1">
                                <label for="name"><b>Name: </b></label>
                            </div>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="name" name="name" value="${name}" placeholder="Product Name">
                            </div>
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-success"><i class="fa fa-search"></i> Search</button>
                            </div>
                        </div>
                    </form>
                    <hr>
                    <c:choose>
                        <c:when test="${products.size() > 0}">
                            <div class="row">          
                                <c:forEach items="${products}" var="product">
                                    <div class="col-md-4">
                                        <div class="card mb-4 shadow-sm">
                                            <button type="button" class="fav-btn btn btn-link" data-id="1"><i class="far fa-star fa-lg"></i></button>
                                            <img class="card-img-top" src="assets/image/product/${product.id}/1.jpg" alt="${product.name}">
                                            <div class="card-body">
                                                <h4><a href="product?id=1">${product.name}</a></h4>
                                                <p class="card-text">
                                                    ${product.detail.substring(0, 60)}...
                                                </p>
                                                <div class="row">
                                                    <div class="col-6">
                                                        <a href="product?id=${product.id}" class="btn btn-primary btn-sm"><i class="fa fa-search"></i> View</a>
                                                        <!-- <button type="button" class="btn btn-outline-info btn-sm"><i class="fa fa-cart-arrow-down"></i></button> -->
                                                    </div>
                                                    <div class="col-6 text-right">
                                                        <small class="font-weight-bold"><fmt:formatNumber value="${product.price}" minFractionDigits="2" /></small>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:when>
                            
                        <c:otherwise>
                            <div class="col-md-12">
                                <div class="alert alert-secondary mt-4" role="alert">
                                    <b>${brand.name}</b> ยังไม่มีสินค้าในขณะนี้
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
        <script>
            function addCommas(nStr) {
                nStr += '';
                x = nStr.split('.');
                x1 = x[0];
                x2 = x.length > 1 ? '.' + x[1] : '';
                var rgx = /(\d+)(\d{3})/;
                while (rgx.test(x1)) {
                    x1 = x1.replace(rgx, '$1' + ',' + '$2');
                }
                return x1 + x2;
            }
            $('#price').slider({
                formatter: (val) => {
                    return addCommas(val[0]) + " : "  + addCommas(val[1]);
                }
            })
        </script>
    </body>
</html>

