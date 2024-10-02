package capa_negocio;

import capaDatos.datos;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo José Medina Flores
 */
public class Comprobante {
    
    
    datos objconectar = new datos();
    String strsql;
    ResultSet rs = null;

    // Listar comprobantes con opción de filtro
public ResultSet listarComprobantes() throws Exception {
    strsql = "SELECT cv.id_comprobante, cv.serie_nro_comprobante, cv.fecha_emision, cv.importe_total, " +
             "c.id_cliente, c.nombre AS cliente_nombre, tc.tipo_comprobante, cv.id_pedido " +
             "FROM COMPROBANTE_VENTA cv " +
             "INNER JOIN CLIENTE c ON cv.id_cliente = c.id_cliente " +
             "INNER JOIN TIPO_COMPROBANTE tc ON cv.id_tipo_comprobante = tc.id_tipo_comprobante " +
             "INNER JOIN PEDIDO p ON cv.id_pedido = p.id_pedido";
    try {
        rs = objconectar.consultarBD(strsql);
        return rs;
    } catch (Exception e) {
        throw new Exception("Error al listar comprobantes: " + e.getMessage());
    }
}


    // Generar el próximo código de comprobante
    public int generarCodigoComprobante() throws Exception {
        strsql = "SELECT COALESCE(MAX(id_comprobante), 0) + 1 AS codigo FROM COMPROBANTE";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de comprobante --> " + e.getMessage());
        }
        return 0; // En caso de que no se encuentre un código válido
    }

    // Registrar un nuevo comprobante
    public void registrarComprobante(int id_comprobante, String serie_nro_comprobante, Date fecha_emision, float importe_total, int id_cliente, int id_usuario, int id_tipo_comprobante, int id_pedido) throws Exception {
        strsql = "INSERT INTO COMPROBANTE (id_comprobante, serie_nro_comprobante, fecha_emision, importe_total, id_cliente, id_usuario, id_tipo_comprobante, id_pedido) VALUES ("
                + id_comprobante + ", '" + serie_nro_comprobante + "', '" + fecha_emision + "', " + importe_total + ", " + id_cliente + ", " + id_usuario + ", " + id_tipo_comprobante + ", " + id_pedido + ")";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar comprobante --> " + e.getMessage());
        }
    }

    // Modificar un comprobante existente
    public void modificarComprobante(int id_comprobante, String serie_nro_comprobante, Date fecha_emision, float importe_total, int id_cliente, int id_usuario, int id_tipo_comprobante, int id_pedido) throws Exception {
        // Consulta SQL para actualizar los datos del comprobante
        strsql = "UPDATE COMPROBANTE SET serie_nro_comprobante = '" + serie_nro_comprobante
                + "', fecha_emision = '" + fecha_emision + "', importe_total = " + importe_total
                + ", id_cliente = " + id_cliente + ", id_usuario = " + id_usuario
                + ", id_tipo_comprobante = " + id_tipo_comprobante + ", id_pedido = " + id_pedido
                + " WHERE id_comprobante = " + id_comprobante;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            // Manejo de excepciones en caso de error
            throw new Exception("Error al modificar comprobante --> " + e.getMessage());
        }
    }

    // Eliminar un comprobante
    public void eliminarComprobante(int id_comprobante) throws Exception {
        strsql = "DELETE FROM COMPROBANTE WHERE id_comprobante = " + id_comprobante;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar comprobante --> " + e.getMessage());
        }
    }
    
    public ResultSet buscarComprobantePorCliente(int id_cliente) throws Exception {
    strsql = "SELECT cv.id_comprobante, cv.serie_nro_comprobante, cv.fecha_emision, cv.importe_total, " +
             "c.id_cliente, c.nombre AS cliente_nombre, tc.tipo_comprobante, cv.id_pedido, " +
             "cv.id_usuario " +  // Aquí incluimos el id_usuario en la selección
             "FROM COMPROBANTE_VENTA cv " +
             "INNER JOIN CLIENTE c ON cv.id_cliente = c.id_cliente " +
             "INNER JOIN TIPO_COMPROBANTE tc ON cv.id_tipo_comprobante = tc.id_tipo_comprobante " +
             "INNER JOIN PEDIDO p ON cv.id_pedido = p.id_pedido " +
             "WHERE c.id_cliente = " + id_cliente;
    try {
        rs = objconectar.consultarBD(strsql);
        return rs;
    } catch (Exception e) {
        throw new Exception("Error al buscar comprobantes por cliente --> " + e.getMessage());
    }
}

    public ResultSet listarTiposComprobante() throws Exception {
    String strSQL = "SELECT tipo_comprobante FROM TIPO_COMPROBANTE";
    try {
        ResultSet rs = objconectar.consultarBD(strSQL);  // Ejecutar la consulta
        return rs;  // Retornar el ResultSet con los tipos de comprobante
    } catch (Exception e) {
        throw new Exception("Error al listar los tipos de comprobante: " + e.getMessage());
    }
}




}
