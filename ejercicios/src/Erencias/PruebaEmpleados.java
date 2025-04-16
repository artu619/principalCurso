package Erencias;

public class PruebaEmpleados {

    public static void main(String[] args) {

        try {
            EmpleadoTiempoCompleto empCompleto = new EmpleadoTiempoCompleto("Ana López", 35, 3000.0, 1500.0);
            System.out.println("Empleado a tiempo completo:");
            System.out.println(empCompleto);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear empleado a tiempo completo: " + e.getMessage());
        }

        try {
            EmpleadoTiempoParcial empParcial = new EmpleadoTiempoParcial("Carlos Pérez", 25, 15.0, 21);
            System.out.println("\nEmpleado a tiempo parcial:");
            System.out.println(empParcial);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear empleado a tiempo parcial: " + e.getMessage());
        }

        try {
            EmpleadoTiempoParcial empParcial1 = new EmpleadoTiempoParcial("Pablo Pérez", 22, 1200.0, 24);
            System.out.println("\nEmpleado a tiempo parcial:");
            System.out.println(empParcial1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear empleado a tiempo parcial: " + e.getMessage());
        }

        try {
            EmpleadoPorHoras empHoras = new EmpleadoPorHoras("Laura Martínez", 28, 500, 160);
            System.out.println("\nEmpleado por horas:");
            System.out.println(empHoras);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear empleado por horas: " + e.getMessage());
        }
    }
}
