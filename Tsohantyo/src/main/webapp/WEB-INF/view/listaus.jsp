<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Oluen tiedot</title>
    </head>
    <body>
        <p>Ei Yhtään oluita lisätty kun et sä sitä osaa tehdä </p>
        <form:form commandName="olut" action="${pageContext.request.contextPath}/olut" method="POST">
            Id: <form:input path="id" />
            Name: <form:input path="name" />
            <input type="submit" /> 
        </form:form>
    </body>
</html>
