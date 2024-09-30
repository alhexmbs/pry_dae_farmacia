package capa_negocio;

import capaDatos.datos;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class Comprobante {
    
    public class ComprobanteDAO {
    datos objconectar = new datos();
    String strsql;
    ResultSet rs = null;

    // Listar comprobantes con opción de filtro
    public ResultSet listarComprobantes(String filtro) throws Exception {
        strsql = "SELECT * FROM COMPROBANTE";

        switch (filtro) {
            case "General":
                break;
            case "Mayor a menor":
                strsql += " ORDER BY importe_total DESC";
                break;
            case "Menor a mayor":
                strsql += " ORDER BY importe_total ASC";
                break;
        }

        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar comprobantes --> " + e.getMessage());
        }
    }

    // Buscar comprobante por ID
    public ResultSet buscarComprobante(int id_comprobante) throws Exception {
        strsql = "SELECT * FROM COMPROBANTE WHERE id_comprobante = " + id_comprobante;
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar comprobante --> " + e.getMessage());
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
        return 0;
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
        strsql = "UPDATE COMPROBANTE SET serie_nro_comprobante = '" + serie_nro_comprobante
                + "', fecha_emision = '" + fecha_emision + "', importe_total = " + importe_total
                + ", id_cliente = " + id_cliente + ", id_usuario = " + id_usuario
                + ", id_tipo_comprobante = " + id_tipo_comprobante + ", id_pedido = " + id_pedido
                + " WHERE id_comprobante = " + id_comprobante;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
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

    // Buscar comprobantes por un rango de fechas
    public ResultSet buscarComprobantePorFecha(Date fecha_inicio, Date fecha_fin) throws Exception {
        strsql = "SELECT * FROM COMPROBANTE WHERE fecha_emision >= '" + fecha_inicio + "' AND fecha_emision <= '" + fecha_fin + "'";
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar comprobantes por fecha --> " + e.getMessage());
        }
    }
}

public class TipoComprobanteDAO {
    datos objconectar = new datos();
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
        return 0;
    }

    // Registrar un nuevo tipo de comprobante
    public void registrarTipoComprobante(int id_tipo_comprobante, String tipo_comprobante) throws Exception {
        strsql = "INSERT INTO TIPO_COMPROBANTE (id_tipo_comprobante, tipo_comprobante) VALUES ("
                + id_tipo_comprobante + ", '" + tipo_comprobante + "')";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar tipo de comprobante --> " + e.getMessage());
        }
    }

    // Modificar un tipo de comprobante existente
    public void modificarTipoComprobante(int id_tipo_comprobante, String tipo_comprobante) throws Exception {
        strsql = "UPDATE TIPO_COMPROBANTE SET tipo_comprobante = '" + tipo_comprobante
                + "' WHERE id_tipo_comprobante = " + id_tipo_comprobante;
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

}
