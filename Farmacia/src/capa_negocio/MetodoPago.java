package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

public class MetodoPago {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;

    // Listar todos los métodos de pago
    public ResultSet listarMetodosPago() throws Exception {
        strSQL = "SELECT * FROM metodo_pago";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar métodos de pago -->" + e.getMessage());
        }
    }

    public Integer generarCodigoMetodoPago() throws Exception {
        strSQL = "SELECT COALESCE(MAX(id_metodo_pago), 0) + 1 AS codigo FROM metodo_pago;";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar el código del metodo de pago farmacéutico --> " + e.getMessage());
        }
        return 0;
    }

    // Registrar un nuevo método de pago
    public void registrarMetodoPago(int idMetodoPago, String metodo, String descripcion, Boolean estado) throws Exception {
        strSQL = "INSERT INTO metodo_pago (id_metodo_pago, metodo_pago, descripcion, estado) "
                + "VALUES (" + idMetodoPago + ", '" + metodo + "', '" + descripcion + "', '" + estado + "')";
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar el método de pago -->" + e.getMessage());
        }
    }

    // Buscar un método de pago por ID
    public ResultSet buscarMetodoPago(int idMetodoPago) throws Exception {
        strSQL = "SELECT * FROM metodo_pago WHERE id_metodo_pago = " + idMetodoPago;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar el método de pago -->" + e.getMessage());
        }
    }

    // Modificar un método de pago
    public void modificarMetodoPago(int idMetodoPago, String metodo, String descripcion) throws Exception {
        strSQL = "UPDATE metodo_pago SET metodo_pago = '" + metodo + "', descripcion = '" + descripcion + "' "
                + "WHERE id_metodo_pago = " + idMetodoPago;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar el método de pago -->" + e.getMessage());
        }
    }

    // Eliminar un método de pago
    public void eliminarMetodoPago(int idMetodoPago) throws Exception {
        strSQL = "UPDATE metodo_pago SET estado = false WHERE id_metodo_pago = " + idMetodoPago;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja el método de pago -->" + e.getMessage());
        }
    }
}
