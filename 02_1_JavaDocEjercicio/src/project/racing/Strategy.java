package project.racing;

import project.driver.Driver;

public interface Strategy {
    void apply(Driver driver, double currentLapTime);
}