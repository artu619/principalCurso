package project.driver;

import project.vehicle.Vehicle;
import project.exception.RaceException;
import project.racing.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private final String name;//Nombre del piloto
    private int experienceYears;//Años de experiencia
    private Vehicle vehicle;//vehiculo asignado al piloto
    private Strategy strategy;// Estragia de carrera
    private List<Double> adjustedLapTimes = new ArrayList<>();// Lista de tiempos de vuelta ajustados
    
    // Constructor de la clase Driver
    public Driver(String name, int experienceYears) {
        if (name == null || name.isBlank()) // Validación del nombre
            throw new RaceException("Name inválido");// Excepción si el nombre es incorrecto
        this.name = name;
        setExperienceYears(experienceYears);// Asigna años de experiencia con validación
    }
 // Métodos para obtener información básica del piloto
    public String getName() { return name; }
    public int getExperienceYears() { return experienceYears; }
    // Método para definir los años de experiencia del piloto con validación
    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0)// Se asegura que los años de experiencia sean válidos
            throw new IllegalArgumentException("experienceYears debe ser >= 0");
        this.experienceYears = experienceYears;
    }
 // Métodos para manejar el vehículo del piloto
    public Vehicle getVehicle() { return vehicle; }
    public void assignVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
 // Métodos para manejar la estrategia de carrera del piloto
    public void setStrategy(Strategy strategy) { this.strategy = strategy; }
 // Inicia la carrera con el vehículo asignado
    public void startDriving() {
        if (vehicle == null)// Verifica si el piloto tiene un vehículo asignado
            throw new RaceException("Sin vehículo asignado");
        vehicle.startRace();// Inicia la carrera con el vehículo
    }
 // Detiene la conducción del piloto
    public void stopDriving() {
        if (vehicle == null) // Verifica si el piloto tiene un vehículo asignado
            throw new RaceException("Sin vehículo asignado");
        vehicle.stopRace();// Detiene la carrera del vehículo
    }
 // Registra el tiempo de una vuelta completada
    public void recordLap(double time) {
        vehicle.recordLapTime(time);// Almacena el tiempo bruto en el vehículo
        if (strategy != null) // Si hay una estrategia de carrera, se aplica
            strategy.apply(this, time);
    }

    public void recordAdjustedTime(double t) { adjustedLapTimes.add(t); }
    public List<Double> getAdjustedLapTimes() { return adjustedLapTimes; }
    public List<Double> getRawLapTimes() { return vehicle.lapTimes; }
}
