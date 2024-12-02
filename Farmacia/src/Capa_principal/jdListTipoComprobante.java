/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Capa_principal;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import capa_negocio.TipoCompobante;

/**
 *
 * @author joseph
 */
public class jdListTipoComprobante extends javax.swing.JDialog {

    private jdPedido dialog1; 
    
    TipoCompobante objC = new TipoCompobante();

    //
//    jdPedido objJdPedido = new jdPedido(null, true);

    /**
     * Creates new form jdListTipoComprobante
     */
    public jdListTipoComprobante(java.awt.Frame parent, boolean modal, jdPedido pedido) {
        super(parent, modal);
        initComponents();
        this.dialog1 = pedido;
        listarTiposDeComprobante();
    }

    private void listarTiposDeComprobante() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("TIPO DE COMPROBANTE");

        tblTiposComprobante.setModel(modelo);

        ResultSet rs = null;
        try {
            rs = objC.listarTipoDeComprobante();
            while (rs.next()) {
                Object[] fila = new Object[9];
                fila[0] = rs.getInt("id_tipo_comprobante");
                fila[1] = rs.getString("tipo_comprobante");

                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurri� un error inesperado", "Error al obtener los tipos de comprobantes", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTiposComprobante = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnEliminar3 = new javax.swing.JButton();
        btnEliminar4 = new javax.swing.JButton();
        btnEliminar5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(246, 244, 235));

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Buscar Tipo de Comprobante", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblTiposComprobante.setBackground(new java.awt.Color(170, 215, 217));
        tblTiposComprobante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTiposComprobante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiposComprobanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTiposComprobante);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEliminar3.setBackground(new java.awt.Color(236, 177, 89));
        btnEliminar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnEliminar3.setText("NUEVO");
        btnEliminar3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar3.setPreferredSize(new java.awt.Dimension(50, 55));
        btnEliminar3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar3ActionPerformed(evt);
            }
        });

        btnEliminar4.setBackground(new java.awt.Color(236, 177, 89));
        btnEliminar4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/darBaja.png"))); // NOI18N
        btnEliminar4.setText("CANCELAR");
        btnEliminar4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar4.setPreferredSize(new java.awt.Dimension(50, 55));
        btnEliminar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar4ActionPerformed(evt);
            }
        });

        btnEliminar5.setBackground(new java.awt.Color(236, 177, 89));
        btnEliminar5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnEliminar5.setText("REGRESAR");
        btnEliminar5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar5.setPreferredSize(new java.awt.Dimension(50, 55));
        btnEliminar5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnEliminar3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminar4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar3ActionPerformed

    private void btnEliminar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar4ActionPerformed

    private void btnEliminar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar5ActionPerformed

    private void tblTiposComprobanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiposComprobanteMouseClicked
        int idComprobante = Integer.parseInt(tblTiposComprobante.getValueAt(tblTiposComprobante.getSelectedRow(), 0).toString());
        String tipo = tblTiposComprobante.getValueAt(tblTiposComprobante.getSelectedRow(), 1).toString();

        dialog1.setTipoComprobante(tipo);
    }//GEN-LAST:event_tblTiposComprobanteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar3;
    private javax.swing.JButton btnEliminar4;
    private javax.swing.JButton btnEliminar5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblTiposComprobante;
    // End of variables declaration//GEN-END:variables
}
