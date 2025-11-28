<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>View Petitions</title></head>
<body>
<h1>All Petitions</h1>
<ul>
    <c:forEach var="petition" items="${petitions}">
        <li>
            <a href="/petition/${petition.id}">${petition.title}</a>
            - ${petition.description}
        </li>
    </c:forEach>
</ul>
<a href="/">Back to Home</a>
</body>
</html>