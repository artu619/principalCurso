package Genericos;
import java.util.ArrayList;
import java.util.List;

public class Almacen<T> {
    private T contenido;

    // Método para guardar elementos
    public void guardar(T contenido) {
        this.contenido = contenido;
    }

    // Método para obtener elementos
    public T obtener() {
        return contenido;
    }

    public static void main(String[] args) {
        // Uso sin parámetros (Raw Type)
        Almacen almacen = new Almacen();

        // Guardamos distintos tipos de datos
        almacen.guardar(100); // Número entero
        almacen.guardar("Hola, mundo!"); // Cadena de texto

        // Intentamos recuperar el contenido con casteo
        try {
            Integer numero = (Integer) almacen.obtener(); // Puede lanzar ClassCastException
            System.out.println("Número obtenido: " + numero);
        } catch (ClassCastException e) {
            System.out.println("Error de casteo: " + e.getMessage());
        }

        try {
            String texto = (String) almacen.obtener(); // Puede lanzar ClassCastException
            System.out.println("Texto obtenido: " + texto);
        } catch (ClassCastException e) {
            System.out.println("Error de casteo: " + e.getMessage());
        }
    }
}
