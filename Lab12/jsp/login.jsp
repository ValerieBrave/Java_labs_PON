<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Login</h3>
<form method="post" action="j_security_check">
    username <input type="text" name="j_username" />
    password <input type="password" name="j_password" />
    <input type="submit" />
</form>
</body>
</html>