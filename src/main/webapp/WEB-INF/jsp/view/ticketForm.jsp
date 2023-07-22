
<head>
    <title>Create A new Ticket</title>
</head>
<body>
<a href="<c:url value='/logout/'/>">logout</a>
    <h2>
        Submit a new ticket
    </h2>
    <form method="POST" action="create" modelAttribute="ticket" enctype="multipart/form-data" >
        <form:label path="customerName">name:</form:label><br>
        <form:input path="customerName"></form:input><br><br>
        <form:label path="ticketSubject">subject:</form:label><br>
        <form:input path="ticketSubject"></form:input><br><br>
        <form:label path="ticketBody">problem:</form:label><br>
        <form:textarea path="ticketBody" rows="10" cols="50"/><br><br>
        <form:label path="attachments"><b>attachments:</b><br></form:label>
        <form:input path="attachments" type="file"/><br><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
