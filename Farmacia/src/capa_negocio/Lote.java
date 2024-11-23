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
    strsql = """
           SELECT l.*, fm.forma_farmaceutica, p.nombre FROM 
                  LOTE l
              INNER JOIN 
                  USUARIO u ON l.id_usuario = u.id_usuario
              INNER JOIN 
                  DETALLE_PRODUCTO_FORMA dp ON l.id_frm_farma = dp.id_frm_farma 
                                            AND l.id_producto = dp.id_producto
              INNER JOIN 
                  PRODUCTO_FARMACEUTICO p ON dp.id_producto = p.id_producto
              INNER JOIN 
                  FORMA_FARMACEUTICA fm ON dp.id_frm_farma = fm.id_frm_farma;
           
             """;

    switch (filtro) {
        case "General":
            break;
        case "Disponibles":
            strsql += " WHERE l.fecha_vencimiento >= CURRENT_DATE";
            break;
        case "Vencidos":
            strsql += " WHERE l.fecha_vencimiento < CURRENT_DATE";
            break;
        case "Fecha vencimiento ascendente":
            strsql += " ORDER BY l.fecha_vencimiento ASC";
            break;
        case "Fecha vencimiento descendente":
            strsql += " ORDER BY l.fecha_vencimiento DESC";
            break;
        default:
            throw new Exception("Filtro no reconocido: " + filtro);
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
        strsql = """
                 SELECT l.*, fm.forma_farmaceutica, p.nombre FROM LOTE l
                  INNER JOIN USUARIO u ON l.id_usuario = u.id_usuario
                  INNER JOIN DETALLE_PRODUCTO_FORMA dp ON l.id_frm_farma = dp.id_frm_farma AND l.id_producto = dp.id_producto
                 inner join producto_farmaceutico p on dp.id_producto = l.id_producto
                 inner join forma_farmaceutica fm ON fm.id_frm_farma = dp.id_frm_farma
                 WHERE l.id_lote = """ + id_lote;
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
    public void insertarLote(int id_lote, Date fecha_entrada, int cantidad_lote, double precio_compra, String numero_lote, 
                             boolean estado, Date fecha_vencimiento, int id_usuario, int id_frm_farma, int id_producto) throws Exception {
        strsql = "INSERT INTO LOTE (id_lote, fecha_entrada, cantidad_lote, precio_compra, numero_lote, " +
                 "estado, fecha_vencimiento, id_usuario, id_frm_farma, id_producto) VALUES (" +
                 id_lote + ", '" + fecha_entrada + "', " + cantidad_lote + ", " + precio_compra + ", '" + numero_lote + "', " +
                 estado + ", '" + fecha_vencimiento + "', " + id_usuario + ", " + id_frm_farma + ", " + id_producto + ")";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al insertar lote --> " + e.getMessage());
        }
    }

    // Modificar un lote existente
    public void modificarLote(int id_lote, Date fecha_entrada, int cantidad_lote, double precio_compra, String numero_lote, 
                              boolean estado, Date fecha_vencimiento, int id_usuario, int id_frm_farma, int id_producto) throws Exception {
        strsql = "UPDATE LOTE SET fecha_entrada = '" + fecha_entrada + "', cantidad_lote = " + cantidad_lote + 
                 ", precio_compra = " + precio_compra + ", numero_lote = '" + numero_lote + "', estado = " + estado + 
                 ", fecha_vencimiento = '" + fecha_vencimiento + "', id_usuario = " + id_usuario + 
                 ", id_frm_farma = " + id_frm_farma + ", id_producto = " + id_producto +
                 " WHERE id_lote = " + id_lote;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar lote --> " + e.getMessage());
        }
    }

    
    public void eliminarLote(int id_lote) throws Exception {
    String verificarSql = "SELECT COUNT(*) FROM PEDIDO_DETALLE_PRODUCTO_FORMA WHERE id_lote = " + id_lote;
    String eliminarSql = "DELETE FROM LOTE WHERE id_lote = " + id_lote;

    try {
        ResultSet rs = objconectar.consultarBD(verificarSql);
        if (rs.next() && rs.getInt(1) == 0) {
            objconectar.ejecutarBd(eliminarSql);
        } else {
            throw new Exception("No se puede eliminar: el lote está en uso en otra entidad.");
        }
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
