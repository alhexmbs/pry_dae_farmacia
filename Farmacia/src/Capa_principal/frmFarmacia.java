package Capa_principal;

import capa_negocio.Usuario_Caja;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class frmFarmacia extends javax.swing.JFrame {

    String rolUsuario;
    Integer idUsu, idCajita;
    Usuario_Caja objUC = new Usuario_Caja();

    public frmFarmacia(String rol, Integer idUsuario, Integer idCaja) {
        initComponents();
        setTitle("Sistema de farmacia");
        System.out.println(rol);
        System.out.println(idUsuario);
        System.out.println(idCaja);
        //setExtendedState(MAXIMIZED_BOTH);
        rolUsuario = rol;
        idUsu = idUsuario;
        idCajita = idCaja;

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        mnuVariaciones = new javax.swing.JMenuItem();
        mnuRptVencer = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        mnuAsignarCajas = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu7.setText("File");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Farmacia");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(221, 221, 221));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoPrincipal.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jMenu1.setText("Cliente");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user plus.png"))); // NOI18N
        jMenuItem1.setText("Registrar cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/medicamentos.png"))); // NOI18N
        jMenu2.setText("Medicamento");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/medicamento.png"))); // NOI18N
        jMenuItem2.setText("Medicamento");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);
        jMenu2.add(jSeparator1);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lote.png"))); // NOI18N
        jMenuItem9.setText("Lote");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);
        jMenu2.add(jSeparator2);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/r.png"))); // NOI18N
        jMenuItem18.setText("Rubro");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);
        jMenu2.add(jSeparator3);

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fabricante.png"))); // NOI18N
        jMenuItem17.setText("Fabricante");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem17);
        jMenu2.add(jSeparator4);

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descuento.png"))); // NOI18N
        jMenuItem19.setText("Promoción");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);
        jMenu2.add(jSeparator5);

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rubro.png"))); // NOI18N
        jMenuItem20.setText("Forma Farmaceutica");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem20);
        jMenu2.add(jSeparator6);

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dt.png"))); // NOI18N
        jMenuItem21.setText("Detalle del medicamento");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem21);

        jMenuBar1.add(jMenu2);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pago.png"))); // NOI18N
        jMenu6.setText("Facturacion y pago");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sale.png"))); // NOI18N
        jMenuItem5.setText("Registrar venta");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuBar1.add(jMenu6);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte.png"))); // NOI18N
        jMenu10.setText("Reportes");

        jMenuItem23.setText("Reporte de ventas mensuales por año");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem23);

        jMenuItem24.setText("Reporte de perdida por productos caducados");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem24);

        jMenuItem25.setText("Reporte productos más vendidos mensualmente");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem25);

        jMenuItem10.setText("Reporte de ventas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem10);

        jMenuItem11.setText("Reportes de productos a vencer");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem11);

        jMenuItem12.setText("Reporte de promociones");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem12);

        jMenuItem13.setText("Reporte de ingresos");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenuItem14.setText(" Reporte de Productos con Mayor Tiempo en Inventario");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem14);

        jMenuItem15.setText("Reporte de productos");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem15);

        jMenuItem3.setText("Reporte de Cliente con Mayor Consumo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed1(evt);
            }
        });
        jMenu10.add(jMenuItem3);

        jMenuItem6.setText("Reporte de Productos sin Ventas Registradas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem6);

        jMenuItem26.setText("Reporte de Ventas según Comprobantes");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem26);

        mnuVariaciones.setText("Reporte de Análisis de Variación Porcentual de Ventas Mensuales por Mes");
        mnuVariaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVariacionesActionPerformed(evt);
            }
        });
        jMenu10.add(mnuVariaciones);

        mnuRptVencer.setText("Reporte de Productos Próximos a Vencer: Análisi y Sugerencias");
        mnuRptVencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRptVencerActionPerformed(evt);
            }
        });
        jMenu10.add(mnuRptVencer);

        jMenuItem7.setText("Alex Burga: Reporte de promociones");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem7);

        jMenuItem27.setText("Alex Burga: Reporte de promociones segun un rango");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem27);

        jMenuItem28.setText("Alex Burga: Reporte margen de ganancias");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem28);

        jMenuBar1.add(jMenu10);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pago.png"))); // NOI18N
        jMenu3.setText("Pagos");

        jMenuItem8.setText("Comprobantes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem29.setText("Metodos de pago");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem29);

        jMenuBar1.add(jMenu3);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user plus.png"))); // NOI18N
        jMenu11.setText("Usuarios");

        jMenuItem16.setText("Gestionar ususarios");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem16);

        mnuAsignarCajas.setText("Asignar a cajas");
        mnuAsignarCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAsignarCajasActionPerformed(evt);
            }
        });
        jMenu11.add(mnuAsignarCajas);

        jMenuBar1.add(jMenu11);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jdManCliente objm = new jdManCliente(null, true);
        objm.setLocationRelativeTo(null);
        objm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        if (rolUsuario.equals("Administrador")) {
            jdManProducto objp = new jdManProducto(null, true);
            objp.setLocationRelativeTo(null);
            objp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(rolUsuario.equals("Administrador")){
            JOptionPane.showMessageDialog(this, "Está acción no le pertenece al rol "+rolUsuario);
        }else if(idCajita <= 0){
            JOptionPane.showMessageDialog(this, "Aún no tiene una caja asignada");
        }else{
            jdPedido obj = new jdPedido(null, false, rolUsuario, idUsu, idCajita);
            obj.setVisible(true);
        }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdMantComprobante objUM = new jdMantComprobante(null, true);
            objUM.setLocationRelativeTo(null);
            objUM.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }
