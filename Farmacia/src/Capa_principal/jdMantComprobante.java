package Capa_principal;

import capa_negocio.Comprobante;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Admin
 */
public class jdMantComprobante extends javax.swing.JDialog {

    public jdMantComprobante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarTipoComprobante();
        listarComprobantes();
        jcFechaEmision.setMinSelectableDate(new Date());
    }
    Comprobante objCompro = new Comprobante();
    String serie;
    String fecha;
    Float importe;
    String cliente;
    String tipo_comprobante;
    Integer id_pedido;
    String username;

    int id_cliente;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNComprobante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        cbTipoComprobante = new javax.swing.JComboBox<>();
        txtImporteTotal = new javax.swing.JTextField();
        jcFechaEmision = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaComprobante = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtIDClienteBusqueda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnBuscarIDCliente = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comprobantes");

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));

        jPanel2.setBackground(new java.awt.Color(170, 215, 217));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Datos Comprobante: ");

        jLabel2.setText("N° Comprobante: ");

        jLabel3.setText("ID Cliente: ");

        jLabel4.setText("Fecha Emision: ");

        jLabel5.setText("Comprobante: ");

        jLabel6.setText("Importe Total: ");

        jLabel7.setText("ID Usuario: ");

        cbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2" }));

        jLabel10.setText("ID Pedido: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtImporteTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbTipoComprobante, javax.swing.GroupLayout.Alignment.LEADING, 0, 131, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIdCliente)
                                        .addComponent(txtIdUsuario)
                                        .addComponent(jcFechaEmision, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                    .addComponent(txtNComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtPedido))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jcFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        btnNuevo.setBackground(new java.awt.Color(236, 177, 89));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(236, 177, 89));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edity.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(236, 177, 89));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(236, 177, 89));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        TablaComprobante.setBackground(new java.awt.Color(170, 215, 217));
        TablaComprobante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaComprobanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaComprobante);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Listado de Comprobante ");

        jLabel11.setText("Buscar por ID Cliente:");

        btnBuscarIDCliente.setBackground(new java.awt.Color(236, 177, 89));
        btnBuscarIDCliente.setText("Buscar");
        btnBuscarIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIDClienteActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(236, 177, 89));
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/simular.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarIDCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtIDClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(btnBuscarIDCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpiarFormulario() {
        // Limpiar campos de texto
        txtNComprobante.setText("");
        txtIdCliente.setText("");
        txtIdUsuario.setText("");

        txtImporteTotal.setText("");

        cbTipoComprobante.setSelectedIndex(0);

        jcFechaEmision.setDate(null);
        txtPedido.setText("");
    }

    private void listarComprobantes() {
        DefaultTableModel modelo = new DefaultTableModel();

        // Añadir las columnas al modelo, ya sin el nombre del cliente
        modelo.addColumn("ID Comprobante");
        modelo.addColumn("Serie");
        modelo.addColumn("Fecha Emisión");
        modelo.addColumn("Importe Total");
        modelo.addColumn("ID Cliente");
        modelo.addColumn("ID Usuario");
        modelo.addColumn("Tipo Comprobante");
        modelo.addColumn("ID Pedido");

        try {
            // Obtener los datos de la base de datos
            ResultSet rs = objCompro.listarComprobantes();

            // Recorrer el ResultSet y añadir los datos a la tabla
            while (rs.next()) {
                Object datos[] = new Object[8];  // Ajustar según el número de columnas

                // Llenar los datos sin el nombre del cliente
                datos[0] = rs.getInt("id_comprobante");  // ID Comprobante
                datos[1] = rs.getString("serie_nro_comprobante");  // Serie
                datos[2] = rs.getDate("fecha_emision");  // Fecha Emisión
                datos[3] = rs.getFloat("importe_total");  // Importe Total
                datos[4] = rs.getInt("id_cliente");  // ID Cliente
                datos[5] = rs.getInt("id_usuario");  // ID Usuario
                datos[6] = rs.getString("tipo_comprobante");  // Tipo Comprobante
                datos[7] = rs.getInt("id_pedido");  // ID Pedido

                // Añadir la fila al modelo
                modelo.addRow(datos);
            }

            // Asignar el modelo a la tabla
            TablaComprobante.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar comprobantes: " + e.getMessage());
        }

    }

    private void listarTipoComprobante() {
        ResultSet rsTipo = null;
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();  // Crear el modelo para el ComboBox

        try {
            // Llamar al método listarTiposComprobante() para obtener los tipos de comprobante desde la base de datos
            rsTipo = objCompro.listarTiposComprobante();

            // Recorrer el ResultSet y agregar cada tipo de comprobante al modelo del ComboBox
            while (rsTipo.next()) {
                modelo.addElement(rsTipo.getString("tipo_comprobante"));  // Agregar el tipo de comprobante (columna en la BD)
            }

            // Asignar el modelo al ComboBox
            cbTipoComprobante.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar tipos de comprobante: " + e.getMessage());
        } finally {
            // Cerrar el ResultSet
            if (rsTipo != null) {
                try {
                    rsTipo.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al cerrar el ResultSet: " + ex.getMessage());
                }
            }
        }
    }


    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        try {
            if (btnNuevo.getText().equals("NUEVO")) {
                btnNuevo.setText("GUARDAR");
                txtNComprobante.setText(String.valueOf(objCompro.generarCodigoComprobante()));
                txtNComprobante.requestFocus();
            } else {
                int idComprobante = Integer.parseInt(txtNComprobante.getText());
                String serieComprobante = txtNComprobante.getText();
                java.sql.Date fechaEmision = new java.sql.Date(jcFechaEmision.getDate().getTime());
                float importeTotal = Float.parseFloat(txtImporteTotal.getText());
                int idCliente = Integer.parseInt(txtIdCliente.getText());
                int idUsuario = Integer.parseInt(txtIdUsuario.getText());
                int idTipoComprobante = cbTipoComprobante.getSelectedIndex() + 1;
                int idPedido = Integer.parseInt(txtPedido.getText());

                // Obtener la fecha actual para comparar
                Date fechaActual = new Date();

                // Validar que la fecha de emisión no sea anterior a la fecha actual
                if (fechaEmision.before(fechaActual)) {
                    JOptionPane.showMessageDialog(this, "La fecha de emisión no puede ser anterior a hoy.");
                    return;
                }

                // Validación de los campos obligatorios
                if (!serieComprobante.isEmpty() && importeTotal > 0 && idCliente > 0 && idUsuario > 0 && idTipoComprobante > 0 && idPedido > 0) {
                    objCompro.registrarComprobante(idComprobante, serieComprobante, fechaEmision, importeTotal, idCliente, idUsuario, idTipoComprobante, idPedido);
                    btnNuevo.setText("NUEVO");
                    limpiarFormulario();
                    listarComprobantes();
                    JOptionPane.showMessageDialog(this, "Comprobante guardado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en la conversión de datos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al insertar comprobante: " + e.getMessage());
        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtNComprobante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un código de comprobante a modificar");
        } else {
            try {
                // Obtener los valores del formulario
                int idComprobante = Integer.parseInt(txtNComprobante.getText());
                String serieComprobante = txtNComprobante.getText();
                java.sql.Date fechaEmision = new java.sql.Date(jcFechaEmision.getDate().getTime());
                float importeTotal = Float.parseFloat(txtImporteTotal.getText());
                int idCliente = Integer.parseInt(txtIdCliente.getText());
                int idUsuario = Integer.parseInt(txtIdUsuario.getText());
                int idTipoComprobante = cbTipoComprobante.getSelectedIndex() + 1;
                int idPedido = Integer.parseInt(txtPedido.getText());

                // Validación de los campos
                if (serieComprobante.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "El campo de serie no puede estar vacío.");
                    return;
                }
                if (importeTotal <= 0) {
                    JOptionPane.showMessageDialog(this, "El importe total debe ser mayor que 0.");
                    return;
                }
                if (idCliente <= 0 || idUsuario <= 0 || idTipoComprobante <= 0 || idPedido <= 0) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para cliente, usuario, tipo de comprobante y pedido.");
                    return;
                }

                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea modificar este comprobante?");
                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Llamada al método modificarComprobante
                    objCompro.modificarComprobante(idComprobante, serieComprobante, fechaEmision, importeTotal, idCliente, idUsuario, idTipoComprobante, idPedido);

                    // Limpiar formulario
                    limpiarFormulario();

                    // Refrescar la lista de comprobantes
                    listarComprobantes();

                    // Mensaje de éxito
                    JOptionPane.showMessageDialog(this, "Comprobante modificado correctamente");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error en la conversión de datos: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al modificar comprobante: " + e.getMessage());
            }

        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {
            if (txtNComprobante.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un número de comprobante a eliminar");
            } else {
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este comprobante?");
                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Llamar al método eliminarComprobante
                    objCompro.eliminarComprobante(Integer.parseInt(txtNComprobante.getText()));

                    // Limpiar el formulario
                    limpiarFormulario();

                    // Refrescar la lista de comprobantes
                    listarComprobantes();

                    // Mensaje de éxito
                    JOptionPane.showMessageDialog(this, "Comprobante eliminado correctamente");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en la conversión de datos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar comprobante: " + e.getMessage());
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIDClienteActionPerformed
        try {
            String idClienteTexto = txtIDClienteBusqueda.getText().trim();

            if (idClienteTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID de cliente válido.");
                return;
            }

            int idCliente = Integer.parseInt(idClienteTexto);

            DefaultTableModel modelo = (DefaultTableModel) TablaComprobante.getModel();
            modelo.setRowCount(0);

            ResultSet rs = objCompro.buscarComprobantePorCliente(idCliente);

            while (rs.next()) {
                Object[] fila = new Object[8];  // Ajusta según el número de columnas que tengas
                fila[0] = rs.getInt("id_comprobante");

                fila[1] = rs.getString("serie_nro_comprobante");

                fila[2] = rs.getDate("fecha_emision");

                fila[3] = rs.getFloat("importe_total");

                fila[4] = rs.getInt("id_cliente");

                fila[5] = rs.getInt("id_usuario");

                fila[6] = rs.getString("tipo_comprobante");

                fila[7] = rs.getInt("id_pedido");

                modelo.addRow(fila);
            }

            TablaComprobante.setModel(modelo);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de cliente debe ser un número.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar comprobantes: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarIDClienteActionPerformed

    private void TablaComprobanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaComprobanteMouseClicked

        int filaSeleccionada = TablaComprobante.getSelectedRow();

        if (filaSeleccionada != -1) {
            txtNComprobante.setText(TablaComprobante.getValueAt(filaSeleccionada, 0).toString());

            txtIdCliente.setText(TablaComprobante.getValueAt(filaSeleccionada, 4).toString());

            id_cliente = (int) TablaComprobante.getValueAt(filaSeleccionada, 4);
            System.out.println(id_cliente);

            txtIdUsuario.setText(TablaComprobante.getValueAt(filaSeleccionada, 5).toString());

            txtPedido.setText(TablaComprobante.getValueAt(filaSeleccionada, 7).toString());

            txtImporteTotal.setText(TablaComprobante.getValueAt(filaSeleccionada, 3).toString());

            java.sql.Date fechaSQL = (java.sql.Date) TablaComprobante.getValueAt(filaSeleccionada, 2);
            jcFechaEmision.setDate(new java.util.Date(fechaSQL.getTime()));

            String tipoComprobante = TablaComprobante.getValueAt(filaSeleccionada, 6).toString();
            cbTipoComprobante.setSelectedItem(tipoComprobante);
        }

        ResultSet rs = null; // Declarar fuera del try-catch

        try {
            rs = objCompro.buscarComprobantePorCliente(id_cliente);
        } catch (Exception ex) {
            Logger.getLogger(jdMantComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs != null && rs.next()) {

                try {
                    serie = rs.getString("serie_nro_comprobante");
                    System.out.println(serie);
                    fecha = rs.getDate("fecha_emision").toString();
                    System.out.println(fecha);

                    importe = rs.getFloat("importe_total");
                    System.out.println(importe);

                    cliente = rs.getString("cliente_nombre");

                    username = rs.getString("username");

                    tipo_comprobante = rs.getString("tipo_comprobante");

                    id_pedido = rs.getInt("id_pedido");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al buscar comprobantes: " + e.getMessage());
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(jdMantComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TablaComprobanteMouseClicked

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        jdImpresionDemo impresion = new jdImpresionDemo(null, true, serie, fecha, importe, cliente, tipo_comprobante, id_pedido, username);
        impresion.setVisible(true);
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaComprobante;
    private javax.swing.JButton btnBuscarIDCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbTipoComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jcFechaEmision;
    private javax.swing.JTextField txtIDClienteBusqueda;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtImporteTotal;
    private javax.swing.JTextField txtNComprobante;
    private javax.swing.JTextField txtPedido;
    // End of variables declaration//GEN-END:variables
}
