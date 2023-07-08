<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Ticket</title>
</head>
<body>
    <h2> Ticket Number <c:out value="${idString}" /></h2>
    <p>Subject: <c:out value="${ticket.ticketSubject}"/><br> </p>
    <p>Customer Name: <c:out value="${ticket.customerName}" /><br> </p>
    <p>Body: <c:out value="${ticket.ticketBody}"/><br> </p>
    <p>Number of Attachments: <c:out value="${ticket.getNumberOfAttachments()}"/><br> </p>
    <c:if test="${ticket.getNumberOfAttachments()>0}">
        <p>Attachments:</p>
        <c:forEach var="attachment" items="${ticket.attachment}">
            <a href="c:url value='/tickets'>
            <c:param name='action' value='download'/>
            <c:param name='ticketID' value='${idString}'/>
            <c:param name='attachment' value='${attachment.value.name}'/>
            </c:url>"
            <c:out value="${attachment.value.name}" />


        </c:forEach>
    </c:if>
</body>
</html>
