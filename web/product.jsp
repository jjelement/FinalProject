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
            <h1 class="display-4">PUREBOOST RBL SHOES</h1>
            <hr>
            <div class="row">
                <div class="col-md-5">
                    <img class="img-thumbnail mb-3" src="image/sn1.jpg" alt="PUREBOOST RBL SHOES">
                    <div class="row">
                        <div class="col-3">
                            <img class="img-fluid" src="image/sn1.jpg" alt="PUREBOOST RBL SHOES">
                        </div>
                        <div class="col-3">
                            <img class="img-fluid" src="image/sn1.jpg" alt="PUREBOOST RBL SHOES">
                        </div>
                        <div class="col-3">
                            <img class="img-fluid" src="image/sn1.jpg" alt="PUREBOOST RBL SHOES">
                        </div>
                        <div class="col-3">
                            <img class="img-fluid" src="image/sn1.jpg" alt="PUREBOOST RBL SHOES">
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris justo dolor, consectetur sit amet viverra vel, iaculis at dolor. Nunc vitae ante et lorem facilisis laoreet. Proin elementum justo libero, eget ullamcorper odio condimentum vel. Etiam ut lectus et odio maximus ultrices. Nulla at nisl varius, dignissim velit eget, consequat augue. Phasellus massa leo, gravida ut pellentesque et, laoreet lacinia arcu. Sed in tellus laoreet, suscipit nisi vel, viverra lorem. Curabitur vel mi rutrum, elementum sem quis, maximus metus. Pellentesque iaculis lobortis orci ut ullamcorper. Pellentesque habitant morbi tristique senectus
                    </p>
                    <hr>
                    <h4 class="text-success">Price: 100 Baht</h4>
                    <form action="#" method="POST" class="form-inline mt-3">
                        <input type="number" class="form-control form-control-sm mb-2" value="1" placeholder="Amount">
                        <button type="submit" class="btn btn-primary btn-sm ml-md-2 mb-2"><i class="fa fa-cart-arrow-down"></i> Add To Cart</button>
                    </form>
                </div>
            </div>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>

