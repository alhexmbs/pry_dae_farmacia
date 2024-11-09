/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capa_negocio;

import capaDatos.datos;
import java.sql.ResultSet;

/**
 *
 * @author Joseph
 */
public class Detalle_Producto_Farmaceutico {

    datos objconectar = new datos();
    String strSQL;
    ResultSet rs = null;

    public ResultSet obtenerDetalle_Producto_Forma(int forma, int producto) throws Exception {
        strSQL = "SELECT DPF.*, P.*\n"
                + "FROM PROMOCION P INNER JOIN  PRODUCTO_FARMACEUTICO PF ON P.ID_PROMOCION = PF.ID_PRODUCTO\n"
                + "INNER JOIN DETALLE_PRODUCTO_FORMA DPF ON PF.ID_PRODUCTO = DPF.ID_PRODUCTO\n"
                + "WHERE DPF.ID_FRM_FARMA = " + forma + " AND DPF.ID_PRODUCTO = " + producto;

        try {
            rs = objconectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al obtener el Detalle Producto Forma --> " + e.getMessage());
        }
    }

    public int obtenerStock(int forma, int producto) throws Exception {
        strSQL = "SELECT STOCK FROM detalle_producto_forma WHERE ID_FRM_FARMA = " + forma + " AND ID_PRODUCTO = " + producto;
        try {
            rs = objconectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("STOCK");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el stock del detalle_producto_farmaceutico --> " + e.getMessage());
        }
        return 0;
    }

    public float obtenerPrecioMaximo() throws Exception {
        strSQL = "SELECT MAX(PRECIO_VENTA) AS MAXIMO_PRECIO FROM DETALLE_PRODUCTO_FORMA";
        try {
            rs = objconectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getFloat("maximo_precio");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el precio maximo --> " + e.getMessage());
        }
        return 0.0f;
    }

    public ResultSet filtro1(String nombre, float min, float max) throws Exception {
        strSQL = "SELECT \n"
                + "pf.nombre AS nombre_producto,\n"
                + "pf.nro_reg_sanitario AS registro_sanitario,\n"
                + "pf.condicion_venta AS condicion_venta,\n"
                + "ff.forma_farmaceutica AS forma_farmaceutica,\n"
                + "f.nombre_fabricante AS fabricante,\n"
                + "dpf.stock AS stock,\n"
                + "dpf.precio_venta AS precio,\n"
                + "dpf.principio_activo AS principio_activo,\n"
                + "dpf.dosis AS dosis,\n"
                + "r.nombre_rubro AS rubro,\n"
                + "p.dscto AS descuento,\n"
                + "p.fecha_inicio AS fecha_inicio_promocion,\n"
                + "p.fecha_fin AS fecha_fin_promocion,\n"
                + "dpf.ID_FRM_FaRMA AS ID_FaRMA,\n"
                + "dpf.ID_PRODUCTO AS ID_PRODUCTO\n"
                + "FROM\n"
                + "producto_farmaceutico pf\n"
                + "INNER JOIN \n"
                + "detalle_producto_forma dpf ON pf.id_producto = dpf.id_producto\n"
                + "INNER JOIN \n"
                + "forma_farmaceutica ff ON dpf.id_frm_farma = ff.id_frm_farma\n"
                + "INNER JOIN \n"
                + "fabricante f ON dpf.id_fabricante = f.id_fabricante\n"
                + "INNER JOIN \n"
                + "rubro r ON pf.id_rubro = r.id_rubro\n"
                + "LEFT JOIN \n"
                + "promocion p ON pf.id_promocion = p.id_promocion\n"
                + "WHERE \n"
                + "dpf.precio_venta BETWEEN " + min + " AND " + max + " \n"
                + "AND UPPER(pf.nombre) LIKE UPPER('%" + nombre + "%') \n"
                + "ORDER BY \n"
                + "pf.nombre;";

        try {
            rs = objconectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al consultar los detalles productos farmaceuticos --> " + e.getMessage());
        }
    }

    // Listar productos con filtro opcional
    public ResultSet listarDetalles_Pro_Farma() throws Exception {
        strSQL = "SELECT \n"
                + "    PF.NOMBRE AS NOMBRE_PRODUCTO,\n"
                + "    PF.NRO_REG_SANITARIO,\n"
                + "    PF.CONDICION_VENTA,\n"
                + "    FF.FORMA_FARMACEUTICA,\n"
                + "    F.NOMBRE_FABRICANTE,\n"
                + "    L.FECHA_ENTRADA,\n"
                + "    L.FECHA_VENCIMIENTO,\n"
                + "    DPF.STOCK,\n"
                + "    DPF.PRECIO_VENTA,\n"
                + "    DPF.PRINCIPIO_ACTIVO,\n"
                + "    DPF.DOSIS\n"
                + "FROM \n"
                + "    DETALLE_PRODUCTO_FORMA DPF\n"
                + "INNER JOIN \n"
                + "    PRODUCTO_FARMACEUTICO PF ON DPF.ID_PRODUCTO = PF.ID_PRODUCTO\n"
                + "INNER JOIN \n"
                + "    FORMA_FARMACEUTICA FF ON DPF.ID_FRM_FARMA = FF.ID_FRM_FARMA\n"
                + "INNER JOIN \n"
                + "    FABRICANTE F ON DPF.ID_FABRICANTE = F.ID_FABRICANTE\n"
                + "INNER JOIN \n"
                + "    LOTE L ON DPF.ID_LOTE = L.ID_LOTE";

        try {
            rs = objconectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al consultar los detalles productos farmaceuticos --> " + e.getMessage());
        }
    }
}
