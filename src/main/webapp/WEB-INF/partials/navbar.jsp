<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <style>

    .navbar-icon {
        height: 3em;
        width: auto;
        vertical-align: middle;
    }
</style>
    <title></title>
</head>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">CarlsList</a>
        <img src="${pageContext.request.contextPath}/images/carl.png" alt="icon" class="navbar-icon">
        </div>



        <ul class="nav navbar-nav navbar-right">
            <% request.getAttribute("user"); %>

            <c:if test="${user == null}">
                <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
                <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
            </c:if>

            <c:if test="${user != null}">

                <div class="navbar-form navbar-left">
                    <form class="form-inline" action="${pageContext.request.contextPath}/searchResults" method="GET">
                        <div class="form-group">
                            <input class="form-control" type="search" name="title" placeholder="Search Ad" aria-label="Search">
                        </div>
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>

                <li><a href="${pageContext.request.contextPath}/profile">My Profile</a></li>
                <li><a href="${pageContext.request.contextPath}/ads">View Ads</a></li>
                <li><a href="${pageContext.request.contextPath}/ads/create">Create Ad</a></li>
                <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </c:if>
        </ul>
    </div>
</nav>
