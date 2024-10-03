/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

/**
 *
 * @author joseph
 */
public class TipoCompobante {
    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarTipoDeComprobante() throws Exception {
        strSQL = "SELECT * FROM TIPO_COMPROBANTE";

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al listar los tipos de comprobantes --> " + ex.getMessage());
        }
    }
}
