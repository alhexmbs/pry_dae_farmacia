
package Capa_principal;

import capa_negocio.Reporte;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Katia
 */
public class jdR_MentasMensuales extends javax.swing.JDialog {

    public jdR_MentasMensuales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
                this.vistareporte.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        vistareporte = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistareporteLayout = new javax.swing.GroupLayout(vistareporte);
        vistareporte.setLayout(vistareporteLayout);
        vistareporteLayout.setHorizontalGroup(
            vistareporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vistareporteLayout.setVerticalGroup(
            vistareporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vistareporte)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap(521, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(vistareporte)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try {
            Container contenedor = this.vistareporte;
            contenedor.setLayout(new BorderLayout());

            JRViewer objReporte = new Reporte().reporteInterno("ventasMensuales.jasper", null);
            contenedor.add(objReporte);
            objReporte.setVisible(true);

            this.vistareporte.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error reporte frm-->" +e.getMessage());
        }    }//GEN-LAST:event_jButton1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane vistareporte;
    // End of variables declaration//GEN-END:variables
}
