package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

public class MetodoPago {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;

    // Listar todos los m�todos de pago
    public ResultSet listarMetodosPago() throws Exception {
        strSQL = "SELECT * FROM metodo_pago";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar m�todos de pago -->" + e.getMessage());
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
            throw new Exception("Error al generar el c�digo del metodo de pago farmac�utico --> " + e.getMessage());
        }
        return 0;
    }

    // Registrar un nuevo m�todo de pago
    public void registrarMetodoPago(int idMetodoPago, String metodo, String descripcion, Boolean estado) throws Exception {
        strSQL = "INSERT INTO metodo_pago (id_metodo_pago, metodo_pago, descripcion, estado) "
                + "VALUES (" + idMetodoPago + ", '" + metodo + "', '" + descripcion + "', '" + estado + "')";
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar el m�todo de pago -->" + e.getMessage());
        }
    }

    // Buscar un m�todo de pago por ID
    public ResultSet buscarMetodoPago(int idMetodoPago) throws Exception {
        strSQL = "SELECT * FROM metodo_pago WHERE id_metodo_pago = " + idMetodoPago;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar el m�todo de pago -->" + e.getMessage());
        }
    }

    // Modificar un m�todo de pago
    public void modificarMetodoPago(int idMetodoPago, String metodo, String descripcion) throws Exception {
        strSQL = "UPDATE metodo_pago SET metodo_pago = '" + metodo + "', descripcion = '" + descripcion + "' "
                + "WHERE id_metodo_pago = " + idMetodoPago;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar el m�todo de pago -->" + e.getMessage());
        }
    }

    // Eliminar un m�todo de pago
    public void eliminarMetodoPago(int idMetodoPago) throws Exception {
        strSQL = "UPDATE metodo_pago SET estado = false WHERE id_metodo_pago = " + idMetodoPago;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja el m�todo de pago -->" + e.getMessage());
        }
    }
}
