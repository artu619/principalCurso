package project.racing;

import project.driver.Driver;

/**
 * Implementación de una estrategia agresiva en la carrera.
 * Reduce el tiempo de vuelta del piloto en un 5% para simular un enfoque más arriesgado.
 */

public class AggressiveStrategy implements Strategy {
	/**
     * Aplica la estrategia agresiva reduciendo el tiempo de vuelta del piloto.
     * @param driver Piloto al que se aplica la estrategia.
     * @param currentLapTime Tiempo de vuelta actual antes del ajuste.
     */
    @Override
    public void apply(Driver driver, double currentLapTime) {
    	// Se reduce el tiempo de vuelta en un 5% para representar conducción agresiva
        double adjusted = currentLapTime * 0.95;
     // Se registra el tiempo ajustado en el historial del piloto
        driver.recordAdjustedTime(adjusted);
    }
}