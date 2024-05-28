package Programa; // Define el paquete al que pertenece la clase

import java.io.Serializable; // Importa la interfaz Serializable para permitir la serialización
import java.time.LocalDate;  // Importa la clase LocalDate para manejar fechas

/**
 * Clase Credito que representa una tarjeta de crédito
 */
public class Credito implements Serializable { // Implementa Serializable para permitir la serialización

    // Atributos privados de la clase
    private String titular;
    private String numeroTarjeta;
    private LocalDate fechaCaducidad;
    private String cvv;
    private int dia;
    private int mes;
    private int anno;
    private double saldo;

    // Constructor que inicializa los atributos
    public Credito(String titular, String numeroTarjeta, int dia, int mes, int anno, LocalDate fechaCaducidad, String cvv, double saldo) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.saldo = saldo;
        this.cvv = cvv;
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Getters y Setters para acceder y modificar los atributos
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    // Método sobrecargado para establecer la fecha de caducidad usando día, mes y año
    public void setFechaCaducidad(int dia, int mes, int anno) {
        this.fechaCaducidad = LocalDate.of(anno, mes, dia);
    }

    // Método para incrementar el saldo
    public void incrementarSaldo(double cantidad) {
        this.saldo += cantidad;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    // Método toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "Tarjeta {número de la tarjeta:" + numeroTarjeta + ", fecha de caducidad:" + fechaCaducidad + ", cvv:" + cvv + ", saldo:" + saldo + '}';
    }
}
