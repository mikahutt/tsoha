<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sisäänkirjautuminen</title>
    </head>
    <body>
        <form action="osallistu" method="POST">

            <label>Käyttäjätunnus: <input type="text" name="tunnus" /></label>
            <label>Salasana: <input type="password" name="salasana" /></label>
            <input type="submit" />
        </form>
    </body>
</html>