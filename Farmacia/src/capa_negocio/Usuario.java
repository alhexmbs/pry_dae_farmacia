/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_negocio;

import capaDatos.datos;
import java.math.*;
import java.sql.*;

/**
 *
 * @author Jesus
 */
public class Usuario {
    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarTodosUsuario() throws Exception{
        strSQL = "select * from usuario";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al listar usuarios --> " + ex.getMessage());
        }
    }
    
    public ResultSet listarPorIDUsuario(int idUsuario) throws Exception{
        strSQL = "select * from usuario where id_usuario = "+idUsuario;
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al filtrar usuarios por ID --> " + ex.getMessage());
        }
    }
    
    public int genenrarIDUsuario() throws Exception{
        strSQL = "select coalesce(max(id_usuario),0)+1 as idUsuario from usuario";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            while(rs.next()){
                return rs.getInt("idUsuario");
            }
        }catch(Exception ex){
            throw new Exception("Error al generar ID del usuario --> " + ex.getMessage());
        }
        
        return 0;
    }
    
    public void insertarUsuario(int idUsuario, String nombre, String apPaterno, String apMaterno, String numDoc, String fechaNac, String direccion, String numCelular, boolean sexo, BigDecimal sueldo, String horario, String username, String email, String contrasena, int idRol, int idTipoDoc, int idCaja) throws Exception{
        strSQL = "insert into usuario values ("+idUsuario+", '"+nombre+"', '"+apPaterno+"', '"+apMaterno+"', '"+numDoc+"', '"+fechaNac+"', '"+direccion+"', '"+numCelular+"', "+sexo+", "+sueldo+", '"+horario+"', '"+username+"', '"+email+"', '"+contrasena+"', current_timestamp, "+idRol+", "+idTipoDoc+", "+idCaja+");";
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al registrar usuario --> " + ex.getMessage());
        }
    }
    
    public void modificarUsuario(int idUsuario, String nombre, String apPaterno, String apMaterno, String numDoc, String fechaNac, String direccion, String numCelular, boolean sexo, BigDecimal sueldo, String horario, String username, String email, String contrasena, int idRol, int idTipoDoc, int idCaja) throws Exception{
        strSQL = "update usuario set nombre = '"+nombre+"', ape_paterno = '"+apPaterno+"', ape_materno = '"+apMaterno+"', nro_documento = '"+numDoc+"', fecha_nacimiento = '"+fechaNac+"', direccion = '"+direccion+"', nro_celular = '"+numCelular+"', sexo = "+sexo+", sueldo = "+sueldo+", horario = '"+horario+"', username = '"+username+"', email = '"+email+"', contrasena = '"+contrasena+"', id_rol = "+idRol+", id_tipo_doc = "+idTipoDoc+", id_caja = "+idCaja+" where id_usuario = "+idUsuario;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al modificar usuario --> " + ex.getMessage());
        }
    }
    
    public void eliminarUsuario(int idUsuario) throws Exception{
        strSQL = "delete from usuario where id_usuario = "+idUsuario;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al eliminar usuario --> " + ex.getMessage());
        }
    }
    
    public int obtenerIDUsuario(String numDoc) throws Exception{
        strSQL = "select id_usuario from usuario where nro_documento = '"+numDoc+"'";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            while(rs.next()){
                return rs.getInt("id_usuario");
            }
        }catch(Exception ex){
            throw new Exception("Error al obtener ID del usuario --> " + ex.getMessage());
        }
        
        return 0;
    }
    
    public void actualizarUltimoLogin(int idUsuario) throws Exception{
        strSQL = "update usuario set ultimo_login = current_timestamp where id_usuario = "+idUsuario;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("");
        }
    }
}
