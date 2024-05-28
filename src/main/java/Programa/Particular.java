package Programa;

import java.io.Serializable;

/**
 * La clase Particular representa un cliente particular que utiliza la plataforma JavaBNB.
 * Hereda de la clase Cliente e incluye detalles adicionales como una tarjeta de crédito y el estado VIP.
 */
public class Particular extends Cliente implements Serializable {

    private Credito tarjetatarjetaCredito;
    private boolean vip;

    /**
     * Constructor de la clase Particular.
     *
     * @param tarjetatarjetaCredito la tarjeta de crédito del cliente
     * @param vip            indica si el cliente es VIP
     * @param dni            el DNI del cliente
     * @param nombre         el nombre del cliente
     * @param correo         el correo electrónico del cliente
     * @param contrasena          la contrasena del cliente
     * @param telefono       el teléfono del cliente
     */
    public Particular(Credito tarjetatarjetaCredito, boolean vip, String dni, String nombre, String correo, String contrasena, String telefono) {
        super(dni, nombre, correo, contrasena, telefono);
        this.tarjetatarjetaCredito = tarjetatarjetaCredito;
        this.vip = vip;
    }

    /**
     * Método para disminuir el saldo de la tarjeta de crédito.
     * Si el cliente es VIP, se aplica un descuento del 10%.
     *
     * @param cantidad la cantidad a disminuir del saldo
     * @return un mensaje con el saldo actual
     */
    public String disminuirSaldo(double cantidad) {
        Double saldo = tarjetatarjetaCredito.getSaldo();
        if (vip) {
            saldo -= cantidad * 0.9;
        } else {
            saldo -= cantidad;
        }
        tarjetatarjetaCredito.setSaldo(saldo);
        return "Tu saldo actual es de  " + saldo + "€";
    }

    /**
     * Método para aumentar el saldo de la tarjeta de crédito.
     *
     * @param cantidad la cantidad a aumentar al saldo
     * @return un mensaje con el saldo actual
     */
    public String aumentarSaldo(double cantidad) {
        Double saldo = tarjetatarjetaCredito.getSaldo();
        saldo += cantidad;
        tarjetatarjetaCredito.setSaldo(saldo);
        return "Tu saldo actual es de " + saldo + "€";
    }

    /**
     * Obtiene el saldo de la tarjeta de crédito.
     *
     * @return el saldo de la tarjeta de crédito
     */
    public double getSaldo() {
        return tarjetatarjetaCredito.getSaldo();
    }

    /**
     * Establece el saldo de la tarjeta de crédito.
     *
     * @param saldo el nuevo saldo de la tarjeta de crédito
     */
    public void setSaldo(double saldo) {
        tarjetatarjetaCredito.setSaldo(saldo);
    }

    /**
     * Obtiene el estado VIP del cliente.
     *
     * @return true si el cliente es VIP, false en caso contrario
     */
    public boolean isVip() {
        return vip;
    }

    /**
     * Establece el estado VIP del cliente.
     *
     * @param vip el nuevo estado VIP del cliente
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     * Obtiene la tarjeta de crédito del cliente.
     *
     * @return la tarjeta de crédito del cliente
     */
    public Credito getTarjetatarjetaCredito() {
        return tarjetatarjetaCredito;
    }

    /**
     * Establece la tarjeta de crédito del cliente.
     *
     * @param tarjetatarjetaCredito la nueva tarjeta de crédito del cliente
     */
    public void setTarjetatarjetaCredito(Credito tarjetatarjetaCredito) {
        this.tarjetatarjetaCredito = tarjetatarjetaCredito;
    }

    /**
     * Devuelve una representación en cadena de los datos del cliente particular.
     *
     * @return una cadena que representa los datos del cliente particular
     */
    @Override
    public String toString() {
        return super.toString() + tarjetatarjetaCredito.toString() + ", vip:" + vip;
    }
}
