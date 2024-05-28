/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package Visual;

public class PantallaAdmin extends javax.swing.JPanel {

    /**
     * Creates new form AdminScreen
     */
    public PantallaAdmin() {
        initComponents();
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
        barraarriba = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        checkBuildingsButton = new javax.swing.JButton();
        checkUsersButton = new javax.swing.JButton();
        checkBookingsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        photoLabel3 = new javax.swing.JLabel();
        photoLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 250, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraarriba.setBackground(new java.awt.Color(255, 153, 102));
        barraarriba.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraarriba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        jButton3.setText("Cerrar sesión");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        barraarriba.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 120, 50));

        titleLabel.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logopeque.png"))); // NOI18N
        barraarriba.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        jPanel1.add(barraarriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1031, 91));

        jPanel2.setBackground(new java.awt.Color(255, 236, 217));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkBuildingsButton.setBackground(new java.awt.Color(255, 153, 102));
        checkBuildingsButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 18)); // NOI18N
        checkBuildingsButton.setText("INMUEBLES");
        checkBuildingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBuildingsButtonActionPerformed(evt);
            }
        });
        jPanel2.add(checkBuildingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 289, 58));

        checkUsersButton.setBackground(new java.awt.Color(255, 153, 102));
        checkUsersButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 18)); // NOI18N
        checkUsersButton.setText("USUARIOS");
        checkUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUsersButtonActionPerformed(evt);
            }
        });
        jPanel2.add(checkUsersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 289, 58));

        checkBookingsButton.setBackground(new java.awt.Color(255, 153, 102));
        checkBookingsButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 18)); // NOI18N
        checkBookingsButton.setText("RESERVAS");
        checkBookingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBookingsButtonActionPerformed(evt);
            }
        });
        jPanel2.add(checkBookingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 289, 58));

        jLabel1.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¿Qué desea consultar?");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 650, 69));

        photoLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photoLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logo.png"))); // NOI18N
        jPanel2.add(photoLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 360, 230));

        photoLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/city.png"))); // NOI18N
        jPanel2.add(photoLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 360, 530));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 86, 1031, 570));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Aplicacion.cardLayout.show(Aplicacion.cards, "Pantalla login");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void checkBuildingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBuildingsButtonActionPerformed
        Aplicacion.cargaComprobarInmuebleAdmin();
    }//GEN-LAST:event_checkBuildingsButtonActionPerformed

    private void checkUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUsersButtonActionPerformed
        Aplicacion.cargaComprobarUsuarioAdmin();
    }//GEN-LAST:event_checkUsersButtonActionPerformed

    private void checkBookingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBookingsButtonActionPerformed
        Aplicacion.cargaComprobarReservaAdmin();
    }//GEN-LAST:event_checkBookingsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraarriba;
    private javax.swing.JButton checkBookingsButton;
    private javax.swing.JButton checkBuildingsButton;
    private javax.swing.JButton checkUsersButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel photoLabel2;
    private javax.swing.JLabel photoLabel3;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
