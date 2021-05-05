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

public class EditarProd extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //variables
            String nom, tam, reci, tipo;
            int id, gram, price;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editarUsuario</title>");
           
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class=\"title\">Editar Datos del producto</h1>");
            out.println("<br>");
            try{
                //proceso para actualizar datos
                nom=request.getParameter("nombrepd");
                price = Integer.parseInt(request.getParameter("pricepd"));
                gram =Integer.parseInt(request.getParameter("grampd"));
                tam = request.getParameter("tamañopd");
                reci = request.getParameter("recipientepd");
                tipo= request.getParameter("tipopd");
                id=Integer.parseInt(request.getParameter("idpd"));

                String qN="UPDATE helados SET name_hel = '"+nom+"' WHERE id_hel = "+id;
                String qP="UPDATE helados SET price_hel = '"+price+"' WHERE id_hel = "+id;
                
                String qG="UPDATE helados SET gram_hel = '"+gram+"' WHERE id_hel = "+id;
                String qT="UPDATE helados SET size_hel = "+tam+" WHERE id_hel = "+id;
                String qR="UPDATE helados SET recipiente_hel = '"+reci+"' WHERE id_hel = "+id;
                String qS="UPDATE helados SET tipo_hel = '"+tipo+"' WHERE id_hel = "+id;
           
                
            
            
                //actualizacion del nombre
                //set=con.createStatement();
                set.executeUpdate(qN);
                
                //actualizacion del apellido paterno
                //set=con.createStatement();
                set.executeUpdate(qP);
                
                //actualizacon del apellido materno
                //set=con.createStatement();
                set.executeUpdate(qG);
                
                //actualizacion de la edad
                //set=con.createStatement();
                set.executeUpdate(qT);
                
                //actualizacion del correo
                //set=con.createStatement();
                set.executeUpdate(qR);
                //set=con.createStatement();
                set.executeUpdate(qS);
                
                System.out.println("Actualización de datos Exitosa");
                
            }catch(Exception e){
                System.out.println("Actualización de datos Fallida");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            
           
            
            out.println("</table>");
            out.println("<a class=\"link1\" href='index.html'>Regresar a la pagina principal </a>");
            out.println("<br>");
            out.println("<a class=\"link2\" href='Consultar'>Consultar datos de usuarios </a>");
            out.println("</body>");
            out.println("</html>");
        };
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}