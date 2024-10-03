package capa_negocio;

import capaDatos.datos;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Katia
 */
public class Lote {

    datos objconectar = new datos();
    String strsql;
    ResultSet rs = null;

    public ResultSet listarLotes(String filtro) throws Exception {
        strsql = "SELECT lote.*, producto_farmaceutico.nombre AS nombre_producto FROM LOTE "
                + "JOIN producto_farmaceutico ON lote.id_producto = producto_farmaceutico.id_producto";

        switch (filtro) {
            case "General":
                break;
            case "Disponibles":
                strsql += " WHERE fecha_vencimiento >= CURRENT_DATE";
                break;
            case "Vencidos":
                strsql += " WHERE fecha_vencimiento < CURRENT_DATE";
                break;
            case "Fecha vencimiento ascendente":
                strsql += " ORDER BY fecha_vencimiento ASC";
                break;
            case "Fecha vencimiento descendente":
                strsql += " ORDER BY fecha_vencimiento DESC";
                break;
        }

        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar lotes --> " + e.getMessage());
        }
    }

    public ResultSet buscarLote(int id_lote) throws Exception {
        strsql = "SELECT lote.*, producto_farmaceutico.nombre AS nombre_producto FROM LOTE "
                + "JOIN producto_farmaceutico ON lote.id_producto = producto_farmaceutico.id_producto "
                + "WHERE lote.id_lote = " + id_lote;
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar lote --> " + e.getMessage());
        }
    }

    public int generarCodigoLote() throws Exception {
        strsql = "SELECT COALESCE(MAX(id_lote), 0) + 1 AS codigo FROM LOTE";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de lote --> " + e.getMessage());
        }
        return 0;
    }

    public void registrarLote(int id_lote, String numero_lote, Date fecha_vencimiento, String estado_farmaco, int id_usuario, int id_producto) throws Exception {
        strsql = "INSERT INTO LOTE (id_lote, numero_lote, fecha_vencimiento, estado_farmaco, id_usuario, id_producto) VALUES ("
                + id_lote + ", '" + numero_lote + "', '" + fecha_vencimiento + "', '" + estado_farmaco + "', " + id_usuario + ", " + id_producto + ")";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar lote bd --> " + e.getMessage());
        }
    }

    public void modificarLote(int idLote, String numeroLote, Date fechaVencimiento, String estadoFarmaco, int id_producto) throws Exception {
        String strsql = "UPDATE lote SET numero_lote = '" + numeroLote + "', fecha_vencimiento = '" + fechaVencimiento + "', "
                + "estado_farmaco = '" + estadoFarmaco + "', id_producto = " + id_producto
                + " WHERE id_lote = " + idLote;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar el lote: " + e.getMessage());
        }
    }

    public void eliminarLote(int id_lote) throws Exception {
        strsql = "DELETE FROM LOTE WHERE id_lote = " + id_lote;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar lote --> " + e.getMessage());
        }
    }

    public Integer obtenerCodigoLote(String numeroLote) throws Exception {
        strsql = "SELECT id_lote FROM lote WHERE numero_lote = '" + numeroLote + "'";

        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("id_lote");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar lotes --> " + e.getMessage());
        }
        return 0;
    }

}
