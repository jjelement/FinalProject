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
            <div class="alert alert-success">
                <h3 class="mt-2"><i class="fa fa-check"></i> ส่งข้อความแล้ว</h3>
                <hr>
                <p>
                    ขอบคุณที่สนใจในบริการของ <span class="bg-light px-1">LUI SHOP</span><br>
                    เจ้าหน้าที่จะทำการตอบกลับข้อความของท่านทางอีเมลล์
                </p>
                <a href="home" class="btn btn-info btn-sm"><i class="fa fa-home"></i> กลับหน้าหลัก</a>
            </div>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>