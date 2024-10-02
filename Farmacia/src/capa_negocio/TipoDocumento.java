package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Jesus
 */
public class TipoDocumento {
    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarTodosTipoDoc() throws Exception{
        strSQL = "select * from tipo_doc";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al listar tipos documentos --> " + ex.getMessage());
        }
    }
    
    public ResultSet listarPorIDTipoDoc(int idTipoDoc) throws Exception{
        strSQL = "select * from tipo_doc where id_tipo_doc = "+idTipoDoc;
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al filtrar tipos de documentos por ID --> " + ex.getMessage());
        }
    }
    
    public void insertarTipoDoc(int idTipoDoc, String tipo) throws Exception{
        strSQL = "insert into tipo_doc values ("+idTipoDoc+", '"+tipo+"')";
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al registrar tipo documento --> " + ex.getMessage());
        }
    }
    
    public void modificarTipoDoc(int idTipoDoc, String tipo) throws Exception{
        strSQL = "update tipo_doc set tipo_doc = '"+tipo+"' where id_tipo_doc = "+idTipoDoc;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al modificar tipo documento --> " + ex.getMessage());
        }
    }
    
    public void eliminarTipoDoc(int idTipoDoc) throws Exception{
        strSQL = "delete from tipo_doc where id_tipo_doc = "+idTipoDoc;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al eliminar tipo documento --> " + ex.getMessage());
        }
    }
    
    public int obtenerIDTipoDoc(String tipo) throws Exception{
        strSQL = "select id_tipo_doc from tipo_doc where tipo_doc = '"+tipo+"'";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            while(rs.next()){
                return rs.getInt("id_tipo_doc");
            }
        }catch(Exception ex){
            throw new Exception("Error al obtener ID del tipo documento --> " + ex.getMessage());
        }
        
        return 0;
    }
}
