<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Petition Details</title></head>
<body>
<h1>${petition.title}</h1>
<p>${petition.description}</p>

<h2>Signatures</h2>
<ul>
    <c:forEach var="signature" items="${petition.signatures}">
        <li>${signature.name} (${signature.email})</li>
    </c:forEach>
</ul>

<h2>Add Your Signature</h2>
<form action="/owenspetitions/petition/${petition.id}/sign" method="post">
    <label>Name: <input type="text" name="name"/></label><br/>
    <label>Email: <input type="text" name="email"/></label><br/>
    <button type="submit">Sign Petition</button>
</form>

<a href="/owenspetitions/view">Back to Petitions</a>
</body>
</html>