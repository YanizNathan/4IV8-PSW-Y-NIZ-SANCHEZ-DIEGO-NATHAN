

<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" language="java" import="java.util.*" session="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="" type="image/x-icon" href="https://comodibujar.club/wp-content/uploads/2020/09/kawaii-helado.jpg">
  
        <title>JSP Page</title>
        
        <style>
            
            .container{
                display: flex;
            }
            
        </style>
        <link rel="stylesheet" href="./CSS/usuario.css">
        
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
        
        <div class="dtitle">
            <h1 align="center" class="titulo">Helados Benny and jerry</h1>
        </div>    
        <hr>
        <div>
            <div>
                <%Cliente c = new Cliente();%>
                <form method="post" action="ConsultarMiPerfil.jsp">
                <p align="center">Consulta de perfil</p>
                <p align="center">Ingrese su número de celular</p>
              
                <input name="numcel" placeholder="Número de celular">
                <input type="submit" class="consulta" value="Consultar perfil"></a>
                <br>
                <br>
                <br>
                  <a href="Close" class="cerrar">Cerrar Sesión</a>
                </form>
            </div>
            <div class="derecha"></div>
        </div>
       
        
        
    </body>
</html>
