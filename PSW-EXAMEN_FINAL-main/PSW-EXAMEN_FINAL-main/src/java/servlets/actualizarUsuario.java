/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.AccionesCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;


public class actualizarUsuario extends HttpServlet {

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
            
            String nombre, appat, apmat, num_cel, num_casa, contrasena, usuario;
            int dia_nac, mes_nac, ano_nac, privilegio, id;
            
            usuario = request.getParameter("usuario_usu2");
            contrasena = request.getParameter("contra_usu2");
            nombre = request.getParameter("nom_usu2");
            appat = request.getParameter("apat_usu2");
            apmat = request.getParameter("amat_usu2");
            num_cel = request.getParameter("cel_usu2");
            num_casa = request.getParameter("tel_usu2");
            
            id = Integer.parseInt(request.getParameter("id2"));
            dia_nac = Integer.parseInt(request.getParameter("dia_usu2"));
            mes_nac = Integer.parseInt(request.getParameter("mes_usu2"));
            ano_nac = Integer.parseInt(request.getParameter("ano_usu2"));
            privilegio = Integer.parseInt(request.getParameter("privilegio_usu2"));
            
            Cliente c = new Cliente();
            
            c.setId(id);
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
            
            int estatus = AccionesCliente.ActualizarUsuario(c);
            
            if(estatus > 0){
            
                response.sendRedirect("ConsultarUsuarios.jsp");
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
