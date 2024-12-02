package capa_negocio;

import capaDatos.datos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;

public class Pedido {

    datos objConectar = new datos();
    String strSQL;
    private Connection con;
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

    public void registrarVenta(float total, int usuario, int cliente, JTable tblDetalle) throws Exception {
        try {
            objConectar.conectar();
            con = objConectar.getCon();
            con.setAutoCommit(false);

            int idPedido = 0; // Variable para almacenar el ID del pedido generado

            // Inserción del pedido
            String sqlPedido = "INSERT INTO public.pedido(\n"
                    + " fecha_hora, estado_pedido, subtotal, id_usuario, id_cliente)\n"
                    + " VALUES (CURRENT_TIMESTAMP, ?, ?, ?, ?) RETURNING id_pedido;";
            try (PreparedStatement psPedido = con.prepareStatement(sqlPedido)) {
                psPedido.setString(1, "Pendiente");
                psPedido.setFloat(2, total);
                psPedido.setInt(3, usuario);
                psPedido.setInt(4, cliente);

                ResultSet rs = psPedido.executeQuery();
                if (rs.next()) {
                    idPedido = rs.getInt("id_pedido"); // Obtener el ID generado
                } else {
                    throw new Exception("No se pudo obtener el ID del pedido.");
                }
            }

            // Inserción del detalle del pedido
            String sqlDetalle = "INSERT INTO public.pedido_detalle_producto_forma(\n"
                    + " id_pedido, id_frm_farma, id_producto, cantidad, precio_unitario, dscto_aplicado, precio_final)\n"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?);";
            String sqlActualizarDetalle = "UPDATE public.detalle_producto_forma\n"
                    + " SET stock = stock - ?\n"
                    + " WHERE id_frm_farma = ? AND id_producto = ?;";

            try (PreparedStatement psDetalle = con.prepareStatement(sqlDetalle); PreparedStatement psActualizar = con.prepareStatement(sqlActualizarDetalle)) {

                int totalFilas = tblDetalle.getRowCount();
                for (int i = 0; i < totalFilas; i++) {
                    // Validar y extraer datos
                    if (tblDetalle.getValueAt(i, 0) == null || tblDetalle.getValueAt(i, 0).toString().isEmpty()) {
                        throw new Exception("Datos incompletos en la fila " + i);
                    }

                    int id_frm_farma = Integer.parseInt(tblDetalle.getValueAt(i, 0).toString());
                    int id_producto = Integer.parseInt(tblDetalle.getValueAt(i, 1).toString());
                    int cantidad = Integer.parseInt(tblDetalle.getValueAt(i, 4).toString());
                    float precio_unitario = Float.parseFloat(tblDetalle.getValueAt(i, 5).toString());
                    String descuentos[] = tblDetalle.getValueAt(i, 6).toString().split(",");
                    float descuento = precio_unitario * (Float.parseFloat(descuentos[0]) / 100);
                    float dscto_aplicado = descuento;
                    float precio_final = precio_unitario - descuento;

                    // Insertar en pedido_detalle_producto_forma
                    psDetalle.setInt(1, idPedido);
                    psDetalle.setInt(2, id_frm_farma);
                    psDetalle.setInt(3, id_producto);
                    psDetalle.setInt(4, cantidad);
                    psDetalle.setFloat(5, precio_unitario);
                    psDetalle.setFloat(6, dscto_aplicado);
                    psDetalle.setFloat(7, precio_final);
                    psDetalle.addBatch();

                    // Actualizar la tabla detalle_producto_forma
                    psActualizar.setInt(1, cantidad);
                    psActualizar.setInt(2, id_frm_farma);
                    psActualizar.setInt(3, id_producto);
                    psActualizar.addBatch();
                }

                psDetalle.executeBatch(); // Ejecutar lote de inserciones
                psActualizar.executeBatch(); // Ejecutar lote de actualizaciones
            }
            
            //Para sumar la cantidad de transacciones al usuario_caja
            String sqlTransaccion = "update usuario_caja set transacciones_realizadas = transacciones_realizadas + 1 "
                    + "where id_usuario = ? and fecha_hora_apertura::date = CURRENT_DATE";
            try (PreparedStatement psTransacciones = con.prepareStatement(sqlTransaccion)){
                psTransacciones.setInt(1, usuario);
                psTransacciones.executeUpdate();
            }
            

            // Confirmar la transacción
            con.commit();
        } catch (Exception e) {
            if (con != null) {
                con.rollback(); // Deshacer la transacción en caso de error
            }
            throw new Exception("Error al registrar la venta y sus detalles: " + e.getMessage());
        } finally {
            objConectar.desconectar(); // Desconectar siempre de la base de datos
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

    public void actualizarEstadoPedido(int idPedido) throws Exception {

        strSQL = "UPDATE pedido SET estado_pedido = 'Pagado' WHERE id_pedido = " + idPedido;
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

    public int obtenerUltimoIdPedido() throws Exception {
        strSQL = "SELECT COALESCE(MAX(id_pedido), 0) AS ultimo_id FROM pedido";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("ultimo_id");
            } else {
                throw new Exception("No se pudo obtener el último ID del pedido.");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el último ID del pedido: " + e.getMessage());
        } finally {
            // Asegúrate de cerrar el ResultSet si tu método consultarBD no lo hace
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception ex) {
                    // Manejo de excepción al cerrar el ResultSet
                }
            }
        }
    }

}
