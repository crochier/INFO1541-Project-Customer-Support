
<html>
<head>
    <title>List of tickets</title>
</head>
<body>
    <a href="<c:url value='/login'>
    <c:param name='logout'/>
    </c:url> ">logout</a>
    <h2>List of tickets</h2>
    <a href="tickets?action=create">create ticket</a> <br><br>
    <c:choose>
        <c:when test="${allTickets.size() == 0}">
            <p>there are no tickets yet...</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="ticket" items="${allTickets}">
                Ticket Number <c:out value="${ticket.key}"/>
                <a href="<c:url value='/tickets'>
                   <c:param name='action' value='view' />
                   <c:param name='ticketID' value='${ticket.key}'/>
                   </c:url>">
                    <c:out value="${ticket.value.ticketSubject}"/>
                </a><br>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>
