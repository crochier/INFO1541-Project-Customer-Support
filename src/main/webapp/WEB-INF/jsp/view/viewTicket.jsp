<html>
    <head>
        <title>Ticket</title>
    </head>
    <body>
    <a href="<c:url value='/logout'/>">Log Out</a>
        <h2>Ticket # <c:out value="${ticketID}"/></h2>
        <p>Subject:  <c:out value="${ticket.ticketSubject}"/><br></p>
        <p>Customer Name:  <c:out value="${ticket.customerName}"/><br/></p>
        <p>Body:  <c:out value="${ticket.ticketBody}"/><br></p>
        <p>Number of Attachments: <c:out value="${ticket.getNumberOfAttachments()}"/></p><br>
        <c:if test="${ticket.getNumberOfAttachments()>0}">
            <p>Attachments: </p>
            <c:forEach var="attachment" items="${ticket.attachments}">
                <a href="<c:url value='/tickets/${ticketID}/attachment/${attachment.value.name}' />">

                <c:out value="${attachment.value.name}"/></a>
            </c:forEach>
        </c:if>
        <br><br>
        <a href="<c:url value='/tickets/listTickets'/>">Return to ticket list</a>
    </body>
</html>

