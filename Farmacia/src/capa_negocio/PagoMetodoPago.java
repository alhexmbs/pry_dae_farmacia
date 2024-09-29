package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

public class PagoMetodoPago {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;

    // Listar PagoMetodoPago
    public ResultSet listarPagoMetodoPago() throws Exception {
        strSQL = "SELECT * FROM pago_metodo_pago";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar pagos y m�todos de pago -->" + e.getMessage());
        }
    }

    // Registrar relaci�n Pago-M�todo de pago
    public void registrarPagoMetodoPago(int idPago, int idMetodoPago, double monto) throws Exception {
        strSQL = "INSERT INTO pago_metodo_pago (id_pago, id_metodo_pago, monto) VALUES (" + 
                  idPago + ", " + idMetodoPago + ", " + monto + ")";
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar el pago con su m�todo de pago -->" + e.getMessage());
        }
    }

    // Buscar por ID de Pago y M�todo de Pago
    public ResultSet buscarPagoMetodoPago(int idPago, int idMetodoPago) throws Exception {
        strSQL = "SELECT * FROM pago_metodo_pago WHERE id_pago = " + idPago + " AND id_metodo_pago = " + idMetodoPago;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar la relaci�n pago y m�todo de pago -->" + e.getMessage());
        }
    }

    // Eliminar relaci�n Pago-M�todo de pago
    public void eliminarPagoMetodoPago(int idPago, int idMetodoPago) throws Exception {
        strSQL = "DELETE FROM pago_metodo_pago WHERE id_pago = " + idPago + " AND id_metodo_pago = " + idMetodoPago;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar la relaci�n pago y m�todo de pago -->" + e.getMessage());
        }
    }
}
