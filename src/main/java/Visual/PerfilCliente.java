/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package Visual;

import Programa.Particular;
import Programa.Inicio;
import Programa.Credito;
import Programa.Validate;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 * Panel que muestra el perfil del cliente actual.
 */
public class PerfilCliente extends javax.swing.JPanel {

    /**
     * El cliente particular actual.
     */
    public Particular particular;

    /**
     * Crea un nuevo panel de perfil de cliente.
     */
    public PerfilCliente() {
        initComponents();
        errorLabel1.setVisible(false);
        requirementsLabel.setVisible(false);
        emailTextField.setEditable(false);
        clave.setEditable(false);
        tlfTextField.setEditable(false);
        promocodeTextField.setEditable(false);
        CCTextField.setEditable(false);
        dayTextField.setEditable(false);
        monthTextField.setEditable(false);
        yearTextField.setEditable(false);
        moneyTextField.setEditable(false);
        cvvTextField.setEditable(false);
    }

    /**
     * Actualiza la información mostrada en el perfil del cliente.
     */
    public void update() {
        if (Inicio.user != null) {
            // Establece los campos de texto con la información del usuario actual
            dniTextField.setText(Inicio.user.getDni());
            username.setText(Inicio.user.getNombre().toUpperCase());
            emailTextField.setText(Inicio.user.getCorreo());
            clave.setText(Inicio.user.getcontrasena());
            tlfTextField.setText(Inicio.user.getTelefono());
            if (Inicio.esUsuarioVip()) {
                promocodeTextField.setText("JAVABNB2024");
            } else {
                promocodeTextField.setText("           ");
            }

            Credito tarjeta = ((Particular) Inicio.user).getTarjetatarjetaCredito();
            if (tarjeta != null) {
                CCTextField.setText(tarjeta.getNumeroTarjeta());
                LocalDate fechaCaducidad = tarjeta.getFechaCaducidad();
                dayTextField.setText(String.valueOf(fechaCaducidad.getDayOfMonth()));
                monthTextField.setText(String.valueOf(fechaCaducidad.getMonthValue()));
                yearTextField.setText(String.valueOf(fechaCaducidad.getYear()));
                cvvTextField.setText(tarjeta.getCvv());
                moneyTextField.setText(String.valueOf(tarjeta.getSaldo()));
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

        jPanel1 = new javax.swing.JPanel();
        data = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        tlfLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        clave = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        emailTextField = new javax.swing.JTextField();
        dniTextField = new javax.swing.JTextField();
        tlfTextField = new javax.swing.JTextField();
        errorLabel1 = new javax.swing.JLabel();
        requirementsLabel = new javax.swing.JLabel();
        promocodeLabel = new javax.swing.JLabel();
        promocodeTextField = new javax.swing.JTextField();
        CCLabel = new javax.swing.JLabel();
        CCTextField = new javax.swing.JTextField();
        dayLabel = new javax.swing.JLabel();
        monthLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        dayTextField = new javax.swing.JTextField();
        monthTextField = new javax.swing.JTextField();
        cvvTextField = new javax.swing.JTextField();
        cvvLabel = new javax.swing.JLabel();
        yearTextField = new javax.swing.JTextField();
        moneyLabel = new javax.swing.JLabel();
        moneyTextField = new javax.swing.JTextField();
        uppermenu = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        mainscr = new javax.swing.JButton();
        cerrarsesion = new javax.swing.JButton();
        addMoneyButton = new javax.swing.JButton();
        ParLabel = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        photoLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 236, 217));

        data.setBackground(new java.awt.Color(255, 250, 248));
        data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        data.setMaximumSize(new java.awt.Dimension(306, 307));
        data.setPreferredSize(new java.awt.Dimension(306, 400));
        data.setRequestFocusEnabled(false);
        data.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        emailLabel.setText("Correo electrónico:");
        data.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 17, -1, -1));

        dniLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        dniLabel.setText("DNI:");
        data.add(dniLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 51, -1, -1));

        tlfLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        tlfLabel.setText("Teléfono:");
        data.add(tlfLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 85, -1, -1));

        passLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        passLabel.setText("Contraseña:");
        data.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 387, -1, -1));

        clave.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        clave.setText("contraseña1");
        data.add(clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 387, 143, -1));

        jButton1.setBackground(new java.awt.Color(255, 153, 102));
        jButton1.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Editar datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        data.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 113, 34));

        emailTextField.setEditable(false);
        emailTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        data.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 270, -1));

        dniTextField.setEditable(false);
        dniTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        data.add(dniTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 370, -1));

        tlfTextField.setEditable(false);
        tlfTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        data.add(tlfTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 340, -1));

        errorLabel1.setBackground(new java.awt.Color(255, 90, 95));
        errorLabel1.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(255, 90, 95));
        errorLabel1.setText("Alguno de los datos no es válido");
        errorLabel1.setEnabled(false);
        errorLabel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                errorLabel1PropertyChange(evt);
            }
        });
        data.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        requirementsLabel.setFont(new java.awt.Font("Noto Sans", 2, 10)); // NOI18N
        requirementsLabel.setForeground(new java.awt.Color(102, 102, 102));
        requirementsLabel.setText("Al menos una mayúscula, minúcula, números y de longitud 8");
        data.add(requirementsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 415, -1, -1));

        promocodeLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        promocodeLabel.setText("Código promocional:");
        data.add(promocodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 119, -1, -1));

        promocodeTextField.setEditable(false);
        promocodeTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        data.add(promocodeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 260, -1));

        CCLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        CCLabel.setText("Tarjeta de crédito:");
        data.add(CCLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 153, -1, -1));

        CCTextField.setEditable(false);
        CCTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        data.add(CCTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 153, 280, -1));

        dayLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        dayLabel.setText("Día:");
        data.add(dayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 187, -1, -1));

        monthLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        monthLabel.setText("Mes:");
        data.add(monthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 227, -1, -1));

        yearLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        yearLabel.setText("Año:");
        data.add(yearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 267, -1, -1));

        dayTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        dayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTextFieldActionPerformed(evt);
            }
        });
        data.add(dayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 187, -1, -1));

        monthTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        monthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthTextFieldActionPerformed(evt);
            }
        });
        data.add(monthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 227, -1, -1));

        cvvTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cvvTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cvvTextFieldActionPerformed(evt);
            }
        });
        data.add(cvvTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 307, -1, -1));

        cvvLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        cvvLabel.setText("CVV:");
        data.add(cvvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 307, -1, -1));

        yearTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        yearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTextFieldActionPerformed(evt);
            }
        });
        data.add(yearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 267, -1, -1));

        moneyLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        moneyLabel.setText("Saldo:");
        data.add(moneyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 347, -1, -1));

        moneyTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        moneyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyTextFieldActionPerformed(evt);
            }
        });
        data.add(moneyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 347, -1, -1));

        uppermenu.setBackground(new java.awt.Color(255, 153, 102));
        uppermenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photoLabel.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        photoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logopeque.png"))); // NOI18N
        uppermenu.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        mainscr.setBackground(new java.awt.Color(255, 102, 102));
        mainscr.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mainscr.setForeground(new java.awt.Color(255, 255, 255));
        mainscr.setText("Volver");
        mainscr.setBorderPainted(false);
        mainscr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainscr.setPreferredSize(new java.awt.Dimension(80, 30));
        mainscr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainscrActionPerformed(evt);
            }
        });
        uppermenu.add(mainscr, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 88, 39));

        cerrarsesion.setBackground(new java.awt.Color(255, 102, 102));
        cerrarsesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cerrarsesion.setForeground(new java.awt.Color(255, 255, 255));
        cerrarsesion.setText("Cerrar sesión");
        cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesionActionPerformed(evt);
            }
        });
        uppermenu.add(cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 106, 39));

        addMoneyButton.setBackground(new java.awt.Color(255, 102, 102));
        addMoneyButton.setForeground(new java.awt.Color(255, 255, 255));
        addMoneyButton.setText("Añadir saldo");
        addMoneyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoneyButtonActionPerformed(evt);
            }
        });
        uppermenu.add(addMoneyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 118, 39));

        ParLabel.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        ParLabel.setForeground(new java.awt.Color(102, 102, 102));
        ParLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ParLabel.setText("Cliente Particular");

        username.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
        username.setForeground(new java.awt.Color(255, 102, 102));
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setText("OOOOOOO");

        photoLabel2.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        photoLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photoLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(uppermenu, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ParLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(photoLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(uppermenu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ParLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(photoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void addMoneyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMoneyButtonActionPerformed
// Verifica si el usuario actual es un Particular
        if (Inicio.user instanceof Particular) {
            // Convierte el usuario en un objeto de tipo Particular
            Particular particular = (Particular) Inicio.user;
            // Obtiene la tarjeta de crédito asociada al Particular
            Credito tarjeta = particular.getTarjetatarjetaCredito();
            try {
                // Verifica si el Particular tiene una tarjeta de crédito asociada
                if (tarjeta != null) {
                    double saldoañadido;
                    // Solicita al usuario que ingrese la cantidad de dinero que desea añadir
                    String notaIntroducida = JOptionPane.showInputDialog(this, "Ingrese la cantidad de dinero que desea tener:");
                    saldoañadido = Double.parseDouble(notaIntroducida);

                    // Incrementa el saldo de la tarjeta con la cantidad ingresada
                    tarjeta.incrementarSaldo(saldoañadido);
                    // Actualiza la interfaz de usuario para mostrar el nuevo saldo (si tienes una etiqueta o campo de texto para el saldo)
                    moneyTextField.setText(String.valueOf(tarjeta.getSaldo()));

                    System.out.println("Dinero añadido. Nuevo saldo: " + tarjeta.getSaldo());
                } else {
                    System.out.println("Este usuario no tiene ninguna tarjeta asociada a su cuenta.");
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Error de formato: " + nfe.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }
        } else {
            System.out.println("Este usuario no es un cliente particular");
        }

    }//GEN-LAST:event_addMoneyButtonActionPerformed

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        Inicio.cerrarSesion();
        Aplicacion.cardLayout.show(Aplicacion.cards, "Pantalla login");
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void mainscrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainscrActionPerformed
        Aplicacion.cargaPantallaPrincipal();
    }//GEN-LAST:event_mainscrActionPerformed

    private void moneyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyTextFieldActionPerformed

    private void yearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTextFieldActionPerformed

    private void cvvTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cvvTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cvvTextFieldActionPerformed

    private void monthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthTextFieldActionPerformed

    private void dayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayTextFieldActionPerformed

    private void errorLabel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_errorLabel1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_errorLabel1PropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jButton1.getText().equals("Editar datos")) {
            // Si el botón está en modo "Editar datos", establece los campos de texto como editables
            emailTextField.setEditable(true);
            clave.setEditable(true);
            tlfTextField.setEditable(true);
            if (Inicio.esUsuarioVip()) {
                // Si el usuario es VIP, el campo de texto del código promocional no se puede editar
                promocodeTextField.setEditable(false);
            } else {
                // Si el usuario no es VIP, el campo de texto del código promocional se puede editar
                promocodeTextField.setEditable(true);
            }
            // Cambiar el texto del botón a "Aceptar"
            jButton1.setText("Aceptar");
        } else {
            // Si el botón está en modo "Aceptar", establece los campos de texto como no editables
            emailTextField.setEditable(false);
            clave.setEditable(false);
            tlfTextField.setEditable(false);
            promocodeTextField.setEditable(false);

            jButton1.setText("Editar datos");

            // Verificar la validez de los datos ingresados
            String email = emailTextField.getText();
            char[] passwCharArray = clave.getPassword();
            String password = new String(passwCharArray);
            String telefono = tlfTextField.getText();
            String promocode = promocodeTextField.getText();

            boolean valido = true;

            // Verificar el correo electrónico
            if (!Validate.validarEmail(email)) {
                errorLabel1.setVisible(true);
                emailTextField.setText("");
                valido = false;
            } // Verificar la contraseña
            else if (!Validate.validarContraseña(password)) {
                errorLabel1.setVisible(true);
                clave.setText("");
                valido = false;
            } // Verificar el teléfono
            else if (!Validate.validarTelefono(telefono)) {
                errorLabel1.setVisible(true);
                tlfTextField.setText("");
                valido = false;
            }

            // Verificar el código promocional
            if (!Validate.validarPromocode(promocode)) {
                errorLabel1.setVisible(true);
                promocodeTextField.setText("");
                valido = false;
            } else {
                errorLabel1.setVisible(false);
            }

            if (valido) {
                // Si todos los datos son válidos, actualiza la información del usuario
                errorLabel1.setVisible(false);
                Inicio.user.setCorreo(email);
                Inicio.user.setTelefono(telefono);
                Inicio.user.setcontrasena(password);

                // Verificar y update el estado VIP del usuario si el código promocional es válido
                if (Inicio.hacerVipSiPromocodeValido(promocode)) {
                    System.out.println("Este usuario ahora es VIP.");
                }

                System.out.println(Inicio.user.toString());
            } else {
                errorLabel1.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CCLabel;
    private javax.swing.JTextField CCTextField;
    private javax.swing.JLabel ParLabel;
    private javax.swing.JButton addMoneyButton;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JPasswordField clave;
    private javax.swing.JLabel cvvLabel;
    private javax.swing.JTextField cvvTextField;
    private javax.swing.JPanel data;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mainscr;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JTextField moneyTextField;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel photoLabel2;
    private javax.swing.JLabel promocodeLabel;
    private javax.swing.JTextField promocodeTextField;
    private javax.swing.JLabel requirementsLabel;
    private javax.swing.JLabel tlfLabel;
    private javax.swing.JTextField tlfTextField;
    private javax.swing.JPanel uppermenu;
    private javax.swing.JLabel username;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
