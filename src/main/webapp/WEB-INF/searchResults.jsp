<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Your Profile" />
  </jsp:include>
  <title>Search Results</title>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />


<div class="container">
  <h1>Search Results</h1>

  <c:set var="searchResults" value="${requestScope.searchResults}" />
  <c:choose>
    <c:when test="${empty searchResults}">
      <p>No results found.</p>
    </c:when>
    <c:otherwise>
      <table class="table table-striped">
        <thead>
        <tr>
          <th>Title</th>
          <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${searchResults}" var="ad">
          <tr>
            <td>${ad.title}</td>
            <td>${ad.description}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:otherwise>
  </c:choose>
</div>
</body>
</html>