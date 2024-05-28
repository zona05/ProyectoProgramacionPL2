package Programa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

// Clase principal del programa
public class MainBNB implements Serializable {

    // Listas estáticas para almacenar inmuebles, clientes y los inmuebles de un anfitrión específico
    private static ArrayList<Inmueble> inmuebles;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Inmueble> inmueblesAnfitrion;

    // Método para inicializar las listas
    public static void inicializadorJavaBNB() {
        inmuebles = new ArrayList<>();
        clientes = new ArrayList<>();
        inmueblesAnfitrion = new ArrayList<>();
        System.out.println(inmuebles);
        System.out.println(inmueblesAnfitrion);
    }

    // Métodos para obtener las listas de inmuebles y clientes
    public static ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Método para agregar un inmueble a la lista
    public static boolean agregarinmueble(Inmueble inmueble) {
        // Verificar si ya existe un inmueble con la misma dirección
        boolean existeInmuebleConMismaDireccion = inmuebles.stream()
                .anyMatch(inmuebleExistente -> inmuebleExistente.getDireccion().equals(inmueble.getDireccion()));

        // Si no existe, agregar el inmueble a la lista
        if (!existeInmuebleConMismaDireccion) {
            inmuebles.add(inmueble);
        } else {
            System.out.println("El inmueble ya está añadido");
        }
        return !existeInmuebleConMismaDireccion;
    }

    // Método para añadir un cliente a la lista
    public static boolean añadirCliente(Cliente cliente) {
        // Verificar si ya existe un cliente con el mismo DNI
        boolean existeClienteConMismoDni = clientes.stream()
                .anyMatch(clienteExistente -> clienteExistente.getDni().equals(cliente.getDni()));

        // Si no existe, agregar el cliente a la lista
        if (!existeClienteConMismoDni) {
            clientes.add(cliente);
        } else {
            System.out.println("El cliente ya ha sido añadido previamente");
        }
        return !existeClienteConMismoDni;
    }

    // Método para buscar inmuebles disponibles en una ciudad y fecha específicas
    public static ArrayList<Inmueble> buscarInmuebles(String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida) {
        ArrayList<Inmueble> inmueblesDisponiblesEnCiudad = new ArrayList<>();

        for (Inmueble inmueble : inmuebles) {
            // Verificar si la ciudad coincide y si el inmueble está disponible en las fechas especificadas
            boolean coincideCiudad = ciudad.isEmpty() || inmueble.getDireccion().getCiudad().equalsIgnoreCase(ciudad);
            boolean coincideDisponibilidad = (fechaEntrada == null && fechaSalida == null) || (fechaEntrada != null && fechaSalida != null && inmueble.estaDisponible(fechaEntrada, fechaSalida));

            // Si coincide, agregar el inmueble a la lista de disponibles
            if (coincideCiudad && coincideDisponibilidad) {
                inmueblesDisponiblesEnCiudad.add(inmueble);
            }
        }

        return inmueblesDisponiblesEnCiudad;
    }

    // Métodos para ordenar inmuebles por precio, tipo y calificación, de forma ascendente y descendente
    public static void ordenarPorPrecioAscSF() {
        if (inmuebles != null) {
            inmuebles.sort(Comparator.comparingDouble(Inmueble::getPrecioNoche));
        }
    }

    public static void ordenarPorPrecioDescSF() {
        if (inmuebles != null) {
            inmuebles.sort(Comparator.comparingDouble(Inmueble::getPrecioNoche).reversed());
        }
    }

    public static void ordenarPortypesSF() {
        if (inmuebles != null) {
            inmuebles.sort(Comparator.comparing(Inmueble::gettypes));
        }
    }

    public static void ordenarPorCalificacionAscSF() {
        if (inmuebles != null) {
            inmuebles.sort(Comparator.comparingDouble(Inmueble::getCalificacion));
        }
    }

    public static void ordenarPorCalificacionDescSF() {
        if (inmuebles != null) {
            inmuebles.sort(Comparator.comparingDouble(Inmueble::getCalificacion).reversed());
        }
    }

    // Métodos para ordenar inmuebles filtrados por ciudad por precio, tipo y calificación, de forma ascendente y descendente
    public static void ordenarPorPrecioAscCF(ArrayList<Inmueble> inmueblesDisponiblesEnCiudad) {
        if (inmueblesDisponiblesEnCiudad != null) {
            inmueblesDisponiblesEnCiudad.sort(Comparator.comparingDouble(Inmueble::getPrecioNoche));
        }
    }

    public static void ordenarPorPrecioDescCF(ArrayList<Inmueble> inmueblesDisponiblesEnCiudad) {
        if (inmueblesDisponiblesEnCiudad != null) {
            inmueblesDisponiblesEnCiudad.sort(Comparator.comparingDouble(Inmueble::getPrecioNoche).reversed());
        }
    }

    public static void ordenarPortypesCF(ArrayList<Inmueble> inmueblesDisponiblesEnCiudad) {
        if (inmueblesDisponiblesEnCiudad != null) {
            inmueblesDisponiblesEnCiudad.sort(Comparator.comparing(Inmueble::gettypes));
        }
    }

    // Métodos para filtrar inmuebles disponibles por tipo (casas y apartamentos)
    public static ArrayList<Inmueble> filtrarCasas(ArrayList<Inmueble> inmueblesDisponibles) {
        ArrayList<Inmueble> casas = new ArrayList<>();
        for (Inmueble inmueble : inmueblesDisponibles) {
            if (inmueble.gettypes().equalsIgnoreCase("Casa")) {
                casas.add(inmueble);
            }
        }
        return casas;
    }

