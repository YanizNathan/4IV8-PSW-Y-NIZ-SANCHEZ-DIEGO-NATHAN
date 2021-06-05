/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.AccionesCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;


public class GuardarCliente extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
                        
            /*
            Vamos a crear la sesion de ese usuario
            
            */
            
            HttpSession sesionCli = request.getSession(true);
            
            //obtener los datos de la sesion
            
            String idsesion = sesionCli.getId();
            
            long fechacreacion = sesionCli.getCreationTime();
            
            long fechaultimoacceso = sesionCli.getLastAccessedTime();
            
            /*
            Vamos a crear una "cookie" que se encargara de almacenar los datos
            de la sesion
            
            */
            
            Integer cuenta = (Integer)sesionCli.getAttribute("cuenta.ss");
            
            if(cuenta == null){
                //es la primera vez que entra
                cuenta = new Integer(1);
            }else{
                cuenta = new Integer(cuenta.intValue()+1);
            }
            
            //si es la primera vez que entra o si ha entrado con anterioridad
            
            sesionCli.setAttribute("cuenta.ss", cuenta);
            
            //vamos a saber que se esta almacenando en la cuenta
            
            System.out.println("Sesion: " + idsesion);
            System.out.println("Fecha en que fue creada: " + new Date(fechacreacion).toString());
            System.out.println("Fecha de ultimo acceso: " + new Date(fechaultimoacceso).toString());
            
            //vamos a obtener todos los parametros del hasmap
            
            Enumeration nombreParametros = sesionCli.getAttributeNames();
            while(nombreParametros.hasMoreElements()){
                String parametros = (String)nombreParametros.nextElement();
                Object valor = sesionCli.getAttribute(parametros);
                System.out.println("El parametro es: " + parametros 
                        + "Su valor es: " + valor.toString());
            }
            
            
            String nombre, appat, apmat, num_cel, num_casa, contrasena, usuario;
            int dia_nac, mes_nac, ano_nac, privilegio;
            
            usuario = request.getParameter("usuario_usu");
            contrasena = request.getParameter("contra_usu");
            nombre = request.getParameter("nom_usu");
            appat = request.getParameter("apat_usu");
            apmat = request.getParameter("amat_usu");
            num_cel = request.getParameter("cel_usu");
            num_casa = request.getParameter("tel_usu");
            
            dia_nac = Integer.parseInt(request.getParameter("dia_usu"));
            mes_nac = Integer.parseInt(request.getParameter("mes_usu"));
            ano_nac = Integer.parseInt(request.getParameter("ano_usu"));
            privilegio = Integer.parseInt(request.getParameter("privilegio_usu"));
            
            Cliente c = new Cliente();
            
            c.setUsuario(usuario);
            c.setContrasena(contrasena);
            c.setNombre(nombre);
            c.setAppat(appat);
            c.setApmat(apmat);
            c.setNum_cel(num_cel);
            c.setNum_casa(num_casa);
            c.setDia_nac(dia_nac);
            c.setMes_nac(mes_nac);
            c.setAno_nac(ano_nac);
            c.setPrivilegio(privilegio);
            
            int estatus = AccionesCliente.RegistarCliente(c);
            
            if(estatus > 0){
            
                response.sendRedirect("RegistrarCliente.jsp");
            }else{
                response.sendRedirect("Error.jsp");
            }
            
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
