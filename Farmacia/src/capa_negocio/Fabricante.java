package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Katia
 */
public class Fabricante {
    
    datos objconectar = new datos(); 
    String strsql; 
    ResultSet rs = null;

    public ResultSet listarFabricantes(String filtro) throws Exception {
        strsql = "SELECT * FROM FABRICANTE";
        
        switch (filtro) {
            case "General":
                break;
             case "Nombre ascendente":
                strsql += " ORDER BY nombre_fabricante ASC"; 
                break;
            case "Nombre descente":
                strsql += " ORDER BY nombre_fabricante DESC"; 
                break;
           
        }
        
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar fabricantes --> " + e.getMessage());
        }
    }

    public ResultSet buscarFabricante(int id_fabricante) throws Exception {
        strsql = "SELECT * FROM FABRICANTE WHERE id_fabricante = " + id_fabricante;
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar fabricante --> " + e.getMessage());
        }
    }

    public int generarCodigoFabricante() throws Exception {
        strsql = "SELECT COALESCE(MAX(id_fabricante), 0) + 1 AS codigo FROM FABRICANTE";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de fabricante --> " + e.getMessage());
        }
        return 0;
    }

    public void registrarFabricante(int id_fabricante, String nombre) throws Exception {
        strsql = "INSERT INTO FABRICANTE (id_fabricante, nombre_fabricante) VALUES (" + id_fabricante + ", '" + nombre + "')";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar fabricante --> " + e.getMessage());
        }
    }

    public void modificarFabricante(int id_fabricante, String nombre) throws Exception {
        strsql = "UPDATE FABRICANTE SET nombre_fabricante = '" + nombre + "' WHERE id_fabricante = " + id_fabricante;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar fabricante --> " + e.getMessage());
        }
    }

    public void eliminarFabricante(int id_fabricante) throws Exception {
        strsql = "DELETE FROM FABRICANTE WHERE id_fabricante = " + id_fabricante;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar fabricante --> " + e.getMessage());
        }
    }
    
     public int obtenerIdFabricantePorNombre(String nombreFabricante) throws Exception {
        strsql = "SELECT id_fabricante FROM FABRICANTE WHERE nombre_fabricante = '" + nombreFabricante + "'";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("id_fabricante");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el ID del fabricante por nombre --> " + e.getMessage());
        }
        return 0;

    }
}
