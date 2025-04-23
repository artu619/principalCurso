package biblioteca.app;

import biblioteca.model.*;
import biblioteca.enums.EstadoRecurso;

import java.util.*;

/**
 * Clase principal que ejecuta el programa de gestión de biblioteca.
 * Ofrece un menú interactivo para listar, prestar y devolver recursos.
 */
public class Main {
	// Mapas para almacenar los recursos y los usuarios registrados
    private static Map<String, RecursoBiblioteca> recursos = new HashMap<>();
    private static Map<String, Usuario> usuarios = new HashMap<>();
    // Escáner para leer entradas desde consola
    private static Scanner scanner = new Scanner(System.in);
    // Método principal del programa
    public static void main(String[] args) {
        inicializarDatos(); // Carga algunos recursos y usuarios predefinidos

        int opcion;
        // Ciclo principal del menú
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            // Menú de opciones
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
    // Muestra el menú principal en consola
    private static void mostrarMenu() {
        System.out.println("\n====== Menú Biblioteca ======");
        System.out.println("1. Listar todos los recursos");
        System.out.println("2. Prestar recurso");
        System.out.println("3. Devolver recurso");
        System.out.println("4. Salir");
        System.out.println("=============================");
    }
 // Inicializa algunos datos por defecto para pruebas
    private static void inicializarDatos() {
        // Libros
        recursos.put("L1", new Libro("L1", "Don Quijote"));
        recursos.put("L2", new Libro("L2", "Cien Años de Soledad"));
        recursos.put("L3", new Libro("L3", "El Principito"));
       

        // Revistas
        recursos.put("R1", new Revista("R1", "National Geographic"));
        recursos.put("R2", new Revista("R2", "Muy Interesante"));
        recursos.put("R3", new Revista("R3", "Ciencia Hoy"));
        

        // DVDs
        recursos.put("D1", new DVD("D1", "Matrix"));
        recursos.put("D2", new DVD("D2", "Inception"));
        recursos.put("D3", new DVD("D3", "El Señor de los Anillos"));

        // Usuarios
        usuarios.put("U1", new Usuario("U1", "Ana"));
        usuarios.put("U2", new Usuario("U2", "Luis"));
        usuarios.put("U3", new Usuario("U3", "Sofía"));
        usuarios.put("U4", new Usuario("U4", "Carlos"));
    }
 // Muestra todos los recursos registrados en la biblioteca
    private static void listarRecursos() {
        System.out.println("\n--- Lista de Recursos ---");

        // Listas separadas por tipo
        List<RecursoBiblioteca> libros = new ArrayList<>();
        List<RecursoBiblioteca> revistas = new ArrayList<>();
        List<RecursoBiblioteca> dvds = new ArrayList<>();

        // Clasifica los recursos por tipo
        for (RecursoBiblioteca recurso : recursos.values()) {
            if (recurso instanceof Libro) {
                libros.add(recurso);
            } else if (recurso instanceof Revista) {
                revistas.add(recurso);
            } else if (recurso instanceof DVD) {
                dvds.add(recurso);
            }
        }

        // Ordena por título dentro de cada tipo
        Comparator<RecursoBiblioteca> porTitulo = Comparator.comparing(RecursoBiblioteca::getTitulo);
        libros.sort(porTitulo);
        revistas.sort(porTitulo);
        dvds.sort(porTitulo);

        // Muestra los recursos organizados
        if (!libros.isEmpty()) {
            System.out.println("📚 Libros:");
            for (RecursoBiblioteca libro : libros) {
                System.out.println("  - " + libro);
            }
        }

        if (!revistas.isEmpty()) {
            System.out.println("\n📰 Revistas:");
            for (RecursoBiblioteca revista : revistas) {
                System.out.println("  - " + revista);
            }
        }

        if (!dvds.isEmpty()) {
            System.out.println("\n🎬 DVDs:");
            for (RecursoBiblioteca dvd : dvds) {
                System.out.println("  - " + dvd);
            }
        }
    }
    
 // Permite prestar un recurso a un usuario si está disponible
    private static void prestarRecurso() {
        System.out.print("Ingrese ID del recurso a prestar: ");
        String idRecurso = scanner.nextLine().toUpperCase();
        System.out.print("Ingrese ID del usuario: ");
        String idUsuario = scanner.nextLine().toUpperCase();

        RecursoBiblioteca recurso = recursos.get(idRecurso);
        Usuario usuario = usuarios.get(idUsuario);
     // Solo se presta si está disponible
        if (recurso != null && usuario != null) {
            if (recurso.getEstado() == EstadoRecurso.DISPONIBLE) {
                usuario.prestarRecurso(recurso);// Llama al método en Usuario
                System.out.println("✅ El recurso \"" + recurso.getTitulo() + "\" ha sido prestado a " + usuario.getNombre() + ".");
            } else {
                System.out.println("❌ El recurso \"" + recurso.getTitulo() + "\" no está disponible. Estado actual: " + recurso.getEstado());
            }
        } else {
            System.out.println("❌ Recurso o usuario no encontrado.");
        }
    }
    // Permite devolver un recurso que haya sido prestado
    private static void devolverRecurso() {
        System.out.print("Ingrese ID del recurso a devolver: ");
        String idRecurso = scanner.nextLine().toUpperCase();

        RecursoBiblioteca recurso = recursos.get(idRecurso);
        if (recurso != null) {
        // Verifica cuál usuario tiene el recurso y lo devuelve
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
    // Lee un número entero desde consola con validación
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingrese un número válido: ");
            scanner.next(); // descarta entrada no numérica
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // consume salto de línea
        return numero;
    }
}
