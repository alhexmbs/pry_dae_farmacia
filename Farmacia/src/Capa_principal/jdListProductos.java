/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Capa_principal;

import capa_negocio.Detalle_Producto_Farmaceutico;
import capa_negocio.Fabricante;
import capa_negocio.Forma_farmaceutica;
import capa_negocio.Producto;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joseph
 */
public class jdListProductos extends javax.swing.JDialog {

    // Referencia dialogo 1    
    private jdPedido dialog1;

    // Objeto Producto
    Detalle_Producto_Farmaceutico objDetallePro = new Detalle_Producto_Farmaceutico();
    Forma_farmaceutica objForma = new Forma_farmaceutica();
    Fabricante objFabricante = new Fabricante();

    /**
     * Creates new form jdListProductos
     */
    public jdListProductos(java.awt.Frame parent, boolean modal, jdPedido pedido) throws Exception {
        super(parent, modal);
        this.dialog1 = pedido;
        initComponents();
        listarFabricante();
        listarFormasFarmaceuticas();
        spnMax.setValue(objDetallePro.obtenerPrecioMaximo());
        spnMin.setValue(0);
        btnAgrupado.add(rbtnConReceta);
        btnAgrupado.add(rbtnSinReceta);
        listar();
    }

    private void listarFabricante() {
        ResultSet rs = null;
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            cboFabricante.setModel(modelo);
            rs = objFabricante.listarFabricantes();
            modelo.addElement("-Ninguno-");
            while (rs.next()) {
                modelo.addElement(rs.getString("id_fabricante") + "-"
                        + rs.getString("nombre_fabricante"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void listarFormasFarmaceuticas() {
        ResultSet rs = null;
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            cboFormaFarmaceutica.setModel(modelo);
            rs = objForma.listarTodosFormaFarmaceutica();
            modelo.addElement("-Ninguno-");
            while (rs.next()) {
                modelo.addElement(rs.getString("id_frm_farma") + "-"
                        + rs.getString("forma_farmaceutica"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void listar() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Forma Farmaceutica");
        modelo.addColumn("Nro Sanitario");
        modelo.addColumn("Condicion Venta");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Principio Activo");
        modelo.addColumn("Dosis");
        modelo.addColumn("Fecha Inicio Promocion");
        modelo.addColumn("Fecha Fin Promocion");
        modelo.addColumn("Id Forma");
        modelo.addColumn("Id Producto");

        tblProducto.setModel(modelo);

        ResultSet rs = null;
        try {

            rs = objDetallePro.filtro1(txtNombreProducto.getText(), ((Number) spnMin.getValue()).floatValue(), ((Number) spnMax.getValue()).floatValue());

            while (rs.next()) {
                Object[] fila = new Object[13];
                fila[0] = rs.getString("nombre_producto");          // Nombre del producto
                fila[1] = rs.getString("forma_farmaceutica");          // Forma Farmaceutica
                fila[2] = rs.getString("registro_sanitario");        // Número de registro sanitario
                fila[3] = rs.getString("condicion_venta");          // Condición de venta
                fila[4] = rs.getInt("stock");                       // Stock disponible
                fila[5] = rs.getFloat("precio");              // Precio de venta
                fila[6] = rs.getString("principio_activo");         // Principio activo
                fila[7] = rs.getString("dosis");                    // Dosis
                fila[8] = rs.getDate("fecha_inicio_promocion");              // Fecha de entrada (tipo Date)
                fila[9] = rs.getString("fecha_fin_promocion");         // Fecha de vencimiento (tipo Date)
                fila[10] = rs.getInt("id_farma");
                fila[11] = rs.getInt("id_producto");

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar --> " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar ResultSet --> " + e.getMessage());
            }
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnAgrupado = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rbtnConReceta = new javax.swing.JRadioButton();
        rbtnSinReceta = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        cboFormaFarmaceutica = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboFabricante = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        spnMin = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spnMax = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(246, 244, 235));

        jPanel1.setBackground(new java.awt.Color(170, 215, 217));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Buscar Detalle Producto Farmaceutico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        rbtnConReceta.setBackground(new java.awt.Color(239, 237, 220));
        rbtnConReceta.setText("Con Receta");

        rbtnSinReceta.setBackground(new java.awt.Color(239, 237, 220));
        rbtnSinReceta.setText("Sin Receta");

        jLabel1.setText("Forma Farmaceutica:");

        cboFormaFarmaceutica.setBackground(new java.awt.Color(239, 237, 220));

        jLabel2.setText("Nombre Fabricante:");

        cboFabricante.setBackground(new java.awt.Color(239, 237, 220));

        jLabel3.setText("Precio:");

        spnMin.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 5.0f));
        spnMin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnMinStateChanged(evt);
            }
        });

        jLabel4.setText("---");

        spnMax.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 5.0f));
        spnMax.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnMaxStateChanged(evt);
            }
        });

        jLabel5.setText("Nombre Producto:");

        txtNombreProducto.setBackground(new java.awt.Color(239, 237, 220));
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(cboFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbtnConReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnSinReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)
                                .addComponent(spnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(cboFormaFarmaceutica, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFormaFarmaceutica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(spnMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(spnMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnConReceta)
                            .addComponent(rbtnSinReceta))
                        .addGap(25, 25, 25))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(246, 244, 235));

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

        btnAgregar.setBackground(new java.awt.Color(236, 177, 89));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setPreferredSize(new java.awt.Dimension(45, 60));
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(236, 177, 89));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnRegresar.setText("LIMPIAR");
        btnRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegresar.setPreferredSize(new java.awt.Dimension(45, 60));
        btnRegresar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        jdManProducto objProducto = new jdManProducto(null, true);
        objProducto.setVisible(true);
        objProducto.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked

        int stock = Integer.parseInt(tblProducto.getValueAt(tblProducto.getSelectedRow(), 4).toString());

        if (stock == 0) {
            JOptionPane.showMessageDialog(rootPane, "Este producto no tiene stock", "Sistema", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombre = tblProducto.getValueAt(tblProducto.getSelectedRow(), 0).toString();
            float precio = Float.parseFloat(tblProducto.getValueAt(tblProducto.getSelectedRow(), 5).toString());
            String dosis = tblProducto.getValueAt(tblProducto.getSelectedRow(), 7).toString();
            int farma = Integer.parseInt(tblProducto.getValueAt(tblProducto.getSelectedRow(), 10).toString());
            int producto = Integer.parseInt(tblProducto.getValueAt(tblProducto.getSelectedRow(), 11).toString());
            dialog1.nombreProducto = nombre;
            dialog1.stockProducto = stock;
            dialog1.vdfForma = farma;
            dialog1.vdfProducto = producto;
            dialog1.concentracionProducto = dosis;
            dialog1.precioProducto = precio;
            dialog1.enviarDatoProducto();
        }
    }//GEN-LAST:event_tblProductoMouseClicked

    private void txtNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyReleased
        listar();
    }//GEN-LAST:event_txtNombreProductoKeyReleased

    private void spnMaxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMaxStateChanged
        listar();
    }//GEN-LAST:event_spnMaxStateChanged

    private void spnMinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMinStateChanged
        listar();
    }//GEN-LAST:event_spnMinStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.ButtonGroup btnAgrupado;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cboFabricante;
    private javax.swing.JComboBox<String> cboFormaFarmaceutica;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbtnConReceta;
    private javax.swing.JRadioButton rbtnSinReceta;
    private javax.swing.JSpinner spnMax;
    private javax.swing.JSpinner spnMin;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
