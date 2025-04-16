package model;

import java.util.UUID;

public class Reserva {
    private Pasajero pasajero;
    private Vuelo vuelo;
    private String codigoReserva;

    public Reserva(Pasajero pasajero, Vuelo vuelo) {
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.codigoReserva = UUID.randomUUID().toString();
    }

    public Pasajero obtenerPasajero() {
        return pasajero;
    }

    public Vuelo obtenerVuelo() {
        return vuelo;
    }

    public String obtenerCodigoReserva() {
        return codigoReserva;
    }

    @Override
    public String toString() {
        return "Reserva: " + codigoReserva + " | Pasajero: " + pasajero.obtenerNombre() + " | Vuelo: " + vuelo.obtenerNumeroVuelo();
    }
}