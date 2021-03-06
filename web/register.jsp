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
            <h1 class="display-4">Register <small class="text-muted" style="font-size: 24px">- สมัครสมาชิก</small></h1>
            <hr>
            <%@include file="components/alert.jsp" %>
            <form action="register" method="POST">
                <div class="form-group row">
                    <label for="email" class="col-sm-3 col-form-label text-right">Email* :</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email" name="email" placeholder="youremail@example.com" required value="${email}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-sm-3 col-form-label text-right">Password* :</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Your Password" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password_confirmation" class="col-sm-3 col-form-label text-right">Confirm Password* :</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password_confirmation" name="password_confirmation" placeholder="Confirm Password" required>
                    </div>
                </div>
                <hr>
                <div class="form-group row">
                    <label for="firstName" class="col-sm-3 col-form-label text-right">First Name :</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="firstName" name="firstName" value="${firstName}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lastName" class="col-sm-3 col-form-label text-right">Last Name :</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="lastName" name="lastName" value="${lastName}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="mobileNumber" class="col-sm-3 col-form-label text-right">Tel Number :</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="mobileNumber" name="mobileNumber" placeholder="0999999999" value="${mobileNumber}">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-sm-3 col-sm-4">
                        <button type="submit" class="btn btn-outline-success btn-block"><i class="fa fa-user-plus"></i> Register</button>
                    </div>
                    <div class="col-sm-2">
                        <a class="btn btn-outline-info btn-block" href="login"><i class="fa fa-sign-in-alt"></i> Login</a>
                    </div>
                </div>
            </form>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>

