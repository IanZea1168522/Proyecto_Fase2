/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto_fase1_zea_1168522_izaguirre_1170522;

import static java.awt.image.ImageObserver.WIDTH;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author izeac
 */
public class Perfil extends javax.swing.JFrame {

    /**
     * Creates new form Perfil
     */
    
    //variable que me guarde el usuario, esto para poder dar de baja la cuenta
    String usuarioGlo;
    Operador op = new Operador();
    
    public Perfil() {
        initComponents();
    }
    public Perfil(String usuario) 
    {
        initComponents();
        //se escribe en pantalla
        labelUsuario.setText("Usuario: " + usuario.split("\\|")[0]);
        labelNombre.setText("Nombre: " + usuario.split("\\|")[1]);
        labelApellido.setText("Apellido: " + usuario.split("\\|")[2]);
        labelFecha.setText("Nació el: " + usuario.split("\\|")[5]);
        labelCorreo.setText("Correo: " + usuario.split("\\|")[6]);
        labelNum.setText("Teléfono: " + usuario.split("\\|")[7]);
        op.SetImageLabel(LabelFoto, usuario.split("\\|")[8], this);
        //se guarda el usuario
        usuarioGlo = usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelNum = new javax.swing.JLabel();
        btncerrarsesion = new javax.swing.JButton();
        LabelFoto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textBoxCambioCorreo = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textBoxCambioTelefono = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textBoxCambioFecha = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonFoto = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        textBoxCambioRutaFoto = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        botonCambio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelAmigues = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonCambio1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textBoxAmigo = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Borrar Cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel3.setText("PAGINA PRINCIPAL:");

        labelUsuario.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        labelUsuario.setText("Usuario:");

        labelApellido.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        labelApellido.setText("Apellido:");

        labelNombre.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        labelNombre.setText("Nombre: ");

        labelFecha.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        labelFecha.setText("Fecha de Nacimiento: ");

        labelCorreo.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        labelCorreo.setText("Correo: ");

        labelNum.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        labelNum.setText("Número de teléfono: ");

        btncerrarsesion.setBackground(new java.awt.Color(153, 204, 255));
        btncerrarsesion.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        btncerrarsesion.setForeground(new java.awt.Color(0, 0, 0));
        btncerrarsesion.setText("Cerrar Sesión");
        btncerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarsesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btncerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(105, 105, 105))
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelApellido))
                    .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelFecha)
                        .addGap(15, 15, 15)
                        .addComponent(labelCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNum))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btncerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Perfil", jPanel3);

        jScrollPane1.setViewportView(textBoxCambioCorreo);

        jLabel1.setText("Correo");

        jScrollPane2.setViewportView(textBoxCambioTelefono);

        jLabel2.setText("Teléfono");

        jScrollPane3.setViewportView(textBoxCambioFecha);

        jLabel4.setText("Cumpleaños");

        jLabel5.setText("d/m/a");

        botonFoto.setBackground(new java.awt.Color(153, 204, 255));
        botonFoto.setForeground(new java.awt.Color(0, 0, 0));
        botonFoto.setText("Examinar...");
        botonFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFotoActionPerformed(evt);
            }
        });

        textBoxCambioRutaFoto.setEnabled(false);
        jScrollPane6.setViewportView(textBoxCambioRutaFoto);

        jLabel8.setText("Foto de perfil");

        botonCambio.setBackground(new java.awt.Color(153, 204, 255));
        botonCambio.setForeground(new java.awt.Color(0, 0, 0));
        botonCambio.setText("Cambiar");
        botonCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(365, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 74, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)))))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonFoto, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addComponent(botonCambio)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cambio", jPanel2);

        jLabel6.setText("Amigos:");

        botonCambio1.setBackground(new java.awt.Color(153, 204, 255));
        botonCambio1.setForeground(new java.awt.Color(0, 0, 0));
        botonCambio1.setText("Agregar");
        botonCambio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambio1ActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(textBoxAmigo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAmigues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonCambio1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCambio1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAmigues, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Amigos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsesionActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Gracias por usar nuestra red! vuelva pronto",  "Gracias!", WIDTH);
        new Inicio().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btncerrarsesionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String strError = "";
        String rutaIn = "C:\\MEIA\\indices_usuario.txt";
        String rutaDesIn = "C:\\MEIA\\Desc_indices_usuario.txt";
        List<String> listaIn = op.Obtener(rutaIn, strError);
        List<String> listaDesIn = op.Obtener(rutaDesIn, strError);
        String CambioIn = op.buscarIn(listaIn, (Integer.parseInt(listaDesIn.get(9))-1), usuarioGlo.split("\\|")[0]);
        String CambioBlo = op.buscar(listaIn, (Integer.parseInt(listaDesIn.get(9))-1), usuarioGlo.split("\\|")[0], strError);
        op.cambiarStatus(CambioIn, CambioBlo, usuarioGlo.split("\\|")[0], strError, rutaIn, rutaDesIn, listaIn, listaDesIn);
        JOptionPane.showMessageDialog(null, "Gracias por habernos preferido, vuelve pronto", "Hasta luego", WIDTH);
        new Inicio().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFotoActionPerformed
        // TODO add your handling code here:
        String ruta;
        ruta = op.obtenerNuevaRutaImg(this);
        if(ruta == null)
        {
            textBoxCambioRutaFoto.setText("");
        }
        else
        {
            textBoxCambioRutaFoto.setText(op.duplicarImagen(ruta));
        }
    }//GEN-LAST:event_botonFotoActionPerformed

    private void botonCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambioActionPerformed
        // TODO add your handling code here:
        try
        {
            String nuevoCorreo = textBoxCambioCorreo.getText();
            int nuevoTelefono = Integer.parseInt(textBoxCambioTelefono.getText());
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate nuevaFecha = LocalDate.parse(textBoxCambioFecha.getText(), formato);
            String nuevaFoto = textBoxCambioRutaFoto.getText();
            if(nuevoCorreo.isEmpty() || nuevaFoto.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Llene todos los campos por favor", "Error", WIDTH);
            }
            else
            {
                if(nuevoCorreo.length() > 40 || nuevaFoto.length() > 200)
                {
                    JOptionPane.showMessageDialog(null, "Datos Ingresados Erróneos", "Error", WIDTH);
                }
                else
                {
                    String[] partes = usuarioGlo.split("\\|"); 
                    partes[6] = nuevoCorreo;
                    partes[7] = String.valueOf(nuevoTelefono);
                    partes[8] = nuevaFoto;
                    partes[5] = String.valueOf(nuevaFecha);
                    String strError = "";
                    String rutaIn = "C:\\MEIA\\indices_usuario.txt";
                    String rutaDesIn = "C:\\MEIA\\Desc_indices_usuario.txt";
                    List<String> listaIn = op.Obtener(rutaIn, strError);
                    List<String> listaDesIn = op.Obtener(rutaDesIn, strError);
                    String CambioIn = op.buscarIn(listaIn, (Integer.parseInt(listaDesIn.get(9))-1), usuarioGlo.split("\\|")[0]);
                    op.cambiarDatos(String.join("|", partes), CambioIn, usuarioGlo.split("\\|")[0], strError, rutaIn, rutaDesIn, listaIn, listaDesIn);
                    new Perfil(String.join("|", partes)).setVisible(true);
                    setVisible(false);
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Datos ingresados erróneos, vuelve a intentarlo", "Error", WIDTH);
        }
    }//GEN-LAST:event_botonCambioActionPerformed

    private void botonCambio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambio1ActionPerformed
        // TODO add your handling code here:
        String strError = "";
        String amigo = textBoxAmigo.getText();
        String rutaIn = "C:\\MEIA\\indices_usuario.txt";
        String rutaDesIn = "C:\\MEIA\\Desc_indices_usuario.txt";
        List<String> listaIn = op.Obtener(rutaIn, strError);
        List<String> listaDesIn = op.Obtener(rutaDesIn, strError);
        String rutaAr = "C:\\MEIA\\Solicitudes.txt";
        List<String> listaAr = op.Obtener(rutaAr, strError);
        String cantidad = String.valueOf(listaAr.size());
        boolean existe = op.comprobarSoli(listaIn, (Integer.parseInt(listaDesIn.get(9))-1), amigo);
        if(existe)
        {
            op.mandarSolicitud((cantidad + "|-1|-1|" +usuarioGlo.split("\\|")[0] + "|" + amigo + "|0|1"), usuarioGlo.split("\\|")[0]);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El usuario no existe, vuelva a intentarlo", "Error", WIDTH);
        }
    }//GEN-LAST:event_botonCambio1ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelFoto;
    private javax.swing.JButton botonCambio;
    private javax.swing.JButton botonCambio1;
    private javax.swing.JButton botonFoto;
    private javax.swing.JButton btncerrarsesion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelAmigues;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNum;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextPane textBoxAmigo;
    private javax.swing.JTextPane textBoxCambioCorreo;
    private javax.swing.JTextPane textBoxCambioFecha;
    private javax.swing.JTextPane textBoxCambioRutaFoto;
    private javax.swing.JTextPane textBoxCambioTelefono;
    // End of variables declaration//GEN-END:variables
}
