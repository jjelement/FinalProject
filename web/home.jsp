<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/head.jsp" %>
    </head>

    <body>
        <%@include file="components/header.jsp" %>

        <main role="main">
            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading">Welcome to <span class="label label-dark">LUI-SHOP</span></h1>
                    <p class="lead text-muted">Universe of sneakers</p>      
                </div>
            </section>

            <div class="album py-5 bg-light">
                <div class="container">

                    <div class="row">          
                        <c:forEach begin="1" end="6">
                            <div class="col-md-4">
                                <div class="card mb-4 shadow-sm">
                                    <img class="card-img-top" src="image/sn1.jpg" alt="PUREBOOST RBL SHOES">
                                    <div class="card-body">
                                        <h4><a href="product?id=1">PUREBOOST RBL SHOES</a></h4>
                                        <p class="card-text">
                                            WINTER-READY RUNNING SHOES WITH AN ADAPTIVE FIT AND LOW-TO-THE-GROUND FEEL.
                                        </p>
                                        <div class="row">
                                            <div class="col-6">
                                                <a href="product?id=1" class="btn btn-primary btn-sm"><i class="fa fa-search"></i> View</a>
                                            </div>
                                            <div class="col-6 text-right">
                                                <small class="font-weight-bold">100.00</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>

