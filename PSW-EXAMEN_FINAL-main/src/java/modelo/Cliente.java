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
import java.sql.SQLException;


public class Cliente {
    
    String nombre, appat, apmat, num_cel, num_casa, usuario, contrasena;
    int dia_nac, mes_nac, ano_nac, id, privilegio;

    public Cliente(){
    
    }
    
    public int getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getNum_cel() {
        return num_cel;
    }

    public void setNum_cel(String num_cel) {
        this.num_cel = num_cel;
    }

    public String getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(String num_casa) {
        this.num_casa = num_casa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getDia_nac() {
        return dia_nac;
    }

    public void setDia_nac(int dia_nac) {
        this.dia_nac = dia_nac;
    }

    public int getMes_nac() {
        return mes_nac;
    }

    public void setMes_nac(int mes_nac) {
        this.mes_nac = mes_nac;
    }

    public int getAno_nac() {
        return ano_nac;
    }

    public void setAno_nac(int ano_nac) {
        this.ano_nac = ano_nac;
    }
    

    public Cliente verificarUsuario(String usuario, String contrasena){
    
        Cliente c = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
        
            con = Conexion.getConnection();
            String q = "Select * from usuario where usuario = ? and contrasena = ?";
            
            ps = con.prepareStatement(q);
            
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                c = new Cliente();
                c.setId(rs.getInt("id_usu"));
                c.setUsuario(rs.getString("usuario"));
                c.setContrasena(rs.getString("contrasena"));
                c.setNombre(rs.getString("nombre"));
                c.setAppat(rs.getString("appat"));
                c.setApmat(rs.getString("apmat"));
                c.setDia_nac(rs.getInt("dia_nac"));
                c.setMes_nac(rs.getInt("mes_nac"));
                c.setDia_nac(rs.getInt("dia_nac"));
                c.setAno_nac(rs.getInt("ano_nac"));
                c.setNum_cel(rs.getString("num_cel"));
                c.setNum_casa(rs.getString("num_par"));
                c.setPrivilegio(rs.getInt("privilegio"));
                
                break;
            }
            
        }catch(SQLException sq){
        
            System.out.println("Error al consultar el cliente");
            System.out.println(sq.getMessage());
            c = null;
            
        }finally{
        
            try{
            
                rs.close();
                ps.close();
                con.close();
                
            }catch(Exception e){
            
                System.out.println("No encontramos la clase");
                System.out.println(e.getMessage());
            }
            
        }
        return c;        
    }
    

}
