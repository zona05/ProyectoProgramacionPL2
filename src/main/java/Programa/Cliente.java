package Programa; // Define el paquete

import java.io.Serializable; // Importa la interfaz Serializable

public class Cliente implements Serializable { // Clase Cliente que implementa Serializable

    // Atributos privados
    private String dni;
    private String nombre;
    private String correo;
    private String contrasena;
    private String telefono;

    // Constructor de la clase
    public Cliente(String dni, String nombre, String correo, String contrasena, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }

    // Métodos Getter y Setter
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "dni:" + dni + ", nombre:" + nombre + ", correo:" + correo + ", contrasena:" + contrasena + ", telefono:" + telefono;
    }
}
