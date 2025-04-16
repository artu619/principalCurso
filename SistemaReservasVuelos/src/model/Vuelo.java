package model;

public class Vuelo {
    private String numeroVuelo;
    private String origen;
    private String destino;
    private String fecha;
    private int asientosDisponibles;

    public Vuelo(String numeroVuelo, String origen, String destino, String fecha, int asientosDisponibles) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.asientosDisponibles = asientosDisponibles;
    }

    public boolean reservarAsiento() {
        if (asientosDisponibles > 0) {
            asientosDisponibles--;
            return true;
        }
        return false;
    }

    public void cancelarReserva() {
        asientosDisponibles++;
    }

    public String obtenerNumeroVuelo() {
        return numeroVuelo;
    }

    public String obtenerOrigen() {
        return origen;
    }

    public String obtenerDestino() {
        return destino;
    }

    public String obtenerFecha() {
        return fecha;
    }

    public int obtenerAsientosDisponibles() {
        return asientosDisponibles;
    }

    @Override
    public String toString() {
        return numeroVuelo + " | " + origen + " -> " + destino + " | Fecha: " + fecha + " | Asientos disponibles: " + asientosDisponibles;
    }
}