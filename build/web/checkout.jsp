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
            <form action="checkout" method="POST">
                <div class="row">
                    <div class="offset-md-1 col-md-5 col-sm-6">
                        <div class="form-group">
                            <label for="firstName">First Name :</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" value="${user.firstName}" required>
                        </div>
                    </div>
                    <div class="col-md-5 col-sm-6">
                        <div class="form-group">
                            <label for="lastName">Last Name :</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" value="${user.lastName}" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="offset-md-1 col-md-5 col-sm-6">
                        <div class="form-group">
                            <label for="firstName">Province :</label>
                            <select name="province" class="form-control" required>
                                <option value="">เลือกจังหวัด</option>
                                <option value="1">กรุงเทพมหานคร</option>
                                <option value="2">ต่างจังหวัด</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-5 col-sm-6">
                        <div class="form-group">
                            <label for="area">Area :</label>
                            <input type="text" class="form-control" id="area" name="area" placeholder="ระบุเขต" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="offset-md-1 col-md-5 col-sm-6">
                        <div class="form-group">
                            <label for="district">District :</label>
                            <input type="text" class="form-control" id="district" name="district" placeholder="ระบุแขวง" required>
                        </div>
                    </div>
                    <div class="col-md-5 col-sm-6">
                        <div class="form-group">
                            <label for="zipCode">Zip Code :</label>
                            <input type="text" class="form-control" id="zipCode" name="zipCode" placeholder="ระบุรหัสไปรษณีย์" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="offset-md-3 col-md-6 col-sm-12">
                        <div class="form-group">
                            <label for="address">Address :</label>
                            <textarea class="form-control" name="address" id="address" placeholder="Your Address" rows="4">${user.address}</textarea>
                        </div>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="offset-md-3 col-md-6 col-sm-12 text-center">
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="visa" name="bank" class="custom-control-input" required>
                            <label class="custom-control-label" for="visa">
                                <img src="assets/image/visa.png" class="img-fluid" style="height: 32px;">
                            </label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="kbank" name="bank" class="custom-control-input">
                            <label class="custom-control-label" for="kbank">
                                <img src="assets/image/kbank.png" class="img-fluid" style="height: 32px;">
                            </label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="scb" name="bank" class="custom-control-input">
                            <label class="custom-control-label" for="scb">
                                <img src="assets/image/scb.png" class="img-fluid" style="height: 32px;">
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-11 text-right">
                        <button type="submit" class="btn btn-success btn-lg"><i class="fa fa-check"></i> Confirm</button>
                    </div>
                </div>
            </form>
        </main>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/javascript.jsp" %>
    </body>
</html>