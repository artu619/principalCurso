package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private List<Vuelo> listaVuelos = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();

    public void agregarVuelo(Vuelo vuelo) {
        listaVuelos.add(vuelo);
    }

    public List<Vuelo> buscarVuelos(String origen, String destino) {
        List<Vuelo> resultados = new ArrayList<>();
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.obtenerOrigen().equalsIgnoreCase(origen) &&
                vuelo.obtenerDestino().equalsIgnoreCase(destino)) {
                resultados.add(vuelo);
            }
        }
        return resultados;
    }

    public Reserva realizarReserva(Pasajero pasajero, Vuelo vuelo) {
        if (vuelo.reservarAsiento()) {
            Reserva reserva = new Reserva(pasajero, vuelo);
            listaReservas.add(reserva);
            return reserva;
        }
        return null;
    }

    public boolean cancelarReserva(String codigoReserva) {
        for (Reserva reserva : listaReservas) {
            if (reserva.obtenerCodigoReserva().equals(codigoReserva)) {
                reserva.obtenerVuelo().cancelarReserva();
                listaReservas.remove(reserva);
                return true;
            }
        }
        return false;
    }
}