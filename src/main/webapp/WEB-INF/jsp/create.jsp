<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Create Petition</title></head>
<body>
<h1>Create a New Petition</h1>
<form action="/owenspetitions/create" method="post">
    <label>Title: <input type="text" name="title"/></label><br/>
    <label>Description: <textarea name="description"></textarea></label><br/>
    <button type="submit">Submit</button>
</form>
<a href="/owenspetitions/">Back to Home</a>
</body>
</html>