package project.racing;

import project.driver.Driver;

public interface RaceEvent {
    void onLapComplete(Driver driver, double lapTime);
    void onRaceFinish(Driver winner);
}