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
            <h1 class="display-4">Contact Us <small class="text-muted" style="font-size: 24px">- ติดต่อเรา</small></h1>
            <hr>
            <%@include file="components/alert.jsp" %>
            <form action="contact" method="POST">
                <div class="form-group row">
                    <label for="email" class="col-sm-3 col-form-label text-right">Email* :</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email" name="email" placeholder="youremail@example.com" required value="${email}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="message" class="col-sm-3 col-form-label text-right">Message :</label>
                    <div class="col-sm-6">
                        <textarea class="form-control" name="message" id="message" rows="5" required></textarea>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="offset-sm-3 col-sm-6">
                        <button type="submit" class="btn btn-outline-success btn-block"><i class="fa fa-user-plus"></i> Send Message</button>
                    </div>
                </div>
            </form>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>

