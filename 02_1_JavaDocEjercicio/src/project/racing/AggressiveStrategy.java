package project.racing;

import project.driver.Driver;

public class AggressiveStrategy implements Strategy {
    @Override
    public void apply(Driver driver, double currentLapTime) {
        double adjusted = currentLapTime * 0.95;
        driver.recordAdjustedTime(adjusted);
    }
}