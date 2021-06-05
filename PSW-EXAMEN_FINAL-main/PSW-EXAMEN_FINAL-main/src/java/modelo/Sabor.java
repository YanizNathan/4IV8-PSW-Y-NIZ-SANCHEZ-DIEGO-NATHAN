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


public class Sabor {
    
    int id_sabor;
    String sabor;

    public int getId_sabor() {
        return id_sabor;
    }

    public void setId_sabor(int id_sabor) {
        this.id_sabor = id_sabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    
    
        public static List<Sabor> ConsultarAllSabores(){
        
            List<Sabor> lista = new ArrayList<Sabor>();
            
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select sabor from sabor";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Sabor s = new Sabor();
                s.setSabor(rs.getString(1));
                lista.add(s);
            }

            System.out.println("Sabores encontrados");
            con.close();

        }catch(Exception ed){
            System.out.println("Sabores no encontrados");
            System.out.println(ed.getMessage());
        
        }return lista;
    }
    
    
}
