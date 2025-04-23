package project.vehicle;

import project.track.TrackType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type,
                                        String model,
                                        EngineType engineType,
                                        double maxSpeed,
                                        TrackType track,
                                        Object extra) {
        switch (type) {
            case CAR:
                return new Car(model, engineType, maxSpeed, track, (Integer) extra);
            case MOTORCYCLE:
                return new Motorcycle(model, engineType, maxSpeed, track, (Boolean) extra);
            case TRUCK:
                return new Truck(model, engineType, maxSpeed, track, (Double) extra);
            default:
                throw new IllegalArgumentException("Tipo de vehículo desconocido: " + type);
        }
    }
}