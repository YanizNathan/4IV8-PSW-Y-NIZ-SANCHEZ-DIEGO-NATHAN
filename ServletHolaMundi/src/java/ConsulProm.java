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

public class ConsulProm extends HttpServlet {
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    public void init(ServletConfig cfg) throws ServletException{
        String URL = "jdbc:mysql://us-cdbr-east-03.cleardb.com/heroku_d889ba9407b37bc";
        String userName = "b6feddf2b85dcc";
        String password = "25b467ec";
                
        try{
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta | Ben & Jerry's</title>");
            out.println("<link rel=\"stylesheet\" href=\"./css/estilo2.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class=\"title\">Tabla de Promociones</h1>");
            out.println("<table class=\"tabla2\" border='2'>"
                    + "<thead>"
                        + "<th>ID</th>"
                        + "<th>Nombre</th>"
                        
                        + "<th>Tipo</th>"
                    + "</thead>");
            try{
                //codigo java para la consulta
                String name, size, recipiente, tipo;
                int id, price, gram;
                
                //tenemos que crear la querry
                
                String q = "select * from promociones";
                
                set = con.createStatement();
                rs = set.executeQuery(q);
                
                while(rs.next()){
                    //mientras exista un registro hay que obtener los datos de la consulta
                    id = rs.getInt("id_prom");
                    name = rs.getString("nom_prom");
                    price = rs.getInt("price_prom");
                   
                    
                    out.println("<tbody>"
                            + "<tr><td>"+id+"</td>"
                            + "<td>"+name+"</td>"
                            + "<td>"+price+"</td>"
                           
                            + "</tbody>");
                }
                //hay que cerrar los hilos
                rs.close();
                set.close();
                
                System.out.println("¡Consulta exitosa!");
                    
            }catch(Exception e){
                System.out.println("Error al realizar la consulta.");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            out.println("</table>");
            out.println("<br>");
            out.println("<a class=\"link1\" href='index.html'>Regresar a la página principal.</a>");
            out.println("</body>");
            out.println("</html>");
        }
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