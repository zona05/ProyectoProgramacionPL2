package Visual;

import Programa.*;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * Clase que maneja eventos de ventana, especialmente el cierre de la ventana.
 */
class WindowEventHandler extends WindowAdapter {

    /**
     * Método que se ejecuta cuando se cierra la ventana. Guarda los datos utilizando MainBNB.
     *
     * @param evt Evento de ventana.
     */
    @Override
    public void windowClosing(WindowEvent evt) {
        MainBNB.guardarDatos();
    }
}

/**
 * Clase principal de la aplicación.
 */
public class Aplicacion {

    // CardLayout para gestionar los diferentes paneles de la aplicación.
    static CardLayout cardLayout = new CardLayout();
    // JPanel que contiene los diferentes paneles de la aplicación.
    static JPanel cards = new JPanel(cardLayout);
    // JFrame principal de la aplicación.
    static JFrame frame = new JFrame();

    // Instancias de los paneles de la aplicación.
    static Login login = new Login();
    static Registro register = new Registro();
    static PoliticaPrivacidad privacypolicy = new PoliticaPrivacidad();
    static PerfilAnfitrion hostprofile = new PerfilAnfitrion();
    static PerfilCliente clientprofile = new PerfilCliente();
    static PantallaAdmin adminscreen = new PantallaAdmin();
    static ComprobarUsuarioAdmin adminconsultaruser = new ComprobarUsuarioAdmin();
    static AddInmueble addbuildings = new AddInmueble();
    static ComprobarInmuebleAdmin admincheckbuildings = new ComprobarInmuebleAdmin();
    static ComprobarInmuebleAnfitrion hostcheckbuildings = new ComprobarInmuebleAnfitrion();
    static MirarInmueble buildingview = new MirarInmueble();
    static ComprobarReservaAdmin adminconsultarreservas = new ComprobarReservaAdmin();
    static ComprobarReservaInvitado guestcheckreserves = new ComprobarReservaInvitado();
    static PantallaPrincipal mainscreen = new PantallaPrincipal();
    static ComprobarReservaAnfitrion hostcheckreserves = new ComprobarReservaAnfitrion();

    // Iniciamos la sesión como null
    public static Inicio sesion = null;

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Inicializa y carga los datos de MainBNB.
        MainBNB.inicializadorJavaBNB();
        MainBNB.cargarDatos();

        // Configura las dimensiones del JFrame.
        frame.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLocationRelativeTo(null);

        // Crear un JScrollPane y agregar el panel cards para permitir el desplazamiento.
        JScrollPane scrollPane = new JScrollPane(cards);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Agregar los paneles iniciales al CardLayout.
        cards.add(login, "Pantalla login");
        cards.add(register, "Pantalla register");
        cards.add(privacypolicy, "Pantalla privacypolicy");
        cards.add(adminscreen, "Pantalla adminscreen");
        cards.add(addbuildings, "Pantalla addbuildings");
        cards.add(hostcheckreserves, "Pantalla hostcheckreserves");

        // Configurar el JFrame.
        frame.setContentPane(scrollPane);
        frame.addWindowListener(new WindowEventHandler());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible el JFrame.
        frame.setVisible(true);
        // Mostrar inicialmente la pantalla de login.
        cardLayout.show(cards, "Pantalla login");
    }

    // Métodos para cargar diferentes paneles en la aplicación.

    /**
     * Carga el perfil del anfitrión.
     */
    public static void cargaPerfilAnfitrion() {
        cards.add(hostprofile, "Pantalla hostprofile");
        hostprofile.update();
        cardLayout.show(cards, "Pantalla hostprofile");
    }

    /**
     * Carga el perfil del cliente.
     */
    public static void cargaPerfilCliente() {
        cards.add(clientprofile, "Pantalla clientprofile");
        clientprofile.update();
        cardLayout.show(cards, "Pantalla clientprofile");
    }

    /**
     * Carga la pantalla de consulta de usuarios administradores.
     */
    public static void cargaComprobarUsuarioAdmin() {
        cards.add(adminconsultaruser, "Pantalla adminconsultaruser");
        adminconsultaruser.update();
        cardLayout.show(cards, "Pantalla adminconsultaruser");
    }

    /**
     * Carga la pantalla de consulta de reservas administrativas.
     */
    public static void cargaComprobarReservaAdmin() {
        cards.add(adminconsultarreservas, "Pantalla adminconsultarreservas");
        adminconsultarreservas.update();
        cardLayout.show(cards, "Pantalla adminconsultarreservas");
    }

    /**
     * Carga la pantalla de consulta de reservas de invitados.
     */
    public static void cargaComprobarReservaInvitado() {
        cards.add(guestcheckreserves, "Pantalla guestcheckreserves");
        guestcheckreserves.update();
        cardLayout.show(cards, "Pantalla guestcheckreserves");
    }

    /**
     * Carga la pantalla de consulta de edificios administrativos.
     */
    public static void cargaComprobarInmuebleAdmin() {
        cards.add(admincheckbuildings, "Pantalla admincheckbuildings");
        admincheckbuildings.update();
        cardLayout.show(cards, "Pantalla admincheckbuildings");
    }

    /**
     * Carga la pantalla de consulta de edificios de anfitriones.
     */
    public static void cargaComprobarInmuebleAnfitrion() {
        cards.add(hostcheckbuildings, "Pantalla hostcheckbuildings");
        hostcheckbuildings.update();
        cardLayout.show(cards, "Pantalla hostcheckbuildings");
    }

    /**
     * Carga la pantalla de consulta de reservas de anfitriones.
     */
    public static void cargaComprobarReservaAnfitrion() {
        cards.add(hostcheckreserves, "Pantalla hostcheckreserves");
        hostcheckreserves.update();
    }

    /**
     * Carga la vista de un inmueble específico.
     *
     * @param inmueble El inmueble que se desea ver.
     */
    public static void cargaMirarInmueble(Inmueble inmueble) {
        cards.add(buildingview, "Pantalla buildingview");
        buildingview.setInmueble(inmueble);
        cardLayout.show(cards, "Pantalla buildingview");
    }

    /**
     * Carga la vista de un inmueble.
     */
    public static void cargaMirarInmueble() {
        cards.add(buildingview, "Pantalla buildingview");
        cardLayout.show(cards, "Pantalla buildingview");
    }

    /**
     * Carga la pantalla principal de la aplicación.
     */
    public static void cargaPantallaPrincipal() {
        cards.add(mainscreen, "Pantalla mainscreen");
        mainscreen.update();
        cardLayout.show(cards, "Pantalla mainscreen");
    }
}