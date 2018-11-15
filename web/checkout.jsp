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
            <h1 class="display-4 mb-4">Checkout <small class="text-muted" style="font-size: 24px">- ตรวจสอบข้อมูล</small></h1>
            
            <hr>
            <div class="text-right">
                <a href="checkout" class="btn btn-success btn-lg"><i class="fa fa-check"></i> Confirm</a>
            </div>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>