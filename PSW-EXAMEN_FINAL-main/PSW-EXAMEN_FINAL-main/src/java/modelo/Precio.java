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


public class Precio {
    
    int id_precio, precio;

    public int getId_precio() {
        return id_precio;
    }

    public void setId_precio(int id_precio) {
        this.id_precio = id_precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    public Precio(){
        
    }
    
    
        public static List<Precio> ConsultarAllPrecios(){
        
            List<Precio> listacuatro = new ArrayList<Precio>();
            
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select precio from precio";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Precio p = new Precio();
                p.setPrecio(rs.getInt(1));
                listacuatro.add(p);
            }

            System.out.println("Precios encontrados");
            con.close();

        }catch(Exception ed){
            System.out.println("Precios no encontrados");
            System.out.println(ed.getMessage());
        
        }return listacuatro;
    }
    
    
}
