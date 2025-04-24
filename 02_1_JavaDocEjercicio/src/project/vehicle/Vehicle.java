package project.vehicle;

import project.racing.Raceable;
import project.racing.Maintainable;
import project.track.TrackType;
import project.util.Validator;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle implements Raceable, Maintainable {
    private final String model;
    private EngineType engineType;
    private double maxSpeed;
    private TrackType preferredTrack;
    private boolean inRace = false;
    private boolean maintenanceRequired = false;
    public List<Double> lapTimes = new ArrayList<>();

    public Vehicle(String model, EngineType engineType, double maxSpeed, TrackType preferredTrack) {
        Validator.checkNotNull(model, "Model");
        this.model = model;
        setEngineType(engineType);
        setMaxSpeed(maxSpeed);
        setPreferredTrack(preferredTrack);
    }

    public String getModel() { return model; }
    public EngineType getEngineType() { return engineType; }
    public double getMaxSpeed() { return maxSpeed; }
    public TrackType getPreferredTrack() { return preferredTrack; }

    public void setEngineType(EngineType engineType) {
        Validator.checkNotNull(engineType, "EngineType");
        this.engineType = engineType;
    }

    public void setMaxSpeed(double maxSpeed) {
        Validator.checkPositive(maxSpeed, "maxSpeed");
        this.maxSpeed = maxSpeed;
    }

    public void setPreferredTrack(TrackType preferredTrack) {
        Validator.checkNotNull(preferredTrack, "preferredTrack");
        this.preferredTrack = preferredTrack;
    }

    @Override
    public void startRace() {
        if (inRace) throw new IllegalStateException("Ya en carrera");
        inRace = true;
        lapTimes.clear();
    }

    @Override
    public void stopRace() {
        if (!inRace) throw new IllegalStateException("No en carrera");
        inRace = false;
        maintenanceRequired = true;
    }

    @Override
    public void recordLapTime(double seconds) {
        if (!inRace) throw new IllegalStateException("No en carrera");
        Validator.checkPositive(seconds, "lapTime");
        lapTimes.add(seconds);
    }

    @Override
    public boolean needsService() { return maintenanceRequired; }

    @Override
    public void performMaintenance() { maintenanceRequired = false; }

    /**
     * Calcula la puntuación de rendimiento según lapTimes y maxSpeed.
     * @return puntuación de rendimiento
     */
    public abstract double calculatePerformanceScore();
}