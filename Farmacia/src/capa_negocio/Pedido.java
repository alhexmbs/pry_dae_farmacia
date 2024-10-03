package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

public class Pedido {

    datos objConectar = new datos();
    String strSQL;
    ResultSet rs = null;

    
    public int genenrarIDpedido() throws Exception {
        strSQL = "select coalesce(max(id_pedido),0)+1 as idPedido from pedido";

        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("idPedido");
            }
        } catch (Exception ex) {
            throw new Exception("Error al generar ID del pedido --> " + ex.getMessage());
        }

        return 0;
    }

    public ResultSet obtenerDetallesPedido(int idPedido) throws Exception {
        strSQL = "SELECT * FROM pedido WHERE id_pedido = " + idPedido;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al obtener los detalles del pedido -->" + e.getMessage());
        }
    }

    public void crearPedido(int idPedido, String fechaHora, String estadoPedido, double subTotal, int idUsuario, int idCliente) throws Exception {
        strSQL = "INSERT INTO pedido (id_pedido, fecha_hora, estado_pedido, subTotal, id_usuario, id_cliente) "
                + "VALUES (" + idPedido + ", '" + fechaHora + "', '" + estadoPedido + "', " + subTotal + ", " + idUsuario + ", " + idCliente + ")";
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al crear el pedido -->" + e.getMessage());
        }
    }

    public void actualizarPedido(int idPedido, String estadoPedido, double subTotal) throws Exception {
        strSQL = "UPDATE pedido SET estado_pedido = '" + estadoPedido + "', subTotal = " + subTotal + " WHERE id_pedido = " + idPedido;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al actualizar el pedido -->" + e.getMessage());
        }
    }

    public void eliminarPedido(int idPedido) throws Exception {
        strSQL = "DELETE FROM pedido WHERE id_pedido = " + idPedido;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar el pedido -->" + e.getMessage());
        }
    }

    public ResultSet listarPedidos() throws Exception {
        strSQL = "SELECT * FROM pedido";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar los pedidos -->" + e.getMessage());
        }
    }

    public ResultSet obtenerMontoPedidoYSaldoRestante(int idPedido) throws Exception {
        strSQL = "SELECT p.subTotal AS monto_pedido, "
                + "COALESCE(SUM(pg.monto_pago), 0) AS total_pagado, "
                + "(p.subTotal - COALESCE(SUM(pg.monto_pago), 0)) AS saldo_restante "
                + "FROM PEDIDO p "
                + "LEFT JOIN PAGO pg ON p.id_pedido = pg.id_pedido "
                + "WHERE p.id_pedido = " + idPedido + " "
                + "GROUP BY p.subTotal";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al obtener el monto del pedido y saldo restante -->" + e.getMessage());
        }
    }

    public void actualizarEstadoPedido(int idPedido, String nuevoEstado) throws Exception {
        strSQL = "UPDATE pedido SET estado_pedido = '" + nuevoEstado + "' WHERE id_pedido = " + idPedido;
        try {
            objConectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al actualizar el estado del pedido -->" + e.getMessage());
        }
    }

}
