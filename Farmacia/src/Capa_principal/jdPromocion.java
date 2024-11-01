package Capa_principal;

import capa_negocio.Promocion;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Katia
 */
public class jdPromocion extends javax.swing.JDialog {

    Promocion obj = new Promocion();

    public jdPromocion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void limpiar() {
        txtId2.setText("");
        txtDescuento.setText("");
        jcFechaInicio.setDate(null);
        jcFechaFin.setDate(null);
        fechaFinIngresado.setDate(null);
        fechainicioIngresado.setDate(null);
        chkVigencia.setSelected(false);
    }

    public void listar(String tipo) {
        ResultSet lista = null;
        Vector rubro;
        String estado = null;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Descuento");
        modelo.addColumn("Fecha inicio");
        modelo.addColumn("Fecha fin");
        modelo.addColumn("Estado");

        try {
            lista = obj.listarPromociones(tipo);
            while (lista.next()) {
                 if (lista.getBoolean("estado")) {
                    estado = "Vigente";
                } else {
                    estado = "No vigente";
                }
                rubro = new Vector();
                rubro.add(lista.getInt("id_promocion"));
                rubro.add(lista.getFloat("dscto"));
                rubro.add(lista.getDate("fecha_inicio"));
                rubro.add(lista.getDate("fecha_fin"));
                rubro.add(estado);
                modelo.addRow(rubro);
            }
            TablaGuardarda1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar las promociones: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        txtBuscarIde = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        txtId2 = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jcFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jcFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chkVigencia = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cboFiltros = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaGuardarda1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        fechainicioIngresado = new com.toedter.calendar.JDateChooser();
        fechaFinIngresado = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnModificaar = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnDarBaja2 = new javax.swing.JButton();

        txtBuscarIde.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscarIde.setBorder(null);

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
        jLabel62.setText("Datos de la promoción:");

        jLabel68.setBackground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("ID promoción:");

        jLabel64.setBackground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Descuento:");

        txtDescuento.setBackground(new java.awt.Color(239, 237, 220));
        txtDescuento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

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

        jLabel65.setBackground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("Fecha inicio:");

        jLabel66.setBackground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Fecha fin:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descuento.png"))); // NOI18N

        jLabel5.setText("Vigencia:");

        chkVigencia.setText("Vigente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel64)
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1)))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel62)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel68)
                        .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chkVigencia))
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(246, 244, 235));

        jLabel24.setText("Filtrar por");

        cboFiltros.setBackground(new java.awt.Color(246, 244, 235));
        cboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Mayor a menor", "Menor a mayor" }));
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

        jLabel2.setText("Listar por rango:");

        jLabel3.setText("Fecha Fin");

        jLabel4.setText("Fecha inicio");

        jButton1.setBackground(new java.awt.Color(236, 177, 89));
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechainicioIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaFinIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechainicioIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaFinIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
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
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/darBaja.png"))); // NOI18N
        btnEliminar1.setText("DAR DE BAJA");
        btnEliminar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnDarBaja2.setBackground(new java.awt.Color(236, 177, 89));
        btnDarBaja2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDarBaja2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDarBaja2.setText("ELIMINAR");
        btnDarBaja2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDarBaja2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBaja2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificaar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDarBaja2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificaar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDarBaja2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId2ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        ResultSet rsPromocion = null;
        try {
            if (txtId2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un código para buscar");
            } else {
                rsPromocion = obj.buscarPromocion(Integer.parseInt(txtId2.getText()));

                if (rsPromocion.next()) {
                    txtDescuento.setText(String.valueOf(rsPromocion.getInt("dscto")));
                    jcFechaInicio.setDate(rsPromocion.getDate("fecha_inicio"));
                    jcFechaFin.setDate(rsPromocion.getDate("fecha_fin"));
                    chkVigencia.setSelected(rsPromocion.getBoolean("estado"));
                    rsPromocion.close();
                } else {
                    JOptionPane.showMessageDialog(this, "Código de promoción no existe");
                    limpiar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar la promocion: " + e.getMessage());
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
                txtId2.setText(String.valueOf(obj.generarCodigoPromocion()));
                txtDescuento.requestFocus();
            } else {

                if (txtId2.getText().isEmpty() || txtDescuento.getText().isEmpty() || jcFechaInicio.getDate() == null || jcFechaFin.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                } else {
                    int codigo = Integer.parseInt(txtId2.getText());
                    int descuento = Integer.parseInt(txtDescuento.getText());
                    java.sql.Date fechaInicio = new java.sql.Date(jcFechaInicio.getDate().getTime());
                    java.sql.Date fechaFin = new java.sql.Date(jcFechaFin.getDate().getTime());
                    boolean estado = chkVigencia.isSelected();

                    if (fechaInicio.before(fechaFin) || fechaInicio.equals(fechaFin)) {
                        obj.registrarPromocion(codigo, descuento, fechaInicio, fechaFin, estado);
                        btnSave.setText("NUEVO");
                        limpiar();
                        listar("General");
                        JOptionPane.showMessageDialog(this, "Promoción guardada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser superior a la fecha fin");
                    }

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al insertar rubro -->" + e.getMessage());
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    public void listarPorFechas(java.sql.Date fechaInicio, java.sql.Date fechaFin) {
        ResultSet lista = null;
        Vector rubro;
        String estado = null;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Descuento");
        modelo.addColumn("Fecha inicio");
        modelo.addColumn("Fecha fin");
        modelo.addColumn("Estado");

        try {
            lista = obj.buscarPromocionPorFecha(fechaInicio, fechaFin);
            while (lista.next()) {
                if (lista.getBoolean("estado")) {
                    estado = "Vigente";
                } else {
                    estado = "No vigente";
                }
                rubro = new Vector();
                rubro.add(lista.getInt("id_promocion"));
                rubro.add(lista.getFloat("dscto"));
                rubro.add(lista.getDate("fecha_inicio"));
                rubro.add(lista.getDate("fecha_fin"));
                rubro.add(estado);
                modelo.addRow(rubro);
            }
            TablaGuardarda1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar promociones por fecha: " + e.getMessage());
        }
    }

    private void btnModificaarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaarActionPerformed
        if (txtId2.getText().isEmpty() || txtDescuento.getText().isEmpty() || jcFechaInicio.getDate() == null || jcFechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos antes de modificar");
        } else {
            int codigo = Integer.parseInt(txtId2.getText());
            int descuento = Integer.parseInt(txtDescuento.getText());
            java.sql.Date fechaInicio = new java.sql.Date(jcFechaInicio.getDate().getTime());
            java.sql.Date fechaFin = new java.sql.Date(jcFechaFin.getDate().getTime());
            boolean estado = chkVigencia.isSelected();
            try {

                if (fechaInicio.before(fechaFin) || fechaInicio.equals(fechaFin)) {

                    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea modificar esta promocion?");
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        obj.modificarPromocion(codigo, descuento, fechaInicio, fechaFin, estado);
                        limpiar();
                        listar("General");
                        JOptionPane.showMessageDialog(this, "Promocion modificada correctamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser superior a la fecha fin");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al modificar la promocion: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnModificaarActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed

        if (txtId2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un codigo para dar de baja");

        } else {
        int codigo = Integer.parseInt(txtId2.getText());

            try {
                ResultSet listaFf = obj.buscarPromocion(codigo);

                while (listaFf.next()) {
                    if (!listaFf.getBoolean("estado")) {
                        JOptionPane.showMessageDialog(this, "Esta promocón ya ha sido dado de baja anteriomente");
                    } else {

                        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea dar de baja esta esta promoción?");
                        if (confirmacion == JOptionPane.YES_OPTION) {
                            obj.darDeBajaPromocion(Integer.parseInt(txtId2.getText()));
                            limpiar();
                            listar("General");
                            JOptionPane.showMessageDialog(rootPane, "Promoción dada de baja correctamente");
                        }

                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error--->" + e.getMessage());

            }

        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listar("General");

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            java.util.Date fechaInicio = fechainicioIngresado.getDate();
            java.util.Date fechaFin = fechaFinIngresado.getDate();

            if (fechaInicio == null || fechaFin == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione ambas fechas.");
                return;
            }

            // Convertir a java.sql.Date para la base de datos
            java.sql.Date sqlFechaInicio = new java.sql.Date(fechaInicio.getTime());
            java.sql.Date sqlFechaFin = new java.sql.Date(fechaFin.getTime());

            if (sqlFechaInicio.after(sqlFechaFin)) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser mayor que la fecha de fin.");
                return;
            }

            listarPorFechas(sqlFechaInicio, sqlFechaFin);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al filtrar por fechas: " + e.getMessage());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDarBaja2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBaja2ActionPerformed

        if (txtId2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un codigo para eliminar");

        } else {
        int codigo = Integer.parseInt(txtId2.getText());

            try {

                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar esta promoción?");
                if (confirmacion == JOptionPane.YES_OPTION) {
                    obj.eliminar(Integer.parseInt(txtId2.getText()));
                    limpiar();
                    listar("General");
                    JOptionPane.showMessageDialog(rootPane, "Promoción eliminada correctamente");

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage() + e.getMessage());

            }

    }//GEN-LAST:event_btnDarBaja2ActionPerformed
    }
    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
/*
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' && c != '\b') {
            evt.consume(); 
            return;
        }

        String texto = txtDescuento.getText() + c;

        try {
            double valor = Double.parseDouble(texto);
            if (valor < 0.1 || valor >= 1) {
                evt.consume(); 
            }
        } catch (NumberFormatException e) {
            evt.consume();
        }
*/
    }//GEN-LAST:event_txtDescuentoKeyTyped

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaGuardarda1;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnDarBaja2;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnModificaar;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JCheckBox chkVigencia;
    private com.toedter.calendar.JDateChooser fechaFinIngresado;
    private com.toedter.calendar.JDateChooser fechainicioIngresado;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jcFechaFin;
    private com.toedter.calendar.JDateChooser jcFechaInicio;
    private javax.swing.JTextField txtBuscarIde;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtId2;
    // End of variables declaration//GEN-END:variables
}
