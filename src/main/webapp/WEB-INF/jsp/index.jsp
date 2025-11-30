<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Knocknacarra Community Webpage</title></head>
<body>
<h1>Welcome to Knocknacarra Community Webpage</h1>
<nav>
    <a href="/owenspetitions/create">Create Petition</a> |
    <a href="/owenspetitions/view">View Petitions</a> |
    <a href="/owenspetitions/search">Search Petitions</a>
</nav>
<ul>
    <c:forEach var="petition" items="${petitions}">
        <li><a href="/owenspetitions/petition/${petition.id}">${petition.title}</a></li>
    </c:forEach>
</ul>
</body>
</html>