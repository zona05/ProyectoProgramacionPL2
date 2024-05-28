/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package Visual;

import Programa.Host;
import Programa.Inmueble;
import Programa.MainBNB;
import Programa.Inicio;
import Programa.Validate;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Panel para que el anfitrión revise sus inmuebles y realice acciones
 * relacionadas.
 */
public class ComprobarInmuebleAnfitrion extends javax.swing.JPanel {

    private ArrayList<Inmueble> buildings; // Referencia al ArrayList de inmuebles del anfitrión de la sesión
    private ListIterator<Inmueble> li; // Iterador para recorrer el ArrayList en ambas direcciones
    private Inmueble objInm; // Referencia a un objeto de types inmueble del ArrayList
    private Inmueble inmuebleActual;
    private String foto = "";

    /**
     * Crea un nuevo panel para que el anfitrión revise sus inmuebles.
     */
    public ComprobarInmuebleAnfitrion() {
        initComponents();
        errorNextLabel.setVisible(false);
        errorPreviousLabel.setVisible(false);
        setEditableFields(false);

        consultarTodo();
    }

    /**
     * Actualiza la vista de los inmuebles del anfitrión.
     */
    public void update() {
        errorNextLabel.setVisible(false);
        errorPreviousLabel.setVisible(false);

        consultarTodo();
    }

    /**
     * Obtiene el inmueble actual que se muestra en el panel.
     *
     * @return El inmueble actual.
     */
    public Inmueble getInmuebleActual() {
        return inmuebleActual;
    }

    /**
     * Establece el inmueble actual que se mostrará en el panel.
     *
     * @param inmuebleActual El inmueble actual.
     */
    public void setInmuebleActual(Inmueble inmuebleActual) {
        this.inmuebleActual = inmuebleActual;
    }

