package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Katia
 */
public class Rubro {

    datos objconectar = new datos();
    String strsql;
    ResultSet rs = null;

    public ResultSet listarRubros(String filtro) throws Exception {
        strsql = "SELECT * FROM RUBRO";
        switch (filtro) {
            case "General":
                break;
            case "Nombre ascendente":
                strsql += " ORDER BY nombre_rubro ASC";
                break;
            case "Nombre descente":
                strsql += " ORDER BY nombre_rubro DESC";
                break;
            default:
                throw new Exception("Filtro no reconocido: " + filtro);
        }
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar rubros --> " + e.getMessage());
        }
    }

    public ResultSet buscarRubro(int id_rubro) throws Exception {
        strsql = "SELECT * FROM RUBRO WHERE id_rubro = " + id_rubro;
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar rubro --> " + e.getMessage());
        }
    }

    public int generarCodigoRubro() throws Exception {
        strsql = "SELECT COALESCE(MAX(id_rubro), 0) + 1 AS codigo FROM RUBRO";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de rubro --> " + e.getMessage());
        }
        return 0;
    }

    public void registrarRubro(int id_rubro, String nombre_rubro, boolean estado) throws Exception {
        strsql = "INSERT INTO RUBRO (id_rubro, nombre_rubro, estado) VALUES (" + id_rubro + ", '" + nombre_rubro + "', " + estado + ")";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar rubro --> " + e.getMessage());
        }
    }

    public void modificarRubro(int id_rubro, String nombre_rubro, boolean estado) throws Exception {
        // Corregir la concatenación de la cadena SQL
        strsql = "UPDATE RUBRO SET nombre_rubro = '" + nombre_rubro + "', estado = " + estado + " WHERE id_rubro = " + id_rubro;

        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar rubro --> " + e.getMessage());
        }
    }

    public void eliminarRubro(int id_rubro) throws Exception {
        strsql = "DELETE FROM RUBRO WHERE id_rubro = " + id_rubro;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar rubro --> " + e.getMessage());
        }
    }

    public Integer obtenerCodigoRubro(String nombre) throws Exception {
        strsql = "SELECT id_rubro FROM RUBRO WHERE nombre_rubro = '" + nombre + "'";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("id_rubro");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener codigo de rubro --> " + e.getMessage());
        }
        return 0;
    }

    // Dar de baja un rubro actualizando el estado a false
    public void darDeBajaRubro(int id_rubro) throws Exception {
        strsql = "UPDATE RUBRO SET estado = FALSE WHERE id_rubro = " + id_rubro;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja el rubro con ID " + id_rubro + " --> " + e.getMessage());
        }
    }

}
