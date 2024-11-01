package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Katia
 */
public class Forma_farmaceutica {

    datos objconectar = new datos();
    String strsql;
    ResultSet rs = null;

    public ResultSet listarFormaFarmaceutica(String tipo) throws Exception {
        strsql = "select * from FORMA_FARMACEUTICA";

        switch (tipo) {
            case "General":
                break;
            case "Nombre ascendente":
                strsql += " ORDER BY forma_farmaceutica asc";
                break;
            case "Nombre descente":
                strsql += " ORDER BY forma_farmaceutica desc";
                break;

        }

        try {
            rs = objconectar.consultarBD(strsql);
            return rs;

        } catch (Exception e) {
            throw new Exception("Error al listar formas farmaceuticas-->" + e.getMessage());
        }

    }

    public ResultSet buscarFormaFarmaceutica(Integer cod) throws Exception {
        strsql = "select * from forma_farmaceutica where  id_frm_farma =" + cod;
        try {
            rs = objconectar.consultarBD(strsql);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar la forma farmaceutica--> " + e.getMessage());
        }
    }

    public Integer generarCodigoformafarmaceutica() throws Exception {
        strsql = "select coalesce (max(id_frm_farma),0)+1 as codigo from forma_farmaceutica";
        try {
            rs = objconectar.consultarBD(strsql);
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                return codigo;
            }
        } catch (Exception e) {
            throw new Exception("Error al genear codigo--> " + e.getMessage());

        }
        return 0;
    }

    public void registrar(int id_frm_farma, String forma_farmaceutica, boolean estado) throws Exception {
        strsql = "INSERT into forma_farmaceutica VALUES (" + id_frm_farma + ", '" + forma_farmaceutica + "', " + estado + ")";
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al registrar forma farmaceutica bd-->" + e.getMessage());
        }
    }

    public void eliminar(Integer cod) throws Exception {
        String verificarSql = "SELECT COUNT(*) FROM detalle_producto_forma WHERE id_frm_farma = " + cod;

        String eliminarSql = "DELETE FROM forma_farmaceutica WHERE id_frm_farma = " + cod;

        try {
            ResultSet rs = objconectar.consultarBD(verificarSql);
            if (rs.next() && rs.getInt(1) == 0) {
                objconectar.ejecutarBd(eliminarSql);
            } else {
                throw new Exception("No se puede eliminar: la forma farmacéutica está siendo nombrada en un producto.");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar forma farmacéutica --> " + e.getMessage());
        }
}

    public void modificarFormaFarmaceutica(int id_frm_farma, String nuevaFormaFarmaceutica, boolean estado) throws Exception {
        strsql = "update forma_farmaceutica set forma_farmaceutica = '" + nuevaFormaFarmaceutica + "', estado = " + estado + " where id_frm_farma = " + id_frm_farma;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al modificar forma farmaceutica --> " + e.getMessage());
        }
    }

    public Integer obtenerCodigoFormaFarmaceutica(String nombre) throws Exception {
        strsql = "select id_frm_farma from forma_farmaceutica where forma_farmaceutica = '"+nombre+"'";
        try {
            rs = objconectar.consultarBD(strsql);
            if (rs.next()) {
                return rs.getInt("id_frm_farma");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener codigo de forma farmaceutica --> " + e.getMessage());
        }
        return 0;
    }

    // Dar de baja una forma farmaceutica actualizando el estado a false
    public void darBajaForma(int id_frm_farma) throws Exception {
        strsql = "UPDATE FORMA_FARMACEUTICA SET estado = FALSE WHERE id_frm_farma = " + id_frm_farma;
        try {
            objconectar.ejecutarBd(strsql);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja la forma farmaceutica con ID " + id_frm_farma + " --> " + e.getMessage());
        }
    }

}
