<%-- 
    Document   : index
    Created on : Aug 14, 2015, 7:57:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="GreetingServlet" method="POST">
            First Name: <input name="txtfname" size="20" /><br>
            Last Name: <input name="txtlname" size="20" /><br>
            <br>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
