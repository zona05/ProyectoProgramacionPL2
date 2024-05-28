/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package Visual;

import Programa.Inmueble;
import Programa.MainBNB;
import Programa.Validate;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JOptionPane;

/**
 * La clase AdminCheckBuildings permite al administrador revisar y gestionar los
 * inmuebles registrados en la aplicación.
 */
public class ComprobarInmuebleAdmin extends javax.swing.JPanel {

    private ArrayList<Inmueble> buildings; // Referencia al ArrayList de inmuebles de la clase JavaBNB
    private ListIterator<Inmueble> li; // Iterador para recorrer el ArrayList en ambas direcciones
    private Inmueble objInm; // Referencia a un objeto de tipo inmueble del ArrayList

    /**
     * Constructor de AdminCheckBuildings que inicializa los componentes y carga
     * los inmuebles.
     */
    public ComprobarInmuebleAdmin() {
        initComponents();
        errorNextLabel.setVisible(false);
        errorPreviousLabel.setVisible(false);
        titleTextPanel.setEditable(false);
        descriptionTextPanel.setEditable(false);
        serviceTextField.setEditable(false);
        streetTextField.setEditable(false);
        cityTextField.setEditable(false);
        numberTextField.setEditable(false);
        cpTextField.setEditable(false);
        priceTextField.setEditable(false);
        guestTextField.setEditable(false);
        roomTextField.setEditable(false);
        bedTextField.setEditable(false);
        bathTextField.setEditable(false);
        serviceTextField.setEditable(false);

        consultarTodo();
    }

    /**
     * Actualiza la vista y los datos de los inmuebles.
     */
    public void update() {
        errorNextLabel.setVisible(false);
        errorPreviousLabel.setVisible(false);
        consultarTodo();
    }

