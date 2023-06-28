<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>

<% List<Ad> searchResults = (List<Ad>) request.getAttribute("searchResults");
  if (searchResults.isEmpty()) { %>
<p>No results found.</p>
<% } else { %>
<ul>
  <% for (Ad ad : searchResults) { %>
  <li>
    <h3><%= ad.getTitle() %></h3>
    <p><%= ad.getDescription() %></p>
    <p>Posted by: <%= ad.getUsername() %></p> <!-- Assuming the Ad class has a getUsername() method -->
  </li>
  <% } %>
</ul>
<% } %>
</body>
</html>