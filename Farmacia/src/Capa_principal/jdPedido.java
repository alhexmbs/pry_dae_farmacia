package Capa_principal;

import capa_negocio.Cliente;
import capa_negocio.Detalle_Producto_Farmaceutico;
import capa_negocio.Forma_farmaceutica;
import capa_negocio.Pedido;
import capa_negocio.Producto;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joseph
 */
public class jdPedido extends javax.swing.JDialog {

    Pedido objPedido = new Pedido();
    Detalle_Producto_Farmaceutico objDetalle_Producto_Farmaceutico = new Detalle_Producto_Farmaceutico();
    Cliente objCliente = new Cliente();
    Producto objProducto = new Producto();
    Forma_farmaceutica objFormaFarma = new Forma_farmaceutica();
    Pedido pedido = new Pedido();
    int codigo_pedido;

    // Datos del formulario
    private String nombreCliente;
    private String nroDocumentoCliente;
    String nombreProducto;
    String concentracionProducto;
    int stockProducto;
    float precioProducto;
    private String tipoComprobante;
//    int numeroVenta;

    // Variables de Detalla_Producto_Forma
    int vdfForma;
    int vdfProducto;

    // Limpiar Total y Cantidad
    public void limpiarTotalCantidadYProducto() {
        txtCantidad.setText("");
        lblTotalVenta.setText("");
        txtNombreProducto.setText("");
        txtConcentracion.setText("");
        txtStockProducto.setText("");
        txtPrecioProducto.setText("");
        vdfForma = 0;
        vdfProducto = 0;
    }

    public void asignarNumPedidol() {
        try {
            int pedido1 = objPedido.genenrarIDpedido();
            txtNumeroVentaPosible.setText(String.valueOf(pedido1));
        } catch (Exception e) {
        }
    }

    public void asignarFechaActual() {
        Date fecha = new Date();
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        txtFechaVenta.setText("     " + smf.format(fecha));
    }

    // Cliente enviar Datos        
    public void enviar() {
        txtNombreCliente.setText(nombreCliente);
        txtDocCliente.setText(nroDocumentoCliente);
    }

    // Producto enviar Datos        
    public void enviarDatoProducto() {
        txtNombreProducto.setText(nombreProducto);
        txtStockProducto.setText(String.valueOf(stockProducto));
        txtPrecioProducto.setText(String.valueOf(precioProducto));
        txtConcentracion.setText(concentracionProducto);
        System.out.println("Forma " + vdfForma);
        System.out.println("Producto " + vdfProducto);
    }

    //      
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNroDocumentoCliente() {
        return nroDocumentoCliente;
    }

