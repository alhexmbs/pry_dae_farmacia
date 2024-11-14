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
    
}
