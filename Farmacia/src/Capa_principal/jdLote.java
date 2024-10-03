
package Capa_principal;
import capa_negocio.Lote;
import capa_negocio.Producto;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Katia
 */
public class jdLote extends javax.swing.JDialog {
    Lote objLote = new Lote();
    Producto objProducto = new Producto();
    int idUsuario = 1;

    public jdLote(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarProductos();
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
        txtNumeroLote = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jcFechaVencimiento = new com.toedter.calendar.JDateChooser();
        cboEstadoFarmaco = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox<>();
        btnNewProducto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cboFiltros = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFf = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();

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
        jLabel62.setText("Datos del lote:");

        jLabel68.setBackground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("ID del lote:");

        jLabel64.setBackground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Número lote:");

        txtNumeroLote.setBackground(new java.awt.Color(239, 237, 220));
        txtNumeroLote.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtId.setBackground(new java.awt.Color(239, 237, 220));
        txtId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnBuscar.setBackground(new java.awt.Color(236, 177, 89));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lupa.png"))); // NOI18N
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel65.setBackground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("Fecha vencimiento:");

        jLabel66.setBackground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Estado farmaco:");

        cboEstadoFarmaco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vigente", "Suspendido", "Cancelado", "Vencido" }));

        jLabel67.setBackground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("Producto:");

        btnNewProducto.setBackground(new java.awt.Color(236, 177, 89));
        btnNewProducto.setText("Añadir");
        btnNewProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel67)
                    .addComponent(jLabel62)
                    .addComponent(jLabel68)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroLote, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jcFechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboEstadoFarmaco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(cboProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel68))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel65))
                    .addComponent(jcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(cboEstadoFarmaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewProducto)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(246, 244, 235));

        jLabel24.setText("Filtrar por");

        cboFiltros.setBackground(new java.awt.Color(246, 244, 235));
        cboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Fecha vencimiento ascendente", "Fecha vencimiento descendente", "Vencidos", "Disponibles" }));
        cboFiltros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltrosActionPerformed(evt);
            }
        });

        tblFf.setAutoCreateRowSorter(true);
        tblFf.setBackground(new java.awt.Color(170, 215, 217));
        tblFf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFf.setShowGrid(false);
        tblFf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFfMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblFf);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnedit.setBackground(new java.awt.Color(236, 177, 89));
        btnedit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edity.png"))); // NOI18N
        btnedit.setText("MODIFICAR");
        btnedit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnlimpiar.setBackground(new java.awt.Color(236, 177, 89));
        btnlimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(236, 177, 89));
        btneliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnlimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnedit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ResultSet rsLote = null;
        try {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un código de lote para buscar");
            } else {
                int idLote = Integer.parseInt(txtId.getText());

                rsLote = objLote.buscarLote(idLote);

                if (rsLote.next()) {
                    txtNumeroLote.setText(rsLote.getString("numero_lote"));
                    jcFechaVencimiento.setDate(rsLote.getDate("fecha_vencimiento"));
                    cboEstadoFarmaco.setSelectedItem(rsLote.getString("estado_farmaco"));
                    cboProducto.setSelectedItem(rsLote.getString("nombre_producto"));
                    rsLote.close();
                } else {
                    JOptionPane.showMessageDialog(this, "El código del lote no existe");
                    limpiarCampos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el lote: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cboFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltrosActionPerformed
        String filtro = cboFiltros.getSelectedItem().toString();
        listarLotes(filtro);
    }//GEN-LAST:event_cboFiltrosActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (btnSave.getText().equals("NUEVO")) {
                btnSave.setText("GUARDAR");
                txtId.setText(String.valueOf(objLote.generarCodigoLote()));
                txtNumeroLote.requestFocus();
            } else {
                if (txtNumeroLote.getText().isEmpty() || jcFechaVencimiento.getDate() == null || cboEstadoFarmaco.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                } else {
                    int codigoLote = Integer.parseInt(txtId.getText());
                    String numeroLote = txtNumeroLote.getText();
                    java.sql.Date fechaVencimiento = new java.sql.Date(jcFechaVencimiento.getDate().getTime());
                    String estadoFarmaco = cboEstadoFarmaco.getSelectedItem().toString();
                    String producto  = cboProducto.getSelectedItem().toString();
                    int id_producto = objProducto.obtenerCodigoProducto(producto);

                    objLote.registrarLote(codigoLote, numeroLote, fechaVencimiento, estadoFarmaco, idUsuario,id_producto);

                    JOptionPane.showMessageDialog(this, "Lote guardado correctamente");

                    btnSave.setText("NUEVO");
                    limpiarCampos();
                    listarLotes("General");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el lote: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un lote para modificar.");
            } else {
                if (txtNumeroLote.getText().isEmpty() || jcFechaVencimiento.getDate() == null || cboEstadoFarmaco.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                } else {
                    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar este lote?", "Confirmar modificación", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idLote = Integer.parseInt(txtId.getText());
                        String numeroLote = txtNumeroLote.getText();
                        java.sql.Date fechaVencimiento = new java.sql.Date(jcFechaVencimiento.getDate().getTime());
                        String estadoFarmaco = cboEstadoFarmaco.getSelectedItem().toString();
                        String producto = cboProducto.getSelectedItem().toString();
                        int id_producto = objProducto.obtenerCodigoProducto(producto);
                        objLote.modificarLote(idLote, numeroLote, fechaVencimiento, estadoFarmaco, id_producto);

                        JOptionPane.showMessageDialog(this, "Lote modificado correctamente");

                        limpiarCampos();
                        listarLotes("General");
                    } else {
                        JOptionPane.showMessageDialog(this, "Modificación cancelada.");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar el lote: " + e.getMessage());
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        try {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el ID del lote a eliminar.");
        } else {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este lote?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                int cod = Integer.parseInt(txtId.getText());
                
                if (objLote.buscarLote(cod) != null) {
                    objLote.eliminarLote(cod);
                    JOptionPane.showMessageDialog(this, "Lote eliminado con éxito.");

                    limpiarCampos();
                    listarLotes("General");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un lote con ese ID.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Eliminación cancelada.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar el lote: " + e.getMessage());
    }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tblFfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFfMouseClicked

        txtId.setText(String.valueOf(tblFf.getValueAt(tblFf.getSelectedRow(), 0)));
        btnBuscarActionPerformed(null);


    }//GEN-LAST:event_tblFfMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listarLotes("General");

    }//GEN-LAST:event_formWindowOpened

    private void btnNewProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProductoActionPerformed
        jdManProducto obj = new jdManProducto(null, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnNewProductoActionPerformed

  private void limpiarCampos() {
        txtNumeroLote.setText("");
        txtId.setText("");
        jcFechaVencimiento.setDate(null);
        cboEstadoFarmaco.setSelectedIndex(0);
        cboProducto.setSelectedIndex(0);
                
    }

    private void listarLotes(String estado) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Lote");
        modelo.addColumn("Número Lote");
        modelo.addColumn("Fecha Vencimiento");
        modelo.addColumn("Estado Farmaco");
        modelo.addColumn("ID Usuario");
        modelo.addColumn("Producto");

        ResultSet rsLote = null;
        try {
            rsLote = objLote.listarLotes(estado);

            while (rsLote.next()) {
                Object[] fila = new Object[6];
                fila[0] = rsLote.getInt("id_lote");
                fila[1] = rsLote.getString("numero_lote");
                fila[2] = rsLote.getDate("fecha_vencimiento");
                fila[3] = rsLote.getString("estado_farmaco");
                fila[4] = rsLote.getInt("id_usuario");
                fila[5] = rsLote.getString("nombre_producto");
                modelo.addRow(fila);
            }

            tblFf.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar los lotes: " + e.getMessage());
        }
    }
    
    private void listarProductos() {
    ResultSet listarProductos = null;
    DefaultComboBoxModel modeloProducto = new DefaultComboBoxModel();
    cboProducto.setModel(modeloProducto);
    try {
        listarProductos = objProducto.listarProductos("General");
        while (listarProductos.next()) {
            modeloProducto.addElement(listarProductos.getString("nombre"));  
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al listar productos---> " + e.getMessage());
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNewProducto;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cboEstadoFarmaco;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jcFechaVencimiento;
    private javax.swing.JTable tblFf;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumeroLote;
    // End of variables declaration//GEN-END:variables
}