    public void setNroDocumentoCliente(String nroDocumentoCliente) {
        this.nroDocumentoCliente = nroDocumentoCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getConcentracionProducto() {
        return concentracionProducto;
    }

    public void setConcentracionProducto(String concentracionProducto) {
        this.concentracionProducto = concentracionProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    //
    private String datoRecibido;

    public void setDato(String dato) {
        this.datoRecibido = dato;
        System.out.println(datoRecibido);
    }

    public jdPedido(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        try {
            codigo_pedido = pedido.genenrarIDpedido();
            System.out.println(codigo_pedido);
        } catch (Exception e) {
            System.out.println("Error al generar el ID del pedido: " + e.getMessage());
        }
        // Desactivados       
        //lblTotalVenta.setEditable(false);

        desactivar();
        llenarTablaInicial();
        asignarFechaActual();
        asignarNumPedidol();
//        jDateFecha.setEnabled(false);
    }

    // Método para desactivar los controles
    public void desactivar() {
        // Número de venta         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel69 = new javax.swing.JLabel();
        btnBuscarProductos = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JLabel();
        txtConcentracion = new javax.swing.JLabel();
        txtStockProducto = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JLabel();
        txtDocCliente = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txtFechaVenta = new javax.swing.JLabel();
        txtNumeroVentaPosible = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        btnCancelarVenta = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnSiguiente = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtCantidad = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnDarBaja = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JTextField();
        lblIGV = new javax.swing.JLabel();
        lblValorVenta = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel9.setBackground(new java.awt.Color(246, 244, 235));

        jPanel2.setBackground(new java.awt.Color(170, 215, 217));

        jLabel67.setBackground(new java.awt.Color(70, 130, 169));
        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(51, 51, 51));
        jLabel67.setText("Producto:");

        jLabel69.setBackground(new java.awt.Color(0, 0, 0));
        jLabel69.setText("Producto:");

        btnBuscarProductos.setBackground(new java.awt.Color(236, 177, 89));
        btnBuscarProductos.setText("Buscar");
        btnBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductosActionPerformed(evt);
            }
        });

        jLabel64.setBackground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Stock:");

        jLabel65.setBackground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("Precio S/:");

        jLabel70.setBackground(new java.awt.Color(0, 0, 0));
        jLabel70.setText("Concentración:");

        txtNombreProducto.setBackground(new java.awt.Color(239, 237, 220));
        txtNombreProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNombreProducto.setOpaque(true);

        txtConcentracion.setBackground(new java.awt.Color(239, 237, 220));
        txtConcentracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtConcentracion.setOpaque(true);

        txtStockProducto.setBackground(new java.awt.Color(239, 237, 220));
        txtStockProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStockProducto.setOpaque(true);

        txtPrecioProducto.setBackground(new java.awt.Color(239, 237, 220));
        txtPrecioProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPrecioProducto.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel70)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConcentracion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBuscarProductos)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel64))
                            .addComponent(jLabel65))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel67)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel64)
                    .addComponent(jLabel69)
                    .addComponent(txtStockProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel70)
                        .addComponent(jLabel65))
                    .addComponent(txtConcentracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel1.setBackground(new java.awt.Color(170, 215, 217));

        jLabel66.setBackground(new java.awt.Color(70, 130, 169));
        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setText("Datos del Cliente:");

        jLabel68.setBackground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("Cliente:");

        txtBuscar.setBackground(new java.awt.Color(236, 177, 89));
        txtBuscar.setText("Buscar");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel63.setBackground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Nro Doc:");

        txtNombreCliente.setBackground(new java.awt.Color(239, 237, 220));
        txtNombreCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNombreCliente.setOpaque(true);

        txtDocCliente.setBackground(new java.awt.Color(239, 237, 220));
        txtDocCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDocCliente.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel63)
                        .addGap(18, 18, 18)
                        .addComponent(txtDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel66)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(jLabel63)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5.setBackground(new java.awt.Color(170, 215, 217));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel75.setBackground(new java.awt.Color(70, 130, 169));
        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(51, 51, 51));
        jLabel75.setText("FECHA:");

        jLabel84.setBackground(new java.awt.Color(70, 130, 169));
        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(51, 51, 51));
        jLabel84.setText("VENTA:");

        txtFechaVenta.setBackground(new java.awt.Color(239, 237, 220));
        txtFechaVenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFechaVenta.setOpaque(true);

        txtNumeroVentaPosible.setBackground(new java.awt.Color(239, 237, 220));
        txtNumeroVentaPosible.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNumeroVentaPosible.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel84)
                .addGap(89, 89, 89))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(txtNumeroVentaPosible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel84))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumeroVentaPosible, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnCancelarVenta.setBackground(new java.awt.Color(236, 177, 89));
        btnCancelarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar (2).png"))); // NOI18N
        btnCancelarVenta.setText("Suprimir");
        btnCancelarVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarVenta.setPreferredSize(new java.awt.Dimension(45, 60));
        btnCancelarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        jLabel76.setBackground(new java.awt.Color(70, 130, 169));
        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(51, 51, 51));
        jLabel76.setText("Opciones:");

        btnSiguiente.setBackground(new java.awt.Color(236, 177, 89));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/79501_go_next_icon.png"))); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguiente.setPreferredSize(new java.awt.Dimension(45, 60));
        btnSiguiente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel76)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(btnCancelarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(246, 244, 235));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        txtCantidad.setBackground(new java.awt.Color(239, 237, 220));
        txtCantidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel77.setBackground(new java.awt.Color(0, 0, 0));
        jLabel77.setText("CANTIDAD:");

        jLabel78.setBackground(new java.awt.Color(0, 0, 0));
        jLabel78.setText("TOTAL:");

        lblTotalVenta.setBackground(new java.awt.Color(170, 215, 217));
        lblTotalVenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTotalVenta.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77)
                .addGap(18, 18, 18)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addComponent(lblTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel77)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel78)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(246, 244, 235));

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

        btnDarBaja.setBackground(new java.awt.Color(236, 177, 89));
        btnDarBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDarBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnDarBaja.setText("ELIMINAR");
        btnDarBaja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });

        btnAgregarProducto.setBackground(new java.awt.Color(236, 177, 89));
        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnAgregarProducto.setText("AGREGAR");
        btnAgregarProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarProducto.setPreferredSize(new java.awt.Dimension(60, 36));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(236, 177, 89));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        btnEliminar.setText("SALIR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDarBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
        jScrollPane3.setViewportView(tblProducto);

        jPanel8.setBackground(new java.awt.Color(246, 244, 235));

        jLabel79.setBackground(new java.awt.Color(70, 130, 169));
        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(51, 51, 51));
        jLabel79.setText("VALOR VENTA");

        jLabel80.setBackground(new java.awt.Color(70, 130, 169));
        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 51, 51));
        jLabel80.setText("DESCUENTO");

        jLabel81.setBackground(new java.awt.Color(70, 130, 169));
        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(51, 51, 51));
        jLabel81.setText("SUB TOTAL");

        jLabel82.setBackground(new java.awt.Color(70, 130, 169));
        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(51, 51, 51));
        jLabel82.setText("I.G.V");

        jLabel83.setBackground(new java.awt.Color(70, 130, 169));
        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(51, 51, 51));
        jLabel83.setText("TOTAL A PAGAR");

        lblTotalPagar.setBackground(new java.awt.Color(170, 215, 217));
        lblTotalPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblIGV.setBackground(new java.awt.Color(153, 153, 153));
        lblIGV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIGV.setPreferredSize(new java.awt.Dimension(37, 18));

        lblValorVenta.setBackground(new java.awt.Color(153, 153, 153));
        lblValorVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblValorVenta.setPreferredSize(new java.awt.Dimension(37, 18));

        lblDescuento.setBackground(new java.awt.Color(153, 153, 153));
        lblDescuento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDescuento.setForeground(new java.awt.Color(255, 0, 0));
        lblDescuento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblDescuento.setPreferredSize(new java.awt.Dimension(37, 18));

        lblSubTotal.setBackground(new java.awt.Color(153, 153, 153));
        lblSubTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSubTotal.setPreferredSize(new java.awt.Dimension(37, 18));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(lblIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(lblIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblValorVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        llenarTablaInicial();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed

        int valor = -1;

        try {
            valor = tblProducto.getSelectedRow();

            if (valor == -1) {
                JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fila a eliminar", "SISTEMA", JOptionPane.ERROR_MESSAGE);
            } else {
                DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();
                modelo.removeRow(valor);
                tblProducto.setModel(modelo);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error de entrada para eliminar fila de tabla", "SISTEMA", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnDarBajaActionPerformed

    public void calcularTotales() {
        float valorVenta = 0;
        float valorDescuento = 0;
        float subtotal = 0;
        float igv = 0;
        float totalPagar = 0;

        DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            valorVenta += Float.parseFloat(modelo.getValueAt(i, 4).toString()) * Float.parseFloat(modelo.getValueAt(i, 5).toString());
            String descuentos[] = modelo.getValueAt(i, 6).toString().split(",");
            valorDescuento += ((Float.parseFloat(descuentos[0]) / 100) * Float.parseFloat(modelo.getValueAt(i, 5).toString()) * Float.parseFloat(modelo.getValueAt(i, 4).toString()));
            subtotal += Float.parseFloat(modelo.getValueAt(i, 8).toString());
        }

        igv = subtotal * 0.18f;
        totalPagar = subtotal + igv;

        lblValorVenta.setText(String.valueOf(valorVenta));
        lblDescuento.setText(String.valueOf(valorDescuento));
        lblSubTotal.setText(String.valueOf(subtotal));
        lblIGV.setText(String.valueOf(igv));
        lblTotalPagar.setText(String.valueOf(totalPagar));
    }

    private void llenarTablaInicial() {
        DefaultTableModel modelo = new DefaultTableModel();

// Agregar las columnas al modelo
        modelo.addColumn("Id Frm Forma");
        modelo.addColumn("Id Producto");
        modelo.addColumn("Forma");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Descuento");
        modelo.addColumn("Precio Final");
        modelo.addColumn("Subtotal");

// Asignar el modelo a la tabla
        tblProducto.setModel(modelo);

// Ocultar la columna "Id Frm Forma" (índice 0)
        tblProducto.getColumnModel().getColumn(0).setMinWidth(0);
        tblProducto.getColumnModel().getColumn(0).setMaxWidth(0);
        tblProducto.getColumnModel().getColumn(0).setWidth(0);
        tblProducto.getColumnModel().getColumn(0).setPreferredWidth(0);

// Ocultar la columna "Id Producto" (índice 1)
        tblProducto.getColumnModel().getColumn(1).setMinWidth(0);
        tblProducto.getColumnModel().getColumn(1).setMaxWidth(0);
        tblProducto.getColumnModel().getColumn(1).setWidth(0);
        tblProducto.getColumnModel().getColumn(1).setPreferredWidth(0);

    }

    private void agregarProducto(int idProducto, int forma, int cantidad) {
        System.out.println("Entrando en funcion");
        System.out.println("La cantidad enviada es: " + cantidad);
        ResultSet set1;
        try {

            // Obtener el modelo de la tabla            
            DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();

            // Valor para saber si se repite un elemento
            boolean repetido = false;
            int numFila = -1;
            System.out.println("llegado1");
            for (int i = 0; i < tblProducto.getRowCount(); i++) {
                int tblProducto2 = Integer.parseInt(this.tblProducto.getValueAt(i, 1).toString());
                int tblForma = Integer.parseInt(this.tblProducto.getValueAt(i, 0).toString());
                if (tblProducto2 == idProducto && tblForma == forma) {
                    repetido = true;
                    numFila = i;
                }
            }
            System.out.println("llegado2");
            System.out.println("Es repetido? " + repetido);
            if (repetido == true) {
                int aux = Integer.parseInt(this.tblProducto.getValueAt(numFila, 4).toString());
                cantidad += aux;
                modelo.removeRow(numFila);
            }
            System.out.println("La cantidad con repetido es: " + cantidad);
            int stockDB = objDetalle_Producto_Farmaceutico.obtenerStock(forma, idProducto);
            System.out.println("El stock es " + stockDB);
            System.out.println("La cantidad es " + cantidad);
            if (cantidad > stockDB) {
                cantidad = stockDB;
                JOptionPane.showMessageDialog(rootPane, "Stock Insuficiente");
            }

            set1 = objDetalle_Producto_Farmaceutico.obtenerDetalle_Producto_Forma(forma, idProducto);
            System.out.println("Probando Probando");

            while (set1.next()) {
                modelo.addRow(new Object[]{
                    set1.getInt("id_frm_farma"),
                    set1.getInt("id_producto"),
                    objFormaFarma.buscarFormaFarmaceuticaModificado(set1.getInt("id_frm_farma")),
                    objProducto.buscarProductoModificado(set1.getInt("id_producto")),
                    cantidad,
                    set1.getFloat("precio_venta"),
                    set1.getInt("dscto") + ",%",
                    set1.getFloat("precio_venta") - (set1.getFloat("precio_venta") * set1.getInt("dscto") / 100),
                    (cantidad * (set1.getFloat("precio_venta") - (set1.getFloat("precio_venta") * set1.getInt("dscto") / 100)))
                });
            }
            tblProducto.setModel(modelo);

        } catch (Exception e) {
        }

    }


    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        String cantidadProducto = "";
        String nomProducto = txtNombreProducto.getText();
        cantidadProducto = txtCantidad.getText();
        String nombreCliente = txtNombreCliente.getText();
        if (nombreCliente.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Primero debe seleccionar un cliente", "Sistema", JOptionPane.ERROR_MESSAGE);
        } else {

            if (nomProducto.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Primero debe seleccionar un producto", "Sistema", JOptionPane.ERROR_MESSAGE);

            } else {
                if (cantidadProducto.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Primero debe ingresar una cantidad de producto", "Sistema", JOptionPane.ERROR_MESSAGE);
                } else {
                    int cantidad = Integer.parseInt(txtCantidad.getText());
                    System.out.println("La cantidad desde el formulario es :" + cantidad);
                    System.out.println("VDFARMA ES: " + vdfForma);
                    System.out.println("VDPRODUCTO ES: " + vdfProducto);
                    agregarProducto(vdfProducto, vdfForma, cantidad);
                    limpiarTotalCantidadYProducto();
                    calcularTotales();
                }
            }
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void vaciar() {
        llenarTablaInicial();

        // Cantidades
        txtCantidad.setText("");
        lblTotalVenta.setText("");

        // Datos Producto
        txtNombreProducto.setText("");
        txtConcentracion.setText("");
        txtStockProducto.setText("");
        txtPrecioProducto.setText("");

        // Cliente
        txtNombreCliente.setText("");
        txtDocCliente.setText("");

        //Vaciar Totales
        lblValorVenta.setText("");
        lblDescuento.setText("");
        lblSubTotal.setText("");
        lblIGV.setText("");
        lblTotalPagar.setText("");

    }

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        int rpta = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de cancelar esta venta? ", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (rpta == 1) {

        } else {
            vaciar();
        }

    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        jdListCliente obj = new jdListCliente(null, true, this);
        obj.setVisible(true);
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductosActionPerformed
        jdListProductos obj;
        try {
            obj = new jdListProductos(null, true, this);
            obj.setVisible(true);
            obj.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(jdPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnBuscarProductosActionPerformed

    public void calcularTotal(float valor) {
        lblTotalVenta.setText("");
        float precio = Float.parseFloat(txtPrecioProducto.getText());
        System.out.println("El precio del pro es " + precio);
        System.out.println("El valor del pro es " + valor);
        lblTotalVenta.setText(String.valueOf(valor * precio));
    }

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        try {
            // Verificar si el campo de texto contiene un número válido
            int cantidad = Integer.parseInt(txtCantidad.getText());
            int stock = Integer.parseInt(txtStockProducto.getText());

            if (cantidad > stock) {
                JOptionPane.showMessageDialog(rootPane, "El stock es insuficiente");
                txtCantidad.setText("");
                lblTotalVenta.setText("");
            } else {
                // Pasar el valor de cantidad como número flotante
                float valor = Float.parseFloat(txtCantidad.getText());
                calcularTotal(valor);
            }
        } catch (NumberFormatException e) {
            // Manejar el caso en que el usuario escribe algo no numérico
//            JOptionPane.showMessageDialog(rootPane, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtCantidadKeyReleased


    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        try {
            String nroDocumento = txtDocCliente.getText();

            if (nroDocumento.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Primero debe seleccionar a un cliente", "Sistema", JOptionPane.ERROR_MESSAGE);
            } else {

                int usuario = 1;
                int idCliente = objCliente.buscarClientePorDoc(nroDocumento);

                float total = Float.parseFloat(lblTotalPagar.getText());

                jdGuardarVenta objGuardar = new jdGuardarVenta(null, true, this);
                objGuardar.usuario = usuario;
                objGuardar.idCliente = idCliente;
                objGuardar.total = total;
                objGuardar.tblProducto = (JTable) tblProducto;
                objGuardar.setVisible(true);
                objGuardar.setLocationRelativeTo(null);
            }

        } catch (Exception ex) {
            Logger.getLogger(jdPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarProductos;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblIGV;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JTextField lblTotalPagar;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JLabel lblValorVenta;
    private javax.swing.JTable tblProducto;
    private javax.swing.JButton txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtConcentracion;
    private javax.swing.JLabel txtDocCliente;
    private javax.swing.JLabel txtFechaVenta;
    private javax.swing.JLabel txtNombreCliente;
    private javax.swing.JLabel txtNombreProducto;
    private javax.swing.JLabel txtNumeroVentaPosible;
    private javax.swing.JLabel txtPrecioProducto;
    private javax.swing.JLabel txtStockProducto;
    // End of variables declaration//GEN-END:variables
}
