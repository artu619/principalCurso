package project.racing;

import project.driver.Driver;
/**
 * Implementación de una estrategia conservadora en la carrera.
 * Aumenta el tiempo de vuelta del piloto en un 5% para simular un enfoque más cauteloso.
 */

public class ConservativeStrategy implements Strategy {
	/**
     * Aplica la estrategia conservadora aumentando el tiempo de vuelta del piloto.
     * @param driver Piloto al que se aplica la estrategia.
     * @param currentLapTime Tiempo de vuelta actual antes del ajuste.
     */
    @Override
    public void apply(Driver driver, double currentLapTime) {
    	// Se incrementa el tiempo de vuelta en un 5% para representar conducción cautelosa
        double adjusted = currentLapTime * 1.05;
     // Se registra el tiempo ajustado en el historial del piloto
        driver.recordAdjustedTime(adjusted);
    }
}