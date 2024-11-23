package capa_negocio;

import capaDatos.datos;
import groovy.transform.Undefined;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Katia
 */
public class Reporte {

    public static final String RUTA_REPORTES = "src\\reportes\\";

    public JRViewer reporteInterno(String archivoReporte, Map<String, Object> parametros) throws Exception {
        try {
            datos objConecion = new datos();
            objConecion.conectar();
            JasperPrint reporte
                    = JasperFillManager.fillReport(this.RUTA_REPORTES + archivoReporte, 
                            parametros, 
                            objConecion.getCon());
            JRViewer visor = new JRViewer(reporte);
            return visor;
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
        }
        return null;

    }
    
   

    public JasperPrint reporteExterno(String archivoReporte, Map<String, Object> parametros) throws Exception {
        try {
            datos objConexion = new datos();
            objConexion.conectar();
            JasperPrint reporte = JasperFillManager.fillReport(
                    this.RUTA_REPORTES + archivoReporte,
                    parametros,
                    objConexion.getCon()
            );
            return reporte;
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

}
