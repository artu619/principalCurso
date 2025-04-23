package project.racing;

import project.driver.Driver;

/**
 * Interfaz para definir eventos dentro de una carrera.
 * Permite registrar momentos clave como la finalización de vueltas y el ganador de la competencia.
 */

public interface RaceEvent {
	/**
     * Método invocado cuando un piloto completa una vuelta en la carrera.
     * @param driver Piloto que finalizó la vuelta.
     * @param lapTime Tiempo registrado para la vuelta completada.
     */
    void onLapComplete(Driver driver, double lapTime);
    /**
     * Método invocado al finalizar la carrera para anunciar el ganador.
     * @param winner Piloto que obtuvo la mejor posición en la competencia.
     */
    void onRaceFinish(Driver winner);
}