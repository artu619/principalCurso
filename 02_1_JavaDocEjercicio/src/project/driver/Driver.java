package project.driver;

import project.vehicle.Vehicle;
import project.exception.RaceException;
import project.racing.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private final String name;
    private int experienceYears;
    private Vehicle vehicle;
    private Strategy strategy;
    private List<Double> adjustedLapTimes = new ArrayList<>();

    public Driver(String name, int experienceYears) {
        if (name == null || name.isBlank())
            throw new RaceException("Name inválido");
        this.name = name;
        setExperienceYears(experienceYears);
    }

    public String getName() { return name; }
    public int getExperienceYears() { return experienceYears; }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0)
            throw new IllegalArgumentException("experienceYears debe ser >= 0");
        this.experienceYears = experienceYears;
    }

    public Vehicle getVehicle() { return vehicle; }
    public void assignVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public void setStrategy(Strategy strategy) { this.strategy = strategy; }

    public void startDriving() {
        if (vehicle == null)
            throw new RaceException("Sin vehículo asignado");
        vehicle.startRace();
    }

    public void stopDriving() {
        if (vehicle == null)
            throw new RaceException("Sin vehículo asignado");
        vehicle.stopRace();
    }

    public void recordLap(double time) {
        vehicle.recordLapTime(time);
        if (strategy != null)
            strategy.apply(this, time);
    }

    public void recordAdjustedTime(double t) { adjustedLapTimes.add(t); }
    public List<Double> getAdjustedLapTimes() { return adjustedLapTimes; }
    public List<Double> getRawLapTimes() { return vehicle.lapTimes; }
}
