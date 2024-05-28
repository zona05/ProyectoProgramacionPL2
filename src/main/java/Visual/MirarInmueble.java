/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package Visual;

import Programa.Host;
import Programa.Inmueble;
import Programa.Particular;
import Programa.Reserva;
import Programa.Inicio;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MirarInmueble extends javax.swing.JPanel {

    Inmueble i;

    /**
     * Crea un nuevo panel de visualización de inmueble.
     */
    public MirarInmueble() {
        initComponents();
        errorLabel1.setVisible(false); // Oculta inicialmente el mensaje de error
    }
    /**
     * Actualiza la información del inmueble en la interfaz.
     */
    public void update() {
        // Oculta o muestra elementos en función de si el usuario es anfitrión
        if (Inicio.esAnfitrion) {
            panelreservas.setVisible(false);
            gradeButton.setVisible(false);
        } else {
            panelreservas.setVisible(true);
            gradeButton.setVisible(true);
        }
        // Actualiza los campos de texto y etiquetas con los datos del inmueble
        titleLabel.setText(i.getTitulo());
        typeLabel.setText(i.gettypes());
        descriptionTextArea.setText(i.getDescripcion());
        priceLabel.setText(Double.toString(i.getPrecioNoche()) + "€ por noche");

        hostLabel.setText("Anfitrion: " + i.getAnfitrion().getNombre());
        if (i.getAnfitrion().isSuperAnfitrion()) {
            superhostLabel.setVisible(true);
        } else {
            superhostLabel.setVisible(false);
        }
        
        guestsLabel.setText(Integer.toString(i.getDatosInmueble().getMaxHuespedes()));
        roomsLabel.setText(Integer.toString(i.getDatosInmueble().getHabitaciones()));
        bathsLabel.setText(Integer.toString(i.getDatosInmueble().getBaños()));
        bedsLabel.setText(Integer.toString(i.getDatosInmueble().getCamas()));

        directionTextArea.setText(i.getDireccion().toString());
        servicesTextArea.setText("Este inmueble ofrece los siguientes servicios: " + i.getServicios());
        markLabel.setText("Valoración: " + Double.toString(i.getCalificacion()));
        numbermarksLabel.setText("Ha sido valorado por" + Integer.toString(i.getValoraciones()) + " clientes");
        
        // Actualiza la imagen del inmueble y las estrellas de calificación
        fotoboton.setIcon(resizeIMG(i.getfoto()));
        estrella1.setIcon(i.getCalificacion() >= 1 ? imagenIcon("./src/main/resources/images/estrella50roja.PNG") : (imagenIcon("./src/main/resources/images/estrella50.PNG")));
        estrella2.setIcon(i.getCalificacion() >= 2 ? imagenIcon("./src/main/resources/images/estrella50roja.PNG") : (imagenIcon("./src/main/resources/images/estrella50.PNG")));
        estrella3.setIcon(i.getCalificacion() >= 3 ? imagenIcon("./src/main/resources/images/estrella50roja.PNG") : (imagenIcon("./src/main/resources/images/estrella50.PNG")));
        estrella4.setIcon(i.getCalificacion() >= 4 ? imagenIcon("./src/main/resources/images/estrella50roja.PNG") : (imagenIcon("./src/main/resources/images/estrella50.PNG")));
        estrella5.setIcon(i.getCalificacion() >= 5 ? imagenIcon("./src/main/resources/images/estrella50roja.PNG") : (imagenIcon("./src/main/resources/images/estrella50.PNG")));

    }
    /**
     * Establece el inmueble a visualizar y actualiza la vista.
     *
     * @param inmueble El inmueble a mostrar.
     */
    public void setInmueble(Inmueble inmueble) {
        this.i = inmueble;
        this.update(); // Llamar al método update() para update la vista con el nuevo inmueble

    }
    /**
     * Crea un ImageIcon a partir de una ruta de imagen.
     *
     * @param img La ruta de la imagen.
     * @return El ImageIcon creado.
     */
    public ImageIcon imagenIcon(String img) {
        try {
            Image image = ImageIO.read(new File(img));
            ImageIcon icon = new ImageIcon(image);
            return icon;
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
            return null;
        }
    }
    /**
     * Redimensiona una imagen a un tamaño fijo.
     *
     * @param img La ruta de la imagen.
     * @return El ImageIcon redimensionado.
     */
    public ImageIcon resizeIMG(String img) {
        try {
            File imagePath = new File(img);
            BufferedImage originalImage = ImageIO.read(imagePath);
            int width = 560;//Altofijo
            int height = 331;//Bajofijo
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(resizedImage);
            return imageIcon;
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
            return null;
        }
    }
    /**
     * Convierte un objeto Date a LocalDate.
     *
     * @param dateObject El objeto Date a convertir.
     * @return El LocalDate resultante.
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
        fotoboton = new javax.swing.JButton();
        starsPanel = new javax.swing.JPanel();
        estrella1 = new javax.swing.JButton();
        estrella2 = new javax.swing.JButton();
        estrella3 = new javax.swing.JButton();
        estrella4 = new javax.swing.JButton();
        estrella5 = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        descriptionTextArea = new javax.swing.JTextArea();
        barraarriba = new javax.swing.JPanel();
        returnButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        servicesTextArea = new javax.swing.JTextArea();
        directionTextArea = new javax.swing.JTextArea();
        guestLabel = new javax.swing.JLabel();
        bathLabel = new javax.swing.JLabel();
        roomLabel = new javax.swing.JLabel();
        bedLabel = new javax.swing.JLabel();
        guestsLabel = new javax.swing.JLabel();
        roomsLabel = new javax.swing.JLabel();
        bathsLabel = new javax.swing.JLabel();
        bedsLabel = new javax.swing.JLabel();
        panelreservas = new javax.swing.JPanel();
        reservenowLabel = new javax.swing.JLabel();
        reserveButton = new javax.swing.JButton();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        endDateFormattedField = new javax.swing.JFormattedTextField();
        startDateFormattedField = new javax.swing.JFormattedTextField();
        daymonthyearLabel1 = new javax.swing.JLabel();
        markLabel = new javax.swing.JLabel();
        gradeButton = new javax.swing.JButton();
        numbermarksLabel = new javax.swing.JLabel();
        hostLabel = new javax.swing.JLabel();
        superhostLabel = new javax.swing.JLabel();
        errorLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 236, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fotoboton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/casa1.jpg"))); // NOI18N
        jPanel1.add(fotoboton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 560, 330));

        starsPanel.setBackground(new java.awt.Color(255, 153, 102));
        starsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        estrella1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estrella50roja.png"))); // NOI18N
        estrella1.setToolTipText("");
        estrella1.setBorderPainted(false);
        estrella1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estrella1ActionPerformed(evt);
            }
        });

        estrella2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estrella50roja.png"))); // NOI18N
        estrella2.setToolTipText("");
        estrella2.setBorderPainted(false);

        estrella3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estrella50.png"))); // NOI18N
        estrella3.setToolTipText("");
        estrella3.setBorderPainted(false);

        estrella4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estrella50.png"))); // NOI18N
        estrella4.setToolTipText("");
        estrella4.setBorderPainted(false);
        estrella4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estrella4ActionPerformed(evt);
            }
        });

        estrella5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estrella50.png"))); // NOI18N
        estrella5.setToolTipText("");
        estrella5.setBorderPainted(false);

        javax.swing.GroupLayout starsPanelLayout = new javax.swing.GroupLayout(starsPanel);
        starsPanel.setLayout(starsPanelLayout);
        starsPanelLayout.setHorizontalGroup(
            starsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(starsPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(estrella1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(estrella2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(estrella3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(estrella4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(estrella5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        starsPanelLayout.setVerticalGroup(
            starsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(starsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(starsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estrella1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(estrella2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estrella3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estrella4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estrella5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(starsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 390, 50));

        titleLabel.setFont(new java.awt.Font("Noto Sans SemiCondensed", 1, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 153, 102));
        titleLabel.setText("Titulo Inmueble");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        priceLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 18)); // NOI18N
        priceLabel.setText("precio €/noche");
        jPanel1.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(new java.awt.Color(255, 250, 248));
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        descriptionTextArea.setRows(5);
        descriptionTextArea.setText("Descripción del inmueble");
        descriptionTextArea.setAutoscrolls(false);
        descriptionTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        descriptionTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(descriptionTextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 710, 50));

        barraarriba.setBackground(new java.awt.Color(255, 153, 102));
        barraarriba.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraarriba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnButton.setBackground(new java.awt.Color(255, 102, 102));
        returnButton.setText("Volver");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        barraarriba.add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 110, 50));

        logoLabel.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        logoLabel.setText("JavaBNB");
        barraarriba.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel1.add(barraarriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 70));

        typeLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 18)); // NOI18N
        typeLabel.setText("Tipo de Inmueble");
        jPanel1.add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        servicesTextArea.setEditable(false);
        servicesTextArea.setBackground(new java.awt.Color(255, 250, 248));
        servicesTextArea.setColumns(20);
        servicesTextArea.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        servicesTextArea.setRows(5);
        servicesTextArea.setText("Este inmueble ofrece los siguientes servicios: XXX");
        servicesTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(servicesTextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 710, 50));

        directionTextArea.setEditable(false);
        directionTextArea.setBackground(new java.awt.Color(255, 250, 248));
        directionTextArea.setColumns(20);
        directionTextArea.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        directionTextArea.setRows(5);
        directionTextArea.setText("Calle del inmueble");
        directionTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(directionTextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 710, 50));

        guestLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        guestLabel.setText("Número de húespedes:");
        jPanel1.add(guestLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, -1, -1));

        bathLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        bathLabel.setText("Número de baños:");
        jPanel1.add(bathLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 590, -1, -1));

        roomLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        roomLabel.setText("Número de habitaciones:");
        jPanel1.add(roomLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 640, -1, -1));

        bedLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 14)); // NOI18N
        bedLabel.setText("Número de camas:");
        jPanel1.add(bedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 690, -1, -1));

        guestsLabel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        guestsLabel.setText("1");
        jPanel1.add(guestsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 540, 29, 20));

        roomsLabel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        roomsLabel.setText("1");
        jPanel1.add(roomsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 640, 25, 20));

        bathsLabel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        bathsLabel.setText("1");
        jPanel1.add(bathsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 590, 29, 20));

        bedsLabel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        bedsLabel.setText("1");
        jPanel1.add(bedsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 690, 35, 20));

        panelreservas.setBackground(new java.awt.Color(255, 250, 248));
        panelreservas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        reservenowLabel.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        reservenowLabel.setForeground(new java.awt.Color(255, 153, 102));
        reservenowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reservenowLabel.setText("Reserva ahora");

        reserveButton.setBackground(new java.awt.Color(255, 153, 102));
        reserveButton.setText("Reservar");
        reserveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveButtonActionPerformed(evt);
            }
        });

        startDateLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        startDateLabel.setForeground(new java.awt.Color(255, 102, 102));
        startDateLabel.setText("Fecha de entrada:");

        endDateLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        endDateLabel.setForeground(new java.awt.Color(255, 102, 102));
        endDateLabel.setText("Fecha de salida:");

        endDateFormattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        startDateFormattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        daymonthyearLabel1.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        daymonthyearLabel1.setText("dd/MM/yyyy");

        javax.swing.GroupLayout panelreservasLayout = new javax.swing.GroupLayout(panelreservas);
        panelreservas.setLayout(panelreservasLayout);
        panelreservasLayout.setHorizontalGroup(
            panelreservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelreservasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelreservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelreservasLayout.createSequentialGroup()
                        .addComponent(reservenowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelreservasLayout.createSequentialGroup()
                        .addComponent(daymonthyearLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
            .addGroup(panelreservasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelreservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reserveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelreservasLayout.createSequentialGroup()
                        .addGroup(panelreservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDateFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDateLabel))
                        .addGap(66, 66, 66)
                        .addGroup(panelreservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(endDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endDateFormattedField))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelreservasLayout.setVerticalGroup(
            panelreservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelreservasLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(reservenowLabel)
                .addGap(18, 18, 18)
                .addGroup(panelreservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateLabel)
                    .addComponent(endDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelreservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(daymonthyearLabel1)
                .addGap(30, 30, 30)
                .addComponent(reserveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel1.add(panelreservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 330, -1));

        markLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 24)); // NOI18N
        markLabel.setText("Valoración: 3");
        jPanel1.add(markLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, -1, -1));

        gradeButton.setBackground(new java.awt.Color(255, 153, 102));
        gradeButton.setFont(new java.awt.Font("Noto Sans SemiBold", 1, 18)); // NOI18N
        gradeButton.setText("Valorar");
        gradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(gradeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, 120, 40));

        numbermarksLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        numbermarksLabel.setText("Ha sido valorado por x clientes");
        jPanel1.add(numbermarksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, -1, -1));

        hostLabel.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 18)); // NOI18N
        hostLabel.setText("Anfitrion:");
        jPanel1.add(hostLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, -1, -1));

        superhostLabel.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        superhostLabel.setText("Superanfitrión");
        jPanel1.add(superhostLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, -1, 50));

        errorLabel1.setFont(new java.awt.Font("Noto Sans SemiBold", 0, 12)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(255, 102, 102));
        errorLabel1.setText("No está disponible para las fechas establecidas");
        jPanel1.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void estrella4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estrella4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estrella4ActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        if (Inicio.user != null) {
            Aplicacion.cargaPantallaPrincipal();
        }
    }//GEN-LAST:event_returnButtonActionPerformed

    private void reserveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveButtonActionPerformed
        errorLabel1.setVisible(false); // Oculta inicialmente el mensaje de error

        // Obtiene las fechas de llegada y salida de los campos de entrada
        LocalDate llegada = convertToLocalDate(startDateFormattedField.getValue());
        LocalDate salida = convertToLocalDate(endDateFormattedField.getValue());

        // Crea una reserva con los datos proporcionados
        Reserva reserva = new Reserva((Particular) Inicio.user, i, llegada, salida);

        // Comprueba si el usuario tiene suficiente saldo para completar la reserva
        if (((Particular) Inicio.user).getSaldo() <= reserva.calcularPrecioTotal()) {
            JOptionPane.showMessageDialog(this, "Su dinero es insuficiente para completar esta reserva", "Dinero insuficiente", JOptionPane.WARNING_MESSAGE);
        }

        // Comprueba si el inmueble está disponible y si el usuario tiene suficiente saldo
        if (i.estaDisponible(llegada, salida) && ((Particular) Inicio.user).getSaldo() > reserva.calcularPrecioTotal()) {

            // Muestra un mensaje de confirmación para la reserva
            String textoconfirmacion = "¿Desea confirmar la reserva de este inmueble del " + llegada + " al " + salida + " por un coste de " + reserva.calcularPrecioTotal() + " euros?";
            int n = JOptionPane.showConfirmDialog(this, textoconfirmacion, "ConfirmDialog", JOptionPane.YES_NO_CANCEL_OPTION);

            // Realiza la reserva si el usuario confirma
            if (n == JOptionPane.YES_OPTION) {
                System.out.println("SI. Haciendo reserva ");
                ArrayList<Reserva> reservass = i.getReservas();
                i.agregarReserva(reserva); // Agrega la reserva al inmueble
                ((Particular) Inicio.user).disminuirSaldo(reserva.calcularPrecioTotal()); // Descuenta el precio de la reserva del saldo del usuario
                for (Reserva reservaa : reservass) {
                    System.out.println("Reserva :" + reservaa.toString());
                }
            } else if (n == JOptionPane.NO_OPTION) {
                System.out.println("NO");
            } else if (n == JOptionPane.CANCEL_OPTION) {
                System.out.println("CANCEL");
            } else {
                System.out.println("Ninguna Opción");
            }
        } else {
            errorLabel1.setVisible(true); // Muestra el mensaje de error si la reserva no se puede realizar
            System.out.println("ERROR");
        }


    }//GEN-LAST:event_reserveButtonActionPerformed

    private void gradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeButtonActionPerformed
        double nota = 0; // Variable para almacenar la nota de la valoración
        boolean reservaHecha = false; // Indica si el usuario ha realizado una reserva en este inmueble

        // Obtener todas las reservas asociadas al inmueble
        ArrayList<Reserva> reservas = i.getReservas();

        // Iterar sobre todas las reservas para verificar si el usuario ha realizado una reserva en este inmueble
        for (Reserva reserva : reservas) {
            // Verificar si el cliente de la reserva es el mismo que el usuario actual de la sesión
            if (reserva.getParticular().getDni().equals((((Particular) Inicio.user).getDni()))) {
                // El usuario ha realizado una reserva en este inmueble
                reservaHecha = true;
                break;
            }
        }

        // Verificar si el usuario ha realizado alguna reserva en este inmueble
        if (reservaHecha) {
            try {
                // Solicitar al usuario que introduzca una valoración entre 0 y 5
                do {
                    String notaIntroducida = JOptionPane.showInputDialog(this, "Ingrese una valoración (entre 0 y 5):");
                    nota = Double.parseDouble(notaIntroducida);
                } while (nota < 0 || nota > 5);

                // Asignar la calificación al inmueble
                i.setCalificacion(nota);

                // Obtener el anfitrión del inmueble y establecerlo como superanfitrión
                Host anfitrion = i.getAnfitrion();
                anfitrion.setSuperAnfitrion();

                // update la visualización del inmueble con la nueva calificación
                update();

                System.out.println("Valoración=" + nota);
                System.out.println("Valoración del inmueble= " + i.getCalificacion());
            } catch (NumberFormatException nfe) {
                System.out.println("Error del formato: " + nfe.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            // Mostrar un mensaje indicando que solo los usuarios que hayan realizado una reserva pueden calificar el inmueble
            JOptionPane.showMessageDialog(this, "Únicamente los usuarios que hayan realizado una reserva en este inmueble tienen permitido calificarlo.");
        }

    }//GEN-LAST:event_gradeButtonActionPerformed

    private void estrella1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estrella1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estrella1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraarriba;
    private javax.swing.JLabel bathLabel;
    private javax.swing.JLabel bathsLabel;
    private javax.swing.JLabel bedLabel;
    private javax.swing.JLabel bedsLabel;
    private javax.swing.JLabel daymonthyearLabel1;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JTextArea directionTextArea;
    private javax.swing.JFormattedTextField endDateFormattedField;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JButton estrella1;
    private javax.swing.JButton estrella2;
    private javax.swing.JButton estrella3;
    private javax.swing.JButton estrella4;
    private javax.swing.JButton estrella5;
    private javax.swing.JButton fotoboton;
    private javax.swing.JButton gradeButton;
    private javax.swing.JLabel guestLabel;
    private javax.swing.JLabel guestsLabel;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel markLabel;
    private javax.swing.JLabel numbermarksLabel;
    private javax.swing.JPanel panelreservas;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton reserveButton;
    private javax.swing.JLabel reservenowLabel;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JLabel roomsLabel;
    private javax.swing.JTextArea servicesTextArea;
    private javax.swing.JPanel starsPanel;
    private javax.swing.JFormattedTextField startDateFormattedField;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JLabel superhostLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
