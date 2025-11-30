<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Search Results</title></head>
<body>
<h1>Search Results</h1>
<ul>
    <c:forEach var="petition" items="${results}">
        <li>
            <a href="/owenspetitions/petition/${petition.id}">${petition.title}</a>
            - ${petition.description}
        </li>
    </c:forEach>
</ul>
<a href="/owenspetitions/search">Back to Search</a>
</body>
</html>