    /**
     * Consulta todos los inmuebles del anfitrión y los muestra en la vista.
     */
    private void consultarTodo() {
        if (Inicio.user != null) {
            try {
                errorNextLabel.setVisible(false);
                errorPreviousLabel.setVisible(false);

                // Verificar si el usuario actual es un anfitrión
                if (Inicio.esAnfitrion) {
                    Host anfitrion = (Host) Inicio.user;
                    // Copia de la lista de inmuebles del anfitrión para evitar problemas de concurrencia
                    buildings = new ArrayList<>(MainBNB.filtrarInmueblesPorAnfitrion(anfitrion)); // Obtener los inmuebles del anfitrión utilizando el método filtrarInmueblesPorAnfitrion

                    // Verificar si hay inmuebles asociados al anfitrión
                    if (buildings.isEmpty()) {
                        setButtonsEnabled(false);
                        limpiezaTextos();
                        return;
                    } else {
                        setButtonsEnabled(true);
                    }

                    // Configurar un iterador para los inmuebles
                    li = buildings.listIterator();
                    if (li.hasNext()) {
                        objInm = li.next();
                        presenta(objInm);
                    } else {
                        errorNextLabel.setVisible(true);
                    }

                } else {
                    // Si el usuario no es un anfitrión, mostrar un mensaje de error
                    System.out.println("El usuario actual no es un anfitrión.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
    }

    /**
     * Establece si los campos editables del formulario están habilitados o no.
     *
     * @param editable true si los campos deben ser editables, false de lo
     * contrario.
     */
    private void setEditableFields(boolean editable) {
        titleTextPanel.setEditable(editable);
        descriptionTextPanel.setEditable(editable);
        serviceTextField.setEditable(editable);
        streetTextField.setEditable(editable);
        cityTextField.setEditable(editable);
        numberTextField.setEditable(editable);
        cpTextField.setEditable(editable);
        priceTextField.setEditable(editable);
        guestTextField.setEditable(editable);
        roomTextField.setEditable(editable);
        bedTextField.setEditable(editable);
        bathTextField.setEditable(editable);
        serviceTextField.setEditable(editable);
    }

    /**
     * Establece si los botones del formulario están habilitados o no.
     *
     * @param enabled true si los botones deben estar habilitados, false de lo
     * contrario.
     */
    private void setButtonsEnabled(boolean enabled) {
        nextButton.setEnabled(enabled);
        previousButton.setEnabled(enabled);
        deleteBuildingButton.setEnabled(enabled);
        checkReservesButton.setEnabled(enabled);
        editBuildingButton.setEnabled(enabled);
        editfoto1.setEnabled(enabled);
    }

    /**
     * Muestra la información de un inmueble en los campos correspondientes del
     * formulario.
     *
     * @param inmueble El inmueble a mostrar.
     */
    private void presenta(Inmueble inmueble) {
        typeLabel.setText(inmueble.gettypes());
        titleTextPanel.setText(inmueble.getTitulo());
        descriptionTextPanel.setText(inmueble.getDescripcion());
        streetTextField.setText(inmueble.getDireccion().getCalle());
        cityTextField.setText(inmueble.getDireccion().getCiudad());
        numberTextField.setText(inmueble.getDireccion().getNumero());
        cpTextField.setText(inmueble.getDireccion().getCp());
        priceTextField.setText(Double.toString(inmueble.getPrecioNoche()));
        guestTextField.setText(Integer.toString(inmueble.getDatosInmueble().getMaxHuespedes()));
        roomTextField.setText(Integer.toString(inmueble.getDatosInmueble().getHabitaciones()));
        bedTextField.setText(Integer.toString(inmueble.getDatosInmueble().getCamas()));
        bathTextField.setText(Integer.toString(inmueble.getDatosInmueble().getBaños()));
        serviceTextField.setText(inmueble.getServicios());
        markTextField.setText(String.valueOf(inmueble.getCalificacion()));
    }

    /**
     * Abre un cuadro de diálogo para seleccionar una imagen y la devuelve.
     *
     * @return El archivo de imagen seleccionado, o null si no se selecciona
     * ningún archivo.
     */
    public File abrirImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen");
        fileChooser.setAcceptAllFileFilterUsed(false); // Deshabilitar la opción "Todos los archivos"
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif", "bmp"));

        int result = fileChooser.showOpenDialog(null); // Mostrar el diálogo de selección y capturar la respuesta

        // Procesar la respuesta
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null; // No se selecciona ningún archivo
    }

    public String guardadoImagen(File archivofoto) {
        String directoriodestino = "./src/main/resources/fotosinmuebles"; // Directorio de destino fijo
        Path pathdestino = Paths.get(directoriodestino, archivofoto.getName());

        try {
            // Asegúrate de que el directorio exista
            if (!Files.exists(Paths.get(directoriodestino))) {
                Files.createDirectories(Paths.get(directoriodestino));
            }

            // Copia el archivo al directorio especificado
            Files.copy(archivofoto.toPath(), pathdestino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Imagen guardada en: " + pathdestino);
            return pathdestino.toString(); // Devuelve la ruta de la imagen como String
        } catch (IOException ex) {
            System.out.println("Error al guardar la imagen: " + ex.getMessage());
            return null; // Devuelve null si hay un error
        }
    }

    /**
     * Abre un cuadro de diálogo para seleccionar una imagen y la asigna al
     * inmueble actual.
     *
     * @param i El inmueble al que se le asignará la imagen.
     */
    public void changeImage(Inmueble i) {
        File fotoFile = abrirImagen();
        if (fotoFile != null) {
            i.setfoto(guardadoImagen(fotoFile));
        }
    }

    /**
     * Limpia todos los campos de texto en el formulario.
     */
    private void limpiezaTextos() {
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
        logoButton = new javax.swing.JButton();
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
        markLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        markTextField = new javax.swing.JTextPane();
        checkReservesButton = new javax.swing.JButton();
        editfoto1 = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        errorNextLabel = new javax.swing.JLabel();
        errorPreviousLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 250, 248));

        barraarriba1.setBackground(new java.awt.Color(255, 250, 248));
        barraarriba1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraarriba1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoButton.setBackground(new java.awt.Color(255, 153, 153));
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);
        logoButton.setDefaultCapable(false);
        logoButton.setFocusPainted(false);
        logoButton.setFocusable(false);
        logoButton.setRequestFocusEnabled(false);
        logoButton.setRolloverEnabled(false);
        logoButton.setVerifyInputWhenFocusTarget(false);
        logoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoButtonActionPerformed(evt);
            }
        });
        barraarriba1.add(logoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        logoLabel.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(255, 90, 95));
        logoLabel.setText("JavaBNB");
        barraarriba1.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 36, -1, -1));

        returnButton.setBackground(new java.awt.Color(255, 90, 95));
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
        barraarriba1.add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(983, 22, 104, 53));

        jPanel3.setBackground(new java.awt.Color(255, 250, 248));

        jPanel2.setBackground(new java.awt.Color(255, 250, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setMinimumSize(new java.awt.Dimension(580, 499));
        jPanel2.setPreferredSize(new java.awt.Dimension(370, 640));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setText("Título:");
        jPanel2.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 112, -1, 15));

        typeLabel.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        typeLabel.setText("var1");
        jPanel2.add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 11, 161, -1));

        descriptionLabel.setText("Descripción:");
        jPanel2.add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 158, -1, -1));

        streetLabel.setText("Calle:");
        jPanel2.add(streetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 207, -1, -1));

        cityLabel.setText("Ciudad:");
        jPanel2.add(cityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 247, -1, -1));
        jPanel2.add(cityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 244, 200, -1));

        deleteBuildingButton.setBackground(new java.awt.Color(255, 153, 153));
        deleteBuildingButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBuildingButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteBuildingButton.setText("Eliminar inmueble");
        deleteBuildingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBuildingButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deleteBuildingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 741, -1, -1));

        cpLabel.setText("C. Postal:");
        jPanel2.add(cpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 328, -1, -1));

        numberLabel.setText("Número:");
        jPanel2.add(numberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 288, -1, -1));
        jPanel2.add(numberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 284, 200, -1));
        jPanel2.add(cpTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 324, 200, -1));

        priceLabel.setText("P.Noche:");
        jPanel2.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 368, -1, -1));
        jPanel2.add(priceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 364, 200, -1));

        guestLabel.setText("Huéspedes:");
        jPanel2.add(guestLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 408, -1, -1));
        jPanel2.add(guestTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 404, 200, -1));

        roomLabel.setText("Habitaciones:");
        jPanel2.add(roomLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 448, -1, -1));
        jPanel2.add(roomTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 444, 200, -1));

        bedLabel.setText("Camas:");
        jPanel2.add(bedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 488, -1, -1));

        bathLabel.setText("Baños:");
        jPanel2.add(bathLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 528, -1, -1));
        jPanel2.add(bedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 484, 200, -1));
        jPanel2.add(bathTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 524, 200, -1));

        jScrollPane3.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(64, 22));

        titleTextPanel.setMinimumSize(new java.awt.Dimension(64, 22));
        titleTextPanel.setPreferredSize(new java.awt.Dimension(64, 22));
        jScrollPane3.setViewportView(titleTextPanel);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 104, 200, 32));
        jPanel2.add(streetTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 204, 200, -1));

        jScrollPane4.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(64, 22));

        serviceTextField.setMinimumSize(new java.awt.Dimension(64, 22));
        serviceTextField.setPreferredSize(new java.awt.Dimension(64, 22));
        jScrollPane4.setViewportView(serviceTextField);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 564, 200, 32));

        editBuildingButton.setBackground(new java.awt.Color(255, 90, 95));
        editBuildingButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBuildingButton.setForeground(new java.awt.Color(255, 255, 255));
        editBuildingButton.setText("Editar inmueble");
        editBuildingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBuildingButtonActionPerformed(evt);
            }
        });
        jPanel2.add(editBuildingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 696, 139, -1));

        serviceLabel.setText("Servicios:");
        jPanel2.add(serviceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 568, -1, -1));

        jScrollPane5.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(64, 22));

        descriptionTextPanel.setMinimumSize(new java.awt.Dimension(64, 22));
        descriptionTextPanel.setPreferredSize(new java.awt.Dimension(64, 22));
        jScrollPane5.setViewportView(descriptionTextPanel);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 154, 200, 32));

        markLabel.setText("Calificación:");
        jPanel2.add(markLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 54, -1, -1));

        jScrollPane6.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(64, 22));

        markTextField.setMinimumSize(new java.awt.Dimension(64, 22));
        markTextField.setPreferredSize(new java.awt.Dimension(64, 22));
        jScrollPane6.setViewportView(markTextField);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 54, 200, 32));

        checkReservesButton.setBackground(new java.awt.Color(255, 90, 95));
        checkReservesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkReservesButton.setForeground(new java.awt.Color(255, 255, 255));
        checkReservesButton.setText("Ver reservas");
        checkReservesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkReservesButtonActionPerformed(evt);
            }
        });
        jPanel2.add(checkReservesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 613, 133, -1));

        editfoto1.setBackground(new java.awt.Color(255, 90, 95));
        editfoto1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editfoto1.setForeground(new java.awt.Color(255, 255, 255));
        editfoto1.setText("Cambiar foto");
        editfoto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editfoto1ActionPerformed(evt);
            }
        });
        jPanel2.add(editfoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 657, 138, -1));

        previousButton.setBackground(new java.awt.Color(255, 153, 153));
        previousButton.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        previousButton.setForeground(new java.awt.Color(255, 255, 255));
        previousButton.setText("Anterior");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setBackground(new java.awt.Color(255, 153, 153));
        nextButton.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Siguiente");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        errorNextLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        errorNextLabel.setForeground(new java.awt.Color(255, 102, 102));
        errorNextLabel.setText("No hay un inmueble posterior");

        errorPreviousLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        errorPreviousLabel.setForeground(new java.awt.Color(255, 102, 102));
        errorPreviousLabel.setText("No hay un inmueble anterior");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(previousButton)
                        .addGap(463, 463, 463)
                        .addComponent(nextButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(561, 561, 561)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorPreviousLabel)
                            .addComponent(errorNextLabel))))
                .addGap(481, 481, 481))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previousButton)
                    .addComponent(nextButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorNextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorPreviousLabel)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraarriba1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(barraarriba1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void logoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        Aplicacion.cargaPantallaPrincipal();
    }//GEN-LAST:event_returnButtonActionPerformed

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
                limpiezaTextos();
            }
        }

    }//GEN-LAST:event_deleteBuildingButtonActionPerformed

    private void editBuildingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBuildingButtonActionPerformed
        // ActionListener para el botón
        //Verificar el texto actual del botón
        if (editBuildingButton.getText().equals("Editar inmueble")) {
            // Si el botón está en modo "Editar datos"
            // Establecer los campos de texto como editables
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
            String types = typeLabel.getText();
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

            //TODO: este numeroo tb me sobra######################################################################################
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

            if (!types.equals("Casa") && !types.equals("Apartamento")) {
                JOptionPane.showMessageDialog(this, "El types solo puede ser 'Casa' o 'Apartamento'.", "types inválido", JOptionPane.WARNING_MESSAGE);
                valido = false;
            }

            if (valido) {
                objInm.setTitulo(titulo);
                objInm.settypes(types);
                objInm.setDescripcion(descripcion);
                objInm.getDireccion().setCalle(calle);
                objInm.getDireccion().setCiudad(ciudad);
                objInm.getDireccion().setNumero(numero);
                objInm.getDireccion().setCp(cp);
                objInm.setPrecioNoche(precio);
                objInm.getDatosInmueble().setMaxHuespedes(huespedes);
                objInm.getDatosInmueble().setHabitaciones(habitaciones);
                objInm.getDatosInmueble().setCamas(camas);
                objInm.getDatosInmueble().setBaños(baños);
                objInm.setServicios(servicios);

                editBuildingButton.setText("Editar inmueble");

                System.out.println(objInm.toString());
            }
        }
    }//GEN-LAST:event_editBuildingButtonActionPerformed

    private void checkReservesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkReservesButtonActionPerformed
        // Establecer el inmueble actual antes de cambiar a la pantalla HostCheckReserves
        setInmuebleActual(objInm);

        System.out.println("Inmueble actual:" + objInm.toString());

        Aplicacion.cargaComprobarReservaAnfitrion();
    }//GEN-LAST:event_checkReservesButtonActionPerformed

    private void editfoto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editfoto1ActionPerformed
        File f = abrirImagen();
        if (f != null) {
            foto = guardadoImagen(f);
            objInm.setfoto(foto);

        } else {
            System.out.println("no existe la ruta");
        }
    }//GEN-LAST:event_editfoto1ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraarriba1;
    private javax.swing.JLabel bathLabel;
    private javax.swing.JTextField bathTextField;
    private javax.swing.JLabel bedLabel;
    private javax.swing.JTextField bedTextField;
    private javax.swing.JButton checkReservesButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel cpLabel;
    private javax.swing.JTextField cpTextField;
    private javax.swing.JButton deleteBuildingButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextPane descriptionTextPanel;
    private javax.swing.JButton editBuildingButton;
    private javax.swing.JButton editfoto1;
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
    private javax.swing.JButton logoButton;
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
