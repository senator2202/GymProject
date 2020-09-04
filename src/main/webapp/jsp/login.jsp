<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
<form name="loginForm" method="post" action="${pageContext.request.contextPath}/mainController">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" value=""/><br/>
    Password:<br/>
    <input type="text" name="password" value=""/><br/>
    ${authResult}<br/>
    <input type="submit" value="Login"/>
</form>
<br/>
<a href="${pageContext.request.contextPath}/jsp/register.jsp">Register</a>
</body>
</html>
