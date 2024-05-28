package Programa;

import java.io.Serializable;
import java.util.Objects;

public class Direccion implements Serializable {

    private String calle;
    private String numero;
    private String codigopostal;
    private String ciudad;

    /**
     * Constructor de la clase Direccion
     *
     * @param calle
     * @param numero
     * @param codigopostal
     * @param ciudad
     */
    public Direccion(String calle, String numero, String codigopostal, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.codigopostal = codigopostal;
        this.ciudad = ciudad;
    }

    //Método que iguala direcciones por su contenido, no por su dirección de memoria
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Direccion otraDireccion = (Direccion) obj;
        return Objects.equals(calle, otraDireccion.calle)
                && Objects.equals(numero, otraDireccion.numero)
                && Objects.equals(codigopostal, otraDireccion.codigopostal)
                && Objects.equals(ciudad, otraDireccion.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calle, numero, codigopostal, ciudad);
    }

    //G&S
    /**
     * Get the value of ciudad
     *
     * @return the value of ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Set the value of ciudad
     *
     * @param ciudad new value of ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Get the value of codigopostal
     *
     * @return the value of codigopostal
     */
    public String getcodigopostal() {
        return codigopostal;
    }

    /**
     * Set the value of codigopostal
     *
     * @param codigopostal new value of codigopostal
     */
    public void setcodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Set the value of numero
     *
     * @param numero new value of numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Get the value of calle
     *
     * @return the value of calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Set the value of calle
     *
     * @param calle new value of calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return "Calle " + calle + ", nº" + numero + ", " + ciudad+ ". codigopostal:" + codigopostal;
    }

}
