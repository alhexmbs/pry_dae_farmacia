package Capa_principal;

import capa_negocio.Reporte;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;

public class jdReportePromocionesRango extends javax.swing.JDialog {

    public jdReportePromocionesRango(java.awt.Frame parent, boolean modal) {
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
        jLabel1 = new javax.swing.JLabel();
        txtMenor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMayor = new javax.swing.JTextField();

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
            .addGap(0, 390, Short.MAX_VALUE)
        );

        jLabel1.setText("Menor:");

        jLabel2.setText("Mayor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vistareporte)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnVerReporte)
                        .addGap(0, 294, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerReporte)
                    .addComponent(jLabel1)
                    .addComponent(txtMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

            // Crear parámetros para el reporte
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("mayor", Integer.parseInt(txtMayor.getText()));  // Corregido aquí
            parametros.put("menor", Integer.parseInt(txtMenor.getText()));  // Corregido aquí

            // Generar el reporte y añadirlo al contenedor
            JRViewer objReporte = new Reporte().reporteInterno("rep_promociones_2.jasper", parametros);
            contenedor.add(objReporte);

            // Forzar la actualización del contenedor
            contenedor.revalidate();
            contenedor.repaint();

            // Mostrar la interfaz del reporte
            this.vistareporte.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + " ERROR en Reporte", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtMayor;
    private javax.swing.JTextField txtMenor;
    private javax.swing.JDesktopPane vistareporte;
    // End of variables declaration//GEN-END:variables
}
