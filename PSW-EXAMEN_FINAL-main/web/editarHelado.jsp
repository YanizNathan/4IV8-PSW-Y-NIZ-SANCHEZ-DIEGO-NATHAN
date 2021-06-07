

<%@page import="modelo.Sabor"%>
<%@page import="modelo.Precio"%>
<%@page import="modelo.Promocion"%>
<%@page import="modelo.Contenedor"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Helado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" type="image/x-icon" href="https://comodibujar.club/wp-content/uploads/2020/09/kawaii-helado.jpg">
        <link rel="stylesheet" href="./CSS/tablas.css">
    </head>
    <body>
        <h1 align="center">Actualizar helados</h1>
        <form method="post" name="actualizarHelados" action="actualizarHelado">
            <table>
                <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    Helado h = Helado.ConsultarHeladoById(id);
                    
                %>
                
                <thead>
                    <tr>
                        <th></th>
                        <th>Sabor</th>
                        <th>Contenedor</th>
                        <th>Promoción</th>
                        <th>Precio</th>
                    </tr>
                    
                </thead>
                <tbody>
                      
                        <tr>
                            <td>
                                <input type="hidden" name="id2" value="<%=h.getId()%>">
                            </td>
                            <td>
                                <select name="sabor_hel2">
                                <%
                                List<Sabor> lista = Sabor.ConsultarAllSabores();
                                for(Sabor s: lista){
                                %>
                                    <option><%=s.getSabor()%></option>
                                <%}%>
                            </td>
                            
                            <td>
                                <select name="cont_hel2">
                                <%
                                List<Contenedor> listados = Contenedor.ConsultarAllContenedores();
                                for(Contenedor k: listados){
                                %>
                                    <option><%=k.getContenedor()%></option>
                                <%}%>
                            </td>
                            
                            <td>
                                <select name="promo_hel2">
                                <%
                                List<Promocion> listatres = Promocion.ConsultarAllPromociones();
                                for(Promocion r: listatres){
                                %>
                                    <option><%=r.getPromocion()%></option>
                                <%}%>
                            </td>
                            
                            <td>
                                <select name="precio_hel2">
                                <%
                                List<Precio> listacuatro = Precio.ConsultarAllPrecios();
                                for(Precio p: listacuatro){
                                %>
                                    <option><%=p.getPrecio()%></option>
                                <%}%>
                            </td>
                            
                        </tr>
                        <tr>
                            <td colspan="4">
                                <input type="submit" value="Actualizar helado">
                            </td>
                        </tr>
                </tbody>
            </table>
        </form>
                    
        <br>
        <a href="ConsultarHelados.jsp">Cancelar</a>
        
    </body>
</html>
