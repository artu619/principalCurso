package project.vehicle;

import project.track.TrackType;
import project.util.LapTimeAnalyzer;

import java.util.List;

/**
 * Clase que representa una motocicleta en el sistema de carreras.
 * Hereda de la clase Vehicle y añade atributos específicos de una moto.
 */

public class Motorcycle extends Vehicle {
    private boolean hasABS;
    /**
     * Constructor de la motocicleta, inicializa los atributos y configura el sistema ABS.
     * @param model Modelo de la moto.
     * @param engineType Tipo de motor (Gasolina, Eléctrico, etc.).
     * @param maxSpeed Velocidad máxima de la motocicleta.
     * @param preferredTrack Tipo de pista donde la moto rinde mejor.
     * @param hasABS Indica si la motocicleta cuenta con sistema de frenos antibloqueo (ABS).
     */

    public Motorcycle(String model, EngineType engineType, double maxSpeed, TrackType preferredTrack, boolean hasABS) {
        super(model, engineType, maxSpeed, preferredTrack);
        this.hasABS = hasABS;
    }
    /**
     * Verifica si la motocicleta tiene sistema ABS.
     * @return true si tiene ABS, false en caso contrario.
     */

    public boolean hasABS() { return hasABS; }
    /**
     * Establece si la motocicleta tiene ABS o no.
     * @param hasABS Nuevo estado del sistema ABS.
     */

    public void setHasABS(boolean hasABS) { this.hasABS = hasABS; }
    /**
     * Calcula la puntuación de rendimiento de la moto en función de la velocidad y tiempos de vuelta.
     * Se incluye un factor de agilidad basado en la presencia de ABS.
     * @return Valor de rendimiento de la motocicleta.
     */
    @Override
    public double calculatePerformanceScore() {
        List<Double> times = lapTimes;
        var stats = LapTimeAnalyzer.analyze(times);
        double agility = 1 + (hasABS ? 0.1 : -0.1);
        return (getMaxSpeed() / stats.getAverage()) * agility;
    }
}