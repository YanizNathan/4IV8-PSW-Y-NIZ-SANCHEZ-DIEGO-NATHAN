

<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" language="java" import="java.util.*" session="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            
            .container{
                display: flex;
            }
            
        </style>
        
    </head>
    <body>
 
        <%
        String usuario = "";
        HttpSession sesionOK = request.getSession();
        if(sesionOK.getAttribute("usuario")==null){
            
        %>
        <jsp:forward page="">
            <jsp:param name="error" value="Es obligatorio identificarse"/>
        </jsp:forward>
        
        <%
        }else{
            usuario = (String)sesionOK.getAttribute("usuario");
        }
        %>
        
        
            <h1>Helados Benny and jerry</h1>
            <a href="Close">Cerrar Sesión</a>
        <div>
            <div class="izquierda">
                <%Cliente c = new Cliente();%>
                <form method="post" action="ConsultarMiPerfil.jsp">
                
                <p>Ingrese su número de celular</p>
                <input name="numcel" placeholder="Número de celular">
                <input type="submit" value="Consultar perfil"></a>
                </form>
            </div>
            <div class="derecha"></div>
        </div>
        
        
        
    </body>
</html>
