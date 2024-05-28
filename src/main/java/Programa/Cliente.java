package Programa;

import java.io.Serializable;


public class Cliente implements Serializable {

    private String dni;
    private String nombre;
    private String correo;
    private String passw;
    private String telefono;
    
    public Cliente(String dni, String nombre, String correo, String passw, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.passw = passw;
        this.telefono = telefono;
    }

    //G&S
    /**
     * Get the value of telefono
     *
     * @return the value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Get the value of passw
     *
     * @return the value of passw
     */
    public String getpassw() {
        return passw;
    }

    /**
     * Set the value of passw
     *
     * @param passw new value of passw
     */
    public void setpassw(String passw) {
        this.passw = passw;
    }

    /**
     * Get the value of correo
     *
     * @return the value of correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Set the value of correo
     *
     * @param correo new value of correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of dni
     *
     * @return the value of dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Set the value of dni
     *
     * @param dni new value of dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    

    @Override
    public String toString() {
        return "dni:" + dni + ", nombre:" + nombre + ", correo:" + correo + ", passw:" + passw + ", telefono:" + telefono;
    }

}
