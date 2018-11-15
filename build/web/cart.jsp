<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/head.jsp" %>
        <style>
            th, td {
                vertical-align: middle !important;
            }
        </style>
    </head>

    <body>
        <%@include file="components/header.jsp" %>

        <main role="main" class="container">
            <h1 class="display-4 mb-4">Shopping Cart <small class="text-muted" style="font-size: 24px">- ตะกร้าสินค้า</small></h1>
            <div class="table-responsive">
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th class="text-center">#</th>
                            <th>Name</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Qty</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach begin="1" end="4" var="i">
                            <tr>
                                <td class="text-center">${i}</td>
                                <td>
                                    <img class="img-fluid" src="image/sn1.jpg" width="60"> PUREBOOST RBL SHOES
                                </td>
                                <td class="text-center">100.00</td>
                                <td class="text-center" style="max-width: 50px">
                                    <input class="form-control text-center" type="number" value="2">
                                </td>
                                <td class="text-center">200.00</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <button type="submit" class="btn btn-primary btn-lg"><i class="fa fa-redo-alt"></i> Update Cart</button>
                </div>
                <div class="col-6 text-right">
                    <a href="checkout" class="btn btn-success btn-lg">Checkout <i class="fa fa-chevron-circle-right"></i></a>
                </div>
            </div>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>