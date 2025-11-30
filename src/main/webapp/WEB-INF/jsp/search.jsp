<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Search Petitions</title></head>
<body>
<h1>Search Petitions</h1>
<form action="/owenspetitions/search" method="post">
    <label>Keyword: <input type="text" name="keyword"/></label>
    <button type="submit">Search</button>
</form>
<a href="/owenspetitions/">Back to Home</a>
</body>
</html>