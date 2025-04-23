package project.racing;

import project.driver.Driver;

public class ConservativeStrategy implements Strategy {
    @Override
    public void apply(Driver driver, double currentLapTime) {
        double adjusted = currentLapTime * 1.05;
        driver.recordAdjustedTime(adjusted);
    }
}