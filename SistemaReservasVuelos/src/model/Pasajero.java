package model;

public class Pasajero {
    private String nombre;
    private String numeroPasaporte;

    public Pasajero(String nombre, String numeroPasaporte) {
        this.nombre = nombre;
        this.numeroPasaporte = numeroPasaporte;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerNumeroPasaporte() {
        return numeroPasaporte;
    }
}