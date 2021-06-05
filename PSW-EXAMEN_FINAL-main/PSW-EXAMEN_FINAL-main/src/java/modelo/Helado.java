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


public class Helado {
    
    String sabor, contenedor;
    int promocion, precio, id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getContenedor() {
        return contenedor;
    }

    public void setContenedor(String contenedor) {
        this.contenedor = contenedor;
    }

    public int getPromocion() {
        return promocion;
    }

    public void setPromocion(int promocion) {
        this.promocion = promocion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    public static int RegistarHelado(Helado h){
    
        int estatus = 0;
        
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "insert into helado(sabor, contenedor, promocion, precio) values(?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, h.getSabor());
            ps.setString(2, h.getContenedor());
            ps.setInt(3, h.getPromocion());
            ps.setInt(4, h.getPrecio());
            
            estatus = ps.executeUpdate();

            System.out.println("Registro helado exitoso");
            con.close();

        }catch(Exception ed){
            System.out.println("Error al registrar helado");
            System.out.println(ed.getMessage());
        
        }return estatus;
    }
    
    
           
            public static List<Helado> ConsultarAllHelados(){
        
            List<Helado> lista = new ArrayList<Helado>();
            
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select * from helado";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Helado h = new Helado();
                h.setId(rs.getInt(1));
                h.setSabor(rs.getString(2));
                h.setContenedor(rs.getString(3));
                h.setPromocion(rs.getInt(4));
                h.setPrecio(rs.getInt(5));
                lista.add(h);
            }

            System.out.println("Helados encontrado");
            con.close();

        }catch(Exception ed){
            System.out.println("Helados no encontrados");
            System.out.println(ed.getMessage());
        
        }return lista;
    }
    
    
            public static Helado ConsultarHeladoById(int id){
        
            Helado h = new Helado();
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select * from helado where id_helado = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            
                h.setId(rs.getInt(1));
                h.setSabor(rs.getString(2));
                h.setContenedor(rs.getString(3));
                h.setPromocion(rs.getInt(4));
                h.setPrecio(rs.getInt(5));
                
            }

            System.out.println("Helado encontrado");
            con.close();

        }catch(Exception ed){
            System.out.println("Heladp no encontrado");
            System.out.println(ed.getMessage());
        
        }return h;
    }
            
    
    public static int ActualizarHelado(Helado h){
    
        int estatus = 0;
        
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "update helado set sabor=?, contenedor=?, promocion=?, precio=? where id_helado = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, h.getSabor());
            ps.setString(2, h.getContenedor());
            ps.setInt(3, h.getPromocion());
            ps.setInt(4, h.getPrecio());
            ps.setInt(5, h.getId());
            
            estatus = ps.executeUpdate();

            System.out.println("Actualización del helado exitosa");
            con.close();

        }catch(Exception ed){
            System.out.println("Error al actualizar helado");
            System.out.println(ed.getMessage());
        
        }return estatus;
    }
    
    
    public static int BorrarHelado(int id){
    
        int estatus = 0;
        
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "delete from helado where id_helado = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            estatus = ps.executeUpdate();

            System.out.println("Borrado helado exitoso");
            con.close();

        }catch(Exception ed){
            System.out.println("Error al borrar helado");
            System.out.println(ed.getMessage());
        
        }return estatus;
    }
            
}
