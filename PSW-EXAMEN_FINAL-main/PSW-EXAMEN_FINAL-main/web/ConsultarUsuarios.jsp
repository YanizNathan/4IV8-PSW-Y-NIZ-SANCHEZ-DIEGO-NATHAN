
<%@page import="modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="control.AccionesCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Uusarios</h1>
        
                <table>
            <thead>
                <tr>
                    
                    <th>Usuario</th>
                    <th>Contraseña</th>
                    <th>Nombre</th>
                    <th>Apellido paterno</th>
                    <th>Apellido materno</th>
                    <th>Dia de nacimiento</th>
                    <th>Mes de nacimiento</th>
                    <th>Año de nacimiento</th>
                    <th>Número de celular</th>
                    <th>Número de casa</th>
                    <th>Privilegio</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            
            <tbody>
                
                    <%List<Cliente> lista = AccionesCliente.ConsultarAllClientes();
                      for(Cliente h:lista){
                    %>
                    <tr>
                        <td>
                            <%=h.getUsuario()%>
                        </td>
                        <td>
                            <%=h.getContrasena()%>
                        </td>
                        <td>
                            <%=h.getNombre()%>
                        </td>
                        <td>
                            <%=h.getAppat()%>
                        </td>
                        <td>
                            <%=h.getApmat()%>
                        </td>
                        <td>
                            <%=h.getDia_nac()%>
                        </td>
                        <td>
                            <%=h.getMes_nac()%>
                        </td>
                        <td>
                            <%=h.getAno_nac()%>
                        </td>
                        <td>
                            <%=h.getNum_cel()%>
                        </td>
                        <td>
                            <%=h.getNum_casa()%>
                        </td>
                        <td>
                            <%=h.getPrivilegio()%>
                        </td>
                        
                        <td>
                            <a href="editarUsuario.jsp?id=<%=h.getId()%>">Editar</a>
                        </td>
                        <td>
                            <a href="borrarUsuario?id=<%=h.getId()%>">Borrar</a>
                        </td>
                        </tr>
                    <%
                      }
                    %>
                  
            </tbody>
        </table>
        
    </body>
</html>
