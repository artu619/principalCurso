package project.track;

public enum TrackType {
    ROAD(1000),
    CIRCUIT(5000),
    OFFROAD(2000);

    private final int defaultLaps;

    TrackType(int defaultLaps) {
        this.defaultLaps = defaultLaps;
    }

    public int getDefaultLaps() {
        return defaultLaps;
    }
}