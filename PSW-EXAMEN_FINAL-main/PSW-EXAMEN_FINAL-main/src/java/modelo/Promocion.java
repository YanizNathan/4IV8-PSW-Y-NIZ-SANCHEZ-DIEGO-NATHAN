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


public class Promocion {
    
    int id_promo, promocion;

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public int getPromocion() {
        return promocion;
    }

    public void setPromocion(int promocion) {
        this.promocion = promocion;
    }
    
    
            public static List<Promocion> ConsultarAllPromociones(){
        
            List<Promocion> listatres = new ArrayList<Promocion>();
            
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select promocion from promocion";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Promocion r = new Promocion();
                r.setPromocion(rs.getInt(1));
                listatres.add(r);
            }

            System.out.println("Promociones encontrados");
            con.close();

        }catch(Exception ed){
            System.out.println("Promociones no encontrados");
            System.out.println(ed.getMessage());
        
        }return listatres;
    
}
}
