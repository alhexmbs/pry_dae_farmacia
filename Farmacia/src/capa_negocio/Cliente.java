package capa_negocio;

import capaDatos.datos;
import java.sql.*;

/**
 *
 * @author Jesus
 */
public class Cliente {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarTodosCliente() throws Exception {
        strSQL = "select * from cliente cl inner join tipo_doc td on cl.id_tipo_doc = td.id_tipo_doc";

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al listar clientes --> " + ex.getMessage());
        }
    }

    public ResultSet listarPorIDCliente(int idCliente) throws Exception {
        strSQL = "select * from cliente cl inner join tipo_doc td on cl.id_tipo_doc = td.id_tipo_doc where cl.id_cliente = " + idCliente;

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al filtrar clientes por ID --> " + ex.getMessage());
        }
    }

    public ResultSet filtrarClientes(String dni) throws Exception {
        strSQL = "select * \n"
                + "from cliente cl \n"
                + "inner join tipo_doc td on cl.id_tipo_doc = td.id_tipo_doc\n"
                + "where cl.nro_documento like '%"+dni+"%'";

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al listar clientes --> " + ex.getMessage());
        }
    }

    public int buscarClientePorDoc(String nroDoc) throws Exception {
        strSQL = "SELECT ID_CLIENTE FROM CLIENTE WHERE NRO_DOCUMENTO = '" + nroDoc + "'";
        int idCliente = 0;
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("ID_CLIENTE");
            }
        } catch (Exception ex) {
            throw new Exception("Error al buscar cliente por nroDocumento --> " + ex.getMessage());
        }
        return 0;
    }

    public int genenrarIDCliente() throws Exception {
        strSQL = "select coalesce(max(id_cliente),0)+1 as idCliente from cliente";

        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("idCliente");
            }
        } catch (Exception ex) {
            throw new Exception("Error al generar ID del cliente --> " + ex.getMessage());
        }

        return 0;
    }

//    public void insertarCliente(int idCliente, String numDoc, String nombre, String apePaterno, String apeMaterno, String fechaNac, boolean sexo, String email, int idTipoDoc) throws Exception {
//        strSQL = "insert into cliente values (" + idCliente + ", '" + numDoc + "', '" + nombre + "', '" + apePaterno + "', '" + apeMaterno + "', '" + fechaNac + "', " + sexo + ", '" + email + "', " + idTipoDoc + ")";
//
//        try {
//            objConectar.ejecutarBd(strSQL);
//        } catch (Exception ex) {
//            throw new Exception("Error al registrar cliente --> " + ex.getMessage());
//        }
//    }
//
//    public void modificarCliente(int idCliente, String numDoc, String nombre, String apePaterno, String apeMaterno, String fechaNac, boolean sexo, String email, int idTipoDoc) throws Exception {
//        strSQL = "update cliente set nro_documento = '" + numDoc + "', nombre = '" + nombre + "', ape_paterno = '" + apePaterno + "', ape_materno = '" + apeMaterno + "', fecha_nacimiento = '" + fechaNac + "', sexo = " + sexo + ", email = '" + email + "', id_tipo_doc = " + idTipoDoc + " where id_cliente = " + idCliente;
//
//        try {
//            objConectar.ejecutarBd(strSQL);
//        } catch (Exception ex) {
//            throw new Exception("Error al modificar cliente --> " + ex.getMessage());
//        }
//    }
    public void insertarCliente(int idCliente, String numDoc, String nombre, String apePaterno, String apeMaterno, String fechaNac, boolean sexo, String email, int idTipoDoc, boolean estado) throws Exception {
        strSQL = "insert into cliente values (" + idCliente + ", '" + numDoc + "', '" + nombre + "', '" + apePaterno + "', '" + apeMaterno + "', '" + fechaNac + "', " + sexo + ", '" + email + "', " + estado + ", " + idTipoDoc + ")";

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al registrar cliente --> " + ex.getMessage());
        }
    }

    public void modificarCliente(int idCliente, String numDoc, String nombre, String apePaterno, String apeMaterno, String fechaNac, boolean sexo, String email, int idTipoDoc, boolean estado) throws Exception {
        strSQL = "update cliente set nro_documento = '" + numDoc + "', nombre = '" + nombre + "', ape_paterno = '" + apePaterno + "', ape_materno = '" + apeMaterno + "', fecha_nacimiento = '" + fechaNac + "', sexo = " + sexo + ", email = '" + email + "', estado = " + estado + ", id_tipo_doc = " + idTipoDoc + " where id_cliente = " + idCliente;

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al modificar cliente --> " + ex.getMessage());
        }
    }

    public void eliminarCliente(int idCliente) throws Exception {
        strSQL = "delete from cliente where id_cliente = " + idCliente;

        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception ex) {
            throw new Exception("Error al eliminar cliente --> " + ex.getMessage());
        }
    }

    public int obtenerIDCliente(String numDoc) throws Exception {
        strSQL = "select id_cliente from cliente where nro_documento = '" + numDoc + "'";

        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("id_cliente");
            }
        } catch (Exception ex) {
            throw new Exception("Error al obtener ID del cliente --> " + ex.getMessage());
        }

        return 0;
    }

    //888
}
