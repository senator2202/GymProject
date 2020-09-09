<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<FORM>
    ${authResult}
</FORM>
<hr/>
<form action="mainController">
    <input type="hidden" name="command" value="logout"/><br/>
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
