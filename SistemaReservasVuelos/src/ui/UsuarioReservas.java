package ui;

import model.*;
import service.SistemaReservas;

import java.util.List;
import java.util.Scanner;

public class UsuarioReservas {
    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();

        // Vuelo de prueba
        sistema.agregarVuelo(new Vuelo("AV101", "Bogotá", "Medellín", "2025-05-01", 3));
        sistema.agregarVuelo(new Vuelo("AV102", "Bogotá", "Cartagena", "2025-05-02", 2));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENÚ DEL SISTEMA DE RESERVAS ===");
            System.out.println("1. Buscar vuelos");
            System.out.println("2. Realizar reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Origen: ");
                    String origen = scanner.nextLine();
                    System.out.print("Destino: ");
                    String destino = scanner.nextLine();
                    List<Vuelo> vuelos = sistema.buscarVuelos(origen, destino);
                    if (vuelos.isEmpty()) {
                        System.out.println("No se encontraron vuelos.");
                    } else {
                        System.out.println("Vuelos disponibles:");
                        for (Vuelo v : vuelos) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Nombre del pasajero: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Número de pasaporte: ");
                    String pasaporte = scanner.nextLine();
                    System.out.print("Número de vuelo: ");
                    String numeroVuelo = scanner.nextLine();

                    Vuelo vueloSeleccionado = null;
                    for (Vuelo v : sistema.buscarVuelos("", "")) {
                        if (v.obtenerNumeroVuelo().equalsIgnoreCase(numeroVuelo)) {
                            vueloSeleccionado = v;
                            break;
                        }
                    }

                    if (vueloSeleccionado == null) {
                        System.out.println("Vuelo no encontrado.");
                    } else {
                        Pasajero pasajero = new Pasajero(nombre, pasaporte);
                        Reserva reserva = sistema.realizarReserva(pasajero, vueloSeleccionado);
                        if (reserva != null) {
                            System.out.println("Reserva realizada exitosamente. Código: " + reserva.obtenerCodigoReserva());
                        } else {
                            System.out.println("No hay asientos disponibles.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código de reserva: ");
                    String codigo = scanner.nextLine();
                    if (sistema.cancelarReserva(codigo)) {
                        System.out.println("Reserva cancelada correctamente.");
                    } else {
                        System.out.println("Reserva no encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}