<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container d-flex justify-content-between">
            <a class="navbar-brand" href="home"><i class="fa fa-shopping-bag"></i> LUI-SHOP</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-list"></i> Brand
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <c:forEach items="${brands}" var="brand">
                                <a class="dropdown-item" href="brand?id=${brand.id}">
                                    ${brand.name}
                                </a>
                            </c:forEach>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact">
                            <i class="fa fa-envelope"></i> Contact Us
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="cart"><i class="fa fa-shopping-cart"></i><span class="badge">(${cart.totalQuantity})</span></a>
                    </li>
                    <c:choose>
                        <c:when test="${user != null}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-user"></i>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="history">
                                        <i class="far fa-clock"></i> History
                                    </a>
                                    <a class="dropdown-item" href="profile">
                                        <i class="fa fa-pencil-alt"></i> Edit Profile
                                    </a>
                                    <a class="dropdown-item" href="logout">
                                        <i class="fa fa-sign-out-alt"></i> Logout
                                    </a>
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="login"><i class="fa fa-sign-in-alt"></i> Login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="register"><i class="fa fa-user-plus"></i> Register</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    
                </ul>
            </div>
        </div>
    </nav>
</header>