package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

public class MetodoPago {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;

    // Listar métodos de pago
    public ResultSet listarMetodosPago() throws Exception {
        strSQL = "SELECT * FROM metodo_pago";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar métodos de pago -->" + e.getMessage());
        }
    }

    // Registrar un nuevo método de pago
    public void registrarMetodoPago(int id, String metodo, String descripcion) throws Exception {
        strSQL = "INSERT INTO metodo_pago (id_metodo_pago, metodo_pago, descripcion) VALUES (" + 
                  id + ", '" + metodo + "', '" + descripcion + "')";
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar el método de pago -->" + e.getMessage());
        }
    }

    // Buscar método de pago por ID
    public ResultSet buscarMetodoPago(int idMetodoPago) throws Exception {
        strSQL = "SELECT * FROM metodo_pago WHERE id_metodo_pago = " + idMetodoPago;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar el método de pago -->" + e.getMessage());
        }
    }

    // Modificar método de pago
    public void modificarMetodoPago(int id, String metodo, String descripcion) throws Exception {
        strSQL = "UPDATE metodo_pago SET metodo_pago = '" + metodo + "', descripcion = '" + descripcion + "' WHERE id_metodo_pago = " + id;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar el método de pago -->" + e.getMessage());
        }
    }

    // Eliminar método de pago
    public void eliminarMetodoPago(int idMetodoPago) throws Exception {
        strSQL = "DELETE FROM metodo_pago WHERE id_metodo_pago = " + idMetodoPago;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar el método de pago -->" + e.getMessage());
        }
    }
}
