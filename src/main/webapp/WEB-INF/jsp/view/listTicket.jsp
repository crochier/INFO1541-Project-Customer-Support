
<html>
<head>
    <title>List of tickets</title>
</head>
<body>
    <h2>List of tickets</h2>
    <a href="tickets?action=create">create ticket</a> <br><br>
    <c:choice>
        <c:when test="${allTickets.size() == 0}">
            <p>there are no blog posts yet...</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="ticket" items="${allTickets}">
                Ticket Number <c:out val="${ticket.key}"/>
                <a href="<c:url value='/tickets'>
                   <c:param name='action' value='view' />
                   <c:param name='ticketID' value='${ticket.key}'/>
                   </c:url>">
                    <c:out value="${ticket.value.ticketSubject}"/>
                </a><br>
            </c:forEach>
        </c:otherwise>
    </c:choice>
</body>
</html>
