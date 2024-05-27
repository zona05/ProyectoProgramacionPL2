/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package Visual;

import Programa.*;

/**
 * Panel que permite al usuario iniciar sesión.
 */
public class Login extends javax.swing.JPanel {

    /**
     * Crea un nuevo panel de inicio de sesión.
     */
    public Login() {
        initComponents();
        errorLabel.setVisible(false);
    }

    /**
     * Restablece los campos de texto del formulario. Este método se utiliza
     * para limpiar los campos de texto cuando se cambia de pestaña o se vuelve
     * a este panel.
     */
    private void resetText() {
        emailTextField.setText("");
        passwordTextField.setText("");
        errorLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        citybg = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        space5 = new javax.swing.JLabel();
        space6 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        registerLabel = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        statementLabel = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        privacypolicyLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        logoname2 = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 236, 217));
        jPanel1.setMaximumSize(new java.awt.Dimension(888, 676));
        jPanel1.setMinimumSize(new java.awt.Dimension(888, 676));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 102, 102));
        titleLabel.setText("¿Está en búsqueda del alojamiento de sus sueños?");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 690, 49));

        photoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logo.png"))); // NOI18N
        jPanel1.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 220, 210));

        citybg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/city.png"))); // NOI18N
        jPanel1.add(citybg, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 360, 650));

        loginLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 36)); // NOI18N
        loginLabel.setText("INICIAR SESIÓN");
        jPanel1.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 47));

        userLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(102, 102, 102));
        userLabel.setText("CORREO ELECTRÓNICO*");
        jPanel1.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, 22));

        passwordLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(102, 102, 102));
        passwordLabel.setText("CONTRASEÑA*");
        jPanel1.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        emailTextField.setBackground(new java.awt.Color(255, 236, 217));
        emailTextField.setToolTipText("");
        emailTextField.setBorder(null);
        emailTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                emailTextFieldMousePressed(evt);
            }
        });
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 421, 27));
        jPanel1.add(space5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(space6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        passwordTextField.setBackground(new java.awt.Color(255, 236, 217));
        passwordTextField.setBorder(null);
        passwordTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordTextFieldMousePressed(evt);
            }
        });
        jPanel1.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 421, 26));

        loginButton.setBackground(new java.awt.Color(255, 153, 51));
        loginButton.setFont(new java.awt.Font("Noto Sans ExtraBold", 0, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Acceso");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 150, 40));

        registerLabel.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(255, 90, 95));
        registerLabel.setText("¿No tienes una cuenta?");
        registerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelMouseClicked(evt);
            }
        });
        jPanel1.add(registerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, -1, -1));

        errorLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        errorLabel.setText("Usuario o contraseña incorrectos.");
        errorLabel.setEnabled(false);
        errorLabel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                errorLabelPropertyChange(evt);
            }
        });
        jPanel1.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        statementLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        statementLabel.setForeground(new java.awt.Color(102, 102, 102));
        statementLabel.setText("Nota: se deben rellenar todos los campos obligatorios (marcados con *)");
        jPanel1.add(statementLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        subtitleLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 24)); // NOI18N
        subtitleLabel.setForeground(new java.awt.Color(255, 153, 51));
        subtitleLabel.setText("Le presentamos");
        jPanel1.add(subtitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        privacypolicyLabel.setBackground(new java.awt.Color(0, 0, 0));
        privacypolicyLabel.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        privacypolicyLabel.setForeground(new java.awt.Color(255, 70, 70));
        privacypolicyLabel.setText("Política de privacidad");
        privacypolicyLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        privacypolicyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                privacypolicyLabelMouseClicked(evt);
            }
        });
        jPanel1.add(privacypolicyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 420, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 420, 20));

        logoname2.setFont(new java.awt.Font("Noto Sans ExtraBold", 0, 36)); // NOI18N
        logoname2.setForeground(new java.awt.Color(255, 153, 102));
        logoname2.setText("JavaBnB");
        jPanel1.add(logoname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, 50));

        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/favicon.png"))); // NOI18N
        jPanel1.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 100, 70));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailTextFieldMousePressed
        emailTextField.setText("");
    }//GEN-LAST:event_emailTextFieldMousePressed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed

    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void passwordTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextFieldMousePressed
        passwordTextField.setText("");
    }//GEN-LAST:event_passwordTextFieldMousePressed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        errorLabel.setVisible(false);
        //Inicializamos atributos
        String correo = emailTextField.getText();

        //no utilizar getText en la passwordField porque esta "deprecated"
        char[] passwordCharArray = passwordTextField.getPassword();
        String clave = new String(passwordCharArray);
        int tipo = Inicio.iniciarSesion(correo, clave);
        resetText();
        switch (tipo) {
            case 0:
            errorLabel.setVisible(true);
            break;
            case 1:
            System.out.println("Admin");
            Aplicacion.cardLayout.show(Aplicacion.cards, "Pantalla adminscreen");
            break;
            case 2:
            System.out.println("Client");
            Aplicacion.loadMainScreen();
            break;
            case 3:
            System.out.println("Anfitrión");
            Aplicacion.loadMainScreen();
            break;
            default:
            break;
        }

    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseClicked
        resetText();
        Aplicacion.cardLayout.show(Aplicacion.cards, "Pantalla register");
    }//GEN-LAST:event_registerLabelMouseClicked

    private void errorLabelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_errorLabelPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_errorLabelPropertyChange

    private void privacypolicyLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_privacypolicyLabelMouseClicked
        Aplicacion.cardLayout.show(Aplicacion.cards, "Pantalla privacypolicy");
    }//GEN-LAST:event_privacypolicyLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel citybg;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel logoname2;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel privacypolicyLabel;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel space5;
    private javax.swing.JLabel space6;
    private javax.swing.JLabel statementLabel;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
