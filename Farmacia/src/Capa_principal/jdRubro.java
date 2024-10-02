
package Capa_principal;

import capa_negocio.Rubro;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class jdRubro extends javax.swing.JDialog {
    Rubro objR = new Rubro();

    /**
     * Creates new form jdRubro
     */
    public jdRubro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtId2 = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cboFiltros = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaGuardarda1 = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnModificaar = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));

        jPanel2.setBackground(new java.awt.Color(170, 215, 217));

        jLabel62.setBackground(new java.awt.Color(70, 130, 169));
        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Datos del rubro:      ");

        jLabel68.setBackground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("ID del rubro:");

        jLabel64.setBackground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Nombre:");

        txtNombre.setBackground(new java.awt.Color(239, 237, 220));
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtId2.setBackground(new java.awt.Color(239, 237, 220));
        txtId2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId2ActionPerformed(evt);
            }
        });

        btnBuscar1.setBackground(new java.awt.Color(236, 177, 89));
        btnBuscar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N
        btnBuscar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel68)
                            .addComponent(jLabel64))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel62)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68))
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(246, 244, 235));

        jLabel24.setText("Filtrar por");

        cboFiltros.setBackground(new java.awt.Color(246, 244, 235));
        cboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Nombre ascendente", "Nombre descente" }));
        cboFiltros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltrosActionPerformed(evt);
            }
        });

        TablaGuardarda1.setAutoCreateRowSorter(true);
        TablaGuardarda1.setBackground(new java.awt.Color(170, 215, 217));
        TablaGuardarda1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaGuardarda1.setShowGrid(false);
        TablaGuardarda1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaGuardarda1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaGuardarda1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        btnSave.setBackground(new java.awt.Color(236, 177, 89));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSave.setText("NUEVO");
        btnSave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnModificaar.setBackground(new java.awt.Color(236, 177, 89));
        btnModificaar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificaar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edity.png"))); // NOI18N
        btnModificaar.setText("MODIFICAR");
        btnModificaar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificaar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaarActionPerformed(evt);
            }
        });

        btnNuevo1.setBackground(new java.awt.Color(236, 177, 89));
        btnNuevo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnNuevo1.setText("LIMPIAR");
        btnNuevo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });

        btnEliminar1.setBackground(new java.awt.Color(236, 177, 89));
        btnEliminar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnEliminar1.setText("ELIMINAR");
        btnEliminar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEliminar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificaar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificaar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId2ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        ResultSet rsRubro = null;
        try {
            if (txtId2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un código para buscar");
            } else {
                rsRubro = objR.buscarRubro(Integer.parseInt(txtId2.getText()));

                if (rsRubro.next()) {
                    txtNombre.setText(rsRubro.getString("nombre_rubro"));
                    rsRubro.close();
                } else {
                    JOptionPane.showMessageDialog(this, "Código de rubro  no existe");
                    limpiar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e);
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void cboFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltrosActionPerformed
        String filtro = cboFiltros.getSelectedItem().toString();
        listar(filtro);

    }//GEN-LAST:event_cboFiltrosActionPerformed

    private void TablaGuardarda1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaGuardarda1MouseClicked

        txtId2.setText(String.valueOf(TablaGuardarda1.getValueAt(TablaGuardarda1.getSelectedRow(), 0)));
        btnBuscar1ActionPerformed(null);
    }//GEN-LAST:event_TablaGuardarda1MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (btnSave.getText().equals("NUEVO")) {
                btnSave.setText("GUARDAR");
                txtId2.setText(String.valueOf(objR.generarCodigoRubro()));
                txtNombre.requestFocus();
            } else {
                int codigo = Integer.parseInt(txtId2.getText());

                String nombre = txtNombre.getText();
                if (!nombre.isEmpty()) {
                    objR.registrarRubro(codigo, nombre);
                    btnSave.setText("NUEVO");
                    limpiar();
                    listar("General");
                    JOptionPane.showMessageDialog(this, "Rubro guardado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese información en todos los campos");
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al insertar rubro -->" + e.getMessage());
        }
    }

    public void limpiar() {
        txtId2.setText("");
        txtNombre.setText("");
    }

    public void listar(String tipo) {
        ResultSet lista = null;
        Vector rubro;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre rubro");

        try {
            lista = objR.listarRubros(tipo);
            while (lista.next()) {
                rubro = new Vector();
                rubro.add(lista.getInt("id_rubro"));
                rubro.add(lista.getString("nombre_rubro"));
                modelo.addRow(rubro);
            }
            TablaGuardarda1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar los rubros: " + e.getMessage());
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnModificaarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaarActionPerformed
        if (txtId2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un código a modificar");
        } else {
            int codigo = Integer.parseInt(txtId2.getText());
            String nombre = txtNombre.getText();
            if (!nombre.isEmpty()) {

                try {
                    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea modificar  este rubro?");
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        objR.modificarRubro(codigo, nombre);
                        limpiar();
                        listar("General");
                        JOptionPane.showMessageDialog(this, "Rubro modificado correctamente");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al modificar rubro---> " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese información en todos los campos");

            }

        }
    }//GEN-LAST:event_btnModificaarActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        try {
            if (txtId2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un código a eliminar");
            } else {

                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este rubro?");
                if (confirmacion == JOptionPane.YES_OPTION) {
                    objR.eliminarRubro(Integer.parseInt(txtId2.getText()));
                    limpiar();
                    listar("General");
                    JOptionPane.showMessageDialog(rootPane, "Rubro eliminado correctamente");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listar("General");
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaGuardarda1;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnModificaar;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtId2;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
