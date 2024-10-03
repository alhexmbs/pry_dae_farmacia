package Capa_principal;

import capa_negocio.MetodoPago;
import capa_negocio.Pago;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jdPago_Admin extends javax.swing.JDialog {

    public jdPago_Admin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    Pago objPago = new Pago();
    MetodoPago objMetodo = new MetodoPago();

    /*listar pagos*/
    private void listarPagos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Monto");
        modelo.addColumn("Estado pago");
        modelo.addColumn("Pedido");
        modelo.addColumn("Usuario");
        modelo.addColumn("Cliente");
        modelo.addColumn("Metodo pago");

        tblPagos.setModel(modelo);

        ResultSet rs = null;
        try {
            rs = objPago.listarPagos();

            while (rs.next()) {
                Object[] fila = new Object[13];
                fila[0] = rs.getInt("id_pago");
                fila[1] = rs.getDouble("monto_pago");
                fila[2] = rs.getString("estado_pago");
                fila[3] = rs.getInt("id_pedido");
                fila[4] = rs.getString("username");
                fila[5] = rs.getString("cliente");
                fila[6] = rs.getString("metodo_pago");

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar pagos --> " + e.getMessage());
        }
    }

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

    private void buscarPago() {
        ResultSet rsProducto = null;
        try {
            if (txtBuscarPago.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un código de pago para buscar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int idPago = Integer.parseInt(txtBuscarPago.getText());
                rsProducto = objPago.buscarPago(idPago);

                if (rsProducto.next()) {
                    lbl_id_pago.setText(rsProducto.getString("id_pago"));
                    lbl_id_pedido.setText(rsProducto.getString("id_pedido"));
                    lbl_id_usuario.setText(rsProducto.getString("username"));
                    lbl_id_cliente.setText(rsProducto.getString("cliente"));
                    txtMonto.setText(rsProducto.getString("monto_pago"));
                    cbxEstado.setSelectedItem(rsProducto.getString("estado_pago"));
                    cmbMetodoPago.setSelectedItem(rsProducto.getString("metodo_pago"));

                    rsProducto.close();
                } else {
                    JOptionPane.showMessageDialog(this, "El código de producto no existe", "Producto no encontrado", JOptionPane.INFORMATION_MESSAGE);
                    txtBuscarPago.setText("");
                    txtMonto.setText("");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El código de producto debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el producto --> " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        lbl_id_pago.setText("");
        lbl_id_pedido.setText("");
        lbl_id_usuario.setText("");
        lbl_id_cliente.setText("");
        txtMonto.setText("");
        cbxEstado.setSelectedIndex(0);
        cmbMetodoPago.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        txtBuscarPago = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_id_pago = new javax.swing.JLabel();
        lbl_id_pedido = new javax.swing.JLabel();
        lbl_id_usuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        lbl_id_cliente = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(170, 215, 217));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPagosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPagos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 760, 150));
        jPanel2.add(txtBuscarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, -1));

        jLabel1.setText("Buscar por ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(236, 177, 89));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 120, 40));

        btnLimpiar.setBackground(new java.awt.Color(236, 177, 89));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 120, 40));

        btnCerrar.setBackground(new java.awt.Color(236, 177, 89));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 80, -1));

        btnModificar.setBackground(new java.awt.Color(236, 177, 89));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edity.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 150, 50));

        btnEliminar.setBackground(new java.awt.Color(236, 177, 89));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 150, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 800, 290));

        jPanel3.setBackground(new java.awt.Color(170, 215, 217));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setText("Pedido:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setText("Usuario:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        lbl_id_pago.setBackground(new java.awt.Color(204, 204, 204));
        lbl_id_pago.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_id_pago.setOpaque(true);
        jPanel3.add(lbl_id_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 90, 20));

        lbl_id_pedido.setBackground(new java.awt.Color(204, 204, 204));
        lbl_id_pedido.setOpaque(true);
        jPanel3.add(lbl_id_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 90, 20));

        lbl_id_usuario.setBackground(new java.awt.Color(204, 204, 204));
        lbl_id_usuario.setOpaque(true);
        jPanel3.add(lbl_id_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 100, 20));

        jLabel6.setText("Estado:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Pendiente", "Pagado" }));
        jPanel3.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 100, -1));

        jLabel7.setText("Cliente:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        lbl_id_cliente.setBackground(new java.awt.Color(204, 204, 204));
        lbl_id_cliente.setOpaque(true);
        jPanel3.add(lbl_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 100, 20));

        jLabel9.setText("Monto a pagar:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));
        jPanel3.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 100, 20));

        jLabel5.setText("Método de pago:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));
        jPanel3.add(cmbMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 120, -1));

        jButton2.setBackground(new java.awt.Color(236, 177, 89));
        jButton2.setText("Agregar");
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listarPagos();
        listarMetodosPago();
    }//GEN-LAST:event_formWindowOpened

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPago();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPagosMouseClicked
        txtBuscarPago.setText(String.valueOf(tblPagos.getValueAt(tblPagos.getSelectedRow(), 0)));
        btnBuscarActionPerformed(null);
    }//GEN-LAST:event_tblPagosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_id_cliente;
    private javax.swing.JLabel lbl_id_pago;
    private javax.swing.JLabel lbl_id_pedido;
    private javax.swing.JLabel lbl_id_usuario;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtBuscarPago;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
