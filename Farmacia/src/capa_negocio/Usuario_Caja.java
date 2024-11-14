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
public class Usuario_Caja {
    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;
    public String loggedInUsername = "";
    
    public ResultSet listarTrabajadores() throws Exception{
        strSQL = "select * from usuario where id_rol != 1";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception ex){
            throw new Exception("Error al obtener los trabajadores --> " + ex.getMessage());
        }
    }
    
    /*
        Cada vez que se asigne un nuevo usuario a una caja, se ejecuta lo siguiente...
        -El resto de atributos inicializan en nulos, exceptuuando el monto inicial que se pedirá antes de registrar la asignación
        -La cantidad de transacciones empieza en 0, estas irán autoincrementando cada que se haga una venta (filtrando por usuario)
    */
    public void asignarCajaUsuario(Integer idUsuario, Integer idCaja, float montoInicial) throws Exception{
        strSQL = "INSERT INTO USUARIO_CAJA (id_usuario, id_caja, monto_inicial, transacciones_realizadas) "
                + "VALUES (" + idUsuario + ", " + idCaja + ", " + montoInicial + ", 0)";
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al asignar los usuarios --> " + ex.getMessage());
        }
    }
    
    /*
        Método para ir autoincrementando la cantidad de transacciones, filtrando si es el usuario
    */
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
    public void verificarAsignacion(Integer idUsuario) throws Exception{
        strSQL = "SELECT COUNT(*) AS asignacion_activa FROM USUARIO_CAJA "
                + "WHERE id_usuario = " + idUsuario + " AND fecha_hora_apertura::date = CURRENT_DATE AND fecha_hora_cierre IS NULL";
        
        try{
            objConectar.ejecutarBd(strSQL);
        }catch(Exception ex){
            throw new Exception("Error al verificar asignacion --> " + ex.getMessage());
        }
    }
}
