package project.vehicle;

import project.track.TrackType;
import project.util.LapTimeAnalyzer;

import java.util.List;

/**
 * Clase que representa un camión dentro del sistema de carreras.
 * Hereda de la clase Vehicle y añade atributos específicos como la capacidad de carga.
 */

public class Truck extends Vehicle {
    private double loadCapacity;
    /**
     * Constructor del camión, inicializa los atributos y valida la capacidad de carga.
     * @param model Modelo del camión.
     * @param engineType Tipo de motor (Gasolina, Diésel, Eléctrico, etc.).
     * @param maxSpeed Velocidad máxima del camión.
     * @param preferredTrack Tipo de pista donde el camión rinde mejor.
     * @param loadCapacity Capacidad de carga en kilogramos (Debe ser >= 0).
     */

    public Truck(String model, EngineType engineType, double maxSpeed, TrackType preferredTrack, double loadCapacity) {
        super(model, engineType, maxSpeed, preferredTrack);
        setLoadCapacity(loadCapacity);
    }
    /**
     * Obtiene la capacidad de carga del camión.
     * @return Capacidad de carga en kilogramos.
     */

    public double getLoadCapacity() { return loadCapacity; }
    /**
     * Establece la capacidad de carga del camión con validación de valor mínimo.
     * @param loadCapacity Capacidad de carga en kilogramos (Debe ser >= 0).
     * @throws IllegalArgumentException Si el valor de carga es negativo.
     */

    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity < 0)
            throw new IllegalArgumentException("loadCapacity debe ser >= 0");
        this.loadCapacity = loadCapacity;
    }
    /**
     * Calcula la puntuación de rendimiento del camión en función de la velocidad y la carga.
     * Se aplica una penalización basada en la cantidad de carga transportada.
     * @return Valor de rendimiento del camión basado en estadísticas de carrera.
     */

    @Override
    public double calculatePerformanceScore() {
        List<Double> times = lapTimes;
        var stats = LapTimeAnalyzer.analyze(times);
        double penalty = 1 - (loadCapacity / 10000);
        return (getMaxSpeed() / stats.getAverage()) * penalty;
    }
}