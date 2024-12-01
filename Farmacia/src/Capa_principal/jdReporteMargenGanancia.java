package Capa_principal;

import capa_negocio.Reporte;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;

public class jdReporteMargenGanancia extends javax.swing.JDialog {

    public jdReporteMargenGanancia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.vistareporte.setVisible(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerReporte = new javax.swing.JButton();
        vistareporte = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnVerReporte.setText("Ver reporte");
        btnVerReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReporteActionPerformed(evt);
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
            .addGap(0, 398, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vistareporte)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerReporte)
                        .addGap(0, 634, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVerReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vistareporte)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReporteActionPerformed
        try {
            Container contenedor = this.vistareporte;
            contenedor.setLayout(new BorderLayout());

            JRViewer objReporte = new Reporte().reporteInterno("reporte_margen_ganancias.jasper", null);
            contenedor.add(objReporte);
            objReporte.setVisible(true);
            this.vistareporte.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + " ERROR en Reporte", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerReporte;
    private javax.swing.JDesktopPane vistareporte;
    // End of variables declaration//GEN-END:variables
}
