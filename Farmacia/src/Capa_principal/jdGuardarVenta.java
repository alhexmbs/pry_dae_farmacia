/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Capa_principal;

import capa_negocio.Comprobante;
import capa_negocio.MetodoPago;
import capa_negocio.Pago;
import capa_negocio.Pedido;
import capa_negocio.TipoCompobante;
import java.sql.*;

import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author
 */
public class jdGuardarVenta extends javax.swing.JDialog {

    private jdPedido dialog1;
    Pedido objPedido = new Pedido();
    TipoCompobante objComprobante = new TipoCompobante();

    Pago objPago = new Pago();
    MetodoPago objMetodo = new MetodoPago();

    Comprobante objComprobanteFinoli = new Comprobante();

    JTable tblProducto;
    float total = 0.0f;
    int idCliente = 0;
    int usuario = 0;

    // Obtener la fecha actual usando LocalDate
    LocalDate localDate = LocalDate.now();

// Convertir LocalDate a java.sql.Date
    Date fechaEmision = Date.valueOf(localDate);

    /**
     * Creates new form jdGuardarVenta
     */
    public jdGuardarVenta(java.awt.Frame parent, boolean modal, jdPedido pedido) {
        super(parent, modal);
        this.dialog1 = pedido;
        initComponents();
        listarCrombantes();
        listarMmetodos();
    }

    private void listarCrombantes() {
        ResultSet rs = null;
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            cboComprobante.setModel(modelo);
            rs = objComprobante.listarTipoDeComprobante();

            modelo.addElement("--Ninguno--");
            while (rs.next()) {

                modelo.addElement(rs.getString("tipo_comprobante"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void listarMmetodos() {
        ResultSet rs = null;
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            cboMetodos.setModel(modelo);
            rs = objMetodo.listarMetodosPago();

            modelo.addElement("--Ninguno--");
            while (rs.next()) {

                modelo.addElement(rs.getString("metodo_pago"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGuardarVenta = new javax.swing.JButton();
        btnCancelarVenta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cboComprobante = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboMetodos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));

        btnGuardarVenta.setBackground(new java.awt.Color(236, 177, 89));
        btnGuardarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnGuardarVenta.setText("Guardar");
        btnGuardarVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarVenta.setPreferredSize(new java.awt.Dimension(45, 60));
        btnGuardarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVentaActionPerformed(evt);
            }
        });

        btnCancelarVenta.setBackground(new java.awt.Color(236, 177, 89));
        btnCancelarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar_Venta.png"))); // NOI18N
        btnCancelarVenta.setText("Cancelar");
        btnCancelarVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarVenta.setPreferredSize(new java.awt.Dimension(45, 60));
        btnCancelarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(170, 215, 217));

        jLabel71.setBackground(new java.awt.Color(70, 130, 169));
        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(51, 51, 51));
        jLabel71.setText("Venta:");

        jLabel1.setText("Tipo de Comprobante:");

        cboComprobante.setBackground(new java.awt.Color(246, 244, 235));
        cboComprobante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Método de pago:");

        cboMetodos.setBackground(new java.awt.Color(246, 244, 235));
        cboMetodos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboComprobante, 0, 171, Short.MAX_VALUE)
                            .addComponent(cboMetodos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel71)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMetodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(btnGuardarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentaActionPerformed
        try {
            String comprobante = cboComprobante.getSelectedItem().toString();

            if (comprobante.equals("--Ninguno--")) {
                JOptionPane.showMessageDialog(rootPane, "Primero debe seleccionar a un tipo de comprobante", "Sistema", JOptionPane.ERROR_MESSAGE);
            } else {

                int opcion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de guardar esta venta?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    System.out.println("========= ANTES DE FINALIZA ===================================");
                    objPedido.registrarVenta(total, usuario, idCliente, (JTable) tblProducto);
                    System.out.println("========= DESPUÉS DE FINALIZA ===================================");
                    JOptionPane.showMessageDialog(rootPane, "La venta se registró exitosamente", "SISTEMA", JOptionPane.INFORMATION_MESSAGE);

                    int id_pedido = objPedido.obtenerUltimoIdPedido();
                    int i = 1;
                    int id_tipo_comprobante;
                    String serie;

                    if (comprobante.equals("Boleta")) {
                        serie = "B0" + i;
                        id_tipo_comprobante = 1;
                    } else {
                        serie = "F0" + i;
                        id_tipo_comprobante = 2;
                    }

                    String serie_correlativo = objComprobanteFinoli.generarSerieCorrelativo(serie);
                    System.out.println("El último pedido es " + id_pedido);
                    System.out.println("El comprobante es " + serie_correlativo);
                    int id_comprobante = objComprobanteFinoli.generarCodigoComprobante();
                    // Registrar el comprobante con la fecha actual
                    objComprobanteFinoli.registrarComprobante(id_comprobante, serie_correlativo, fechaEmision, total, idCliente, usuario, id_tipo_comprobante, id_pedido);
                    
                    int id_pago = objPago.generarNuevoIdPago();
                    int id_metodo_pago = cboMetodos.getSelectedIndex();
                    String estado = "Pagado";
                    
                    objPago.registrarPago(id_pago, total, estado, id_pedido, usuario, idCliente, id_metodo_pago);
                    objPedido.actualizarEstadoPedido(id_pedido);
                    
                    // Limpiar y actualizar el diálogo
                    dialog1.asignarFechaActual();
                    dialog1.asignarNumPedidol();
                    dispose();
                    dialog1.vaciar();
                    dialog1.asignarFechaActual();
                } else {
                    // Opcional: manejar la opción "No"
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // Es recomendable manejar o registrar la excepción adecuadamente
        }
    }//GEN-LAST:event_btnGuardarVentaActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnGuardarVenta;
    private javax.swing.JComboBox<String> cboComprobante;
    private javax.swing.JComboBox<String> cboMetodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
