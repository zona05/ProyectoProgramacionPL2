package Programa; // Define el paquete al que pertenece la clase

import java.time.LocalDate; // Importa la clase LocalDate para manejar fechas

/**
 * La clase Host representa a un cliente que actúa como anfitrión dentro de la
 * plataforma JavaBNB. Un anfitrión puede registrar inmuebles y recibir una calificación
 * que le permite convertirse en super anfitrión.
 */
public class Host extends Cliente {

    // Atributos de la clase Host
    private LocalDate fechaRegistro; // Fecha de registro del anfitrión
    private boolean superAnfitrion; // Indica si el anfitrión es un super anfitrión

    /**
     * Constructor de la clase Host.
     * 
     * @param dni      el DNI del anfitrión
     * @param nombre   el nombre del anfitrión
     * @param correo   el correo electrónico del anfitrión
     * @param contrasena    la contraseña de acceso del anfitrión
     * @param telefono el número de teléfono del anfitrión
     */
    public Host(String dni, String nombre, String correo, String contrasena, String telefono) {
        super(dni, nombre, correo, contrasena, telefono); // Llama al constructor de la clase base (Cliente)
        this.fechaRegistro = LocalDate.now(); // Establece la fecha de registro como la fecha actual
        this.superAnfitrion = false; // Inicializa el estado de superAnfitrión como falso
    }

    /**
     * Obtiene el valor de superAnfitrion.
     *
     * @return el valor de superAnfitrion
     */
    public boolean isSuperAnfitrion() {
        return superAnfitrion; // Devuelve el estado de superAnfitrión
    }

    /**
     * Establece el valor de superAnfitrion en función de la calificación promedio
     * de los inmuebles registrados por el anfitrión.
     */
    public void setSuperAnfitrion() {
        int calificacion = 0; // Inicializa la calificación total como cero
        int cantidad = 0; // Inicializa la cantidad de inmuebles como cero
        for (Inmueble i : MainBNB.getInmuebles()) { // Itera sobre todos los inmuebles en la plataforma
            if (i.getAnfitrion().getDni().equals(this.getDni())) { // Comprueba si el anfitrión es propietario del inmueble
                calificacion += i.getCalificacion(); // Suma la calificación del inmueble a la calificación total
                cantidad++; // Incrementa la cantidad de inmuebles registrados por el anfitrión
            }
        }
        int notamedia = cantidad > 0 ? calificacion / cantidad : 0; // Calcula la calificación promedio
        this.superAnfitrion = notamedia >= 4; // Establece el estado de superAnfitrión en función de la calificación promedio
    }

    /**
     * Añade un inmueble a la plataforma JavaBNB y guarda los datos.
     * 
     * @param inmueble el inmueble a añadir
     */
    public void agregarinmueble(Inmueble inmueble) {
        MainBNB.agregarinmueble(inmueble); // Agrega el inmueble a la lista de inmuebles en la plataforma
        MainBNB.guardarDatos(); // Guarda los datos actualizados de la plataforma
    }

    /**
     * Obtiene el valor de fechaRegistro.
     *
     * @return el valor de fechaRegistro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro; // Devuelve la fecha de registro del anfitrión
    }

    /**
     * Establece el valor de fechaRegistro.
     *
     * @param fechaRegistro el nuevo valor de fechaRegistro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro; // Establece la fecha de registro del anfitrión
    }

    /**
     * Devuelve una representación en cadena de la información del anfitrión.
     *
     * @return una cadena que representa al anfitrión
     */
    @Override
    public String toString() {
        return super.toString() + ", fecha de registro: " + fechaRegistro + ", Super anfitrión: " + superAnfitrion;
    }
}
