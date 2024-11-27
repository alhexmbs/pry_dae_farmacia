package Capa_principal;

import capa_negocio.Fabricante;
import capa_negocio.Forma_farmaceutica;
import capa_negocio.Lote;
import capa_negocio.Producto;
import capa_negocio.Promocion;
import capa_negocio.Rubro;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Katia
 */
public class jdManProducto extends javax.swing.JDialog {

    Producto objProducto = new Producto();
    Rubro objRubro = new Rubro();
    Promocion objPromocion = new Promocion();

    public jdManProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarRubros();
        listarPromociones();

    }

   

    private void listarRubros() {
        ResultSet listarRubros = null;
        DefaultComboBoxModel modeloRubro = new DefaultComboBoxModel();
        cboRubro.setModel(modeloRubro);
        try {
            listarRubros = objRubro.listarRubros("General");
            while (listarRubros.next()) {
                modeloRubro.addElement(listarRubros.getString("nombre_rubro"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar rubros---> " + e.getMessage());
        }
    }

    private void listarPromociones() {
        ResultSet listarPromociones = null;
        DefaultComboBoxModel modeloPromocion = new DefaultComboBoxModel();
        cboPromocion.setModel(modeloPromocion);
        try {
            listarPromociones = objPromocion.listarPromociones("General");
            while (listarPromociones.next()) {
                modeloPromocion.addElement(listarPromociones.getString("dscto"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar promociones---> " + e.getMessage());
        }
    }

   

    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtNumRegisSani.setText("");
        cboRubro.setSelectedIndex(0);
        cboPromocion.setSelectedIndex(0);
        cboConVenta.setSelectedIndex(0);

    }

    private void aplicarFiltro() {
    String filtroSeleccionado = (String) cboFiltros.getSelectedItem();

    try {
        switch (filtroSeleccionado) {
            case "General":
                listar("General");
                break;
            
            case "Nombre asc":
                listar("ORDER BY pf.nombre ASC");
                break;
            case "Nombre desc":
                listar("ORDER BY pf.nombre DESC");
                break;
            case "Con promoción":
                listar("pf.id_promocion IS NOT NULL");
                break;
            case "Sin promoción":
                listar("pf.id_promocion IS NULL");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Filtro no reconocido.");
                break;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al aplicar filtro --> " + e.getMessage());
    }
}


    private void listar(String filtro) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Número de registro sanitario");
        modelo.addColumn("Condición Venta");
        modelo.addColumn("Descuento");
        modelo.addColumn("Rubro");

        tblProducto.setModel(modelo);

        ResultSet rs = null;
        try {
            rs = objProducto.listarProductos(filtro);

            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("id_producto");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("nro_reg_sanitario");
                fila[3] = rs.getString("condicion_venta");
                fila[4] = rs.getString("descuento") == null ? "Sin Promoción" : rs.getString("descuento");
                fila[5] = rs.getString("rubro");

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar productos fr--> " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCorreo3 = new javax.swing.JTextField();
        btnDarBaja = new javax.swing.JButton();
        chkVigencia = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        lblNombreProducto = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnAr = new javax.swing.JButton();
        txtNumRegisSani = new javax.swing.JTextField();
        cboPromocion = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        cboConVenta = new javax.swing.JComboBox<>();
        btnAp = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        cboRubro = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAr1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        cboFiltros = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDarDeBaja = new javax.swing.JButton();

        txtCorreo3.setBackground(new java.awt.Color(239, 237, 220));
        txtCorreo3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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

        chkVigencia.setText("Vigente");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Producto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));

        tblProducto.setAutoCreateRowSorter(true);
        tblProducto.setBackground(new java.awt.Color(170, 215, 217));
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProducto.setShowGrid(false);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProducto);

        jPanel6.setBackground(new java.awt.Color(170, 215, 217));

        jPanel7.setBackground(new java.awt.Color(239, 237, 220));

        jButton2.setBackground(new java.awt.Color(246, 244, 235));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estesi-producto02.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblNombreProducto.setBackground(new java.awt.Color(0, 0, 0));
        lblNombreProducto.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel66.setBackground(new java.awt.Color(70, 130, 169));
        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setText("Producto:");

        jLabel68.setBackground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("Buscar ID del producto:");

        txtBuscarCodigo.setBackground(new java.awt.Color(239, 237, 220));
        txtBuscarCodigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnBuscar.setBackground(new java.awt.Color(236, 177, 89));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel68)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel66)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel68))
                .addGap(17, 17, 17)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(170, 215, 217));

        btnAr.setBackground(new java.awt.Color(236, 177, 89));
        btnAr.setText("Añadir");
        btnAr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArActionPerformed(evt);
            }
        });

        txtNumRegisSani.setBackground(new java.awt.Color(239, 237, 220));
        txtNumRegisSani.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNumRegisSani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumRegisSaniActionPerformed(evt);
            }
        });
        txtNumRegisSani.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumRegisSaniKeyTyped(evt);
            }
        });

        txtId.setBackground(new java.awt.Color(239, 237, 220));
        txtId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtNombre.setBackground(new java.awt.Color(239, 237, 220));
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel76.setBackground(new java.awt.Color(0, 0, 0));
        jLabel76.setText("Condición de venta:");

        cboConVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin receta", "Con receta", "Ambas" }));

        btnAp.setBackground(new java.awt.Color(236, 177, 89));
        btnAp.setText("Añadir");
        btnAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApActionPerformed(evt);
            }
        });

        jLabel74.setBackground(new java.awt.Color(0, 0, 0));
        jLabel74.setText("Número de registro sanitario:");

        jLabel77.setBackground(new java.awt.Color(0, 0, 0));
        jLabel77.setText("Rubro:");

        jLabel63.setBackground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Nombre:");

        jLabel78.setBackground(new java.awt.Color(0, 0, 0));
        jLabel78.setText("Promoción:");

        jLabel67.setBackground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("ID producto:");

        cboRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRubroActionPerformed(evt);
            }
        });

        jLabel62.setBackground(new java.awt.Color(70, 130, 169));
        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Datos del producto:");

        btnAr1.setBackground(new java.awt.Color(236, 177, 89));
        btnAr1.setText("Añadir detalle del producto");
        btnAr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAr1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAr1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel74)
                                        .addComponent(jLabel63))
                                    .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumRegisSani)
                                    .addComponent(txtNombre)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(23, 25, Short.MAX_VALUE)
                                    .addComponent(jLabel62)
                                    .addGap(18, 18, 18)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(96, 96, 96)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel78)
                                                .addComponent(jLabel77))
                                            .addGap(30, 30, 30)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cboRubro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cboPromocion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(47, 47, 47)
                                            .addComponent(jLabel76)
                                            .addGap(30, 30, 30)
                                            .addComponent(cboConVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAr, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAp, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(33, 33, 33))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74)
                    .addComponent(txtNumRegisSani, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(cboConVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAp)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel78)))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(cboRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAr))
                .addGap(18, 18, 18)
                .addComponent(btnAr1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel22.setText("Filtrar por:");

        cboFiltros.setBackground(new java.awt.Color(246, 244, 235));
        cboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Nombre asc", "Nombre desc", "Con promoción", "Sin promoción" }));
        cboFiltros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltrosActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(236, 177, 89));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(236, 177, 89));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edity.png"))); // NOI18N
        btnEdit.setText("MODIFICAR");
        btnEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

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

        btnDarDeBaja.setBackground(new java.awt.Color(236, 177, 89));
        btnDarDeBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDarDeBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDarDeBaja.setText("ELIMINAR");
        btnDarDeBaja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarDeBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDarDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDarDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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

    private void cboFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltrosActionPerformed
        aplicarFiltro();
    }//GEN-LAST:event_cboFiltrosActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaActionPerformed
        if (txtBuscarCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un código de producto para eliminar");
        } else {
            try {
                int idProducto = Integer.parseInt(txtBuscarCodigo.getText());

                ResultSet rsProducto = objProducto.buscarProducto(idProducto);

                if (rsProducto.next()) {
                    int idFrmFarma = rsProducto.getInt("id_producto");
                    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que deseas eliminar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        objProducto.eliminarProducto(idProducto);
                        limpiarFormulario();
                        listar("General");
                        JOptionPane.showMessageDialog(this, "Producto eliminado correctamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El código de producto no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

                rsProducto.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el producto --> " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDarDeBajaActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un código de producto para modificar");
        } else {
            try {
                int idProducto = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                String numRegSanitario = txtNumRegisSani.getText();
                String condicionVenta = cboConVenta.getSelectedItem().toString();
                String rubro = (String) cboRubro.getSelectedItem();
                String promocion = (String) cboPromocion.getSelectedItem();
                
                if (!nombre.isEmpty() || !numRegSanitario.isEmpty()) {
                    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea modificar este producto?");
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idRubro = objRubro.obtenerCodigoRubro(rubro);
                        int idPromocion = objPromocion.obtenerCodigoPromocion(promocion);
                        
                        objProducto.modificarProducto(idProducto, nombre, numRegSanitario, condicionVenta, idPromocion, idRubro);
                        limpiarFormulario();
                        listar("General");
                        JOptionPane.showMessageDialog(this, "Producto modificado correctamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese información en todos los campos obligatorios");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al modificar producto --> " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (btnSave.getText().equals("NUEVO")) {
                btnSave.setText("GUARDAR");
                // Generar código de producto y convertir a String
                Integer nuevoCodigo = objProducto.generarCodigoProducto();
                txtId.setText(String.valueOf(nuevoCodigo));
                txtNombre.requestFocus();
            } else {

                int idProducto = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                String numRegSanitario = txtNumRegisSani.getText();
                String condicionVenta = cboConVenta.getSelectedItem().toString();
                String rubro = (String) cboRubro.getSelectedItem();
                String promocion = (String) cboPromocion.getSelectedItem();
                int idRubro = objRubro.obtenerCodigoRubro(rubro);
                int idPromocion = objPromocion.obtenerCodigoPromocion(promocion);


                if (!nombre.isEmpty() || txtNumRegisSani.getText().isEmpty()) {
                    objProducto.registrarProducto(idProducto, nombre, numRegSanitario, condicionVenta, idPromocion, idRubro);
                    btnSave.setText("NUEVO");
                    limpiarFormulario();
                    listar("General");
                    JOptionPane.showMessageDialog(this, "Producto guardado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese información en todos los campos");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al insertar Producto --> " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    private void cboRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRubroActionPerformed

    private void txtNumRegisSaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumRegisSaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumRegisSaniActionPerformed

    private void btnArActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArActionPerformed
        jdRubro obj = new jdRubro(null, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnArActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listar("General");
    }//GEN-LAST:event_formWindowOpened

    private void buscarProducto() {
        ResultSet rsProducto = null;
        try {
            if (txtBuscarCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un código de producto para buscar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int idProducto = Integer.parseInt(txtBuscarCodigo.getText());
                rsProducto = objProducto.buscarProducto(idProducto);

                if (rsProducto.next()) {
                    txtId.setText(rsProducto.getString("id_producto"));
                    txtNombre.setText(rsProducto.getString("nombre"));
                    lblNombreProducto.setText(rsProducto.getString("nombre"));
                    txtNumRegisSani.setText(rsProducto.getString("nro_reg_sanitario"));
                    cboConVenta.setSelectedItem(rsProducto.getString("condicion_venta"));

                
                    // Manejar dosis
                    /*
                    String dosisCompleta = rsProducto.getString("dosis"); // Por ejemplo: "500 - mg"
                    if (dosisCompleta != null && !dosisCompleta.isEmpty()) {
                        String[] partesDosis = dosisCompleta.split(" - "); // Dividir por " - "
                        if (partesDosis.length == 2) {
                            spDosis.setValue(Integer.parseInt(partesDosis[0])); // Asignar cantidad al spinner
                            cboUnidad.setSelectedItem(partesDosis[1]); // Asignar unidad al combo
                        }
                    }
                     */
                    cboRubro.setSelectedItem(rsProducto.getString("descuento"));

                    cboRubro.setSelectedItem(rsProducto.getString("rubro"));

                    rsProducto.close();
                } else {
                    JOptionPane.showMessageDialog(this, "El código de producto no existe", "Producto no encontrado", JOptionPane.INFORMATION_MESSAGE);
                    limpiarFormulario();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El código de producto debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el producto --> " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarProducto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        txtBuscarCodigo.setText(String.valueOf(tblProducto.getValueAt(tblProducto.getSelectedRow(), 0)));
        btnBuscarActionPerformed(null);
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed


    }//GEN-LAST:event_btnDarBajaActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (txtNombre.getText().length() >= 200) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNumRegisSaniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumRegisSaniKeyTyped
        if (txtNumRegisSani.getText().length() >= 6) {
            evt.consume();
        } 
    }//GEN-LAST:event_txtNumRegisSaniKeyTyped

    private void btnAr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAr1ActionPerformed
        jdDetalleProductoTipo objd = new jdDetalleProductoTipo(null, true);
        objd.setLocationRelativeTo(null);
        objd.setVisible(true);
    }//GEN-LAST:event_btnAr1ActionPerformed

    private void btnApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApActionPerformed
        jdPromocion obj = new jdPromocion(null, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnApActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAp;
    private javax.swing.JButton btnAr;
    private javax.swing.JButton btnAr1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JButton btnDarDeBaja;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboConVenta;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JComboBox<String> cboPromocion;
    private javax.swing.JComboBox<String> cboRubro;
    private javax.swing.JCheckBox chkVigencia;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextField txtCorreo3;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumRegisSani;
    // End of variables declaration//GEN-END:variables
}
