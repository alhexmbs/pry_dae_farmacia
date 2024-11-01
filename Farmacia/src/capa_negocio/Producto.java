package capa_negocio;

import capaDatos.datos;
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
        StringBuilder strSQL = new StringBuilder("SELECT pf.*, pro.dscto AS descuento, rb.nombre_rubro AS rubro "
                + "FROM producto_farmaceutico pf "
                + "INNER JOIN promocion pro ON pro.id_promocion = pf.id_promocion "
                + "INNER JOIN rubro rb ON rb.id_rubro = pf.id_rubro");

        if (!filtro.equals("General")) {
            if (filtro.equals("ORDER BY pf.nombre ASC") || filtro.equals("ORDER BY pf.nombre DESC")) {
                strSQL.append(" ").append(filtro);
            } else {
                strSQL.append(" WHERE ").append(filtro);
            }
        }

        try {
            rs = objconectar.consultarBD(strSQL.toString());
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al consultar productos farmacéuticos --> " + e.getMessage());
        }
    }

    public ResultSet listardetalle(String filtro) throws Exception {
    strSQL = "SELECT dtf.*, fm.forma_farmaceutica, pro.nombre, fa.nombre_fabricante " +
             "FROM detalle_producto_forma dtf " +
             "INNER JOIN forma_farmaceutica fm ON dtf.id_frm_farma = fm.id_frm_farma " +
             "INNER JOIN producto_farmaceutico pro ON pro.id_producto = dtf.id_producto " +
             "INNER JOIN fabricante fa ON fa.id_fabricante = dtf.id_fabricante";

    if (filtro != null && !filtro.isEmpty()) {
        strSQL += " WHERE " + filtro;
    }

    try {
        rs = objconectar.consultarBD(strSQL);
        return rs;
    } catch (Exception e) {
        throw new Exception("Error al consultar productos farmacéuticos --> " + e.getMessage());
    }
}


    // Listar todos los productos sin filtro
    public ResultSet listarProductos() throws Exception {
        return listarProductos("General");
    }

    // Generar código de producto
    public Integer generarCodigoProducto() throws Exception {
        strSQL = "SELECT COALESCE(MAX(id_producto), 0) + 1 AS codigo FROM producto_farmaceutico;";
        try {
            rs = objconectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar el código del producto farmacéutico --> " + e.getMessage());
        }
        return 0;
    }

    // Registrar producto en la tabla producto_farmaceutico
    public void registrarProducto(int id_producto, String nombre, String nro_reg_sanitario, String condicion_venta,
            int id_promocion, int id_rubro) throws Exception {

        strSQL = "INSERT INTO producto_farmaceutico (id_producto, nombre, nro_reg_sanitario, condicion_venta, id_promocion, id_rubro) "
                + "VALUES (" + id_producto + ", '" + nombre + "', '" + nro_reg_sanitario + "', '" + condicion_venta + "', "
                + id_promocion + ", " + id_rubro+")";
        try {
            objconectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar un producto farmacéutico --> " + e.getMessage());
        }
    }

    // Registrar detalle de producto en DETALLE_PRODUCTO_FORMA
    public void registrarDetalleProductoForma(Integer id_frm_farma, Integer id_producto, Integer stock, double precio_venta,
            char estado, String principio_activo, String dosis, Integer id_fabricante) throws Exception {

        strSQL = "INSERT INTO detalle_producto_forma (id_frm_farma, id_producto, stock, precio_venta, estado, "
                + "principio_activo, dosis, id_fabricante) "
                + "VALUES (" + id_frm_farma + ", " + id_producto + ", " + stock + ", " + precio_venta + ", '"
                + estado + "', '" + principio_activo + "', '" + dosis + "', " + id_fabricante + ")";

        try {
            objconectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar el detalle del producto en DETALLE_PRODUCTO_FORMA --> " + e.getMessage());
        }
    }

    // Modificar producto en la tabla producto_farmaceutico
    public void modificarProducto(int id_producto, String nombre, String nro_reg_sanitario, String condicion_venta,
            Integer id_promocion, int id_rubro) throws Exception {
        strSQL = "UPDATE producto_farmaceutico SET "
                + "nombre = '" + nombre + "', "
                + "nro_reg_sanitario = '" + nro_reg_sanitario + "', "
                + "condicion_venta = '" + condicion_venta + "', "
                + "id_promocion = " + (id_promocion != null ? id_promocion : "NULL") + ", "
                + "id_rubro = " + id_rubro + " "
                + "WHERE id_producto = " + id_producto;

        try {
            objconectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar el producto farmacéutico --> " + e.getMessage());
        }
    }

    // Modificar detalle de producto en DETALLE_PRODUCTO_FORMA
    public void modificarDetalleProductoForma(Integer id_frm_farma, Integer id_producto, Integer stock, double precio_venta,
            char estado, String principio_activo, String dosis, Integer id_fabricante) throws Exception {
        strSQL = "UPDATE detalle_producto_forma SET "
                + "stock = " + stock + ", "
                + "precio_venta = " + precio_venta + ", "
                + "estado = '" + estado + "', "
                + "principio_activo = '" + principio_activo + "', "
                + "dosis = '" + dosis + "', "
                + "id_fabricante = " + id_fabricante + " "
                + "WHERE id_frm_farma = " + id_frm_farma + " AND id_producto = " + id_producto;

        try {
            objconectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar el detalle del producto en DETALLE_PRODUCTO_FORMA --> " + e.getMessage());
        }
    }

    // Buscar un producto por nombre
    public int buscarProductoPorNombre(String nombre) throws Exception {
        strSQL = "SELECT id_producto FROM producto_farmaceutico WHERE nombre ILIKE '" + nombre + "'";
        try {
            rs = objconectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("id_producto");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar producto por nombre --> " + e.getMessage());
        }
        return 0;
    }

    // Buscar detalles de un producto específico
    public ResultSet buscarProducto(Integer id_producto) throws Exception {
        strSQL = "select pf.*, pro.dscto as descuento,  rb.nombre_rubro as rubro from producto_farmaceutico pf inner join promocion pro on pro.id_promocion = pf.id_promocion \n"
                + "inner join rubro rb on rb.id_rubro = pf.id_rubro where pf.id_producto =" + id_producto;

        try {
            rs = objconectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar producto farmacéutico --> " + e.getMessage());
        }
    }

  public ResultSet buscarDetalle(Integer idFormaFar, Integer producto) throws Exception {
    String strSQL = "SELECT dtf.*, fm.forma_farmaceutica, pro.nombre, fa.nombre_fabricante " +
                    "FROM detalle_producto_forma dtf " +
                    "INNER JOIN forma_farmaceutica fm ON dtf.id_frm_farma = fm.id_frm_farma " +
                    "INNER JOIN producto_farmaceutico pro ON pro.id_producto = dtf.id_producto " +
                    "INNER JOIN fabricante fa ON fa.id_fabricante = dtf.id_fabricante " +
                    "WHERE dtf.id_frm_farma = '" + idFormaFar + "' AND dtf.id_producto = '" + producto + "'";

    try {
        rs = objconectar.consultarBD(strSQL);
        return rs;
    } catch (Exception e) {
        throw new Exception("Error al buscar el producto y su tipo --> " + e.getMessage());
    }
}



    // Obtener código de producto por nombre
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

    
    public void eliminarProducto(Integer cod) throws Exception {
        String verificarSql = "SELECT COUNT(*) FROM detalle_producto_forma WHERE id_producto = " + cod;

        String eliminarSql = "DELETE FROM producto_farmaceutico WHERE id_producto = " + cod;

        try {
            ResultSet rs = objconectar.consultarBD(verificarSql);
            if (rs.next() && rs.getInt(1) == 0) {
                objconectar.ejecutarBd(eliminarSql);
            } else {
                throw new Exception("No se puede eliminar: este producto está siendo nombrada en un detalle de producto forma.");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar rubro --> " + e.getMessage());
        }
    }

    
    
    // Dar de baja un producto actualizando el estado a 'I'
    public void darDeBajaDetalleProducto(int id_producto, int id_frm_farma) throws Exception {
        strSQL = "UPDATE detalle_producto_forma SET estado = 'I' WHERE id_producto = " + id_producto + " AND id_frm_farma = " + id_frm_farma;

        try {
            objconectar.ejecutarBd(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja el producto con ID " + id_producto + " y la forma " + id_frm_farma + " --> " + e.getMessage());
        }
    }

}
