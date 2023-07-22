<c:set var = "now" value="<%=System.currentTimeMillis()%>"/>
<html>
<head>
    <title>Ticket Sessions Admin</title>
</head>
<body>
    <a href="<c:url value='/logout/'/>">logout</a>
    <h2>Sessions</h2>
    There are a total of <c:out value="${numSessions}"/> active sessions going on.
    <ul>
        <c:forEach items="${sessionList}" var="s">
            <li><c:out value="${s.id} - ${s.getAttribute('username')} - last active ${(now-s.getLastAccessedTime())/1000} seconds ago "/></li>
        </c:forEach>
    </ul>
</body>
</html>
