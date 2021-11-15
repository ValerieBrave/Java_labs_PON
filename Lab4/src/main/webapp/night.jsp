<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %><%--
  Created by IntelliJ IDEA.
  User: Валерия Смелова
  Date: 10.10.2021
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Night</title>
</head>
<body>
<%
    BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java_labs\\Lab4\\src\\main\\logs\\stdout.txt", true));
    writer.write("Night");
    writer.append("\n");
    writer.close();
%>
<h1>Night</h1>
</body>
</html>
