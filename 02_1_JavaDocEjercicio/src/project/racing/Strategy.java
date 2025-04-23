package project.racing;

import project.driver.Driver;
/**
 * Interfaz que define una estrategia de carrera para los pilotos.
 * Permite modificar el tiempo de vuelta según diferentes enfoques de conducción.
 */
public interface Strategy {
	/**
     * Aplica la estrategia al piloto y ajusta su tiempo de vuelta.
     * @param driver Piloto al que se aplicará la estrategia.
     * @param currentLapTime Tiempo registrado en la vuelta actual antes del ajuste.
     */
    void apply(Driver driver, double currentLapTime);
}