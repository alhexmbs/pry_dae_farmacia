package Capa_principal;

import capa_negocio.Comprobante;
import capa_negocio.MetodoPago;
import capa_negocio.Pago;
import capa_negocio.Pedido;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class jdPago_Cajero extends javax.swing.JDialog {

    //Pago pago = new Pago();
    Pedido pedido = new Pedido();
    int idPedido;

    public jdPago_Cajero(java.awt.Frame parent, boolean modal, int idPedido) {
        super(parent, modal);
        this.idPedido = idPedido;
        initComponents();
        listarTipoComprobante();
        listarMetodosPago();
        mostrarMontoPedido();
    }

    private void mostrarMontoPedido() {
        try {
            ResultSet rs = pedido.obtenerMontoPedidoYSaldoRestante(idPedido);
            if (rs.next()) {
                //double montoPedido = rs.getDouble("monto_pedido");
                double saldoRestante = rs.getDouble("saldo_restante");
                lbl_monto_pedido.setText(String.valueOf(saldoRestante));
                txtTotalPagado.setText(String.valueOf(saldoRestante));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el monto del pedido: " + e.getMessage());
        }
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
        lbl_monto_pedido = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        txtTotalPagado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoComprobante = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        lblSaldoRestante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        background_panel.setBackground(new java.awt.Color(246, 244, 235));
        background_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(170, 215, 217));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Monto a pagar:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        lbl_monto_pedido.setBackground(new java.awt.Color(204, 204, 204));
        lbl_monto_pedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_monto_pedido.setOpaque(true);
        jPanel1.add(lbl_monto_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 120, 30));

        btnPagar.setBackground(new java.awt.Color(236, 177, 89));
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 120, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 100, -1));

        jLabel2.setText("Tipo de comprobante:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        cmbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 20));
        jPanel1.add(txtTotalPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 100, 20));

        jLabel11.setText("Monto:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        cmbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbTipoComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 120, 20));

        jLabel13.setText("Método de pago:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jPanel1.add(lblSaldoRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 70, 30));

        background_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 490, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        
    }//GEN-LAST:event_btnPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background_panel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JComboBox<String> cmbTipoComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSaldoRestante;
    private javax.swing.JLabel lbl_monto_pedido;
    private javax.swing.JTextField txtTotalPagado;
    // End of variables declaration//GEN-END:variables
}
