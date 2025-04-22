package Jardinera;
/**
 * Crea una jardinera que tiene diferentes plantas.
 * Hay varios tipos de planta: margaritas, lavanda, amapola.
 * En una jardinera caben hasta seis plantas.
 * 
 * Haz tu propia clase genérica para plantar las plantas.
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Se crea una jardinera que puede contener cualquier tipo de Planta
        Jardinera<Planta> jardinera = new Jardinera<>();

        // Se plantan distintas plantas
        jardinera.plantar(new Margarita());
        jardinera.plantar(new Lavanda());
        jardinera.plantar(new Amapola());
        jardinera.plantar(new Margarita());
        jardinera.plantar(new Lavanda());
        jardinera.plantar(new Amapola());
        jardinera.plantar(new Margarita()); // Esta no debería poder plantarse

        // Se muestran las plantas en la jardinera
        jardinera.mostrarPlantas();
		

	}

}
