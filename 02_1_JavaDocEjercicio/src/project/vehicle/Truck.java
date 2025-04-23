package project.vehicle;

import project.track.TrackType;
import project.util.LapTimeAnalyzer;

import java.util.List;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String model, EngineType engineType, double maxSpeed, TrackType preferredTrack, double loadCapacity) {
        super(model, engineType, maxSpeed, preferredTrack);
        setLoadCapacity(loadCapacity);
    }

    public double getLoadCapacity() { return loadCapacity; }

    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity < 0)
            throw new IllegalArgumentException("loadCapacity debe ser >= 0");
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculatePerformanceScore() {
        List<Double> times = lapTimes;
        var stats = LapTimeAnalyzer.analyze(times);
        double penalty = 1 - (loadCapacity / 10000);
        return (getMaxSpeed() / stats.getAverage()) * penalty;
    }
}