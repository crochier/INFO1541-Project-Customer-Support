
<head>
    <title>Create A new Ticket</title>
</head>
<body>
<a href="<c:url value='/login'>
    <c:param name='logout'/>
    </c:url> ">logout</a>
    <h2>
        Submit a new ticket
    </h2>
    <form method="POST" action="tickets" enctype="multipart/form-data" >
        <input type="hidden" name="action" value="create">
        Customer Name: <br>
        <input type="text" name="customerName" > <br><br>
        Subject: <br>
        <input type="text" name="subject" > <br><br>
        Problem: <br>
        <textarea name="ticketBody" rows="10" cols="50" > </textarea> <br><br>
        <b> Attachments </b> <br>
        <input type="file" name="attachment"> <br><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
