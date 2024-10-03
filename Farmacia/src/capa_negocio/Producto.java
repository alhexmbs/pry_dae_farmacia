package capa_negocio;

import capaDatos.datos;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author Katia
 */
public class Producto {

    datos objconectar = new datos();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarProductos(String filtro) throws Exception {
        strSQL = "SELECT pro.*, fa.nombre_fabricante, ff.forma_farmaceutica, ru.nombre_rubro, pr.dscto "
                + "FROM producto_farmaceutico pro "
                + "INNER JOIN fabricante fa ON fa.id_fabricante = pro.id_fabricante "
                + "INNER JOIN forma_farmaceutica ff ON ff.id_frm_farma = pro.id_frm_farma "
                + "INNER JOIN rubro ru ON ru.id_rubro = pro.id_rubro "
                + "LEFT JOIN promocion pr ON pr.id_promocion = pro.id_promocion";

        if (!filtro.equals("General")) {
            strSQL += " WHERE " + filtro;
        }

        try {
            rs = objconectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al consultar productos farmacéuticos --> " + e.getMessage());
        }
    }
    
    
    public ResultSet listarProductos() throws Exception {
        strSQL = "SELECT pro.*, fa.nombre_fabricante, ff.forma_farmaceutica, ru.nombre_rubro, pr.dscto "
                + "FROM producto_farmaceutico pro "
                + "INNER JOIN fabricante fa ON fa.id_fabricante = pro.id_fabricante "
                + "INNER JOIN forma_farmaceutica ff ON ff.id_frm_farma = pro.id_frm_farma "
                + "INNER JOIN rubro ru ON ru.id_rubro = pro.id_rubro "
                + "LEFT JOIN promocion pr ON pr.id_promocion = pro.id_promocion";

        

        try {
            rs = objconectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al consultar productos farmacéuticos --> " + e.getMessage());
        }
    }

    public Integer generarCodigoProducto() throws Exception {
        strSQL = "SELECT COALESCE(MAX(id_producto), 0) + 1 AS codigo FROM producto_farmaceutico;";
        try {
            rs = objconectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar el código del producto farmacéutico --> " + e.getMessage());
        }
        return 0;
    }

    public void registrarProducto(Integer id_producto, String nombre, double precio_compra, double precio_venta,
            Integer stock, String nro_reg_sanitario, String condicion_venta, Date fecha_entrada,
            Integer id_fabricante, Integer id_frm_farma, Integer id_rubro, Integer id_promocion) throws Exception {

        strSQL = "INSERT INTO public.producto_farmaceutico (id_producto, nombre, precio_compra, precio_venta, stock, "
                + "nro_reg_sanitario, condicion_venta, fecha_entrada, id_fabricante, id_frm_farma, id_rubro, id_promocion) "
                + "VALUES (" + id_producto + ", '" + nombre + "', " + precio_compra + ", " + precio_venta + ", " + stock
                + ", '" + nro_reg_sanitario + "', '" + condicion_venta + "', '" + fecha_entrada + "', "
                + id_fabricante + ", " + id_frm_farma + ", " + id_rubro + ", " + id_promocion + ")";
        try {
            objconectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar un producto farmacéutico --> " + e.getMessage());
        }
    }

    public ResultSet buscarProducto(Integer id_producto) throws Exception {
        String strSQL = "SELECT pro.id_producto, pro.nombre, pro.precio_compra, pro.precio_venta, pro.stock, "
                + "pro.nro_reg_sanitario, pro.condicion_venta, pro.fecha_entrada, "
                + "fa.nombre_fabricante, ff.forma_farmaceutica, ru.nombre_rubro, "
                + "COALESCE(pr.dscto, 0) AS descuento "
                + "FROM producto_farmaceutico pro "
                + "INNER JOIN fabricante fa ON fa.id_fabricante = pro.id_fabricante "
                + "INNER JOIN forma_farmaceutica ff ON ff.id_frm_farma = pro.id_frm_farma "
                + "INNER JOIN rubro ru ON ru.id_rubro = pro.id_rubro "
                + "LEFT JOIN promocion pr ON pr.id_promocion = pro.id_promocion "
                + "WHERE pro.id_producto = " + id_producto;

        try {
            rs = objconectar.consultarBD(strSQL);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + rsmd.getColumnName(i));
            }

            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar producto farmacéutico --> " + e.getMessage());
        }
    }

    public void eliminarProducto(Integer id_producto) throws Exception {
        strSQL = "DELETE FROM producto_farmaceutico WHERE id_producto = " + id_producto;
        try {
            objconectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar un producto farmacéutico --> " + e.getMessage());
        }
    }

    public void modificarProducto(int idProducto, String nombre, float precioCompra, float precioVenta, int stock, String nroRegSanitario, String condicionVenta, Date fechaEntrada, int idFabricante, int idForma, int idRubro, int idPromocion) throws Exception {
        String strSQL = "UPDATE producto_farmaceutico "
                + "SET nombre = '" + nombre + "', "
                + "precio_compra = " + precioCompra + ", "
                + "precio_venta = " + precioVenta + ", "
                + "stock = " + stock + ", "
                + "nro_reg_sanitario = '" + nroRegSanitario + "', "
                + "condicion_venta = '" + condicionVenta + "', "
                + "fecha_entrada = '" + fechaEntrada + "', "
                + "id_fabricante = " + idFabricante + ", "
                + "id_frm_farma = " + idForma + ", "
                + "id_rubro = " + idRubro + ", "
                + "id_promocion = " + idPromocion + " "
                + "WHERE id_producto = " + idProducto;

        try {
            objconectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar el producto --> " + e.getMessage());
        }
    }

    public Integer obtenerCodigoProducto(String nombreProducto) throws Exception {
        strSQL = "SELECT id_producto FROM producto_farmaceutico WHERE nombre = '" + nombreProducto + "'";

        try {
            rs = objconectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("id_producto");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar productos bd --> " + e.getMessage());
        }
        return 0;
    }

}
