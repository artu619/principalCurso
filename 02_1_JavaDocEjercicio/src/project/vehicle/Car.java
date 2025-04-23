package project.vehicle;

import project.track.TrackType;
import project.util.LapTimeAnalyzer;

import java.util.List;

/**
 * Clase que representa un automóvil dentro del sistema de carreras.
 * Hereda de la clase Vehicle y añade atributos específicos de un coche.
 */

public class Car extends Vehicle {
    private int doorCount;
    /**
     * Constructor del automóvil, inicializa los atributos y valida el número de puertas.
     * @param model Modelo del coche.
     * @param engineType Tipo de motor (Gasolina, Eléctrico, etc.).
     * @param maxSpeed Velocidad máxima del vehículo.
     * @param preferredTrack Tipo de pista donde el coche rinde mejor.
     * @param doorCount Número de puertas (Debe estar entre 2 y 5).
     */

    public Car(String model, EngineType engineType, double maxSpeed, TrackType preferredTrack, int doorCount) {
        super(model, engineType, maxSpeed, preferredTrack);
        setDoorCount(doorCount);
    }
    /**
     * Obtiene el número de puertas del coche.
     * @return Número de puertas del automóvil.
     */

    public int getDoorCount() { return doorCount; }
    /**
     * Establece el número de puertas del coche con validación de rango.
     * @param doorCount Número de puertas (Debe estar entre 2 y 5).
     * @throws IllegalArgumentException Si el número de puertas no está dentro del rango permitido.
     */

    public void setDoorCount(int doorCount) {
        if (doorCount < 2 || doorCount > 5)
            throw new IllegalArgumentException("doorCount debe estar entre 2 y 5");
        this.doorCount = doorCount;
    }
    /**
     * Calcula la puntuación de rendimiento del coche en función de la velocidad,
     * el tiempo promedio de vuelta y la consistencia del rendimiento.
     * @return Valor de rendimiento del coche basado en estadísticas de carrera.
     */

    
    @Override
    public double calculatePerformanceScore() {
        List<Double> times = lapTimes;
        var stats = LapTimeAnalyzer.analyze(times);
        double consistency = 1 / (1 + LapTimeAnalyzer.stdDev(times));
        return (getMaxSpeed() / stats.getAverage()) * (doorCount / 2.0) * consistency;
    }
}
