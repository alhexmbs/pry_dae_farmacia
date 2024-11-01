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
    }

    private void limpiarCampos() {
        txtNumeroLote.setText("");
        txtId.setText("");
        jcFechaEntrada.setDate(null);
        txtCantidad.setText("");
        txtPrecioCompra.setText("");
        txtNumeroLote.setText("");
        jcFechaVencimiento.setDate(null);
        chkVigencia.setSelected(false);

    }

    private void listarLotes(String estado) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Lote");
        modelo.addColumn("Fecha Entrada");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Numero de lote");
        modelo.addColumn("Estado");
        modelo.addColumn("Fecha Vencimiento");
        modelo.addColumn("Producto");

        ResultSet rsLote = null;
        try {
            rsLote = objLote.listarLotes(estado);

            while (rsLote.next()) {
                Object[] fila = new Object[8];
                fila[0] = rsLote.getInt("id_lote");
                fila[1] = rsLote.getDate("fecha_entrada");
                fila[2] = rsLote.getInt("cantidad_lote");
                fila[3] = rsLote.getDouble("precio_compra");
                fila[4] = rsLote.getString("numero_lote");
                fila[5] = rsLote.getBoolean("estado");
                fila[6] = rsLote.getDate("fecha_vencimiento");
                fila[7] = rsLote.getInt("id_usuario");
                modelo.addRow(fila);
            }

            tblFf.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar los lotes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        tblDetalle1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jcFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jcFechaEntrada = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        chkVigencia = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        txtNumeroLote = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btnDarBaja = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cboFiltros = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFf = new javax.swing.JTable();
        btnDarBaja1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDetalle2 = new javax.swing.JTable();
        jLabel63 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        tblDetalle1.setAutoCreateRowSorter(true);
        tblDetalle1.setBackground(new java.awt.Color(170, 215, 217));
        tblDetalle1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDetalle1.setShowGrid(false);
        jScrollPane6.setViewportView(tblDetalle1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Lote");
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

        jLabel1.setText("Fecha de entrada:");

        jLabel2.setText("Cantidad de lote:");

        txtCantidad.setBackground(new java.awt.Color(239, 237, 220));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel3.setText("Estado:");

        chkVigencia.setText("Vigente");

        jLabel4.setText("Precio de compra:");

        txtPrecioCompra.setBackground(new java.awt.Color(239, 237, 220));

        txtNumeroLote.setBackground(new java.awt.Color(239, 237, 220));

        jLabel5.setText("Producto - Tipo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel68))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jcFechaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                                    .addComponent(jSeparator1)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcFechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroLote, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel62)))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jcFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel64)
                    .addComponent(txtNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chkVigencia))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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

        btnDarBaja.setBackground(new java.awt.Color(236, 177, 89));
        btnDarBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDarBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/darBaja.png"))); // NOI18N
        btnDarBaja.setText("DAR DE BAJA");
        btnDarBaja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });

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
        jScrollPane4.setViewportView(tblFf);

        btnDarBaja1.setBackground(new java.awt.Color(236, 177, 89));
        btnDarBaja1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDarBaja1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDarBaja1.setText("ELIMINAR");
        btnDarBaja1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDarBaja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBaja1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(170, 215, 217));

        tblDetalle2.setAutoCreateRowSorter(true);
        tblDetalle2.setBackground(new java.awt.Color(170, 215, 217));
        tblDetalle2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDetalle2.setShowGrid(false);
        jScrollPane7.setViewportView(tblDetalle2);

        jLabel63.setBackground(new java.awt.Color(70, 130, 169));
        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setText("Productos Disponibles:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDarBaja1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDarBaja1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ResultSet rsLote = null;
        try {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un codigo de lote para buscar");
            } else {
                int idLote = Integer.parseInt(txtId.getText());

                rsLote = objLote.buscarLote(idLote);

                if (rsLote.next()) {
                    jcFechaEntrada.setDate(rsLote.getDate("fecha_entrada"));
                    txtCantidad.setText(String.valueOf(rsLote.getInt("cantidad_lote")));
                    txtPrecioCompra.setText(String.valueOf(rsLote.getDouble("precio_compra")));
                    txtNumeroLote.setText(rsLote.getString("numero_lote"));
                    jcFechaVencimiento.setDate(rsLote.getDate("fecha_vencimiento"));
                    if (rsLote.getBoolean("estado")) {
                        chkVigencia.setSelected(true);
                    } else {
                        chkVigencia.setSelected(false);
                    }
                    rsLote.close();
                } else {
                    JOptionPane.showMessageDialog(this, "El codigo del lote no existe");
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
                limpiarCampos();
                btnSave.setText("GUARDAR");
                txtId.setText(String.valueOf(objLote.generarCodigoLote()));
                txtCantidad.requestFocus();
            } else {
                if (txtNumeroLote.getText().isEmpty()
                        || jcFechaEntrada.getDate() == null
                        || txtCantidad.getText().isEmpty()
                        || txtPrecioCompra.getText().isEmpty()
                        || jcFechaVencimiento.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                } else {
                    int codigoLote = Integer.parseInt(txtId.getText());

                    java.sql.Date fechaEntrada = new java.sql.Date(jcFechaEntrada.getDate().getTime());
                    int cantidad = Integer.parseInt(txtCantidad.getText());
                    Double precio_compra = Double.valueOf(txtCantidad.getText());

                    String numeroLote = txtNumeroLote.getText();
                    java.sql.Date fechaVencimiento = new java.sql.Date(jcFechaVencimiento.getDate().getTime());
                    Boolean estado = chkVigencia.isSelected();

                    objLote.registrarLote(codigoLote, numeroLote, fechaEntrada, cantidad, precio_compra, estado, fechaVencimiento, idUsuario);

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
                if (txtNumeroLote.getText().isEmpty()
                        || jcFechaEntrada.getDate() == null
                        || txtCantidad.getText().isEmpty()
                        || txtPrecioCompra.getText().isEmpty()
                        || jcFechaVencimiento.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                } else {
                    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar este lote?", "Confirmar modificación", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idLote = Integer.parseInt(txtId.getText());
                        String numeroLote = txtNumeroLote.getText();
                        java.sql.Date fechaEntrada = new java.sql.Date(jcFechaEntrada.getDate().getTime());
                        java.sql.Date fechaVencimiento = new java.sql.Date(jcFechaVencimiento.getDate().getTime());
                        boolean estado = chkVigencia.isSelected();
                        int cantidadLote = Integer.parseInt(txtCantidad.getText());
                        double precioCompra = Double.parseDouble(txtPrecioCompra.getText());
                        int id_usuario = 1;

                        objLote.modificarLote(idLote, numeroLote, fechaEntrada, fechaVencimiento, estado, cantidadLote, precioCompra, id_usuario);

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

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed
        try {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el ID del lote a eliminar.");
            } else {
                int confirmacion = JOptionPane.showConfirmDialog(this, " ¿Esta seguro de que desea dar de baja este lote?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    int cod = Integer.parseInt(txtId.getText());

                    if (objLote.buscarLote(cod) != null) {
                        objLote.darDeBajaLote(cod);
                        JOptionPane.showMessageDialog(this, "Lote dado de baja con  exito.");

                        limpiarCampos();
                        listarLotes("General");
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontro un lote con ese ID.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Operacion cancelada cancelada.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de baja al lote: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDarBajaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listarLotes("General");
    }//GEN-LAST:event_formWindowOpened

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnDarBaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBaja1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDarBaja1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JButton btnDarBaja1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JCheckBox chkVigencia;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JDateChooser jcFechaEntrada;
    private com.toedter.calendar.JDateChooser jcFechaVencimiento;
    private javax.swing.JTable tblDetalle1;
    private javax.swing.JTable tblDetalle2;
    private javax.swing.JTable tblFf;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumeroLote;
    private javax.swing.JTextField txtPrecioCompra;
    // End of variables declaration//GEN-END:variables
}
