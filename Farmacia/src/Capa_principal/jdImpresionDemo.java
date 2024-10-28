package Capa_principal;

import java.util.Date;

/**
 *
 * @author alhex
 */
public class jdImpresionDemo extends javax.swing.JDialog {

    String p_serie;
    String p_fecha;
    Float p_importe;
    String p_cliente;
    String p_tipo_comprobante;
    Integer p_id_pedido;
    String p_username;
    public jdImpresionDemo(java.awt.Frame parent, boolean modal, String serie, String fecha, Float importe, String cliente, String tipo_comprobante, Integer id_pedido, String username) {
        super(parent, modal);
        initComponents();
        p_serie = serie;
        p_fecha = fecha;
        p_importe = importe;
        p_cliente = cliente;
        p_tipo_comprobante = tipo_comprobante;
        p_id_pedido = id_pedido;
        p_username = username;
        
        //mostrarDatos();
        
        lblSerie.setText(p_serie);
        lblFecha.setText(p_fecha);
    }
    
    private void mostrarDatos() {
        lblSerie.setText(p_serie);
        lblFecha.setText(p_fecha);
        //lblImporte.setText(p_importe.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblImporte = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("FARMASALUD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 18, -1, -1));

        jLabel2.setText("Numero de serie:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        lblSerie.setBackground(new java.awt.Color(204, 204, 204));
        lblSerie.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblSerie.setOpaque(true);
        jPanel1.add(lblSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 119, 26));

        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        lblImporte.setBackground(new java.awt.Color(204, 204, 204));
        lblImporte.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblImporte.setOpaque(true);
        jPanel1.add(lblImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 107, 29));

        jLabel4.setText("Importe:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        lblFecha.setBackground(new java.awt.Color(204, 204, 204));
        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFecha.setOpaque(true);
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 155, 29));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblSerie;
    // End of variables declaration//GEN-END:variables
}
