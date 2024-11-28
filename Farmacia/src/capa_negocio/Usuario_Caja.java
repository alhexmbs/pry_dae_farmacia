package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Jesus
 */
public class Usuario_Caja {
    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;
    public String loggedInUsername = "";
    
    public ResultSet listarTrabajadores() throws Exception{
        strSQL = "select * from usuario where id_rol != 1 and estado = true";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al obtener los trabajadores --> " + ex.getMessage());
        }
    }
    
    public void asignarCajaUsuario(Integer idUsuario, Integer idCaja, float montoInicial) throws Exception{
        strSQL = "INSERT INTO USUARIO_CAJA (id_usuario, id_caja, monto_inicial, fecha_hora_apertura, transacciones_realizadas) "
                + "VALUES (" + idUsuario + ", " + idCaja + ", " + montoInicial + ", CURRENT_TIMESTAMP, 0)";
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al asignar los usuarios --> " + ex.getMessage());
        }
    }
    
    public void actualizarCantTransacciones(Integer idUsuario, Integer idCaja) throws Exception{
        strSQL = "UPDATE USUARIO_CAJA SET transacciones_realizadas = transacciones_realizadas + 1 "
                + "WHERE id_usuario = " + idUsuario + " AND id_caja = " + idCaja;
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al actualizar el número de transacciones --> " + ex.getMessage());
        }
    }
    
    /*
        Método para verificar si existe una caja asignada a un usuario
    */
    public Integer verificarAsignacion(Integer idUsuario) throws Exception{
        strSQL = "SELECT COUNT(*) AS asignacion_activa FROM USUARIO_CAJA "
                + "WHERE id_usuario = " + idUsuario + " AND fecha_hora_apertura::date = CURRENT_DATE AND fecha_hora_cierre IS NULL";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("asignacion_activa");
            }
        }catch(Exception ex){
            throw new Exception("Error al verificar asignacion --> " + ex.getMessage());
        }
        
        return 0;
    }
    
    /*
        Método para obtener el idCaja del usuario
    */
    public Integer obtenerIDCajaActual(Integer idUsuario) throws Exception{
        strSQL = "SELECT id_caja FROM USUARIO_CAJA "
                + "WHERE id_usuario = "+idUsuario+" AND fecha_hora_apertura::date = CURRENT_DATE";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("id_caja");
            }
            
        }catch(Exception ex){
            throw new Exception("Error al buscar caja asignada --> " + ex.getMessage());
        }
        
        return 0;
    }
    
    /*
        Método para actualizar la fecha_hora_cierre cada que se salga del sistema
    */
    public void actualizarFechaHoraCierre(Integer idUsuario, Integer idCaja) throws Exception{
        strSQL = "UPDATE USUARIO_CAJA SET fecha_hora_cierre = NOW() WHERE id_usuario = " + idUsuario + " AND id_caja = " + idCaja + " "
                + "AND fecha_hora_apertura::date = CURRENT_DATE";
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al modificar la fecha y hora de cierre --> " + ex.getMessage());
        }
    }
}
