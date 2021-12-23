<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lab9.CBean" %>
<html>
<head>
    <title>Ccc.jsp</title>
</head>
<body>
<%
    CBean objFromReq = (CBean) request.getAttribute("atrCBean");
    CBean objFromSess = (CBean) request.getSession().getAttribute(request.getSession().getId());
%>
<h2>Values from attribute of request</h2>

<div>
    <label><%=objFromReq != null? objFromReq.getValue1() : null %>
    </label>
    <label><%=objFromReq != null? objFromReq.getValue2() : null %>
    </label>
    <label><%=objFromReq != null? objFromReq.getValue3() : null %>
    </label>
</div>

<h2>Values from attribute of session</h2>

<div>
    <label><%=objFromSess != null? objFromSess.getValue1() : null %>
    </label>
    <label><%=objFromSess != null? objFromSess.getValue2() : null %>
    </label>
    <label><%=objFromSess != null? objFromSess.getValue3() : null %>
    </label>
</div>
</body>
</html>