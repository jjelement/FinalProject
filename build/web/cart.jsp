<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <form class="cart" method="POST">
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
                            <c:choose>
                                <c:when test="${cart.totalQuantity > 0}">
                                    <c:forEach items="${cart.lineItems}" var="lineItem" varStatus="i">
                                        <tr>
                                            <td class="text-center">${i.count}</td>
                                            <td>
                                                <img class="img-fluid" src="assets/image/product/${lineItem.product.id}/1.jpg" width="60"> ${lineItem.product.name}
                                            </td>
                                            <td class="text-center"><fmt:formatNumber value="${lineItem.salePrice}" minFractionDigits="2" /> </td>
                                            <td class="text-center" style="max-width: 50px">
                                                <input class="form-control text-center" type="number" name="qty_${lineItem.product.id}" value="${lineItem.quantity}">
                                            </td>
                                            <td class="text-center">${lineItem.totalPrice}</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="5" class="text-center"><i>ยังไม่มีสินค้าในตะกร้า</i></td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                            
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
            </form>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>