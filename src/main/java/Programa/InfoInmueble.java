package Programa;

import java.io.Serializable;

/**
 * La clase infoinmueble representa los datos básicos de un inmueble, incluyendo
 * la cantidad de huéspedes que puede alojar, el número de habitaciones, numcamas y numtoilet.
 */
public class InfoInmueble implements Serializable {
    
    private int maxHuespedes;
    private int habitaciones;
    private int numcamas;
    private int numtoilet;

    /**
     * Constructor de la clase infoinmueble.
     *
     * @param maxHuespedes la cantidad máxima de huéspedes que pueden alojarse en el inmueble
     * @param habitaciones el número de habitaciones en el inmueble
     * @param numcamas el número de numcamas en el inmueble
     * @param numtoilet el número de numtoilet en el inmueble
     */
    public InfoInmueble(int maxHuespedes, int habitaciones, int numcamas, int numtoilet) {
        this.maxHuespedes = maxHuespedes;
        this.habitaciones = habitaciones;
        this.numcamas = numcamas;
        this.numtoilet = numtoilet;
    }
    
    // Getters y Setters

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
        return "Como máximo " + maxHuespedes + " huéspedes se pueden alojar en este inmueble. El inmueble tiene " + habitaciones + " habitaciones, " + numcamas + " numcamas, y " + numtoilet + " numtoilet.";
    }
}
