package Programa;

import java.time.LocalDate;

/**
 * La clase Anfitrion representa a un cliente que actúa como anfitrión dentro de la
 * plataforma JavaBNB. Un anfitrión puede registrar inmuebles y recibir una calificación
 * que le permite convertirse en super anfitrión.
 */
public class Host extends Cliente {

    private LocalDate fechaRegistro;
    private boolean superAnfitrion;

    /**
     * Constructor de la clase Anfitrion.
     * 
     * @param dni      el DNI del anfitrión
     * @param nombre   el nombre del anfitrión
     * @param correo   el correo electrónico del anfitrión
     * @param passw    la passw de acceso del anfitrión
     * @param telefono el número de teléfono del anfitrión
     */
    public Host(String dni, String nombre, String correo, String passw, String telefono) {
        super(dni, nombre, correo, passw, telefono);
        this.fechaRegistro = LocalDate.now();
        this.superAnfitrion = false;
    }

    /**
     * Obtiene el valor de superAnfitrion.
     *
     * @return el valor de superAnfitrion
     */
    public boolean isSuperAnfitrion() {
        return superAnfitrion;
    }

    /**
     * Establece el valor de superAnfitrion en función de la calificación promedio
     * de los inmuebles registrados por el anfitrión.
     */
    public void setSuperAnfitrion() {
        int calificacion = 0;
        int cantidad = 0;
        for (Inmueble i : MainBNB.getInmuebles()) {
            if (i.getAnfitrion().getDni().equals(this.getDni())) {
                calificacion += i.getCalificacion();
                cantidad++;
            }
        }
        int notamedia = cantidad > 0 ? calificacion / cantidad : 0;
        this.superAnfitrion = notamedia >= 4;
    }

    /**
     * Añade un inmueble a la plataforma JavaBNB y guarda los datos.
     * 
     * @param inmueble el inmueble a añadir
     */
    public void añadirInmueble(Inmueble inmueble) {
        MainBNB.añadirInmueble(inmueble);
        MainBNB.guardarDatos();
    }

    /**
     * Obtiene el valor de fechaRegistro.
     *
     * @return el valor de fechaRegistro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece el valor de fechaRegistro.
     *
     * @param fechaRegistro el nuevo valor de fechaRegistro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
