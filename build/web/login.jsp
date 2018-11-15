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
            <h1 class="display-4">Login <small class="text-muted" style="font-size: 24px">- เข้าสู่ระบบ</small></h1>
            <hr>
            <form action="login" method="POST">
                <div class="form-group row">
                    <label for="email" class="col-sm-3 col-form-label text-right">Email :</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email" name="email" placeholder="youremail@example.com" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-sm-3 col-form-label text-right">Password :</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Your Password" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-sm-3 col-sm-4">
                        <button type="submit" class="btn btn-outline-success btn-block"><i class="fa fa-sign-in-alt"></i> Login</button>
                    </div>
                    <div class="col-sm-2">
                        <a class="btn btn-outline-info btn-block" href="register"><i class="fa fa-user-plus"></i> Register</a>
                    </div>
                </div>
            </form>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>

