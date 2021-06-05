

<%@page import="modelo.Cliente"%>
<%@page import="control.AccionesCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mi perfil</h1>
        
                <form method="post" name="ActualizarUsuario" action="actualizarMiPerfil">
            <%
                    String numcel = request.getParameter("numcel");
                    Cliente c = AccionesCliente.ConsultarClienteByNum(numcel);
                    
                %>
                <br>
                <input type="text" name="usuario_usu2" value="<%=c.getUsuario()%>" placeholder="Ingresa nombre de usuario">
                <br>
                <input type="password" name="contra_usu2" value="<%=c.getContrasena()%>" placeholder="Ingresa contraseña">
                <br>
                <input type="text" name="nom_usu2" value="<%=c.getNombre()%>" placeholder="Ingresa nombre">
                <br>
                <input type="text" name="apat_usu2" value="<%=c.getAppat()%>" placeholder="Ingresa apellido paterno">
                <br>
                <input type="text" name="amat_usu2" value="<%=c.getApmat()%>" placeholder="Ingresa apellido materno">
                <br>
                <input type="number" name="dia_usu2" value="<%=c.getDia_nac()%>" placeholder="Ingresa dia de nacimiento">
                <br>
                <input type="number" name="mes_usu2" value="<%=c.getMes_nac()%>" placeholder="Ingresa mes de nacimiento">
                <br>
                <input type="number" name="ano_usu2" value="<%=c.getAno_nac()%>" placeholder="Ingresa año de nacimiento">
                <br>
                <input type="text" name="cel_usu2" value="<%=c.getNum_cel()%>" placeholder="Ingresa numero de celular">
                <br>
                <input type="text" name="tel_usu2" value="<%=c.getNum_casa()%>" placeholder="Ingresa numero de casa">
                <br>
                <input type="text" name="privilegio_usu2" value="<%=c.getPrivilegio()%>" placeholder="Ingresa privilegio">
                <br>
                <input type="submit" value="Actualizar">
        </form>
        
    </body>
</html>
