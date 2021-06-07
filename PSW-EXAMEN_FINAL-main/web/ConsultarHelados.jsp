
<%@page import="java.util.List"%>
<%@page import="modelo.Helado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./CSS/tablas.css">
        <link rel="shortcut icon" type="image/x-icon" href="https://comodibujar.club/wp-content/uploads/2020/09/kawaii-helado.jpg">
    </head>
    <body>
        <h1 align="center">Helados</h1>
        <table align="center">
            <thead>
                <tr>
                    <th>Sabor</th>
                    <th>Contenedor</th>
                    <th>Promoción</th>
                    <th>Precio</th>
                </tr>
            </thead>
            
            <tbody>
                
                    <%List<Helado> lista = Helado.ConsultarAllHelados();
                      for(Helado h:lista){
                    %>
                    <tr>
                        <td>
                            <%=h.getSabor()%>
                        </td>
                        <td>
                            <%=h.getContenedor()%>
                        </td>
                        <td>
                            <%=h.getPromocion()%>
                        </td>
                        <td>
                            <%=h.getPrecio()%>
                        </td>
                        <td>
                            <a href="editarHelado.jsp?id=<%=h.getId()%>">Editar</a>
                        </td>
                        <td>
                            <a href="borrarHelado?id=<%=h.getId()%>">Borrar</a>
                        </td>
                        </tr>
                    <%
                      }
                    %>
                  
            </tbody>
        </table>
                    
        <br>
        <a href="principalAdmin.jsp">Regresar</a>
        
    </body>
</html>
