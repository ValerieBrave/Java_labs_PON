<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<html>
<head>
    <title>
    </title>
</head>
<body>
<h3>Init params</h3>
<%=pageContext.getServletContext().getInitParameter("URL1")%><br/>
<%=pageContext.getServletContext().getInitParameter("URL2")%>

</body>
</html>