    public static ArrayList<Inmueble> filtrarApartamentos(ArrayList<Inmueble> inmueblesDisponibles) {
        ArrayList<Inmueble> apartamentos = new ArrayList<>();
        for (Inmueble inmueble : inmueblesDisponibles) {
            if (inmueble.gettypes().equalsIgnoreCase("Apartamento")) {
                apartamentos.add(inmueble);
            }
        }
        return apartamentos;
    }

   

        public static void ordenarPorCalificacionAscCF(ArrayList<Inmueble> inmueblesDisponiblesEnCiudad) {
        if (inmueblesDisponiblesEnCiudad != null) {
            inmueblesDisponiblesEnCiudad.sort(Comparator.comparingDouble(Inmueble::getCalificacion));
        }
    }

    public static void ordenarPorCalificacionDescCF(ArrayList<Inmueble> inmueblesDisponiblesEnCiudad) {
        if (inmueblesDisponiblesEnCiudad != null) {
            inmueblesDisponiblesEnCiudad.sort(Comparator.comparingDouble(Inmueble::getCalificacion).reversed());
        }
    }

    // Método para cargar datos desde archivos
    public static void cargarDatos() {
        try {
            FileInputStream istreamClientes = new FileInputStream("./src/main/resources/datos/datainfoClientes.dat");
            ObjectInputStream oisClientes = new ObjectInputStream(istreamClientes);
            clientes = (ArrayList<Cliente>) oisClientes.readObject();
            istreamClientes.close();
        } catch (IOException ioe) {
            System.out.println("Error  IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }

        try {
            FileInputStream istreamInmuebles = new FileInputStream("./src/main/resources/datos/datainfoInmuebles.dat");
            ObjectInputStream oisInmuebles = new ObjectInputStream(istreamInmuebles);
            inmuebles = (ArrayList<Inmueble>) oisInmuebles.readObject();
            istreamInmuebles.close();
        } catch (IOException ioe) {
            System.out.println("Error IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }

    // Método para guardar datos en archivos
    public static void guardarDatos() {
        try {
            if (!clientes.isEmpty()) {
                FileOutputStream ostreamClientes = new FileOutputStream("./src/main/resources/datos/datainfoClientes.dat");
                ObjectOutputStream oosClientes = new ObjectOutputStream(ostreamClientes);
                oosClientes.writeObject(clientes);
                ostreamClientes.close();
            } else {
                System.out.println("Error: No hay datos de clientes...");
            }
        } catch (IOException ioe) {
            System.out.println("Error IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }

        try {
            if (!inmuebles.isEmpty()) {
                FileOutputStream ostreamInmuebles = new FileOutputStream("./src/main/resources/datos/datainfoInmuebles.dat");
                ObjectOutputStream oosInmuebles = new ObjectOutputStream(ostreamInmuebles);
                oosInmuebles.writeObject(inmuebles);
                ostreamInmuebles.close();
            }
        } catch (IOException ioe) {
            System.out.println("Error IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }

    // Método para eliminar un anfitrión y sus inmuebles
    public static void eliminarAnfitrion(Cliente cliente) {
        Host anfitrion = (Host) cliente;
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getAnfitrion().equals(anfitrion)) {
                inmueble.getReservas().clear();
                inmuebles.remove(inmueble);
            }
        }
        clientes.remove(cliente);
        guardarDatos();
    }

    // Método para eliminar un cliente particular y sus reservas
    public static void eliminarParticular(Cliente cliente) {
        Particular particular = (Particular) cliente;
        for (Inmueble inmueble : inmuebles) {
            for (Reserva reserva : inmueble.getReservas()) {
                if (reserva.getParticular().equals(particular)) {
                    inmueble.getReservas().remove(reserva);
                    inmuebles.remove(inmueble);
                }
            }
        }
        clientes.remove(cliente);
        guardarDatos();
    }

    // Método para filtrar inmuebles por el DNI de su anfitrión
    public static ArrayList<Inmueble> filtrarInmueblesPorAnfitrion(Cliente anfitrion) {
        inmueblesAnfitrion = new ArrayList<>();
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getAnfitrion().getDni().equals(anfitrion.getDni())) {
                inmueblesAnfitrion.add(inmueble);
            }
        }
        return inmueblesAnfitrion;
    }

    // Método para eliminar las reservas asociadas a un inmueble
    public static void eliminarReservasDeInmueble(Inmueble inmueble) {
        System.out.println("Eliminando reservas asociadas al inmueble (2): " + inmueble.getTitulo());
        //for (Reserva reserva : inmueble.getReservas()) {System.out.println("Eliminando reserva: " + reserva);reserva.getParticular().getReservas().remove(reserva);}
        inmueble.getReservas().clear();
        System.out.println("Las reservas se han eliminado correctamente.");
    }

    // Método para eliminar un inmueble y sus reservas
    public static void eliminarInmueble(Inmueble inmueble) {
        // Eliminar el inmueble de la lista de inmuebles
        System.out.println("Se ha eliminado el inmueble: " + inmueble.toString());

        inmuebles.remove(inmueble);

        // borrar las reservas asociadas al inmueble
        eliminarReservasDeInmueble(inmueble);

        // Guardar los cambios en el archivo de datos
        guardarDatos();
    }

}
