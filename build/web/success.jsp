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
                <h2 class="mt-2"><strong><i class="fa fa-check"></i> SUCCESS</strong> <small>- สั่งซื้อสินค้าเสร็จสิ้น</small></h2>
                <hr>
                <p>
                    ระบบจะทำการตรวจสอบ และจัดนำส่งตามที่อยู่ที่ท่านระบุ ภายใน 1-2 วัน<br>
                    ขอบคุณที่ใช้บริการ <span class="bg-light px-1">LUI SHOP</span>
                </p>
                <a href="home" class="btn btn-info btn-sm"><i class="fa fa-home"></i> กลับหน้าหลัก</a>
            </div>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>