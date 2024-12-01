package capa_negocio;

import capaDatos.datos;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo Jos� Medina Flores
 */
public class Comprobante {

    datos objconectar = new datos();
    String strsql;
    ResultSet rs = null;

    // Listar comprobantes con opci�n de filtro
    public ResultSet listarComprobantes() throws Exception {
        strsql = "SELECT cv.id_comprobante, cv.serie_nro_comprobante, cv.fecha_hora, cv.importe_total, "
                + "cv.id_cliente, u.id_usuario, tc.tipo_comprobante, cv.id_pedido "
                + "FROM COMPROBANTE_VENTA cv "
                + "INNER JOIN CLIENTE c ON cv.id_cliente = c.id_cliente "
                + "INNER JOIN USUARIO u ON cv.id_usuario = u.id_usuario "
                + // Aseg�rate de que la tabla y campo sean correctos
                "INNER JOIN TIPO_COMPROBANTE tc ON cv.id_tipo_comprobante = tc.id_tipo_comprobante "
                + "INNER JOIN PEDIDO p ON cv.id_pedido = p.id_pedido";
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar comprobantes: " + e.getMessage());
        }
    }

    // Generar el pr�ximo c�digo de comprobante
    public int generarCodigoComprobante() throws Exception {
        strsql = "SELECT COALESCE(MAX(id_comprobante), 0) + 1 AS codigo FROM COMPROBANTE_VENTA";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar c�digo de comprobante --> " + e.getMessage());
        }
        return 0; // En caso de que no se encuentre un c�digo v�lido
    }

    // Registrar un nuevo comprobante
    public void registrarComprobante(int id_comprobante, String serie_nro_comprobante, Date fecha_emision, float importe_total, int id_cliente, int id_usuario, int id_tipo_comprobante, int id_pedido) throws Exception {
        strsql = "INSERT INTO COMPROBANTE_VENTA (id_comprobante, serie_nro_comprobante, fecha_hora, importe_total, id_cliente, id_usuario, id_tipo_comprobante, id_pedido) VALUES ("
                + id_comprobante + ", '" + serie_nro_comprobante + "', '" + fecha_emision + "', " + importe_total + ", " + id_cliente + ", " + id_usuario + ", " + id_tipo_comprobante + ", " + id_pedido + ")";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar comprobante --> " + e.getMessage());
        }
    }

    // Modificar un comprobante existente
    // Eliminar un comprobante
    public void eliminarComprobante(int id_comprobante) throws Exception {
        strsql = "DELETE FROM COMPROBANTE_VENTA WHERE id_comprobante = " + id_comprobante;
        try {
            objconectar.ejecutarBd(strsql);  // Suponiendo que ejecutarBd ejecuta una consulta SQL
        } catch (Exception e) {
            throw new Exception("Error al eliminar comprobante --> " + e.getMessage());
        }
    }

    public ResultSet buscarComprobantePorCliente(int id_cliente) throws Exception {
        strsql = strsql = "SELECT cv.id_comprobante, cv.serie_nro_comprobante, cv.fecha_hora, cv.importe_total, "
                + "c.id_cliente, c.nombre AS cliente_nombre, tc.tipo_comprobante, cv.id_pedido, "
                + "cv.id_usuario, U.username "
                + "FROM COMPROBANTE_VENTA cv "
                + "INNER JOIN CLIENTE c ON cv.id_cliente = c.id_cliente "
                + "INNER JOIN TIPO_COMPROBANTE tc ON cv.id_tipo_comprobante = tc.id_tipo_comprobante "
                + "INNER JOIN PEDIDO p ON cv.id_pedido = p.id_pedido "
                + "INNER JOIN USUARIO U on U.id_usuario = p.id_usuario "
                + "WHERE c.id_cliente = " + id_cliente;
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

    public String generarSerieCorrelativo(String serie) throws Exception {
        strsql = "SELECT MAX(serie_nro_comprobante) AS last_comprobante "
                + "FROM COMPROBANTE_VENTA "
                + "WHERE serie_nro_comprobante LIKE '" + serie + "-%'";
        try {
            rs = objconectar.consultarBD(strsql);
            int nextCorrelativo = 1; // Correlativo inicial

            if (rs.next()) {
                String lastComprobante = rs.getString("last_comprobante");
                if (lastComprobante != null && !lastComprobante.isEmpty()) {
                    // Extraer la parte correlativa del �ltimo comprobante
                    String[] parts = lastComprobante.split("-");
                    if (parts.length == 2) {
                        try {
                            int lastCorrelativo = Integer.parseInt(parts[1]);
                            nextCorrelativo = lastCorrelativo + 1;
                        } catch (NumberFormatException nfe) {
                            throw new Exception("Formato de correlativo inv�lido en el �ltimo comprobante.");
                        }
                    }
                }
            }

            // Formatear el correlativo con ceros a la izquierda (6 d�gitos)
            String correlativo = String.format("%06d", nextCorrelativo);
            // Combinar serie y correlativo
            return serie + "-" + correlativo;
        } catch (Exception e) {
            throw new Exception("Error al generar serie y correlativo del comprobante: " + e.getMessage());
        }
    }

}
