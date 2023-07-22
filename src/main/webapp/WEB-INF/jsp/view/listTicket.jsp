
<html>
<head>
    <title>List of tickets</title>
</head>
<body>
    <a href="<c:url value='/logout'/>">logout</a>
    <h2>List of tickets</h2>
    <a href="<c:url value='/tickets/create'/>">create ticket</a> <br><br>
    <c:choose>
        <c:when test="${allTickets.size() == 0}">
            <p>there are no tickets yet...</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="ticket" items="${allTickets}">
                Ticket Number <c:out value="${ticket.key}"/>
                <a href="<c:url value='/tickets/view/${ticket.key}'/>">
                    <c:out value="${ticket.value.ticketSubject}"/> <br><br>
                </a>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>
