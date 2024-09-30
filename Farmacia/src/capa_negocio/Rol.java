/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Jesus
 */
public class Rol {
    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarTodosRol() throws Exception{
        strSQL = "select * from rol";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al listar roles --> " + ex.getMessage());
        }
    }
    
    public ResultSet listarPorIDRol(int idRol) throws Exception{
        strSQL = "select * from rol where id_rol = "+idRol;
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al filtrar roles por ID --> " + ex.getMessage());
        }
    }
    
    public void insertarRol(int idRol, String rol, String descripcion) throws Exception{
        strSQL = "insert into rol values ("+idRol+", '"+rol+"', '"+descripcion+"')";
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al registrar rol --> " + ex.getMessage());
        }
    }
    
    public void modificarRol(int idRol, String rol, String descripcion) throws Exception{
        strSQL = "update rol set rol = '"+rol+"', descripcion = '"+descripcion+"' where id_rol = "+idRol;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al modificar rol --> " + ex.getMessage());
        }
    }
    
    public void eliminarRol(int idRol) throws Exception{
        strSQL = "delete from rol where id_rol = "+idRol;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al eliminar rol --> " + ex.getMessage());
        }
    }
    
    public int obtenerIDRol(String rol) throws Exception{
        strSQL = "select id_rol from rol where rol = '"+rol+"'";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            while(rs.next()){
                return rs.getInt("id_rol");
            }
        }catch(Exception ex){
            throw new Exception("Error al obtener ID del rol --> " + ex.getMessage());
        }
        
        return 0;
    }
}

