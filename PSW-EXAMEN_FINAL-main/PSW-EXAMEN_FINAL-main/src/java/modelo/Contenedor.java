/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Contenedor {
    
    int id_cont;
    String contenedor;

    public int getId_cont() {
        return id_cont;
    }

    public void setId_cont(int id_cont) {
        this.id_cont = id_cont;
    }

    public String getContenedor() {
        return contenedor;
    }

    public void setContenedor(String contenedor) {
        this.contenedor = contenedor;
    }
    
    
    
        public static List<Contenedor> ConsultarAllContenedores(){
        
            List<Contenedor> listados = new ArrayList<Contenedor>();
            
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select contenedor from contenedor";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Contenedor k = new Contenedor();
                k.setContenedor(rs.getString(1));
                listados.add(k);
            }

            System.out.println("contenedores encontrados");
            con.close();

        }catch(Exception ed){
            System.out.println("contenedores no encontrados");
            System.out.println(ed.getMessage());
        
        }return listados;
    }
    
    
}
