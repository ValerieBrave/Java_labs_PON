<%@ page import="smelova.lab4.TimeHelper" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab 4</title>
</head>
<body>
<%TimeHelper timeHelper = new TimeHelper();%>
<%--1--%>
<%timeHelper.PrintHello(timeHelper.getHour());%>

<%String includeName = timeHelper.GetTimeName(timeHelper.getHour()) +".jsp";%>

<h1><%=timeHelper.getRc()%></h1>
<%----%>
<hr>
<%----%>
<%--2--%>
<%
    Calendar calendar = Calendar.getInstance();
    int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
%>
<table id="tbl" ></table>
<script>
    function createTable() {
        <%
          StringBuilder htmlValue = new StringBuilder();
          String wDay = "";
          htmlValue
              .append("<tr>")
              .append("<th>").append("dd.mm.yyyy").append("</th>")
              .append("<th>").append("day of week").append("</th>")
              .append("</tr>");
          for (int i = 0; i < 7; i++) {
            int day = 24*60*60*1000*i;
            switch (weekDay) {
                case 1: wDay = "7"; break;
                case 2: wDay = "1"; break;
                case 3: wDay = "2"; break;
                case 4: wDay = "3"; break;
                case 5: wDay = "4"; break;
                case 6: wDay = "5"; break;
                case 7: wDay = "6"; break;
            }
            htmlValue
              .append("<tr>")
              .append("<td>").append(dateFormat.format(new Date(calendar.getTimeInMillis() + day))).append("</td>")
              .append("<td>").append(wDay).append("</td>")
              .append("</tr>");
            weekDay = (weekDay % 7) + 1;
          }
        %>
        document.getElementById("tbl").innerHTML += "<%= htmlValue %>";
    }

    createTable();

</script>
<hr>
<%--5--%>
<%if (includeName.equals("night.jsp")) {%>
<%@ include file="night.jsp" %>
<% } %>

<%if (includeName.equals("morning.jsp")) {%>
<%@ include file="morning.jsp" %>
<% } %>

<%if (includeName.equals("afternoon.jsp")) {%>
<%@ include file="afternoon.jsp" %>
<% } %>

<%if (includeName.equals("evening.jsp")) {%>
<%@ include file="evening.jsp" %>
<% } %>


<form action="<%= includeName %>" method="get">
    <button type="submit">Press</button>
</form>
<hr>
<%--6--%>
<jsp:include page="<%= includeName %>"/>
<hr>
<%--7--%>
<jsp:include page="/Afternoon"/>
<hr>
<%--8--%>
<%--<jsp:forward page="<%= includeName %>"/>--%>

<%--11--%>
<form action="Jjj" method="post">
    <button type="submit">POST to Jjj</button>
</form>
<a href="Jjj">GET to Jjj</a>
</body>
</html>