//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdManUsuario usuario = new jdManUsuario(this, true);
            usuario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        if (rolUsuario.equals("Administrador")) {
            jdLote objL = new jdLote(null, true);
            objL.setLocationRelativeTo(null);
            objL.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            JOptionPane.showMessageDialog(this, "En mantenimiento");
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            JOptionPane.showMessageDialog(this, "En mantenimiento");
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            JOptionPane.showMessageDialog(this, "En mantenimiento");
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            JOptionPane.showMessageDialog(this, "En mantenimiento");
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdReporteProductoBajaRotacion objL = new jdReporteProductoBajaRotacion(null, true);
            objL.setLocationRelativeTo(null);
            objL.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            JOptionPane.showMessageDialog(this, "En mantenimiento");
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdDetalleProductoTipo objL = new jdDetalleProductoTipo(null, true);
            objL.setLocationRelativeTo(null);
            objL.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdPromocion objL = new jdPromocion(null, true);
            objL.setLocationRelativeTo(null);
            objL.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed

        if (rolUsuario.equals("Administrador")) {
            jdRubro objL = new jdRubro(null, true);
            objL.setLocationRelativeTo(null);
            objL.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed

        if (rolUsuario.equals("Administrador")) {
            jdFabricante objL = new jdFabricante(null, true);
            objL.setLocationRelativeTo(null);
            objL.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdFormFarmaceutica objL = new jdFormFarmaceutica(null, true);
            objL.setLocationRelativeTo(null);
            objL.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta secci n");
        }

    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void mnuAsignarCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAsignarCajasActionPerformed
        // TODO add your handling code here:
        if (rolUsuario.equals("Administrador")) {
            jdAsignarCaja objAc = new jdAsignarCaja(null, true);
            objAc.setLocationRelativeTo(null);
            objAc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_mnuAsignarCajasActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdR_Katia_MentasMensuales obkatiaReporte1 = new jdR_Katia_MentasMensuales(null, true);
            obkatiaReporte1.setLocationRelativeTo(null);
            obkatiaReporte1.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }


    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            int rpta = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Seleccione una opción", JOptionPane.YES_NO_OPTION);
            if (rpta == 0) {
                objUC.actualizarFechaHoraCierre(idUsu, idCajita);
                System.exit(0);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error inesperado --> " + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing


    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdR_Katia_PerdidasProductosCaducados obkatiaReporte1 = new jdR_Katia_PerdidasProductosCaducados(null, true);
            obkatiaReporte1.setLocationRelativeTo(null);
            obkatiaReporte1.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdR_Katia_ProductosMasVendidos obkatiaReporte1 = new jdR_Katia_ProductosMasVendidos(null, true);
            obkatiaReporte1.setLocationRelativeTo(null);
            obkatiaReporte1.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem3ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed1

        if (rolUsuario.equals("Administrador")) {
            jdReporteClienteMayorConsumo obj = new jdReporteClienteMayorConsumo(null, true);
            obj.setLocationRelativeTo(null);
            obj.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed1

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        if (rolUsuario.equals("Administrador")) {
            jd_ProdSinVentas_JU objPR = new jd_ProdSinVentas_JU(this, true);
            objPR.setLocationRelativeTo(null);
            objPR.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mnuVariacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVariacionesActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdR_Vidaurre_1 objReporte = new jdR_Vidaurre_1(this, true);
            objReporte.setLocationRelativeTo(null);
            objReporte.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_mnuVariacionesActionPerformed

    private void mnuRptVencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRptVencerActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdR_Vidaurre_2 objReporte = new jdR_Vidaurre_2(this, true);
            objReporte.setLocationRelativeTo(null);
            objReporte.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_mnuRptVencerActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        if (rolUsuario.equals("Administrador")) {
            jd_VentasComprobante_JU objReporte = new jd_VentasComprobante_JU(this, true);
            objReporte.setLocationRelativeTo(null);
            objReporte.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdReportePromociones objReporte = new jdReportePromociones(this, true);
            objReporte.setLocationRelativeTo(null);
            objReporte.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdReportePromocionesRango objReporte = new jdReportePromocionesRango(this, true);
            objReporte.setLocationRelativeTo(null);
            objReporte.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdReporteMargenGanancia objReporte = new jdReporteMargenGanancia(this, true);
            objReporte.setLocationRelativeTo(null);
            objReporte.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta seccion");
        }
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        if (rolUsuario.equals("Administrador")) {
            jdAgregarMetodoPago objUM = new jdAgregarMetodoPago(null, true);
            objUM.setLocationRelativeTo(null);
            objUM.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tiene acceso a esta sección");
        }
    }//GEN-LAST:event_jMenuItem29ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JMenuItem mnuAsignarCajas;
    private javax.swing.JMenuItem mnuRptVencer;
    private javax.swing.JMenuItem mnuVariaciones;
    // End of variables declaration//GEN-END:variables
}
