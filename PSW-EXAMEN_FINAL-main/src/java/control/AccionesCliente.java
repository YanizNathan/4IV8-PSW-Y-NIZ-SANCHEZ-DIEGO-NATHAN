/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Cliente;
import control.Conexion;
import java.util.ArrayList;
import java.util.List;


public class AccionesCliente {
    
    public static int RegistarCliente(Cliente c){
    
        int estatus = 0;
        
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "insert into usuario(usuario, contrasena, nombre, appat, apmat, dia_nac, mes_nac, ano_nac, num_cel, num_par, privilegio) values(?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, c.getUsuario());
            ps.setString(2, c.getContrasena());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getAppat());
            ps.setString(5, c.getApmat());
            ps.setInt(6, c.getDia_nac());
            ps.setInt(7, c.getMes_nac());
            ps.setInt(8, c.getAno_nac());
            ps.setString(9, c.getNum_cel());
            ps.setString(10, c.getNum_casa());
            ps.setInt(11, c.getPrivilegio());
            
            estatus = ps.executeUpdate();

            System.out.println("Registro usuario exitoso");
            con.close();

        }catch(Exception ed){
            System.out.println("Error al registrar cliente");
            System.out.println(ed.getMessage());
        
        }return estatus;
    }
    
    
    
        public static int ActualizarUsuario(Cliente c){
    
        int estatus = 0;
        
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "update usuario set usuario=?, contrasena=?, nombre=?, appat=?, apmat=?, dia_nac=?, mes_nac=?, ano_nac=?, num_cel=?, num_par=?, privilegio=? where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, c.getUsuario());
            ps.setString(2, c.getContrasena());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getAppat());
            ps.setString(5, c.getApmat());
            ps.setInt(6, c.getDia_nac());
            ps.setInt(7, c.getMes_nac());
            ps.setInt(8, c.getAno_nac());
            ps.setString(9, c.getNum_cel());
            ps.setString(10, c.getNum_casa());
            ps.setInt(11, c.getPrivilegio());
            ps.setInt(12, c.getId());
            
            estatus = ps.executeUpdate();

            System.out.println("Actualización del usuario exitosa");
            con.close();

        }catch(Exception ed){
            System.out.println("Error al actualizar usuario");
            System.out.println(ed.getMessage());
        
        }return estatus;
    }
    
        
    public static int ActualizarUsuarioByNum(Cliente c){
    
        int estatus = 0;
        
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "update usuario set usuario=?, contrasena=?, nombre=?, appat=?, apmat=?, dia_nac=?, mes_nac=?, ano_nac=?, num_par=?, privilegio=? where num_cel = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, c.getUsuario());
            ps.setString(2, c.getContrasena());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getAppat());
            ps.setString(5, c.getApmat());
            ps.setInt(6, c.getDia_nac());
            ps.setInt(7, c.getMes_nac());
            ps.setInt(8, c.getAno_nac());
            ps.setString(9, c.getNum_casa());
            ps.setInt(10, c.getPrivilegio());
            ps.setString(11, c.getNum_cel());
            
            estatus = ps.executeUpdate();

            System.out.println("Actualización del usuario exitosa");
            con.close();

        }catch(Exception ed){
            System.out.println("Error al actualizar usuario");
            System.out.println(ed.getMessage());
        
        }return estatus;
    }
    
        public static int BorrarUsuario(int id){
    
        int estatus = 0;
        
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "delete from usuario where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            estatus = ps.executeUpdate();

            System.out.println("Borrado cliente exitoso");
            con.close();

        }catch(Exception ed){
            System.out.println("Error al borrar cliente");
            System.out.println(ed.getMessage());
        
        }return estatus;
    }
        
        
        
        public static Cliente ConsultarClienteById(int id){
        
            Cliente c = new Cliente();
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select * from usuario where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            
                c.setId(rs.getInt(1));
                c.setUsuario(rs.getString(2));
                c.setContrasena(rs.getString(3));
                c.setNombre(rs.getString(4));
                c.setAppat(rs.getString(5));
                c.setApmat(rs.getString(6));
                c.setDia_nac(rs.getInt(7));
                c.setMes_nac(rs.getInt(8));
                c.setAno_nac(rs.getInt(9));
                c.setNum_cel(rs.getString(10));
                c.setNum_casa(rs.getString(11));
                c.setPrivilegio(rs.getInt(12));
                
            }

            System.out.println("Usuario encontrado");
            con.close();

        }catch(Exception ed){
            System.out.println("Usuario no encontrado");
            System.out.println(ed.getMessage());
        
        }return c;
    }
        
        
            public static List<Cliente> ConsultarAllClientes(){
        
            List<Cliente> lista = new ArrayList<Cliente>();
            
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select * from usuario";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setUsuario(rs.getString(2));
                c.setContrasena(rs.getString(3));
                c.setNombre(rs.getString(4));
                c.setAppat(rs.getString(5));
                c.setApmat(rs.getString(6));
                c.setDia_nac(rs.getInt(7));
                c.setMes_nac(rs.getInt(8));
                c.setAno_nac(rs.getInt(9));
                c.setNum_cel(rs.getString(10));
                c.setNum_casa(rs.getString(11));
                c.setPrivilegio(rs.getInt(12));
                lista.add(c);
            }

            System.out.println("Usuarios encontrado");
            con.close();

        }catch(Exception ed){
            System.out.println("Usuarios no encontrados");
            System.out.println(ed.getMessage());
        
        }return lista;
    }
            
            
            public static Cliente ConsultarClienteByNum(String numcel){
        
            Cliente c = new Cliente();
        try{
            
            Connection con = Conexion.getConnection();                   
            String q = "select * from usuario where num_cel = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, numcel);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            
                c.setId(rs.getInt(1));
                c.setUsuario(rs.getString(2));
                c.setContrasena(rs.getString(3));
                c.setNombre(rs.getString(4));
                c.setAppat(rs.getString(5));
                c.setApmat(rs.getString(6));
                c.setDia_nac(rs.getInt(7));
                c.setMes_nac(rs.getInt(8));
                c.setAno_nac(rs.getInt(9));
                c.setNum_cel(rs.getString(10));
                c.setNum_casa(rs.getString(11));
                c.setPrivilegio(rs.getInt(12));
                
            }

            System.out.println("Usuario encontrado");
            con.close();

        }catch(Exception ed){
            System.out.println("Usuario no encontrado");
            System.out.println(ed.getMessage());
        
        }return c;
    }     
 
   }
    
