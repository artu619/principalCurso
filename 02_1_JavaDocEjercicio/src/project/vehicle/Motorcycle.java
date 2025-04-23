package project.vehicle;

import project.track.TrackType;
import project.util.LapTimeAnalyzer;

import java.util.List;

public class Motorcycle extends Vehicle {
    private boolean hasABS;

    public Motorcycle(String model, EngineType engineType, double maxSpeed, TrackType preferredTrack, boolean hasABS) {
        super(model, engineType, maxSpeed, preferredTrack);
        this.hasABS = hasABS;
    }

    public boolean hasABS() { return hasABS; }

    public void setHasABS(boolean hasABS) { this.hasABS = hasABS; }

    @Override
    public double calculatePerformanceScore() {
        List<Double> times = lapTimes;
        var stats = LapTimeAnalyzer.analyze(times);
        double agility = 1 + (hasABS ? 0.1 : -0.1);
        return (getMaxSpeed() / stats.getAverage()) * agility;
    }
}