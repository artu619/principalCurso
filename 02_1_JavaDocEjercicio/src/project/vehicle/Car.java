package project.vehicle;

import project.track.TrackType;
import project.util.LapTimeAnalyzer;

import java.util.List;

public class Car extends Vehicle {
    private int doorCount;

    public Car(String model, EngineType engineType, double maxSpeed, TrackType preferredTrack, int doorCount) {
        super(model, engineType, maxSpeed, preferredTrack);
        setDoorCount(doorCount);
    }

    public int getDoorCount() { return doorCount; }

    public void setDoorCount(int doorCount) {
        if (doorCount < 2 || doorCount > 5)
            throw new IllegalArgumentException("doorCount debe estar entre 2 y 5");
        this.doorCount = doorCount;
    }

    @Override
    public double calculatePerformanceScore() {
        List<Double> times = lapTimes;
        var stats = LapTimeAnalyzer.analyze(times);
        double consistency = 1 / (1 + LapTimeAnalyzer.stdDev(times));
        return (getMaxSpeed() / stats.getAverage()) * (doorCount / 2.0) * consistency;
    }
}
