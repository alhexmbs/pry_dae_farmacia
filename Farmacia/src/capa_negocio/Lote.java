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

    // Listar lotes con filtro opcional
    public ResultSet listarLotes(String filtro) throws Exception {
        strsql = "SELECT L.* FROM LOTE L ";

        // Aplicar filtro específico si es necesario
        switch (filtro) {
            case "General":
                break;
            case "Disponibles":
                strsql += " WHERE L.fecha_vencimiento >= CURRENT_DATE";
                break;
            case "Vencidos":
                strsql += " WHERE L.fecha_vencimiento < CURRENT_DATE";
                break;
            case "Fecha vencimiento ascendente":
                strsql += " ORDER BY L.fecha_vencimiento ASC";
                break;
            case "Fecha vencimiento descendente":
                strsql += " ORDER BY L.fecha_vencimiento DESC";
                break;
        }

        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar lotes --> " + e.getMessage());
        }
    }

    // Buscar un lote específico por su ID
    public ResultSet buscarLote(int id_lote) throws Exception {
        strsql = "SELECT L.* FROM LOTE L "
                + "WHERE L.id_lote = " + id_lote;
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar lote --> " + e.getMessage());
        }
    }

    // Generar un nuevo código de lote
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

    // Registrar un nuevo lote
    public void registrarLote(int id_lote, String numero_lote, Date fecha_entrada, int cantidad_lote, double precio_compra,
            boolean estado, Date fecha_vencimiento, int id_usuario) throws Exception {
        strsql = "INSERT INTO LOTE (id_lote, numero_lote, fecha_entrada, cantidad_lote, precio_compra, estado, fecha_vencimiento, id_usuario) VALUES ("
                + id_lote + ", '" + numero_lote + "', '" + fecha_entrada + "', " + cantidad_lote + ", "
                + precio_compra + ", " + estado + ", '" + fecha_vencimiento + "', " + id_usuario + ")";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar lote --> " + e.getMessage());
        }
    }

    // Modificar un lote existente
    public void modificarLote(int idLote, String numeroLote, Date fechaEntrada, Date fechaVencimiento, boolean estado, int cantidadLote, double precioCompra, int id_usuario) throws Exception {
        strsql = "UPDATE lote SET numero_lote = '" + numeroLote + "', fecha_entrada = '" + fechaEntrada + "', fecha_vencimiento = '" + fechaVencimiento + "', "
                + "estado = '" + estado + "', cantidad_lote = " + cantidadLote + ", precio_compra = " + precioCompra + ", id_usuario = " + id_usuario
                + " WHERE id_lote = " + idLote;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar el lote --> " + e.getMessage());
        }
    }

    // Eliminar un lote por su ID
    public void eliminarLote(int id_lote) throws Exception {
        strsql = "DELETE FROM LOTE WHERE id_lote = " + id_lote;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar lote --> " + e.getMessage());
        }
    }

    // Obtener el ID de un lote a partir de su número
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

    // Obtener el último lote registrado
    public int obtenerUltimoLote() throws Exception {
        strsql = "SELECT MAX(id_lote) AS ultimo_lote FROM LOTE";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("ultimo_lote");
            } else {
                return 0; // Retorna 0 si no hay lotes registrados
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el último lote registrado --> " + e.getMessage());
        }
    }

    // Dar de baja un lote actualizando el estado a false
    public void darDeBajaLote(int id_lote) throws Exception {
        strsql = "UPDATE LOTE SET estado = FALSE WHERE id_lote = " + id_lote;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja el lote con ID " + id_lote + " --> " + e.getMessage());
        }
    }

}
