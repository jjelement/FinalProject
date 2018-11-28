<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/head.jsp" %>
        <style>
            .bgimg-1, .bgimg-2, .bgimg-3, .bgimg-top {
                position: relative;
                opacity: 0.65;
                background-attachment: fixed;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;

            }
            .bgimg-top {
                background-image: url("assets/image/bg-top.jpg");
            }
            
            .bgimg-1 {
                background-image: url("assets/image/img_parallax.jpg");
            }

            .bgimg-2 {
                background-image: url("assets/image/img_parallax2.jpg");
            }

            .bgimg-3 {
                background-image: url("assets/image/img_parallax3.jpg");
            }
            
            .section-title {
                background-color: rgba(35, 35, 35, 0.7);
                padding-top: 1.5rem;
                padding-bottom: 1.5rem;
                margin-bottom: 1.5rem;
                color: #f8f9fa;
            }
            
            @media only screen and (max-device-width: 1024px) {
                .bgimg-1, .bgimg-2, .bgimg-3 {
                    background-attachment: scroll;
                }
            }

        </style>
    </head>

    <body>
        <%@include file="components/header.jsp" %>

        <main role="main">
            <div class="bgimg-top">
                <section class="jumbotron text-center">
                    <div class="container text-light">
                        <h1 class="jumbotron-heading">Welcome to <span class="p-2 text-light bg-secondary">LUI-SHOP</span></h1>
                        <p class="lead text-muted">
                            <hr>
                            Universe of sneakers
                        </p>      
                    </div>
                </section>
            </div>

            <div class="album">
                <c:forEach items="${brands}" var="brand" varStatus="i">
                    <div class="bgimg-${i.count}">
                        <div class="section-title">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-11">
                                        <h1 class="display-4">${brand.name}</h1>
                                    </div>
                                    <div class="col-sm-1 text-right my-auto">
                                        <a href="brand?id=${brand.id}" class="text-light align-middle"><i class="fa fa-plus-circle"></i> More</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="container pb-5">
                            <div class="row">          
                                <c:forEach items="${brand.productList.subList(0, 3)}" var="product" varStatus="j">
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
                        </div>
                    </div>
                </c:forEach>
            </div>

        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>

