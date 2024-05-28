/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package Visual;

import Programa.Host;
import Programa.Inmueble;
import Programa.MainBNB;
import Programa.Inicio;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class PantallaPrincipal extends javax.swing.JPanel {

    public ArrayList<ImagenInmueble> buildingsicon;
    private ArrayList<Inmueble> buildings;
    private ArrayList<Inmueble> allBuildings;
    int estado;

    /**
     * Constructor de la clase PantallaPrincipal.
     */
    public PantallaPrincipal() {
        initComponents();
        buildingsLabel.setVisible(false);
    }

    /**
     * Actualiza la interfaz de usuario.
     */
    public void update() {
        buildings = MainBNB.getInmuebles();
        allBuildings = MainBNB.getInmuebles();

        buildingsicon = new ArrayList<>();

        if (Inicio.esAnfitrion) {
            addBuildingsButton.setVisible(true);
            myBuildingsButton.setVisible(true);
            misReservasButton.setVisible(false);
        } else {
            addBuildingsButton.setVisible(false);
            myBuildingsButton.setVisible(false);
            misReservasButton.setVisible(true);
        }
    }

    /**
     * Inserta todos los edificios en la interfaz.
     */
    public void insertAllBuildings() {
        buildingsLabel.setVisible(true);
        deleteBuildings(); // Elimina cualquier widget de edificio existente antes de insertar nuevos si es posible
        if (allBuildings == null | allBuildings.isEmpty()) {
            System.err.println("No existen inmuebles disponibles. No se pueden insertar inmuebles.");
            return;
        }
        System.out.println("Existen inmuebles disponibles:");

        int fila = 0;
        int x = 30; //valor de prueba
        for (Inmueble inmueble : allBuildings) {
            if (x >= 480) { //1920=tamaño de la ventana
                fila += 240;//el tamaño de la ventana  del widget
                x = 30;
            }
            ImagenInmueble iconoinm = new ImagenInmueble();
            iconoinm.init(inmueble);
            buildingsicon.add(iconoinm);
            buildingsContainer.add(iconoinm, new org.netbeans.lib.awtextra.AbsoluteConstraints(x, fila, -1, -1));  
            x += 210; //valor de prueba
        }
        buildingsContainer.revalidate(); // Actualiza el contenedor para mostrar los cambios
        buildingsContainer.repaint();   // Repinta el contenedor para asegurar que los cambios sean visibles
        buildings = allBuildings;
    }

    /**
     * Inserta los edificios en la interfaz.
     */
    public void insertBuildings() {
        buildingsLabel.setVisible(true);
        if (buildings == null | buildings.isEmpty()) {
            System.err.println("La lista de edificios está vacía. No se pueden insertar inmuebles.");
            return;
        }
        System.out.println("La lista de edificios no está vacía:");
        deleteBuildings(); // Elimina cualquier widget de edificio existente antes de insertar nuevos

        int fila = 0;
        //tamaño ventana widget
        int x = 30; //valor de prueba
        for (Inmueble inmueble : buildings) {
            if (x >= 480) { //1920=tamaño de la ventana
                fila += 240;
                x = 30;
            }
            ImagenInmueble iconoinm = new ImagenInmueble();
            iconoinm.init(inmueble);
            buildingsicon.add(iconoinm);
            buildingsContainer.add(iconoinm, new org.netbeans.lib.awtextra.AbsoluteConstraints(x, fila, -1, -1)); 
            x += 210; //valor de prueba
        }
        buildingsContainer.revalidate(); // Actualiza el contenedor para mostrar los cambios
        buildingsContainer.repaint();   // Repinta el contenedor para asegurar que los cambios sean visibles
    }

    /**
     * Elimina los edificios de la interfaz.
     */
    public void deleteBuildings() {
        for (ImagenInmueble ii : buildingsicon) {
            this.buildingsContainer.remove(ii);
        }
        buildingsicon.clear(); // Limpia la lista de widgets de edificios después de eliminarlos
        buildingsContainer.revalidate(); // Actualiza el contenedor para mostrar los cambios
        buildingsContainer.repaint();   // Repinta el contenedor para asegurar que los cambios sean visibles
    }

    /**
     * Convierte un objeto a LocalDate.
     *
     * @param dateObject Objeto de fecha.
     * @return Fecha convertida a LocalDate.
     */
    public LocalDate convertToLocalDate(Object dateObject) {
        if (dateObject instanceof Date) {
            return ((Date) dateObject).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            return null;
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
        barraarriba = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        hostProfile = new javax.swing.JButton();
        addBuildingsButton = new javax.swing.JButton();
        myBuildingsButton = new javax.swing.JButton();
        misReservasButton = new javax.swing.JButton();
        buscaalojamiento2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        startDateTextField = new javax.swing.JFormattedTextField();
        endDateTextField = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        showAllBuildingsButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textbuscaaloj2 = new javax.swing.JTextArea();
        barraabajo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buildingsContainer = new javax.swing.JPanel();
        filterComboBox = new javax.swing.JComboBox<>();
        applyButton = new javax.swing.JButton();
        buildingsLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 236, 217));
        jPanel1.setMaximumSize(new java.awt.Dimension(1817, 2551));
        jPanel1.setMinimumSize(new java.awt.Dimension(1817, 2551));
        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 1000));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraarriba.setBackground(new java.awt.Color(255, 153, 102));
        barraarriba.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        barraarriba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/logopeque.png"))); // NOI18N
        barraarriba.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        hostProfile.setBackground(new java.awt.Color(255, 204, 153));
        hostProfile.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        hostProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user (1).jpg"))); // NOI18N
        hostProfile.setText("Mi Cuenta");
        hostProfile.setBorderPainted(false);
        hostProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hostProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostProfileActionPerformed(evt);
            }
        });
        barraarriba.add(hostProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 100, 50));

        addBuildingsButton.setBackground(new java.awt.Color(255, 102, 102));
        addBuildingsButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        addBuildingsButton.setText("Añadir inmueble");
        addBuildingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBuildingsButtonActionPerformed(evt);
            }
        });
        barraarriba.add(addBuildingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 130, 40));

        myBuildingsButton.setBackground(new java.awt.Color(255, 102, 102));
        myBuildingsButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        myBuildingsButton.setText("Mis inmuebles");
        myBuildingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myBuildingsButtonActionPerformed(evt);
            }
        });
        barraarriba.add(myBuildingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 120, 40));

        misReservasButton.setBackground(new java.awt.Color(255, 102, 102));
        misReservasButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        misReservasButton.setText("Mis reservas");
        misReservasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misReservasButtonActionPerformed(evt);
            }
        });
        barraarriba.add(misReservasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 110, 40));

        jPanel1.add(barraarriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 90));

        buscaalojamiento2.setBackground(new java.awt.Color(255, 250, 248));
        buscaalojamiento2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buscaalojamiento2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Destino:");
        buscaalojamiento2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 90, 260, -1));

        cityTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityTextFieldActionPerformed(evt);
            }
        });
        buscaalojamiento2.add(cityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, -1));

        jLabel2.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        jLabel2.setText("Fecha de llegada");
        buscaalojamiento2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        startDateTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        startDateTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        startDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateTextFieldActionPerformed(evt);
            }
        });
        startDateTextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startDateTextFieldPropertyChange(evt);
            }
        });
        buscaalojamiento2.add(startDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 108, -1));

        endDateTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        endDateTextField.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        endDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateTextFieldActionPerformed(evt);
            }
        });
        buscaalojamiento2.add(endDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 108, -1));

        jLabel3.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        jLabel3.setText("Fecha de salida");
        buscaalojamiento2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        searchButton.setBackground(new java.awt.Color(255, 153, 102));
        searchButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        searchButton.setText("Buscar");
        searchButton.setPreferredSize(new java.awt.Dimension(129, 36));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        buscaalojamiento2.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 143, -1));

        showAllBuildingsButton.setBackground(new java.awt.Color(255, 153, 102));
        showAllBuildingsButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        showAllBuildingsButton.setText("Mostrar todos los inmuebles");
        showAllBuildingsButton.setMaximumSize(new java.awt.Dimension(143, 58));
        showAllBuildingsButton.setMinimumSize(new java.awt.Dimension(143, 58));
        showAllBuildingsButton.setPreferredSize(new java.awt.Dimension(143, 58));
        showAllBuildingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllBuildingsButtonActionPerformed(evt);
            }
        });
        buscaalojamiento2.add(showAllBuildingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 212, 40));

        jLabel6.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("dd/MM/yyyy");
        buscaalojamiento2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        textbuscaaloj2.setEditable(false);
        textbuscaaloj2.setBackground(new java.awt.Color(214, 175, 136));
        textbuscaaloj2.setColumns(20);
        textbuscaaloj2.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 18)); // NOI18N
        textbuscaaloj2.setRows(5);
        textbuscaaloj2.setText(" Busque el mejor inmueble\n      para sus vacaciones");
        textbuscaaloj2.setAutoscrolls(false);
        textbuscaaloj2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        buscaalojamiento2.add(textbuscaaloj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 81));

        jPanel1.add(buscaalojamiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 280, 410));

        barraabajo.setBackground(new java.awt.Color(255, 153, 102));
        barraabajo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraabajo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jLabel4.setText("© JavaBNB, 2024");
        barraabajo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jLabel5.setText("Políticas de Privacidad");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        barraabajo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, 20));

        jPanel1.add(barraabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 664, 1120, 40));

        buildingsContainer.setBackground(new java.awt.Color(255, 236, 217));
        buildingsContainer.setMinimumSize(new java.awt.Dimension(1242, 416));
        buildingsContainer.setPreferredSize(new java.awt.Dimension(1242, 426));
        buildingsContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        filterComboBox.setBackground(new java.awt.Color(255, 153, 102));
        filterComboBox.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtrar por:", "Precio Mayor", "Precio Menor", "Chales", "Apartamentos", "Calificacion Mayor", "Calificacion Menor" }));
        filterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterComboBoxActionPerformed(evt);
            }
        });
        buildingsContainer.add(filterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 180, 30));

        applyButton.setBackground(new java.awt.Color(255, 153, 102));
        applyButton.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        applyButton.setText("Aplicar");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        buildingsContainer.add(applyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 100, 40));

        jPanel1.add(buildingsContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 780, 510));

        buildingsLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 3, 48)); // NOI18N
        buildingsLabel.setForeground(new java.awt.Color(255, 153, 102));
        buildingsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildingsLabel.setText("Inmuebles Disponibles");
        buildingsLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(buildingsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 590, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void hostProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostProfileActionPerformed
        deleteBuildings();
        if (Inicio.esAnfitrion) {
            Aplicacion.cargaPerfilAnfitrion();
        } else {
            Aplicacion.cargaPerfilCliente();
        }
    }//GEN-LAST:event_hostProfileActionPerformed

    private void addBuildingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBuildingsButtonActionPerformed
        deleteBuildings();
        Aplicacion.cardLayout.show(Aplicacion.cards, "Pantalla addbuildings");
    }//GEN-LAST:event_addBuildingsButtonActionPerformed

    private void myBuildingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myBuildingsButtonActionPerformed
        deleteBuildings();
        Aplicacion.cargaComprobarInmuebleAnfitrion();
        if (Inicio.user != null) {
            ArrayList<Inmueble> inmueblesAnfitrion = MainBNB.filtrarInmueblesPorAnfitrion((Host) Inicio.user);
            for (Inmueble inmueble : inmueblesAnfitrion) {
                //System.out.println(inmueble.toString());

            }
        }
    }//GEN-LAST:event_myBuildingsButtonActionPerformed

    private void misReservasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misReservasButtonActionPerformed
        deleteBuildings();
        Aplicacion.cargaComprobarReservaInvitado();
    }//GEN-LAST:event_misReservasButtonActionPerformed

    private void endDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateTextFieldActionPerformed

    private void startDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateTextFieldActionPerformed

    private void startDateTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startDateTextFieldPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateTextFieldPropertyChange

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // Establece el ítem seleccionado en el ComboBox de filtro
        filterComboBox.setSelectedItem("Filtrar por:");
