package biblioteca.app;

import biblioteca.model.*;
import biblioteca.enums.EstadoRecurso;

import java.util.*;

/**
 * Clase principal que ejecuta la aplicación de gestión de recursos de una biblioteca.
 * 
 * Proporciona un menú interactivo para listar, prestar y devolver recursos, 
 * permitiendo la interacción con los usuarios y los distintos materiales disponibles.
 */
public class Main {

    /** Mapa que almacena los recursos disponibles, identificados por su ID único. */
    private static Map<String, RecursoBiblioteca> recursos = new HashMap<>();
    
    /** Mapa que almacena los usuarios registrados en la biblioteca. */
    private static Map<String, Usuario> usuarios = new HashMap<>();

    /** Escáner utilizado para la lectura de entradas desde la consola. */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal del programa. Ejecuta el flujo de la aplicación y gestiona el menú principal.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        inicializarDatos();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    listarRecursos();
                    break;
                case 2:
                    prestarRecurso();
                    break;
                case 3:
                    devolverRecurso();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema de biblioteca. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    /**
     * Muestra el menú de opciones disponibles para el usuario.
     */
    private static void mostrarMenu() {
        System.out.println("\n====== Menú Biblioteca ======");
        System.out.println("1. Listar todos los recursos");
        System.out.println("2. Prestar recurso");
        System.out.println("3. Devolver recurso");
        System.out.println("4. Salir");
        System.out.println("=============================");
    }

    /**
     * Inicializa la biblioteca con un conjunto de recursos (libros, revistas y DVDs)
     * y usuarios de ejemplo, usados para pruebas o demostración del sistema.
     */
    private static void inicializarDatos() {
        recursos.put("L1", new Libro("L1", "Don Quijote"));
        recursos.put("L2", new Libro("L2", "Cien Años de Soledad"));
        recursos.put("L3", new Libro("L3", "El Principito"));

        recursos.put("R1", new Revista("R1", "National Geographic"));
        recursos.put("R2", new Revista("R2", "Muy Interesante"));
        recursos.put("R3", new Revista("R3", "Ciencia Hoy"));

        recursos.put("D1", new DVD("D1", "Matrix"));
        recursos.put("D2", new DVD("D2", "Inception"));
        recursos.put("D3", new DVD("D3", "El Señor de los Anillos"));

        usuarios.put("U1", new Usuario("U1", "Ana"));
        usuarios.put("U2", new Usuario("U2", "Luis"));
        usuarios.put("U3", new Usuario("U3", "Sofía"));
        usuarios.put("U4", new Usuario("U4", "Carlos"));
    }

    /**
     * Muestra todos los recursos registrados en la biblioteca,
     * clasificados por tipo (Libros, Revistas y DVDs) y ordenados por ID.
     */
    private static void listarRecursos() {
    	System.out.println("\n--- Lista de Recursos ---");

        List<RecursoBiblioteca> libros = new ArrayList<>();
        List<RecursoBiblioteca> revistas = new ArrayList<>();
        List<RecursoBiblioteca> dvds = new ArrayList<>();

        for (RecursoBiblioteca recurso : recursos.values()) {
            if (recurso instanceof Libro) {
                libros.add(recurso);
            } else if (recurso instanceof Revista) {
                revistas.add(recurso);
            } else if (recurso instanceof DVD) {
                dvds.add(recurso);
            }
        }

        // Ordenar por ID
        Comparator<RecursoBiblioteca> porId = Comparator.comparing(RecursoBiblioteca::getId);
        libros.sort(porId);
        revistas.sort(porId);
        dvds.sort(porId);

        if (!libros.isEmpty()) {
            System.out.println("📚 Libros:");
            libros.forEach(libro -> System.out.println(
                "  - [" + libro.getId() + "] " + libro.getTitulo() + " (Estado: " + libro.getEstado() + ")"));
        }

        if (!revistas.isEmpty()) {
            System.out.println("\n📰 Revistas:");
            revistas.forEach(revista -> System.out.println(
                "  - [" + revista.getId() + "] " + revista.getTitulo() + " (Estado: " + revista.getEstado() + ")"));
        }

        if (!dvds.isEmpty()) {
            System.out.println("\n🎬 DVDs:");
            dvds.forEach(dvd -> System.out.println(
                "  - [" + dvd.getId() + "] " + dvd.getTitulo() + " (Estado: " + dvd.getEstado() + ")"));
        }
    }

    /**
     * Permite a un usuario prestar un recurso, siempre que este esté disponible.
     * Solicita al usuario ingresar el ID del recurso y el ID del usuario correspondiente.
     */
    private static void prestarRecurso() {
        System.out.print("Ingrese ID del recurso a prestar: ");
        String idRecurso = scanner.nextLine().toUpperCase();
        System.out.print("Ingrese ID del usuario: ");
        String idUsuario = scanner.nextLine().toUpperCase();

        RecursoBiblioteca recurso = recursos.get(idRecurso);
        Usuario usuario = usuarios.get(idUsuario);

        if (recurso != null && usuario != null) {
            if (recurso.getEstado() == EstadoRecurso.DISPONIBLE) {
                usuario.prestarRecurso(recurso);
                System.out.println("✅ El recurso \"" + recurso.getTitulo() + "\" ha sido prestado a " + usuario.getNombre() + ".");
            } else {
                System.out.println("❌ El recurso \"" + recurso.getTitulo() + "\" no está disponible. Estado actual: " + recurso.getEstado());
            }
        } else {
            System.out.println("❌ Recurso o usuario no encontrado.");
        }
    }

    /**
     * Permite devolver un recurso que haya sido previamente prestado a un usuario.
     * Identifica qué usuario tiene el recurso y realiza la operación de devolución.
     */
    private static void devolverRecurso() {
        System.out.print("Ingrese ID del recurso a devolver: ");
        String idRecurso = scanner.nextLine().toUpperCase();

        RecursoBiblioteca recurso = recursos.get(idRecurso);
        if (recurso != null) {
            for (Usuario usuario : usuarios.values()) {
                if (usuario.tienePrestado(recurso)) {
                    usuario.devolverRecurso(recurso);
                    System.out.println("✅ Recurso \"" + recurso.getTitulo() + "\" devuelto por " + usuario.getNombre() + ".");
                    return;
                }
            }
            System.out.println("⚠️ Este recurso no está prestado actualmente.");
        } else {
            System.out.println("❌ Recurso no encontrado.");
        }
    }

    /**
     * Solicita al usuario introducir un número entero, asegurando que la entrada sea válida.
     *
     * @param mensaje Texto que se muestra al usuario antes de la entrada.
     * @return El número entero introducido por el usuario.
     */
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingrese un número válido: ");
            scanner.next();
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consume el salto de línea pendiente
        return numero;
    }
}

