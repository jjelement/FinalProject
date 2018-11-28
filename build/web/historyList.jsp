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
            <h1 class="display-4 mb-4">History <small class="text-muted" style="font-size: 24px">- ประวัติการสั่งซื้อ</small></h1>
            <div class="table-responsive">
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th class="text-center">#</th>
                            <th>Date</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Qty</th>
                            <th class="text-center">View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${orderList.size() > 0}">
                                <c:forEach items="${orderList}" var="order" varStatus="i">
                                    <tr>
                                        <td class="text-center">${i.count}</td>
                                        <td><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${order.createdAt}" /> </td>
                                        <td class="text-center"><fmt:formatNumber value="${order.totalPrice}" minFractionDigits="2" /> </td>
                                        <td class="text-center">${order.totalQty} ชิ้น</td>
                                        <td class="text-center"><a href="history?id=${i.count}" class="btn btn-info"><i class="fa fa-search"></i></a></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5" class="text-center"><i>ไม่มีประวัติการสั่งซื้อ</i></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>

                    </tbody>
                </table>
            </div>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>