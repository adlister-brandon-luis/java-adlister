<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>

<c:set var="searchResults" value="${requestScope.searchResults}" />
<c:choose>
  <c:when test="${empty searchResults}">
    <p>No results found.</p>
  </c:when>
  <c:otherwise>
    <ul>
      <c:forEach items="${searchResults}" var="ad">
        <h3>${ad.title}</h3>
        <p>${ad.description}</p>
      </c:forEach>
    </ul>
  </c:otherwise>
</c:choose>
</body>
</html>