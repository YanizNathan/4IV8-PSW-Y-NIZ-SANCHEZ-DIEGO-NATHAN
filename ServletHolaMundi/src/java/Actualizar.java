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
       String URL = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_3dcf7b914574222";
       
        String userName = "b6feddf2b85dcc";
        String password = "25b467ec";
                
        try{
            //tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("¡Conexión exitosa!");
        }catch(Exception e){
            System.out.println("Conexión no exitosa.");
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
            String name, size, recipiente, tipo;
            int id, price, gram;
            id=Integer.parseInt(request.getParameter("idactualizar"));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualización  | Ben & Jerry's</title>");
            out.println("<link rel=\"stylesheet\" href=\"./CSS/estilo.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"containerRegistro\">");
            out.println("<table border='2'>"
                    + "<thead>"
                        + "<th>ID</th>"
                        + "<th>Nombre</th>"
                        + "<th>Precio</th>"
                        + "<th>Gramos</th>"
                        + "<th>Tamaño</th>"
                        + "<th>Recipiente</th>"
                        + "<th>Tipo</th>"
                    + "</thead>");
            try{
                //mostramos los datos de el id del usuario ingresado en el index
                String q="select * from helados where id_hel="+id;
                set=con.createStatement();
                rs=set.executeQuery(q);
                while(rs.next()){
                    id = rs.getInt("id_hel");
                    name = rs.getString("name_hel");
                    price = rs.getInt("price_hel");
                    gram = rs.getInt("gram_hel");
                    size = rs.getString("size_hel");
                    recipiente = rs.getString("recipiente_hel");
                    tipo = rs.getString("tipo_hel");
                    out.println("<tbody>"
                            + "<td>"+id+"</td>"
                            + "<td>"+name+"</td>"
                            + "<td>"+price+"</td>"
                            + "<td>"+gram+"</td>"
                            + "<td>"+size+"</td>"
                            + "<td>"+recipiente+"</td>"
                            + "<td>"+tipo+"</td></tr>"
                            + "</tbody>");
                }  
            }catch(Exception e){
                System.out.println("Consulta no exitosa.");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            out.println("</table>");
            out.println("<br>");
            out.println("<div class=\"containerRegistro\">");
            out.println("<form name=\"datos_act\" method=\"get\" action=\"EditarProd\" onsubmit=\"return validarDatosA(this)\">"
                    + "<div class=\"user-details\">"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Nombre</span>"
                    + "<input type=\"text\" name=\"nombrepd\" placeholder=\"Digite el nombre actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Precio</span>"
                    + "<input type=\"number\" name=\"pricepd\" placeholder=\"Digite el precio actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Gramos</span>"
                    + "<input type=\"number\" name=\"grampd\" placeholder=\"Digite los gramos actualizados\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Tamaño</span>"
                    + "<input type=\"text\" name=\"tamañopd\" placeholder=\"Digite el tamaño actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Recipiente</span>"
                    + "<input type=\"text\" name=\"recipientepd\" placeholder=\"Digite el recipiente actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">Tipo</span>"
                    + "<input type=\"text\" name=\"tipopd\" placeholder=\"Digite el tipo actualizado\" required>"
                    + "</div>"
                    + "<div class=\"input-box\">"
                    + "<span class=\"details\">ID</span>"
                    + "<input type=\"number\" name=\"idpd\" placeholder=\"Digite el mismo ID\" required>"
                    + "</div>"
                    + "<div class=\"button\">"
                    + "<input type=\"submit\" value=\"Actualizar datos\">"
                    + "</div>"
                    + "</form>"
                    + "</div>"
                    + "<br>");
            out.println("</div>");
            out.println("<a href='index.html'>Regresar a la pagina principal.</a>");
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