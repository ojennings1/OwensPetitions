<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>View Petitions</title></head>
<body>
<h1>All Petitions</h1>

<table border="1" cellpadding="5">
    <tr>
        <th>Petition Name</th>
        <th>Petition Description</th>
        <th>Created Date</th>
        <th>Closing Date</th>
    </tr>
    <c:forEach var="petition" items="${petitions}">
        <tr>
            <td><a href="/petition/${petition.id}">${petition.title}</a></td>
            <td>${petition.description}</td>
            <td>${petition.createdDate}</td>
            <td>${petition.closingDate}</td>
        </tr>
    </c:forEach>
 </table>
 <br>
<a href="/">Back to Home</a>
</body>
</html>