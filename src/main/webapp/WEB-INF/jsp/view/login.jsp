
<html>
<head>
    <title>Ticket Login</title>
</head>
<body>
    <h2>
        login
    </h2>
    you must login to access the ticket management system <br><br>
    <c:if test="${loginFailed==true}">
        <b><c:out value="The username or password are not correct. Please try again."></c:out> </b> <br><br>
    </c:if>
    <form method="post" action="<c:url value='/login'/> ">
        Username: <input type="text" name="username"> <br><br>
        Password: <input type="password" name="password"> <br><br>
        <input type="submit" value="login">
    </form>
</body>
</html>
