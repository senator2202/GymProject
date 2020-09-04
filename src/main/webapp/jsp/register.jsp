<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
<form name="loginForm" method="post" action="/mainController">
    <input type="hidden" name="command" value="register"/>
    Login:<br/>
    <input type="text" name="login" value=""/><br/>
    Password:<br/>
    <input type="text" name="password" value=""/><br/>
    ${authResult}<br/>
    <input type="submit" value="Register"/>
</form
</body>
</html>
