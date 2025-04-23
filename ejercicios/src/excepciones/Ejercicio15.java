package excepciones;

import java.util.Scanner;

public class Ejercicio15{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contrasena;

        do {
            System.out.print("Introduce una contraseña segura: ");
            contrasena = scanner.nextLine();

            try {
                validarContrasena(contrasena);
                System.out.println("Contraseña aceptada.");
                break; // Si la contraseña es válida, salimos del bucle.
            } catch (ContrasenaInseguraException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Inténtalo de nuevo.");
            }
        } while (true);

        scanner.close();
    }

    public static void validarContrasena(String contrasena) throws ContrasenaInseguraException {
        if (contrasena.length() < 8) {
            throw new ContrasenaInseguraException("La contraseña debe tener al menos 8 caracteres.");
        }
        if (!contrasena.matches(".*[A-Z].*")) {
            throw new ContrasenaInseguraException("La contraseña debe contener al menos una letra mayúscula.");
        }
        if (!contrasena.matches(".*\\d.*")) {
            throw new ContrasenaInseguraException("La contraseña debe contener al menos un número.");
        }
    }
}

class ContrasenaInseguraException extends Exception {
    public ContrasenaInseguraException(String mensaje) {
        super(mensaje);
    }
}
