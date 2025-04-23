package project.app;

import project.vehicle.*;
import project.track.TrackType;
import project.driver.Driver;
import project.racing.*;
import project.util.LapTimeAnalyzer;

import java.util.DoubleSummaryStatistics;

public class RaceApp {
    public static void main(String[] args) {
        // Crear vehículos usando Factory
        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR,
                "Ferrari F8", EngineType.PETROL, 340, TrackType.CIRCUIT, 2);
        Vehicle moto = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE,
                "Yamaha R1", EngineType.PETROL, 299, TrackType.CIRCUIT, true);

        // Crear pilotos y asignar estrategia
        Driver alice = new Driver("Alice", 5);
        alice.assignVehicle(car);
        alice.setStrategy(new AggressiveStrategy());

        Driver bob = new Driver("Bob", 3);
        bob.assignVehicle(moto);
        bob.setStrategy(new ConservativeStrategy());

        // Configurar carrera avanzada y listeners
        Race race = new Race("GP Avanzado", TrackType.CIRCUIT, null);
        race.addParticipant(alice);
        race.addParticipant(bob);

        race.addListener(new RaceEvent() {
            @Override
            public void onLapComplete(Driver driver, double lapTime) {
                System.out.println(driver.getName() + " completó vuelta en " + lapTime + "s");
            }
            @Override
            public void onRaceFinish(Driver winner) {
                System.out.println("Ganador: " + winner.getName());
            }
        });

        // Iniciar simulación de la carrera
        race.start();

        // Analizar tiempos ajustados y mostrar estadísticas
        DoubleSummaryStatistics stats = LapTimeAnalyzer.analyze(alice.getAdjustedLapTimes());
        System.out.println("Alice Avg Adjusted: " + stats.getAverage());
    }
}
