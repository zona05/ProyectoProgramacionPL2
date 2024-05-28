package Programa;

import Visual.Aplicacion;

/**
 * La clase Sesion maneja la gestión de la sesión del usuario en la aplicación JavaBNB.
 * Permite iniciar y cerrar sesión, update información del usuario y registrar nuevos clientes.
 */
public class Inicio {

    public static Cliente user;
    public static boolean esAnfitrion;

    /**
     * Inicia una nueva sesión con el cliente proporcionado.
     *
     * @param cliente el cliente que inicia la sesión
     */
    public static void nuevaSesion(Cliente cliente) {
        if (cliente != null) {
            user = cliente;
            esAnfitrion = user instanceof Host;
        } else {
            user = null;
            esAnfitrion = false;
        }
    }

    /**
     * Devuelve el cliente actual de la sesión.
     *
     * @return el cliente actual
     */
    public static Cliente devolverCliente() {
        return user;
    }

    /**
     * Actualiza el nombre del usuario en la sesión actual.
     *
     * @param data el nuevo nombre
     */
    public static void updatenombre(String data) {
        if (!Validate.validarNombre(data)) {
            return;
        }
        for (Cliente cliente : MainBNB.getClientes()) {
            if (cliente.getDni().equals(user.getDni())) {
                cliente.setNombre(data);
                return;
            }
        }
    }

    /**
     * Inicia sesión con el correo y la contrasena proporcionados.
     *
     * @param correo el correo del cliente
     * @param contrasena la contrasena del cliente
     * @return un entero que indica el types de usuario (1: administrador, 2: cliente, 3: anfitrión, 0: no encontrado)
     */
    public static int iniciarSesion(String correo, String contrasena) {
        boolean isHost = false;
        if (correo.equals("admin@java.bnb") && contrasena.equals("admin")) {
            System.out.println("La sesion ha sido iniciada como administrador");
            return 1;
        }
        for (Cliente cliente : MainBNB.getClientes()) {
            System.out.println("Revision cliente: " + cliente);
            isHost = (cliente instanceof Host);

            if (cliente.getCorreo().equals(correo.toLowerCase()) && cliente.getcontrasena().equals(contrasena)) {
                Aplicacion.sesion.nuevaSesion(cliente);
                System.out.println("La sesion ha sido iniciada por " + Aplicacion.sesion.user);
                return isHost ? 3 : 2;
            }
        }
        return 0;
    }

    /**
     * Cierra la sesión actual.
     */
    public static void cerrarSesion() {
        user = null;
        esAnfitrion = false;
    }

    /**
     * Registra un nuevo cliente en la aplicación.
     *
     * @param cliente el nuevo cliente a registrar
     */
    public static void registrarCliente(Cliente cliente) {
        if (Validate.comprobarExistenciaCliente(cliente.getCorreo(), cliente.getDni(), cliente.getTelefono())) {
            return;
        }
        MainBNB.getClientes().add(cliente);
        Aplicacion.sesion.nuevaSesion(cliente);
        System.out.println(cliente.toString());
    }

    /**
     * Hace VIP al usuario actual si el código promocional es válido.
     *
     * @param promocode el código promocional
     * @return true si el código es válido y el usuario se convierte en VIP, false en caso contrario
     */
    public static boolean hacerVipSiPromocodeValido(String promocode) {
        if (user instanceof Particular && "JAVABNB2024".equals(promocode)) {
            ((Particular) user).setVip(true);
            return true;
        }
        return false;
    }

    /**
     * Verifica si el usuario actual es VIP.
     *
     * @return true si el usuario es VIP, false en caso contrario
     */
    public static boolean esUsuarioVip() {
        if (user instanceof Particular) {
            return ((Particular) user).isVip();
        }
        return false;
    }
}
