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
    Forma_farmaceutica objFormaFarmaceutica = new Forma_farmaceutica();
    Rubro objRubro = new Rubro();
    Promocion objPromocion = new Promocion();
    Fabricante objFabricante = new Fabricante();
    Lote objLote = new Lote();

    public jdManProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarFormasFarmaceuticas();
        listarRubros();
        listarPromociones();
        listarFabricantes();
        listarLotes();
    }

    private void listarLotes() {
        ResultSet listarLotes = null;
        DefaultComboBoxModel modeloLote = new DefaultComboBoxModel();
        cboLote.setModel(modeloLote);
        try {
            listarLotes = objLote.listarLotes("Disponibles");
            while (listarLotes.next()) {
                modeloLote.addElement(listarLotes.getString("numero_lote"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar los lotes---> " + e.getMessage());
        }
    }

    private void listarFormasFarmaceuticas() {
        ResultSet listarFormas = null;
        DefaultComboBoxModel modeloForma = new DefaultComboBoxModel();
        cboForma.setModel(modeloForma);
        try {
            listarFormas = objFormaFarmaceutica.listarFormaFarmaceutica("General");
            while (listarFormas.next()) {
                modeloForma.addElement(listarFormas.getString("forma_farmaceutica"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar formas farmacéuticas---> " + e.getMessage());
        }
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

    private void listarFabricantes() {
        ResultSet listarFabricantes = null;
        DefaultComboBoxModel modeloFabricante = new DefaultComboBoxModel();
        cboFabricante.setModel(modeloFabricante);
        try {
            listarFabricantes = objFabricante.listarFabricantes("General");
            while (listarFabricantes.next()) {
                modeloFabricante.addElement(listarFabricantes.getString("nombre_fabricante"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar fabricantes---> " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecioVenta.setText("");
        spStock.setValue(0);
        txtNumRegisSani.setText("");
        cboEstado.setSelectedIndex(0);
        txtPrincipio.setText("");
        spDosis.setValue(0);
        cboUnidad.setSelectedIndex(0);
        cboForma.setSelectedIndex(0);
        cboRubro.setSelectedIndex(0);
        cboPromocion.setSelectedIndex(0);
        cboFabricante.setSelectedIndex(0);
        cboLote.setSelectedIndex(0);

    }

    private void aplicarFiltro() {
        String filtroSeleccionado = (String) cboFiltros.getSelectedItem();

        try {

            switch (filtroSeleccionado) {
                case "General":
                    listar("General");
                    break;
                case "Bajo stock":
                    listar("pro.stock <= 10");
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
        modelo.addColumn("Forma Farmacéutica");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Estado");
        modelo.addColumn("Principio Activo");
        modelo.addColumn("Dosis");
        modelo.addColumn("Registro Sanitario");
        modelo.addColumn("Condición Venta");
        modelo.addColumn("Fabricante");
        modelo.addColumn("Rubro");
        modelo.addColumn("Descuento");

        tblProducto.setModel(modelo);

        ResultSet rs = null;
        try {
            rs = objProducto.listarProductos(filtro);

            while (rs.next()) {
                Object[] fila = new Object[13];
                fila[0] = rs.getInt("id_producto");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("forma_farmaceutica");
                fila[3] = rs.getInt("stock");
                fila[4] = rs.getDouble("precio_venta");
                fila[5] = rs.getString("estado");
                fila[6] = rs.getString("principio_activo");
                fila[7] = rs.getString("dosis");
                fila[8] = rs.getString("nro_reg_sanitario");
                fila[9] = rs.getString("condicion_venta");
                fila[10] = rs.getString("nombre_fabricante");
                fila[11] = rs.getString("nombre_rubro");
                fila[12] = rs.getString("descuento") == null ? "Sin Promoción" : rs.getString("descuento");

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar productos --> " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCorreo3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        txtNumRegisSani = new javax.swing.JTextField();
        spStock = new javax.swing.JSpinner();
        txtId = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        cboForma = new javax.swing.JComboBox<>();
        cboRubro = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        cboPromocion = new javax.swing.JComboBox<>();
        cboFabricante = new javax.swing.JComboBox<>();
        btnAF = new javax.swing.JButton();
        btnAr = new javax.swing.JButton();
        btnAp = new javax.swing.JButton();
        btnae = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spDosis = new javax.swing.JSpinner();
        cboUnidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAgregarLote = new javax.swing.JButton();
        txtPrincipio = new javax.swing.JTextField();
        cboLote = new javax.swing.JComboBox<>();
        jLabel76 = new javax.swing.JLabel();
        cboConVenta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cboFiltros = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDarDeBaja = new javax.swing.JButton();
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

        txtCorreo3.setBackground(new java.awt.Color(239, 237, 220));
        txtCorreo3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Producto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));

        jPanel2.setBackground(new java.awt.Color(170, 215, 217));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel5.setBackground(new java.awt.Color(170, 215, 217));

        jLabel74.setBackground(new java.awt.Color(0, 0, 0));
        jLabel74.setText("Número de registro sanitario:");

        jLabel63.setBackground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Nombre:");

        txtPrecioVenta.setBackground(new java.awt.Color(239, 237, 220));
        txtPrecioVenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel67.setBackground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("ID producto:");

        jLabel72.setBackground(new java.awt.Color(0, 0, 0));
        jLabel72.setText("Stock:");

        txtNumRegisSani.setBackground(new java.awt.Color(239, 237, 220));
        txtNumRegisSani.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNumRegisSani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumRegisSaniActionPerformed(evt);
            }
        });

        txtId.setBackground(new java.awt.Color(239, 237, 220));
        txtId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel65.setBackground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("Precio de la venta:");

        txtNombre.setBackground(new java.awt.Color(239, 237, 220));
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel4.setBackground(new java.awt.Color(170, 215, 217));

        jLabel77.setBackground(new java.awt.Color(0, 0, 0));
        jLabel77.setText("Rubro:");

        jLabel78.setBackground(new java.awt.Color(0, 0, 0));
        jLabel78.setText("Promoción:");

        cboForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFormaActionPerformed(evt);
            }
        });

        cboRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRubroActionPerformed(evt);
            }
        });

        jLabel75.setBackground(new java.awt.Color(0, 0, 0));
        jLabel75.setText("Forma farmaceutica:");

        jLabel80.setBackground(new java.awt.Color(0, 0, 0));
        jLabel80.setText("Fabricante:");

        btnAF.setBackground(new java.awt.Color(236, 177, 89));
        btnAF.setText("Añadir");
        btnAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAFActionPerformed(evt);
            }
        });

        btnAr.setBackground(new java.awt.Color(236, 177, 89));
        btnAr.setText("Añadir");
        btnAr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArActionPerformed(evt);
            }
        });

        btnAp.setBackground(new java.awt.Color(236, 177, 89));
        btnAp.setText("Añadir");
        btnAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApActionPerformed(evt);
            }
        });

        btnae.setBackground(new java.awt.Color(236, 177, 89));
        btnae.setText("Añadir");
        btnae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaeActionPerformed(evt);
            }
        });

        jLabel71.setBackground(new java.awt.Color(0, 0, 0));
        jLabel71.setText("Principio activo");

        jLabel2.setText("Dosis");

        cboUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mg", "g", "µg", "ml" }));

        jLabel3.setText("Lote");

        btnAgregarLote.setBackground(new java.awt.Color(236, 177, 89));
        btnAgregarLote.setText("Añadir");
        btnAgregarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLoteActionPerformed(evt);
            }
        });

        txtPrincipio.setBackground(new java.awt.Color(239, 237, 220));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel75)
                    .addComponent(jLabel78)
                    .addComponent(jLabel77)
                    .addComponent(jLabel80)
                    .addComponent(jLabel71))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(spDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(cboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboForma, 0, 161, Short.MAX_VALUE)
                    .addComponent(cboRubro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPromocion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboFabricante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrincipio)
                    .addComponent(cboLote, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAF, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(btnAr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnae, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarLote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel71))
                    .addComponent(txtPrincipio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAF)
                        .addGap(18, 18, 18)
                        .addComponent(btnAr)
                        .addGap(18, 18, 18)
                        .addComponent(btnAp)
                        .addGap(18, 18, 18)
                        .addComponent(btnae))
                    .addComponent(jLabel75)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cboForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnAgregarLote)
                    .addComponent(cboLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel76.setBackground(new java.awt.Color(0, 0, 0));
        jLabel76.setText("Condición de venta:");

        cboConVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin receta", "Con receta", "Ambas" }));

        jLabel4.setText("Estado");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "C", "T", "I" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrecioVenta)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumRegisSani, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel76))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cboConVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(txtNumRegisSani, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(cboConVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jLabel62.setBackground(new java.awt.Color(70, 130, 169));
        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Datos del producto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel62)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(420, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(419, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(236, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(237, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(246, 244, 235));

        jLabel22.setText("Filtrar por:");

        cboFiltros.setBackground(new java.awt.Color(246, 244, 235));
        cboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Bajo stock" }));
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
        btnDarDeBaja.setText("DAR DE BAJA");
        btnDarDeBaja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarDeBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(21, 21, 21)
                .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnDarDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDarDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

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
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    int idFrmFarma = rsProducto.getInt("id_frm_farma");
                    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea dar de baja este producto?", "Confirmar", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        objProducto.darDeBajaDetProducto(idProducto, idFrmFarma);
                        limpiarFormulario();
                        listar("General");
                        JOptionPane.showMessageDialog(this, "Producto dado de baja correctamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El código de producto no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

                rsProducto.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al dar de baja al producto --> " + e.getMessage());
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
                float precioVenta = Float.parseFloat(txtPrecioVenta.getText());
                int stock = (int) spStock.getValue();
                String numRegSanitario = txtNumRegisSani.getText();
                String condicionVenta = cboConVenta.getSelectedItem().toString();
                String principio_activo = txtPrincipio.getText();
                String dosis = spDosis.getValue().toString() + " - " + cboUnidad.getSelectedItem().toString();

                // Obtener los IDs de forma farmacéutica, rubro, promoción y fabricante
                String formaFarmaceutica = (String) cboForma.getSelectedItem();
                String rubro = (String) cboRubro.getSelectedItem();
                String promocion = (String) cboPromocion.getSelectedItem();
                String fabricante = (String) cboFabricante.getSelectedItem();
                char estado = (char) cboEstado.getSelectedItem();

                if (!nombre.isEmpty() && precioVenta > 0 && !numRegSanitario.isEmpty()) {
                    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea modificar este producto?");
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        // Obtener los IDs
                        int idForma = objFormaFarmaceutica.obtenerCodigoFormaFarmaceutica(formaFarmaceutica);
                        int idRubro = objRubro.obtenerCodigoRubro(rubro);
                        int idPromocion = objPromocion.obtenerCodigoPromocion(promocion);
                        int idFabricante = objFabricante.obtenerIdFabricantePorNombre(fabricante);
                        int idLote = (int) cboLote.getSelectedItem();

                        // Asegúrate de que el método de modificar producto tiene los parámetros correctos
                        objProducto.modificarProducto(idProducto, nombre, numRegSanitario, condicionVenta, idPromocion, idRubro);

                        // Aquí deberías modificar el detalle del producto también
                        objProducto.modificarDetalleProductoForma(idForma, idProducto, stock, precioVenta, estado, principio_activo, dosis, idFabricante, idLote);

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
                limpiarFormulario();
            } else {

                int idProducto = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                float precioVenta = Float.parseFloat(txtPrecioVenta.getText());
                int stock = (int) spStock.getValue();
                String numRegSanitario = txtNumRegisSani.getText();
                String condicionVenta = cboConVenta.getSelectedItem().toString();
                String principio_activo = txtPrincipio.getText();
                String dosis = spDosis.getValue().toString() + " - " + cboUnidad.getSelectedItem().toString();

                // Obtener los IDs de forma farmacéutica, rubro, promoción y fabricante
                String formaFarmaceutica = (String) cboForma.getSelectedItem();
                String rubro = (String) cboRubro.getSelectedItem();
                String promocion = (String) cboPromocion.getSelectedItem();
                String fabricante = (String) cboFabricante.getSelectedItem();
                String estadoString = (String) cboEstado.getSelectedItem();
                char estado = estadoString.charAt(0); // Obtener el primer carácter del String

                int idForma = objFormaFarmaceutica.obtenerCodigoFormaFarmaceutica(formaFarmaceutica);
                int idRubro = objRubro.obtenerCodigoRubro(rubro);
                int idPromocion = objPromocion.obtenerCodigoPromocion(promocion);
                int idFabricante = objFabricante.obtenerIdFabricantePorNombre(fabricante);

                int idLote = 1;

                if (!nombre.isEmpty()) {
                    // Registrar en producto_farmaceutico
                    objProducto.registrarProducto(idProducto, nombre, numRegSanitario, condicionVenta, idPromocion, idRubro);

                    // Registrar en detalle_producto_forma
                    objProducto.registrarDetalleProductoForma(idForma, idProducto, stock, precioVenta, estado, principio_activo, dosis, idFabricante, idLote);

                    btnSave.setText("NUEVO");
                    limpiarFormulario();
                    listar("General");
                    JOptionPane.showMessageDialog(this, "Producto y detalle guardados correctamente");
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

    private void cboFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFormaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFormaActionPerformed

    private void txtNumRegisSaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumRegisSaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumRegisSaniActionPerformed

    private void btnAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAFActionPerformed
        jdFormFarmaceutica obj = new jdFormFarmaceutica(null, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnAFActionPerformed

    private void btnArActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArActionPerformed
        jdRubro obj = new jdRubro(null, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnArActionPerformed

    private void btnaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaeActionPerformed
        jdFabricante obj = new jdFabricante(null, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnaeActionPerformed

    private void btnApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApActionPerformed
        jdPromocion obj = new jdPromocion(null, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnApActionPerformed

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
                    txtPrecioVenta.setText(rsProducto.getString("precio_venta"));
                    spStock.setValue(rsProducto.getObject("stock"));
                    txtNumRegisSani.setText(rsProducto.getString("nro_reg_sanitario"));
                    cboConVenta.setSelectedItem(rsProducto.getString("condicion_venta"));

                    // Asignar estado
                    char estado = rsProducto.getString("estado").charAt(0); // Cambia a String y luego a char
                    cboEstado.setSelectedItem(String.valueOf(estado)); // Asegúrate de que el combo tenga el valor como String

                    txtPrincipio.setText(rsProducto.getString("principio_activo"));

                    // Manejar dosis
                    String dosisCompleta = rsProducto.getString("dosis"); // Por ejemplo: "500 - mg"
                    if (dosisCompleta != null && !dosisCompleta.isEmpty()) {
                        String[] partesDosis = dosisCompleta.split(" - "); // Dividir por " - "
                        if (partesDosis.length == 2) {
                            spDosis.setValue(Integer.parseInt(partesDosis[0])); // Asignar cantidad al spinner
                            cboUnidad.setSelectedItem(partesDosis[1]); // Asignar unidad al combo
                        }
                    }

                    cboFabricante.setSelectedItem(rsProducto.getString("nombre_fabricante"));
                    cboForma.setSelectedItem(rsProducto.getString("forma_farmaceutica"));
                    cboRubro.setSelectedItem(rsProducto.getString("nombre_rubro"));
                    cboPromocion.setSelectedItem(rsProducto.getString("descuento"));

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

    private void btnAgregarLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLoteActionPerformed
        jdLote lote = new jdLote(null, true);
        lote.setLocationRelativeTo(null);
        lote.setVisible(true);
    }//GEN-LAST:event_btnAgregarLoteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAF;
    private javax.swing.JButton btnAgregarLote;
    private javax.swing.JButton btnAp;
    private javax.swing.JButton btnAr;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDarDeBaja;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnae;
    private javax.swing.JComboBox<String> cboConVenta;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboFabricante;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JComboBox<String> cboForma;
    private javax.swing.JComboBox<String> cboLote;
    private javax.swing.JComboBox<String> cboPromocion;
    private javax.swing.JComboBox<String> cboRubro;
    private javax.swing.JComboBox<String> cboUnidad;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JSpinner spDosis;
    private javax.swing.JSpinner spStock;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextField txtCorreo3;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumRegisSani;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtPrincipio;
    // End of variables declaration//GEN-END:variables
}
