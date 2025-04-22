package Jardinera;

import java.util.ArrayList;
import java.util.List;

// Clase genérica que representa una jardinera para cualquier tipo de planta
// T debe ser un tipo que herede de Planta
public class Jardinera<T extends Planta> {
	// Lista que almacena las plantas
	private List<T> plantas;
	 // Número máximo de plantas que puede contener la jardinera
    private static final int MAX_PLANTAS = 6; // Máximo número de plantas permitidas
    
    // Constructor: inicializa la lista vacía
    public Jardinera() {
        plantas = new ArrayList<>();
    }
    
    // Método para plantar una nueva planta
    // Devuelve true si se planta con éxito, false si ya está llena
    public boolean plantar(T planta) {
        if (plantas.size() < MAX_PLANTAS) {
            plantas.add(planta);
            System.out.println(planta.obtenerNombre() + " plantada.");
            return true;
        } else {
            System.out.println("La jardinera está llena. No se puede plantar más.");
            return false;
        }
    }

    // Muestra todas las plantas que hay actualmente en la jardinera
    public void mostrarPlantas() {
        if (plantas.isEmpty()) {
            System.out.println("La jardinera está vacía.");
        } else {
            System.out.println("Plantas en la jardinera:");
            for (T planta : plantas) {
                System.out.println("- " + planta.obtenerNombre());
            }
        }
    }
    

}
