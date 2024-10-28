package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Katia
 */
public class Promocion {

    datos objconectar = new datos();
    String strsql;
    ResultSet rs = null;

    public ResultSet listarPromociones(String filtro) throws Exception {
        strsql = "SELECT * FROM PROMOCION";

        switch (filtro) {
            case "General":
                break;
            case "Mayor a menor":
                strsql += " ORDER BY dscto DESC";
                break;
            case "Menor a mayor":
                strsql += " ORDER BY dscto ASC";
                break;
        }

        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar promociones --> " + e.getMessage());
        }
    }

    public ResultSet buscarPromocion(int id_promocion) throws Exception {
        strsql = "SELECT * FROM PROMOCION WHERE id_promocion = " + id_promocion;
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar promocion --> " + e.getMessage());
        }
    }

    public int generarCodigoPromocion() throws Exception {
        strsql = "SELECT COALESCE(MAX(id_promocion), 0) + 1 AS codigo FROM PROMOCION";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de promocion --> " + e.getMessage());
        }
        return 0;
    }

    public void registrarPromocion(int id_promocion, int descuento, Date fecha_inicio, Date fecha_fin, boolean estado) throws Exception {
        strsql = "INSERT INTO PROMOCION (id_promocion, dscto, fecha_inicio, fecha_fin, estado) VALUES ("
                + id_promocion + ", " + descuento + ", '" + fecha_inicio + "', '" + fecha_fin + "', " + estado + ")";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar promocion --> " + e.getMessage());
        }
    }

    public void modificarPromocion(int id_promocion, int descuento, Date fecha_inicio, Date fecha_fin, boolean estado) throws Exception {
        strsql = "UPDATE PROMOCION SET dscto = " + descuento
                + ", fecha_inicio = '" + fecha_inicio + "', fecha_fin = '" + fecha_fin
                + "', estado = " + estado + " WHERE id_promocion = " + id_promocion;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar promocion --> " + e.getMessage());
        }
    }

    public void eliminarPromocion(int id_promocion) throws Exception {
        strsql = "DELETE FROM PROMOCION WHERE id_promocion = " + id_promocion;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar promocion --> " + e.getMessage());
        }
    }

    public ResultSet buscarPromocionPorFecha(Date fecha_inicio, Date fecha_fin) throws Exception {
        strsql = "SELECT * FROM PROMOCION WHERE fecha_inicio >= '" + fecha_inicio + "' AND fecha_fin <= '" + fecha_fin + "'";
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar promocion por fecha --> " + e.getMessage());
        }
    }

    public Integer obtenerCodigoPromocion(String dscto) throws Exception {
        strsql = "SELECT id_promocion FROM promocion WHERE dscto = '" + dscto + "'";

        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("id_promocion");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar promociones --> " + e.getMessage());
        }
        return 0;
    }

    // Dar de baja un promocion actualizando el estado a false
    public void darDeBajaPromocion(int id_promocion) throws Exception {
        strsql = "UPDATE PROMOCION SET estado = FALSE WHERE id_promocion = " + id_promocion;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja la promocion con ID " + id_promocion + " --> " + e.getMessage());
        }
    }

}
