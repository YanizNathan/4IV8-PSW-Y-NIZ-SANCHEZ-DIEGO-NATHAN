<%-- 
    Document   : sesiondelusuario
    Created on : 10/06/2021, 07:51:00 PM
    Author     : aza06
--%>
<%@page import="Modelo.Usuario"%>
<%@page import="Control.AccionesUsuario"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="Servlet.actualizarUsuario"%>
<%@page import="Servlet.usuarioActualizar"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/icon.png" type="image/png">
    <link rel="stylesheet" href="style.css">
    <title>Salud.Maps | Tu cuenta</title>
    
</head>
    <body>
        <header>
       <ul>
           <li><img src="img/logo_lateral_negro.png" alt="El logo del servicio."></li>
            <%
    String usuario = "";
    HttpSession sesionuok = request.getSession();
    if(sesionuok.getAttribute("usuario")==null){
    
    %> 
           <li><a href="index.jsp"><b>Buscar</b></a></li> 
           <li><a href="#" class="active"><b>Tu cuenta</b></a></li>
           
            <%
    
    }else{
     %>
           <li><a href="index.jsp"><b>Buscar</b></a></li>
           <li><a href="favoritos.jsp"><b>Favoritos</b></a></li>
           <li><a href="#" class="active"><b>Tu cuenta</b></a></li>
           <li><a href="cerrarSesion"><b>Cerrar sesion</b></a></li>
            <li class="Nombre"><%  PrintWriter pw= response.getWriter();
        pw.println("<br><li class='Nombre' color:'red' align='center'>"+sesionuok.getAttribute("usuario")+"</li><br>");%><li>
           
           <%
    }
    %>
       </ul> 
    </header>  
        
        <div class="cuadro_lugares">
               <h1>Ingresa los nuevos datos que quieras actualizar de tu cuenta.</h1>
        <br>
        <form method="post" name="usuarioActualizar" action="usuarioActualizar">
                    <table border="2" >
                        <%
                           
                            
                            Usuario e = AccionesUsuario.buscarUsuarioByNom(sesionuok.getAttribute("usuario").toString());
                            %>
                            <tr>
                                <td> Id: </td>
                                <td> <input  name="id_usu2" value="<%=e.getId_usu()%>" readonly></input></td>
                            </tr>
                            <tr>
                           
                            
                            <td>Nombre:</td>
                            <td><input type="text" name="nom_usu2" size="30" value="<%=e.getNom_usu()%>"></td>        
                        </tr>
                        <tr>
                            <td>Contraseña:</td>
                            <td><input type="password" name="con_usu2" size="30" value="<%=e.getCon_usu()%>" ></td>        
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="email" name="ema_usu2" size="30" value="<%=e.getEma_usu()%>" ></td>        
                        </tr>

                        <tr>
                            <td colspan="2" ><input type="submit" value="Actualizar Usuario"></td>
                        </tr>        
                    </table>
                   
                </form>
                        
                       
   
<footer>
       
      <div class="container-footer-all">
       
           <div class="container-body">

               <div class="colum1">
                   <h1>Mas informacion de la compañia</h1>

                   <p>Para poder tener nustra informacion ir al siguiente link:.</p>
                        <a href="./quienes.html">Quienes somos?</a>
               </div>

               <div class="colum2">

                   <h1>Redes Sociales</h1>

                   <div class="row2">
                       <img src="img/facebook.png">
                       <label>Siguenos en Facebook</label>
                   </div>
                   <div class="row2">
                       <img src="img/twitter.png">
                       <label>Siguenos en Twitter</label>
                   </div>
                   <div class="row2">
                       <img src="img/instagram.png">
                       <label>Siguenos en Instagram</label>
                   </div>
                   <div class="row2">
                       <img src="img/google-plus.png">
                       <label>Siguenos en Google Plus</label>
                   </div>
                   <div class="row2">
                       <img src="img/pinterest.png">
                       <label>Siguenos en Pinterest</label>
                   </div>


               </div>

               <div class="colum3">

                   <h1>Informacion Contactos</h1>

                   <div class="row2">
                       <img src="img/house.png">
                       <label>Centro de Estudios Cientificos y Tecnologicos
                             N 9° "Juan De Dios Batiz"
                       </label>
                   </div>

                   <div class="row2">
                       <img src="img/smartphone.png">
                       <label>+52 1 55 7895 2487</label>
                   </div>

                   <div class="row2">
                       <img src="img/contact.png">
                        <label>equipodosmasuno@gmail.com</label>
                   </div>

               </div>

           </div>
       
       </div>
       
       <div class="container-footer">
              <div class="footer">
                   <div class="copyright">
                       © 2021 Todos los Derechos Reservados | <a href="">DataJockey</a>
                   </div>

                   <div class="information">
                       <a href="">Informacion Compañia</a> | <a href="">Privacion y Politica</a> | <a href="">Terminos y Condiciones</a>
                   </div>
               </div>

           </div>
       
   </footer>
    </body>
</html>