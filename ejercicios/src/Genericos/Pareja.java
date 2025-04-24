package Genericos;

public class Pareja<T, U> { // Nombre de la clase corregido
    private T primero;
    private U segundo;

    // Constructor
    public Pareja(T primero, U segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    // Métodos getter
    public T getPrimero() {
        return primero;
    }

    public U getSegundo() {
        return segundo;
    }

    // Método toString
    @Override
    public String toString() {
        return "(" + primero + ", " + segundo + ")";
    }

    // Método principal de prueba
    public static void main(String[] args) {
        Pareja<Integer, String> ejemplo = new Pareja<>(10, "Hola");
        System.out.println(ejemplo); // Salida: (10, Hola)
    }
}

