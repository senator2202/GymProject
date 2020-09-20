<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
<form name="loginForm" action="/mainController">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <label>
        <input type="text" name="login" value=""/>
    </label><br/>
    Password:<br/>
    <label>
        <input type="text" name="password" value=""/>
    </label><br/>
    ${authResult}<br/>
    <input type="submit" value="Login"/>
</form>
<br/>
<form action="/mainController">
    <input type="hidden" name="command" value="open_page"/>
    <input type="hidden" name="page_path" value="/jsp/register.jsp"/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