// Establece el estado actual
        this.estado = 1;
// Obtiene los valores de los campos de texto y elimina los espacios en blanco al principio y al final
        String ciudad = cityTextField.getText().trim();
// Variables para almacenar las fechas convertidas a LocalDate
        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;

// Verifica si los campos de fecha no están vacíos antes de intentar convertir
        String fechaEntradaText = startDateTextField.getText().trim();
        String fechaSalidaText = endDateTextField.getText().trim();

        if (!fechaEntradaText.isEmpty()) {
            try {
                fechaEntrada = convertToLocalDate(fechaEntradaText);
            } catch (DateTimeParseException e) {
                // Muestra un mensaje de error si el formato de fecha es inválido
                JOptionPane.showMessageDialog(this, "El formato de la fecha debe ser DD/MM/YYYY", "Formato de fecha inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (!fechaSalidaText.isEmpty()) {
            try {
                fechaSalida = convertToLocalDate(fechaSalidaText);
            } catch (DateTimeParseException e) {
                // Muestra un mensaje de error si el formato de fecha es inválido
                JOptionPane.showMessageDialog(this, "El formato de la fecha debe ser DD/MM/YYYY", "Formato de fecha inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

// Filtra los inmuebles según los criterios introducidos
        ArrayList<Inmueble> inmueblesFiltrados = MainBNB.buscarInmuebles(ciudad, fechaEntrada, fechaSalida);

// Actualiza la lista de edificios con los inmuebles filtrados
        buildings = inmueblesFiltrados;

// Llama al método para insertar los inmuebles en el panel
        insertBuildings();


    }//GEN-LAST:event_searchButtonActionPerformed

    private void showAllBuildingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllBuildingsButtonActionPerformed
        filterComboBox.setSelectedItem("Filtrar por:");

        this.estado = 0;
        insertAllBuildings();
    }//GEN-LAST:event_showAllBuildingsButtonActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        deleteBuildings();
        Aplicacion.cardLayout.show(Aplicacion.cards, "Pantalla privacypolicy");
    }//GEN-LAST:event_jLabel5MouseClicked

    private void filterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterComboBoxActionPerformed

    }//GEN-LAST:event_filterComboBoxActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // Imprime el estado actual
        System.out.println(estado);

// Elimina todos los edificios del panel
        deleteBuildings();

// Obtiene la opción seleccionada en el ComboBox de filtro
        String selectedOption = (String) filterComboBox.getSelectedItem();

        ArrayList<Inmueble> inmueblesFiltrados;

// Determina qué lista de inmuebles usar según el estado actual
        if (estado == 0) {
            inmueblesFiltrados = new ArrayList<>(allBuildings); // Usa todos los inmuebles disponibles
        } else {
            inmueblesFiltrados = new ArrayList<>(buildings); // Usa los inmuebles filtrados por la búsqueda
        }

// Llama al método de filtrado correspondiente según la opción seleccionada
        switch (selectedOption) {
            case "Precio Mayor":
                MainBNB.ordenarPorPrecioDescCF(inmueblesFiltrados);
                break;
            case "Precio Menor":
                MainBNB.ordenarPorPrecioAscCF(inmueblesFiltrados);
                break;
            case "Chales":
                // Filtra los inmuebles disponibles por tipo "Casa"
                inmueblesFiltrados = MainBNB.filtrarCasas(inmueblesFiltrados);
                break;
            case "Apartamentos":
                // Filtra los inmuebles disponibles por tipo "Apartamento"
                inmueblesFiltrados = MainBNB.filtrarApartamentos(inmueblesFiltrados);
                break;
            case "Calificación Mayor":
                MainBNB.ordenarPorCalificacionDescCF(inmueblesFiltrados);
                break;
            case "Calificación Menor":
                MainBNB.ordenarPorCalificacionAscCF(inmueblesFiltrados);
                break;
        }

// Actualiza la lista de edificios con los inmuebles filtrados y ordenados
        buildings = inmueblesFiltrados;

// Llama al método para insertar los inmuebles en el panel
        insertBuildings();


    }//GEN-LAST:event_applyButtonActionPerformed

    private void cityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBuildingsButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel barraabajo;
    private javax.swing.JPanel barraarriba;
    private javax.swing.JPanel buildingsContainer;
    private javax.swing.JLabel buildingsLabel;
    private javax.swing.JPanel buscaalojamiento2;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JFormattedTextField endDateTextField;
    private javax.swing.JComboBox<String> filterComboBox;
    private javax.swing.JButton hostProfile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton misReservasButton;
    private javax.swing.JButton myBuildingsButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton showAllBuildingsButton;
    private javax.swing.JFormattedTextField startDateTextField;
    private javax.swing.JTextArea textbuscaaloj2;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
