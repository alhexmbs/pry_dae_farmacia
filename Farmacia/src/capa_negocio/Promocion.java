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
            throw new Exception("Error al buscar promoción --> " + e.getMessage());
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
            throw new Exception("Error al generar código de promoción --> " + e.getMessage());
        }
        return 0; 
    }

    public void registrarPromocion(int id_promocion, float descuento, Date fecha_inicio, Date fecha_fin) throws Exception {
        strsql = "INSERT INTO PROMOCION (id_promocion, dscto, fecha_inicio, fecha_fin) VALUES ("
                + id_promocion + ", " + descuento + ", '" + fecha_inicio + "', '" + fecha_fin + "')";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar promoción --> " + e.getMessage());
        }
    }

    public void modificarPromocion(int id_promocion, float descuento, Date fecha_inicio, Date fecha_fin) throws Exception {
        strsql = "UPDATE PROMOCION SET dscto = " + descuento
                + ", fecha_inicio = '" + fecha_inicio + "', fecha_fin = '" + fecha_fin
                + "' WHERE id_promocion = " + id_promocion;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar promoción --> " + e.getMessage());
        }
    }

    public void eliminarPromocion(int id_promocion) throws Exception {
        strsql = "DELETE FROM PROMOCION WHERE id_promocion = " + id_promocion;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar promoción --> " + e.getMessage());
        }
    }

    public ResultSet buscarPromocionPorFecha(Date fecha_inicio, Date fecha_fin) throws Exception {
        strsql = "SELECT * FROM PROMOCION WHERE fecha_inicio >= '" + fecha_inicio + "' AND fecha_fin <= '" + fecha_fin + "'";
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar promoción por fecha --> " + e.getMessage());
        }
    }
}
