<html>
<head>
    <title>Create a new ticket</title>
</head>

    <body>
    <a href="<c:url value='/logout'/>">Log Out</a>
        <h2>Submit a new ticket</h2>

        <form:form method="post" action="create" modelAttribute="ticket" enctype="multipart/form-data">
            <form:label path="customerName">Title:</form:label><br>
            <form:input path="customerName"/><br><br>
            <form:label path="ticketSubject">Subject:</form:label><br>
            <form:input path="ticketSubject"/><br><br>
            <form:label path="ticketBody">Problem:</form:label><br>
            <form:textarea path="ticketBody" rows="10" cols="50"/><br><br>
            <form:label path="attachments"><b>Attachments:</b><br></form:label>
            <form:input type="file" path="attachments"/><br><br>
            <input type="submit" value="Submit">
        </form:form>


    </body>
</html>

