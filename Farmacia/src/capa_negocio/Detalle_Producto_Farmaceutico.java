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

    // Listar productos con filtro opcional
    public ResultSet listarDetalles_Pro_Farma() throws Exception {
        strSQL = "SELECT \n"
                + "    PF.NOMBRE AS NOMBRE_PRODUCTO,\n"
                + "    PF.NRO_REG_SANITARIO,\n"
                + "    PF.CONDICION_VENTA,\n"
                + "    DPF.STOCK,\n"
                + "    DPF.PRECIO_VENTA,\n"
                + "    DPF.PRINCIPIO_ACTIVO,\n"
                + "    DPF.DOSIS,\n"
                + "    FF.FORMA_FARMACEUTICA\n"
                + "FROM \n"
                + "    PRODUCTO_FARMACEUTICO PF\n"
                + "JOIN \n"
                + "    DETALLE_PRODUCTO_FORMA DPF ON PF.ID_PRODUCTO = DPF.ID_PRODUCTO\n"
                + "JOIN \n"
                + "    FORMA_FARMACEUTICA FF ON DPF.ID_FRM_FARMA = FF.ID_FRM_FARMA;";

        try {
            rs = objconectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al consultar los detalles productos farmaceuticos --> " + e.getMessage());
        }
    }
}
