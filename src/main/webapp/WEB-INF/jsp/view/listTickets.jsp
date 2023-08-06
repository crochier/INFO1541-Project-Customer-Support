<html>
<head>
    <title>List of Tickets</title>
</head>
<body>
        <a href="<c:url value='/logout'/>">Log Out</a>
    <h2>List of tickets</h2>
    <a href="<c:url value='/tickets/create'/>">Create Ticket</a><br><br>
    <c:choose>
        <c:when test="${allTickets.size() == 0}">
            <p>There are no tickets yet....</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="ticket" items="${allTickets}">
                Ticket # <c:out value="${ticket.id}"/>
                <a href="<c:url value='/tickets/view/${ticket.id}' />">
                <c:out value="${ticket.ticketSubject}"/></a><br>
            </c:forEach>
        </c:otherwise>
   </c:choose>

</body>
</html>
