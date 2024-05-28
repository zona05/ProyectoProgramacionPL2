package Programa; // Define el paquete al que pertenece la clase

import java.io.Serializable; // Importa la interfaz Serializable para permitir la serialización

/**
 * La clase InfoInmueble representa los datos básicos de un inmueble, incluyendo
 * la cantidad de huéspedes que puede alojar, el número de habitaciones, camas y baños.
 */
public class InfoInmueble implements Serializable {
    
    // Atributos de la clase InfoInmueble
    private int maxHuespedes; // Cantidad máxima de huéspedes que puede alojar el inmueble
    private int habitaciones; // Número de habitaciones en el inmueble
    private int numcamas; // Número de camas en el inmueble
    private int numtoilet; // Número de baños en el inmueble

    /**
     * Constructor de la clase InfoInmueble.
     *
     * @param maxHuespedes la cantidad máxima de huéspedes que pueden alojarse en el inmueble
     * @param habitaciones el número de habitaciones en el inmueble
     * @param numcamas el número de camas en el inmueble
     * @param numtoilet el número de baños en el inmueble
     */
    public InfoInmueble(int maxHuespedes, int habitaciones, int numcamas, int numtoilet) {
        this.maxHuespedes = maxHuespedes; // Inicializa la cantidad máxima de huéspedes
        this.habitaciones = habitaciones; // Inicializa el número de habitaciones
        this.numcamas = numcamas; // Inicializa el número de camas
        this.numtoilet = numtoilet; // Inicializa el número de baños
    }
    
    // Getters y Setters para acceder y modificar los atributos privados

    /**
     * Obtiene el valor de numtoilet.
     *
     * @return el valor de numtoilet
     */
    public int getnumtoilet() {
        return numtoilet;
    }

    /**
     * Establece el valor de numtoilet.
     *
     * @param numtoilet el nuevo valor de numtoilet
     */
    public void setnumtoilet(int numtoilet) {
        this.numtoilet = numtoilet;
    }

    /**
     * Obtiene el valor de numcamas.
     *
     * @return el valor de numcamas
     */
    public int getnumcamas() {
        return numcamas;
    }

    /**
     * Establece el valor de numcamas.
     *
     * @param numcamas el nuevo valor de numcamas
     */
    public void setnumcamas(int numcamas) {
        this.numcamas = numcamas;
    }

    /**
     * Obtiene el valor de habitaciones.
     *
     * @return el valor de habitaciones
     */
    public int getHabitaciones() {
        return habitaciones;
    }

    /**
     * Establece el valor de habitaciones.
     *
     * @param habitaciones el nuevo valor de habitaciones
     */
    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    /**
     * Obtiene el valor de maxHuespedes.
     *
     * @return el valor de maxHuespedes
     */
    public int getMaxHuespedes() {
        return maxHuespedes;
    }

    /**
     * Establece el valor de maxHuespedes.
     *
     * @param maxHuespedes el nuevo valor de maxHuespedes
     */
    public void setMaxHuespedes(int maxHuespedes) {
        this.maxHuespedes = maxHuespedes;
    }

    /**
     * Devuelve una representación en cadena de los datos del inmueble.
     *
     * @return una cadena que representa los datos del inmueble
     */
    @Override
    public String toString() {
        return "Como máximo " + maxHuespedes + " huéspedes se pueden alojar en este inmueble. El inmueble tiene " + habitaciones + " habitaciones, " + numcamas + " camas, y " + numtoilet + " baños.";
    }
}
