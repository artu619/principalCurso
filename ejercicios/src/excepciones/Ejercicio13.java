package excepciones;

import java.util.Scanner;

class NombreVacioException extends Exception {
    public NombreVacioException(String mensaje) {
        super(mensaje);
    }
}

class NombreInvalidoException extends Exception {
    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre;

        do {
            System.out.print("Introduce tu nombre (solo letras): ");
            nombre = scanner.nextLine().trim();

            try {
                validarNombre(nombre);
            } catch (NombreVacioException | NombreInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
                nombre = ""; // Reiniciar para repetir el bucle
            }
        } while (nombre.isEmpty());

        System.out.println("Hola, " + nombre + "!");
        scanner.close();
    }

    public static void validarNombre(String nombre) throws NombreVacioException, NombreInvalidoException {
        if (nombre.isEmpty()) {
            throw new NombreVacioException("El nombre no puede estar vacío o contener solo espacios.");
        }
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new NombreInvalidoException("El nombre solo puede contener letras y caracteres especiales como tildes y la ñ.");
        }
    }
}


