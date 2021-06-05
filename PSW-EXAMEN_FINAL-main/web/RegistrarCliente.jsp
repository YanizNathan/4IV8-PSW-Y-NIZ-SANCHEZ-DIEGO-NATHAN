

<%@page contentType="text/html" import="java.util.*" session="true" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Iniciar Sesión</h1>
        
        <form method="post" name="IniciarSesionCliente" action="VerificarUsuario">
            
            <br>
            <input type="text" name="usuario_cli" placeholder="Ingresa nombre de usuario">
            <br>
            <input type="password" name="contra_cli" placeholder="Ingresa contraseña">
            <br>
            <input type="submit" value="Iniciar sesión">
            
        </form>
        
    </body>
</html>
