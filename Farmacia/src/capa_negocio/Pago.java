package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

public class Pago {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;

    // Listar todos los pagos
    public ResultSet listarPagos() throws Exception {
        strSQL = "SELECT  P.id_pago, P.monto_pago, P.estado_pago, P.id_pedido, U.username, C.nombre || ' ' ||C.ape_paterno as cliente, MP.metodo_pago  FROM pago P inner join cliente C on P.id_cliente = C.id_cliente inner join usuario U on U.id_usuario = P.id_usuario inner join metodo_pago MP on MP.id_metodo_pago = P.id_metodo_pago";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar pagos -->" + e.getMessage());
        }
    }

    public int generarNuevoIdPago() throws Exception {
        strSQL = "SELECT COALESCE(MAX(id_pago), 0) + 1 AS nuevoIdPago FROM pago";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("nuevoIdPago");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar nuevo ID de pago -->" + e.getMessage());
        }
        return 0;
    }

    public void registrarPago(int idPago, double monto, String estado, int idPedido, int idUsuario, int idCliente, int idMetodoPago) throws Exception {
        strSQL = "INSERT INTO pago (id_pago, monto_pago, estado_pago, id_pedido, id_usuario, id_cliente, id_metodo_pago) "
                + "VALUES (" + idPago + ", " + monto + ", '" + estado + "', " + idPedido + ", " + idUsuario + ", " + idCliente + ", " + idMetodoPago + ")";
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar el pago -->" + e.getMessage());
        }
    }

    // Buscar un pago por ID
    public ResultSet buscarPago(int idPago) throws Exception {
        strSQL = "SELECT  P.id_pago, P.monto_pago, P.estado_pago, P.id_pedido, U.username, C.nombre || ' ' ||C.ape_paterno as cliente, MP.metodo_pago  FROM pago P inner join cliente C on P.id_cliente = C.id_cliente inner join usuario U on U.id_usuario = P.id_usuario inner join metodo_pago MP on MP.id_metodo_pago = P.id_metodo_pago WHERE P.id_pago = " + idPago;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar el pago -->" + e.getMessage());
        }
    }

    // Modificar un pago
    public void modificarPago(int idPago, double monto, String estado, int idMetodoPago) throws Exception {
        strSQL = "UPDATE pago SET monto_pago = " + monto + ", estado_pago = '" + estado + "', id_metodo_pago = " + idMetodoPago
                + " WHERE id_pago = " + idPago;
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
