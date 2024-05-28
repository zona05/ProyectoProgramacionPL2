package Programa; // Define el paquete al que pertenece la clase

import java.io.Serializable; // Importa la interfaz Serializable para serialización
import java.util.Objects; // Importa la clase Objects para comparaciones

public class Direccion implements Serializable {

    // Atributos de la clase
    private String calle;
    private String numero;
    private String codigopostal;
    private String ciudad;

    /**
     * Constructor de la clase Direccion
     *
     * @param calle nombre de la calle
     * @param numero número de la calle
     * @param codigopostal código postal de la dirección
     * @param ciudad nombre de la ciudad
     */
    public Direccion(String calle, String numero, String codigopostal, String ciudad) {
        this.calle = calle; // Asigna el valor del parámetro calle al atributo calle
        this.numero = numero; // Asigna el valor del parámetro numero al atributo numero
        this.codigopostal = codigopostal; // Asigna el valor del parámetro codigopostal al atributo codigopostal
        this.ciudad = ciudad; // Asigna el valor del parámetro ciudad al atributo ciudad
    }

    // Método equals para comparar direcciones por su contenido
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // Comprueba si las referencias son iguales
            return true; // Devuelve true si son la misma instancia
        }
        if (obj == null || getClass() != obj.getClass()) { // Comprueba si el objeto es nulo o de una clase diferente
            return false; // Devuelve false si son diferentes
        }
        Direccion otraDireccion = (Direccion) obj; // Convierte el objeto en una instancia de Direccion
        // Compara los atributos de las direcciones y devuelve true si son iguales, false si son diferentes
        return Objects.equals(calle, otraDireccion.calle)
                && Objects.equals(numero, otraDireccion.numero)
                && Objects.equals(codigopostal, otraDireccion.codigopostal)
                && Objects.equals(ciudad, otraDireccion.ciudad);
    }

    // Método hashCode para generar un código hash basado en los atributos de la dirección
    @Override
    public int hashCode() {
        return Objects.hash(calle, numero, codigopostal, ciudad); // Devuelve un código hash basado en los atributos
    }

    // Getters y Setters para los atributos de la clase
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getcodigopostal() {
        return codigopostal;
    }

    public void setcodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    // Método toString para obtener una representación de la dirección como cadena de texto
    @Override
    public String toString() {
        return "Calle " + calle + ", nº" + numero + ", " + ciudad + ". Código postal:" + codigopostal;
    }

}
