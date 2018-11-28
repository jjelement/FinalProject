<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/head.jsp" %>
    </head>

    <body>
        <%@include file="components/header.jsp" %>

        <main role="main" class="container">
            <h1 class="display-4">Edit Profile <small class="text-muted" style="font-size: 24px">- แก้ไขโปรไฟล์</small></h1>
            <hr>
            <form action="profile" method="POST">
                <div class="form-group row">
                    <label for="email" class="col-sm-3 col-form-label text-right">Email :</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email" name="email" disabled value="${user.email}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="firstName" class="col-sm-3 col-form-label text-right">First Name :</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="firstName" name="firstName" value="${user.firstName}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lastName" class="col-sm-3 col-form-label text-right">Last Name :</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="lastName" name="lastName" value="${user.lastName}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="mobileNumber" class="col-sm-3 col-form-label text-right">Tel Number :</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="mobileNumber" name="mobileNumber" value="${user.mobileNumber}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-sm-3 col-form-label text-right">Address :</label>
                    <div class="col-sm-6">
                        <textarea class="form-control" name="address" id="address" rows="4">${user.address}</textarea>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="offset-sm-3 col-sm-6">
                        <button type="submit" class="btn btn-outline-success btn-block"><i class="fa fa-check"></i> Save Profile</button>
                    </div>
                </div>
            </form>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>