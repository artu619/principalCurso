package project.racing;

import project.driver.Driver;
import project.track.TrackType;
import project.exception.RaceException;

import java.util.*;

public class Race {
    private final String name;
    private final TrackType trackType;
    private final int laps;
    private final List<Driver> participants = new ArrayList<>();
    private final List<RaceEvent> listeners = new ArrayList<>();

    public Race(String name, TrackType trackType, Integer laps) {
        this.name = Objects.requireNonNull(name);
        this.trackType = Objects.requireNonNull(trackType);
        this.laps = laps != null ? laps : trackType.getDefaultLaps();
    }

    public void addParticipant(Driver d) {
        if (d.getVehicle() == null || d.getVehicle().getPreferredTrack() != trackType)
            throw new RaceException("Vehículo no apto para tipo de pista");
        participants.add(d);
    }

    public void addListener(RaceEvent listener) { listeners.add(listener); }

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

    private Driver determineWinner() {
        return participants.stream()
                .max(Comparator.comparingDouble(d ->
                        d.getVehicle().calculatePerformanceScore()))
                .orElseThrow(() -> new RaceException("Sin participantes"));
    }
}
