<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">CarlsList</a>
        </div>
        
        <ul class="nav navbar-nav navbar-right">
            <% request.getAttribute("user"); %>

            <c:if test="${user == null}">
                <li><a href="/register">Register</a></li>
                <li><a href="/login">Login</a></li>
            </c:if>

            <c:if test="${user != null}">

                <form class="d-flex" action="/searchResults" method="GET">
                    <input class="form-control me-2" type="search" name="title"  placeholder="Search Ad" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>

                <li><a href="/profile">My Profile</a></li>
                <li><a href="/ads">View Ads</a></li>
                <li><a href="/ads/create">Create Ad</a></li>
                <li><a href="/logout">Logout</a></li>
            </c:if>
        </ul>
    </div>
</nav>