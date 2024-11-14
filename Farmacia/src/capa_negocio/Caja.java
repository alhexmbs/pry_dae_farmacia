package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Jesus
 */
public class Caja {
    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarTodosCaja() throws Exception{
        strSQL = "select * from caja";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al listar cajas --> " + ex.getMessage());
        }
    }
    
    public ResultSet listarCajasVigentes() throws Exception{
        strSQL = "select * from caja where estado = true";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al listar cajas vigentes --> " + ex.getMessage());
        }
    }
    
    public ResultSet listarPorIDCaja(int idCaja) throws Exception{
        strSQL = "select * from caja where idCaja = "+idCaja;
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al filtrar cajas por ID --> " + ex.getMessage());
        }
    }
    
    public void insertarCaja(int idCaja, String numCaja) throws Exception{
        strSQL = "insert into caja values ("+idCaja+", '"+numCaja+"')";
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al registrar caja --> " + ex.getMessage());
        }
    }
    
    public void modificarCaja(int idCaja, String numCaja) throws Exception{
        strSQL = "update caja set numero_caja = '"+numCaja+"' where id_caja = "+idCaja;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al modificar caja --> " + ex.getMessage());
        }
    }
    
    public void eliminarCaja(int idCaja) throws Exception{
        strSQL = "delete from caja where id_caja = "+idCaja;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al eliminar caja --> " + ex.getMessage());
        }
    }
    
    public int obtenerIDCaja(String numCaja) throws Exception{
        strSQL = "select id_caja from caja where numero_caja = '"+numCaja+"'";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            while(rs.next()){
                return rs.getInt("id_caja");
            }
        }catch(Exception ex){
            throw new Exception("Error al obtener ID de caja --> " + ex.getMessage());
        }
        
        return 0;
    }
}

