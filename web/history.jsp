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
            <h1 class="display-4 mb-4">History <small class="text-muted" style="font-size: 24px">- ประวัติการสั่งซื้อ (#${order.id} - <fmt:formatDate value="${order.createdAt}" pattern="dd/MM/yyyy hh:mm:ss"/>)</small></h1>
            <div class="table-responsive">
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                                <th class="text-center">#</th>
                                <th>Name</th>
                                <th class="text-center">Qty</th>
                                <th class="text-center">Price</th>
                            </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${order.productOrderItemList}" var="orderItem" varStatus="i">
                            <tr>
                                <td class="text-center">${i.count}</td>
                                <td>
                                    <img class="img-fluid" src="assets/image/product/${orderItem.productId.id}/1.jpg" width="60"> ${orderItem.productId.name}
                                </td>
                                <td class="text-center">${orderItem.qty} ชิ้น</td>
                                <td class="text-center"><fmt:formatNumber value="${orderItem.price}" minFractionDigits="2" /> </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="2"></td>
                            <td class="text-center"><b><fmt:formatNumber value="${order.totalQty}" maxFractionDigits="0" /></b></td>
                            <td class="text-center"><b><fmt:formatNumber value="${order.totalPrice}" minFractionDigits="2" /></b></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <a href="history" class="btn btn-warning"><i class="fa fa-arrow-left"></i> Back</a>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>