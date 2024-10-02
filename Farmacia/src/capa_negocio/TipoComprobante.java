/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_negocio;
import capaDatos.datos;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class TipoComprobante {
    
     datos objconectar = new datos();  // Instancia de la clase de conexión a la base de datos
    String strsql;
    ResultSet rs = null;

    // Listar todos los tipos de comprobantes
    public ResultSet listarTiposComprobante() throws Exception {
        strsql = "SELECT * FROM TIPO_COMPROBANTE";
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar tipos de comprobante --> " + e.getMessage());
        }
    }

    // Buscar un tipo de comprobante por ID
    public ResultSet buscarTipoComprobante(int id_tipo_comprobante) throws Exception {
        strsql = "SELECT * FROM TIPO_COMPROBANTE WHERE id_tipo_comprobante = " + id_tipo_comprobante;
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar tipo de comprobante --> " + e.getMessage());
        }
    }

    // Generar el próximo código de tipo de comprobante
    public int generarCodigoTipoComprobante() throws Exception {
        strsql = "SELECT COALESCE(MAX(id_tipo_comprobante), 0) + 1 AS codigo FROM TIPO_COMPROBANTE";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de tipo de comprobante --> " + e.getMessage());
        }
        return 0; // En caso de que no se encuentre un código válido
    }

    // Registrar un nuevo tipo de comprobante
    public void registrarTipoComprobante(int id_tipo_comprobante, String tipo_comprobante) throws Exception {
        strsql = "INSERT INTO TIPO_COMPROBANTE (id_tipo_comprobante, tipo_comprobante) VALUES (" + id_tipo_comprobante + ", '" + tipo_comprobante + "')";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar tipo de comprobante --> " + e.getMessage());
        }
    }

    // Modificar un tipo de comprobante existente
    public void modificarTipoComprobante(int id_tipo_comprobante, String tipo_comprobante) throws Exception {
        strsql = "UPDATE TIPO_COMPROBANTE SET tipo_comprobante = '" + tipo_comprobante + "' WHERE id_tipo_comprobante = " + id_tipo_comprobante;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar tipo de comprobante --> " + e.getMessage());
        }
    }

    // Eliminar un tipo de comprobante
    public void eliminarTipoComprobante(int id_tipo_comprobante) throws Exception {
        strsql = "DELETE FROM TIPO_COMPROBANTE WHERE id_tipo_comprobante = " + id_tipo_comprobante;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar tipo de comprobante --> " + e.getMessage());
        }
    }
    
    
}
