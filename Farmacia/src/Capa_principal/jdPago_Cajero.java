package Capa_principal;

import capa_negocio.Comprobante;
import capa_negocio.MetodoPago;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class jdPago_Cajero extends javax.swing.JDialog {

    public jdPago_Cajero(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarTipoComprobante();
        listarMetodosPago();
    }

    Comprobante objCompro = new Comprobante();
    MetodoPago objMetodo = new MetodoPago();

    private void listarMetodosPago() {
        ResultSet rsTipo = null;
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        try {

            rsTipo = objMetodo.listarMetodosPago();

            while (rsTipo.next()) {
                modelo.addElement(rsTipo.getString("metodo_pago"));
            }

            cmbMetodoPago.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar los tipos de pagos: " + e.getMessage());
        } finally {

            if (rsTipo != null) {
                try {
                    rsTipo.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el ResultSet: " + ex.getMessage());
                }
            }
        }
    }

    private void listarTipoComprobante() {
        ResultSet rsTipo = null;
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        try {

            rsTipo = objCompro.listarTiposComprobante();

            while (rsTipo.next()) {
                modelo.addElement(rsTipo.getString("tipo_comprobante"));
            }

            cmbTipoComprobante.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar tipos de comprobante: " + e.getMessage());
        } finally {

            if (rsTipo != null) {
                try {
                    rsTipo.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el ResultSet: " + ex.getMessage());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_id_pedido = new javax.swing.JLabel();
        lbl_monto_pedido = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbTipoComprobante = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        background_panel.setBackground(new java.awt.Color(246, 244, 235));
        background_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(170, 215, 217));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Monto a pagar:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setText("Pedido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        lbl_id_pedido.setBackground(new java.awt.Color(204, 204, 204));
        lbl_id_pedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_id_pedido.setOpaque(true);
        jPanel1.add(lbl_id_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 120, 30));

        lbl_monto_pedido.setBackground(new java.awt.Color(204, 204, 204));
        lbl_monto_pedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_monto_pedido.setOpaque(true);
        jPanel1.add(lbl_monto_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, 30));

        btnPagar.setBackground(new java.awt.Color(236, 177, 89));
        btnPagar.setText("Pagar");
        jPanel1.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 120, 30));

        jLabel4.setText("El id del pedido viene desde el pedido");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jLabel7.setText("El monto viene desde el pedido");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel8.setText("El usuario viene desde el inicio de sesión");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel9.setText("No se podrían considerar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel10.setText("El cliente viene desde pedido");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 100, -1));

        jLabel5.setText("Cliente:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 120, 30));

        jLabel2.setText("Tipo de comprobante:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        cmbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 110, 20));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 100, 20));

        jLabel11.setText("Monto:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jLabel12.setText("Agregar un JOptionPane de si se está conforme con el pago");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        cmbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbTipoComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 120, 20));

        jLabel13.setText("Método de pago:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        background_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 730, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background_panel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JComboBox<String> cmbTipoComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_id_pedido;
    private javax.swing.JLabel lbl_monto_pedido;
    // End of variables declaration//GEN-END:variables
}
