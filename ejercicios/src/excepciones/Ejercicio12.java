package excepciones;

import java.util.Scanner;
import java.util.InputMismatchException;

class NotaInvalidaException extends Exception {
    public NotaInvalidaException(String mensaje) {
        super(mensaje);
    }
}

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nota;

        do {
            System.out.print("Ingrese la nota del alumno (0-10): ");
            try {
                nota = scanner.nextDouble();
                if (nota < 0 || nota > 10) {
                    throw new NotaInvalidaException("Nota inválida: " + nota);
                }
                System.out.println("Nota establecida correctamente: " + nota);
                break; // Sale del bucle si la nota es válida
            } catch (NotaInvalidaException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException y) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Limpia la entrada incorrecta
            }
        } while (true); // Se repite hasta que se ingrese una nota válida

        scanner.close();
    }
}

     











