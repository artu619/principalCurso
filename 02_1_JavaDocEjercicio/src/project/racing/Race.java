package project.racing;

import project.driver.Driver;
import project.track.TrackType;
import project.exception.RaceException;

import java.util.*;

/**
 * Clase que representa una carrera de vehículos con múltiples participantes.
 * Maneja eventos de carrera y determina un ganador basado en el rendimiento.
 */
public class Race {
    private final String name;//nombre de la carrera
    private final TrackType trackType;//tipo de pista en la que realiza la carrera
    private final int laps;// Número de vueltas que se correrán
    private final List<Driver> participants = new ArrayList<>();//Lista de pilotos participantes
    private final List<RaceEvent> listeners = new ArrayList<>();//Lista de listeners para eventos de carrera
    /**
     * Constructor para la carrera, asegurando valores válidos.
     * @param name Nombre de la carrera.
     * @param trackType Tipo de pista de la carrera.
     * @param laps Número de vueltas (opcional, si es null se usa el valor por defecto del TrackType).
     */
    
    public Race(String name, TrackType trackType, Integer laps) {
        this.name = Objects.requireNonNull(name);
        this.trackType = Objects.requireNonNull(trackType);
        this.laps = laps != null ? laps : trackType.getDefaultLaps();
    }
    /**
     * Añade un piloto a la carrera validando que su vehículo sea adecuado para la pista.
     * @param d Piloto que se añadirá a la lista de participantes.
     */

    public void addParticipant(Driver d) {
        if (d.getVehicle() == null || d.getVehicle().getPreferredTrack() != trackType)
            throw new RaceException("Vehículo no apto para tipo de pista");
        participants.add(d);
    }
    /**
     * Agrega un listener para eventos de la carrera.
     * @param listener Objeto que reaccionará a eventos de la carrera.
     */

    public void addListener(RaceEvent listener) { listeners.add(listener); }
    /**
     * Inicia la simulación de la carrera, recorriendo el número de vueltas y registrando los tiempos de los pilotos.
     */
    public void start() {
        participants.forEach(Driver::startDriving);
        for (int lap = 1; lap <= laps; lap++) {
            for (Driver d : participants) {
                double t = Math.random() * 10 + (1000 / d.getVehicle().getMaxSpeed());
                d.recordLap(t);
                listeners.forEach(l -> l.onLapComplete(d, t));
            }
        }
        participants.forEach(Driver::stopDriving);
        Driver winner = determineWinner();
        listeners.forEach(l -> l.onRaceFinish(winner));
    }
    
    /**
     * Determina el ganador de la carrera basado en el rendimiento del vehículo.
     * @return Piloto ganador de la carrera.
     */

    private Driver determineWinner() {
        return participants.stream()
                .max(Comparator.comparingDouble(d ->
                        d.getVehicle().calculatePerformanceScore()))
                .orElseThrow(() -> new RaceException("Sin participantes"));
    }
}