    /**
     * Consulta y carga todos los inmuebles de JavaBNB en la lista local.
     */
    private void consultarTodo() {
        try {
            errorNextLabel.setVisible(false);
            errorPreviousLabel.setVisible(false);

            if (MainBNB.getInmuebles() != null) {
                buildings = new ArrayList<>(MainBNB.getInmuebles()); // Copia de la lista para evitar problemas de concurrencia

                li = buildings.listIterator();
                if (buildings.isEmpty()) {
                    nextButton.setEnabled(false);
                    previousButton.setEnabled(false);
                    deleteBuildingButton.setEnabled(false);
                    limpiarCampos();
                    return;
                } else {
                    nextButton.setEnabled(true);
                    previousButton.setEnabled(true);
                    deleteBuildingButton.setEnabled(true);
                }

                if (li.hasNext()) {
                    objInm = li.next();
                    presenta(objInm);
                } else {
                    errorNextLabel.setVisible(true);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Limpia los campos de texto en el panel de administración.
     */
    private void limpiarCampos() {
        typeLabel.setText("");
        titleTextPanel.setText("");
        descriptionTextPanel.setText("");
        streetTextField.setText("");
        cityTextField.setText("");
        numberTextField.setText("");
        cpTextField.setText("");
        priceTextField.setText("");
        guestTextField.setText("");
        roomTextField.setText("");
        bedTextField.setText("");
        bathTextField.setText("");
        serviceTextField.setText("");
        markTextField.setText("");
    }

    /**
     * Presenta los detalles del inmueble en los campos de texto
     * correspondientes.
     *
     * @param inmueble el inmueble cuyos detalles se van a mostrar
     */
    private void presenta(Inmueble inmueble) {
        titleTextPanel.setText(inmueble.getTitulo());
        descriptionTextPanel.setText(inmueble.getDescripcion());
        streetTextField.setText(inmueble.getDireccion().getCalle());
        cityTextField.setText(inmueble.getDireccion().getCiudad());
        typeLabel.setText(inmueble.gettypes());
        numberTextField.setText(inmueble.getDireccion().getNumero());
        cpTextField.setText(inmueble.getDireccion().getcodigopostal());
        priceTextField.setText(Double.toString(inmueble.getPrecioNoche()));
        guestTextField.setText(Integer.toString(inmueble.getinfoinmueble().getMaxHuespedes()));
        roomTextField.setText(Integer.toString(inmueble.getinfoinmueble().getHabitaciones()));
        bedTextField.setText(Integer.toString(inmueble.getinfoinmueble().getnumcamas()));
        bathTextField.setText(Integer.toString(inmueble.getinfoinmueble().getnumtoilet()));
        serviceTextField.setText(inmueble.getServicios());
        markTextField.setText(String.valueOf(inmueble.getCalificacion()));
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
        barraarriba1 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        deleteBuildingButton = new javax.swing.JButton();
        cpLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        numberTextField = new javax.swing.JTextField();
        cpTextField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        guestLabel = new javax.swing.JLabel();
        guestTextField = new javax.swing.JTextField();
        roomLabel = new javax.swing.JLabel();
        roomTextField = new javax.swing.JTextField();
        bedLabel = new javax.swing.JLabel();
        bathLabel = new javax.swing.JLabel();
        bedTextField = new javax.swing.JTextField();
        bathTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        titleTextPanel = new javax.swing.JTextPane();
        streetTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        serviceTextField = new javax.swing.JTextPane();
        editBuildingButton = new javax.swing.JButton();
        serviceLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        descriptionTextPanel = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        markTextField = new javax.swing.JTextPane();
        markLabel = new javax.swing.JLabel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        errorNextLabel = new javax.swing.JLabel();
        errorPreviousLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 250, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraarriba1.setBackground(new java.awt.Color(255, 153, 102));
        barraarriba1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraarriba1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(255, 90, 95));
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logopeque.png"))); // NOI18N
        barraarriba1.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        returnButton.setBackground(new java.awt.Color(255, 102, 102));
        returnButton.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setText("Volver");
        returnButton.setBorderPainted(false);
        returnButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        returnButton.setPreferredSize(new java.awt.Dimension(80, 30));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        barraarriba1.add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 100, 40));

        jPanel1.add(barraarriba1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 982, 90));

        jPanel3.setBackground(new java.awt.Color(255, 236, 217));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 250, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setMinimumSize(new java.awt.Dimension(580, 499));
        jPanel2.setPreferredSize(new java.awt.Dimension(370, 750));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        titleLabel.setText("Título:");
        jPanel2.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 40, 30));

        typeLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 24)); // NOI18N
        typeLabel.setText("var1");
        jPanel2.add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 190, 60));

        descriptionLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        descriptionLabel.setText("Descripción:");
        jPanel2.add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 40));

        streetLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        streetLabel.setText("Calle:");
        jPanel2.add(streetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 40, 30));

        cityLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cityLabel.setText("Ciudad:");
        jPanel2.add(cityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 30));

        cityTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jPanel2.add(cityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 200, 30));

        deleteBuildingButton.setBackground(new java.awt.Color(255, 153, 102));
        deleteBuildingButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        deleteBuildingButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteBuildingButton.setText("Eliminar inmueble");
        deleteBuildingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBuildingButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deleteBuildingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 160, 40));

        cpLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cpLabel.setText("Codigo postal:");
        jPanel2.add(cpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 80, 30));

        numberLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        numberLabel.setText("Número:");
        jPanel2.add(numberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 30));

        numberTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        numberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(numberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 170, 30));

        cpTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jPanel2.add(cpTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 170, 30));

        priceLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        priceLabel.setText("Precio por noche:");
        jPanel2.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        priceTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(priceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 170, 30));

        guestLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        guestLabel.setText("Huéspedes:");
        jPanel2.add(guestLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, 30));

        guestTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        guestTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(guestTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 170, 30));

        roomLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        roomLabel.setText("Habitaciones:");
        jPanel2.add(roomLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 326, -1, 30));

        roomTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jPanel2.add(roomTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 60, 30));

        bedLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        bedLabel.setText("Camas:");
        jPanel2.add(bedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, 30));

        bathLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        bathLabel.setText("Baños:");
        jPanel2.add(bathLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, 30));

        bedTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jPanel2.add(bedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 110, 30));

        bathTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jPanel2.add(bathTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 120, 30));

        jScrollPane3.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(64, 22));

        titleTextPanel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        titleTextPanel.setMinimumSize(new java.awt.Dimension(64, 22));
        titleTextPanel.setPreferredSize(new java.awt.Dimension(64, 22));
        jScrollPane3.setViewportView(titleTextPanel);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 450, 30));

        streetTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        streetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(streetTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 200, 30));

        jScrollPane4.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(64, 22));

        serviceTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        serviceTextField.setMinimumSize(new java.awt.Dimension(64, 22));
        serviceTextField.setPreferredSize(new java.awt.Dimension(64, 22));
        jScrollPane4.setViewportView(serviceTextField);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 442, 50));

        editBuildingButton.setBackground(new java.awt.Color(255, 153, 102));
        editBuildingButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        editBuildingButton.setForeground(new java.awt.Color(255, 255, 255));
        editBuildingButton.setText("Editar inmueble");
        editBuildingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBuildingButtonActionPerformed(evt);
            }
        });
        jPanel2.add(editBuildingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 517, 150, 40));

        serviceLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        serviceLabel.setText("Servicios:");
        jPanel2.add(serviceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 376, -1, 50));

        jScrollPane5.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(64, 22));

        descriptionTextPanel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        descriptionTextPanel.setMinimumSize(new java.awt.Dimension(64, 22));
        descriptionTextPanel.setPreferredSize(new java.awt.Dimension(64, 22));
        jScrollPane5.setViewportView(descriptionTextPanel);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 450, 40));

        jScrollPane6.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(64, 22));

        markTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        markTextField.setMinimumSize(new java.awt.Dimension(64, 22));
        markTextField.setPreferredSize(new java.awt.Dimension(64, 22));
        jScrollPane6.setViewportView(markTextField);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 440, 40));

        markLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        markLabel.setText("Calificación:");
        jPanel2.add(markLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 580, 580));

        previousButton.setBackground(new java.awt.Color(255, 153, 102));
        previousButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        previousButton.setForeground(new java.awt.Color(255, 255, 255));
        previousButton.setText("Anterior");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        jPanel3.add(previousButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 50, 100, 40));

        nextButton.setBackground(new java.awt.Color(255, 153, 102));
        nextButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Siguiente");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel3.add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 50, 100, 40));

        errorNextLabel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        errorNextLabel.setText("No hay otro inmueble");
        jPanel3.add(errorNextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        errorPreviousLabel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        errorPreviousLabel.setText("No hay otro inmueble");
        jPanel3.add(errorPreviousLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 64, 982, 900));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 982, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (li.hasNext()) {
            objInm = li.next();
            errorNextLabel.setVisible(false);
            errorPreviousLabel.setVisible(false);
            presenta(objInm);

        } else {
            errorNextLabel.setVisible(true);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if (li.hasPrevious()) {
            objInm = li.previous();
            errorNextLabel.setVisible(false);
            errorPreviousLabel.setVisible(false);
            presenta(objInm);

        } else {
            errorPreviousLabel.setVisible(true);
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void editBuildingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBuildingButtonActionPerformed
        // ActionListener para el botón
        //Verificar el texto actual del botón
        if (editBuildingButton.getText().equals("Editar inmueble")) {
            // Si el botón está en modo "Editar datos"
            // Establecer los campos de texto como editables
            // Si el botón está en modo "Aceptar"
            // Establecer los campos de texto como no editables
            titleTextPanel.setEditable(true);
            descriptionTextPanel.setEditable(true);
            streetTextField.setEditable(true);
            cityTextField.setEditable(true);
            numberTextField.setEditable(true);
            cpTextField.setEditable(true);
            priceTextField.setEditable(true);
            guestTextField.setEditable(true);
            roomTextField.setEditable(true);
            bedTextField.setEditable(true);
            bathTextField.setEditable(true);
            serviceTextField.setEditable(true);

            // Cambiar el texto del botón a "Aceptar"
            editBuildingButton.setText("Aceptar");
        } else {

            // Si el botón está en modo "Aceptar"
            // Establecer los campos de texto como no editables
            titleTextPanel.setEditable(false);
            descriptionTextPanel.setEditable(false);
            streetTextField.setEditable(false);
            cityTextField.setEditable(false);
            numberTextField.setEditable(false);
            cpTextField.setEditable(false);
            priceTextField.setEditable(false);
            guestTextField.setEditable(false);
            roomTextField.setEditable(false);
            bedTextField.setEditable(false);
            bathTextField.setEditable(false);
            serviceTextField.setEditable(false);

            editBuildingButton.setText("Editar datos");

            String titulo = titleTextPanel.getText();
            String descripcion = descriptionTextPanel.getText();
            String calle = streetTextField.getText();
            String numero = numberTextField.getText();
            String ciudad = cityTextField.getText();
            String cp = cpTextField.getText();
            String tipo = typeLabel.getText();
            double precio = Double.parseDouble(priceTextField.getText());
            int huespedes = Integer.parseInt(guestTextField.getText());
            int habitaciones = Integer.parseInt(roomTextField.getText());
            int camas = Integer.parseInt(bedTextField.getText());
            int baños = Integer.parseInt(bathTextField.getText());
            String servicios = serviceTextField.getText();

            boolean valido = true;

            if (titulo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cada inmueble necesita un título", "Sin título", JOptionPane.WARNING_MESSAGE);
                valido = false;

            } else if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cada inmueble necesita una descripción.", "Sin descripción", JOptionPane.WARNING_MESSAGE);
                valido = false;
            } else if (!Validate.validarNombre(ciudad)) {
                JOptionPane.showMessageDialog(this, "Existe algún error con la ciudad, puede que esté vacía o que el formato no sea válido.", "Error con la ciudad", JOptionPane.WARNING_MESSAGE);
                valido = false;
            } else if (!Validate.validarNombre(calle)) {
                JOptionPane.showMessageDialog(this, "La casilla de la calle del inmueble es necesaria.", "Falta la calle", JOptionPane.WARNING_MESSAGE);
                valido = false;
            }

            boolean numeroo = false;
            int numeroInt = 0;
            if (!numero.isEmpty()) {
                try {
                    numeroInt = Integer.parseInt(numero);
                    numeroo = true;
                } catch (NumberFormatException e) {
                    valido = false;
                    JOptionPane.showMessageDialog(this, "El número del inmueble debe ser un número entero.", "Error de número", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La casilla del número del inmueble es necesaria.", "Falta el número", JOptionPane.WARNING_MESSAGE);
                valido = false;

            }

            boolean cpp = false;
            int cpInt = 0;
            if (!cp.isEmpty() && cp.length() == 5) {
                try {
                    cpInt = Integer.parseInt(cpTextField.getText());
                    cpp = true;
                } catch (NumberFormatException e) {
                    valido = false;
                    JOptionPane.showMessageDialog(this, "El código postal tiene que ser un número entero.", "Error del código postal", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                valido = false;
                JOptionPane.showMessageDialog(this, "El código postal debe tener 5 carácteres exactamente.", "Error del código postal", JOptionPane.WARNING_MESSAGE);
            }

            if (priceLabel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo del precio no puede estar vacío.", "Campo de precio vacío", JOptionPane.WARNING_MESSAGE);
                valido = false;
            } else {
                if (precio <= 0) {
                    JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.", "Precio menor o igual a 0", JOptionPane.WARNING_MESSAGE);
                    valido = false;
                }
            }

            if (guestTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo de huéspedes no puede estar vacío.", "Campo de huéspedes vacío", JOptionPane.WARNING_MESSAGE);
                valido = false;
            } else {
                if (huespedes <= 0) {
                    JOptionPane.showMessageDialog(this, "El máximo de huéspedes debe ser mayor a 0.", "Número de huéspedes menor o igual a 0", JOptionPane.WARNING_MESSAGE);
                    valido = false;
                }
            }

            if (roomTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo de habitaciones no puede estar vacío.", "Campo de habitaciones vacío", JOptionPane.WARNING_MESSAGE);
                valido = false;
            } else {
                if (habitaciones <= 0) {
                    JOptionPane.showMessageDialog(this, "El número de habitaciones debe ser mayor a 0.", "Número de habitaciones menor o igual a 0", JOptionPane.WARNING_MESSAGE);
                    valido = false;
                }
            }

            if (bedTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo de camas no puede estar vacío.", "Campo de camas vacío", JOptionPane.WARNING_MESSAGE);
                valido = false;
            } else {
                if (camas <= 0) {
                    JOptionPane.showMessageDialog(this, "El número de camas debe ser mayor a 0.", "Número de camas menor o igual a 0", JOptionPane.WARNING_MESSAGE);
                    valido = false;
                }
            }

            if (bathTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo de baños no puede estar vacío.", "Campo de baños vacío", JOptionPane.WARNING_MESSAGE);
                valido = false;
            } else {
                if (baños <= 0) {
                    JOptionPane.showMessageDialog(this, "El número de baños debe ser mayor a 0.", "Número de baños menor o igual a 0", JOptionPane.WARNING_MESSAGE);
                    valido = false;
                }
            }

            if (servicios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cada inmueble necesita un conjunto de servicios.", "Sin servicios", JOptionPane.WARNING_MESSAGE);
                valido = false;
            } else {
            }

            if (!tipo.equals("Casa") && !tipo.equals("Apartamento")) {
                JOptionPane.showMessageDialog(this, "El tipo solo puede ser 'Casa' o 'Apartamento'.", "Tipo inválido", JOptionPane.WARNING_MESSAGE);
                valido = false;
            }

            if (valido) {
                objInm.setTitulo(titulo);
                objInm.settypes(tipo);
                objInm.setDescripcion(descripcion);
                objInm.getDireccion().setCalle(calle);
                objInm.getDireccion().setCiudad(ciudad);
                objInm.getDireccion().setNumero(numero);
                objInm.getDireccion().setcodigopostal(cp);
                objInm.setPrecioNoche(precio);
                objInm.getinfoinmueble().setMaxHuespedes(huespedes);
                objInm.getinfoinmueble().setHabitaciones(habitaciones);
                objInm.getinfoinmueble().setnumcamas(camas);
                objInm.getinfoinmueble().setnumtoilet(baños);
                objInm.setServicios(servicios);
                editBuildingButton.setText("Editar inmueble");
            }
        }
    }//GEN-LAST:event_editBuildingButtonActionPerformed

    private void deleteBuildingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBuildingButtonActionPerformed
        if (objInm != null) {
            MainBNB.eliminarInmueble(objInm); // Llamar al método para eliminar el inmueble
            li.remove();

            if (li.hasNext()) {
                objInm = li.next();
                if (objInm != null) {
                    presenta(objInm);
                }
            } else if (li.hasPrevious()) {
                objInm = li.previous();
                if (objInm != null) {
                    presenta(objInm);
                }
            } else {
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_deleteBuildingButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        Aplicacion.cardLayout.show(Aplicacion.cards, "Pantalla adminscreen");
    }//GEN-LAST:event_returnButtonActionPerformed

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void streetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetTextFieldActionPerformed

    private void numberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberTextFieldActionPerformed

    private void guestTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guestTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraarriba1;
    private javax.swing.JLabel bathLabel;
    private javax.swing.JTextField bathTextField;
    private javax.swing.JLabel bedLabel;
    private javax.swing.JTextField bedTextField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel cpLabel;
    private javax.swing.JTextField cpTextField;
    private javax.swing.JButton deleteBuildingButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextPane descriptionTextPanel;
    private javax.swing.JButton editBuildingButton;
    private javax.swing.JLabel errorNextLabel;
    private javax.swing.JLabel errorPreviousLabel;
    private javax.swing.JLabel guestLabel;
    private javax.swing.JTextField guestTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel markLabel;
    private javax.swing.JTextPane markTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JTextField roomTextField;
    private javax.swing.JLabel serviceLabel;
    private javax.swing.JTextPane serviceTextField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextPane titleTextPanel;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
