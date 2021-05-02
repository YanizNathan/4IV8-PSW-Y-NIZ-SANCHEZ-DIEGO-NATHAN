import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

public class Actualizar extends HttpServlet {
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    public void init(ServletConfig cfg) throws ServletException{
        //lo primero que necesitamos es trazar la ruta al servidor de la bd
        String URL = "jdbc:mysql://localhost/registro4iv8";
        //driver:gestor:puerto//ip/nombreBD
        String userName = "root";
        String password = "vaquero24";
                
        try{
            //tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            System.out.println("Conexión no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //variables
            String nom, appat, apmat, correo;
            int id, edad;
            id=Integer.parseInt(request.getParameter("idactualizar"));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualización de datos</title>");
            out.println("<link rel=\"stylesheet\" href=\"./CSS/estilo.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"containerRegistro\">");
            out.println("<table border='2'>"
                    + "<thead>"
                        + "<tr><th>ID</th>"
                        + "<th>Nombre completo</th>"
                        + "<th>Edad</th>"
                        + "<th>Correo electrónico</th></tr>"
                    + "</thead>");
            try{
                //mostramos los datos de el id del usuario ingresado en el index
                String q="select * from mregistro where id_usu="+id;
                set=con.createStatement();
                rs=set.executeQuery(q);
                while(rs.next()){
                    id = rs.getInt("id_usu");
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    apmat = rs.getString("apmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("correo_usu");
                    out.println("<tbody>"
                            + "<tr><td>"+id+"</td>"
                            + "<td>"+nom+" "+appat+" "+apmat+"</td>"
                            + "<td>"+edad+"</td>"
                            + "<td>"+correo+"</td></tr>"
                            + "</tbody>");
                }  
            }catch(Exception e){
                System.out.println("Consulta no exitosa");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            out.println("</table>");
            out.println("<br>");
            out.println("<a href='index.html'>Regresar a la pagina principal </a>");
            out.println("<div class=\"containerRegistro\">");
            out.println("<form name=\"datos_act\" method=\"get\" action=\"editarUsuario\" onsubmit=\"return validarDatosA(this)\">"
                    + "<div class=\"user-details\">"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Nombre</span>"
                    + "<input type=\"text\" name=\"nombrea\" placeholder=\"Digite el nombre actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Correo electrónico</span>"
                    + "<input type=\"email\" name=\"correoa\" placeholder=\"Digite el correo electrónico actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Apellido paterno</span>"
                    + "<input type=\"text\" name=\"appata\" placeholder=\"Digite el apellido paterno actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Apellido materno</span>"
                    + "<input type=\"text\" name=\"apmata\" placeholder=\"Digite el apellido materno actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Edad</span>"
                    + "<input type=\"number\" name=\"edada\" placeholder=\"Digite la edad actualizada\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">ID</span>"
                    + "<input type=\"number\" name=\"ida\" placeholder=\"Digite el mismo ID\" required>"
                    + "</div>"
                    + "<div class=\"button\">"
                    + "<input type=\"submit\" value=\"Actualizar datos\">"
                    + "</div>"
                    + "</form>"
                    + "</div>"
                    + "<br>");
            out.println("</div>");
            out.println("<script src=\"./JS/validacion.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}