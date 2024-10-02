package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

/**
 *
 * @author Alex
 */

public class Pago {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;

    // Listar todos los pagos
    public ResultSet listarPagos() throws Exception {
        strSQL = "SELECT * FROM pago";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar pagos -->" + e.getMessage());
        }
    }

    // Registrar un nuevo pago
    public void registrarPago(int id, double monto, String estado, int idPedido, int idUsuario, int idCliente) throws Exception {
        strSQL = "INSERT INTO pago (id_pago, monto_pago, estado_pago, id_pedido, id_usuario, id_cliente) " +
                 "VALUES (" + id + ", " + monto + ", '" + estado + "', " + idPedido + ", " + idUsuario + ", " + idCliente + ")";
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar el pago -->" + e.getMessage());
        }
    }

    // Buscar un pago por ID
    public ResultSet buscarPago(int idPago) throws Exception {
        strSQL = "SELECT * FROM pago WHERE id_pago = " + idPago;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar el pago -->" + e.getMessage());
        }
    }

    // Modificar un pago
    public void modificarPago(int id, double monto, String estado) throws Exception {
        strSQL = "UPDATE pago SET monto_pago = " + monto + ", estado_pago = '" + estado + "' WHERE id_pago = " + id;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar el pago -->" + e.getMessage());
        }
    }

    // Eliminar un pago
    public void eliminarPago(int idPago) throws Exception {
        strSQL = "DELETE FROM pago WHERE id_pago = " + idPago;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar el pago -->" + e.getMessage());
        }
    }
}
