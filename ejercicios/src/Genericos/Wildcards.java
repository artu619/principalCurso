package Genericos;


import java.util.List;
import java.util.ArrayList;
//ejercicio4
public class Wildcards {
	
	// Método para sumar cualquier lista de números
    public static double sumar(List<? extends Number> lista) {
        double suma = 0;
        for (Number num : lista) {
            suma += num.doubleValue();
        }
        return suma;
    }
 // Método para añadir números a una lista de enteros
    public static void llenarInteger(List<? super Integer> lista, int... valores) {
        for (int valor : valores) {
            lista.add(valor);
        }
    }
    
    public static void main(String[] args) {
        List<Integer> listaEnteros = new ArrayList<>();
        llenarInteger(listaEnteros, 1, 2, 3, 4, 5);
        System.out.println("Lista después de llenado: " + listaEnteros);

        List<Double> listaDoubles = List.of(2.5, 3.5, 4.5);
        System.out.println("Suma de lista de dobles: " + sumar(listaDoubles));

        System.out.println("Suma de lista de enteros: " + sumar(listaEnteros));
    }

}
