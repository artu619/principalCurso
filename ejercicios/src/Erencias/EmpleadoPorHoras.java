package Erencias;

public class EmpleadoPorHoras extends Empleado {
	private double eurosHora;
    private int horasMensuales;

    public EmpleadoPorHoras(String nombre, int edad, double eurosHora, int horasMensuales) {
        super(nombre, edad, eurosHora * horasMensuales); // Guardamos el salario mensual como salarioBase
        if (eurosHora < 0 || horasMensuales < 0) {
            throw new IllegalArgumentException("Euros por hora y horas mensuales deben ser mayores o iguales a 0.");
        }
        this.eurosHora = eurosHora;
        this.horasMensuales = horasMensuales;
    }

    public double getEurosHora() {
        return eurosHora;
    }

    public int getHorasMensuales() {
        return horasMensuales;
    }

    public double calcularSalario() {
        return eurosHora * horasMensuales;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               ", Edad: " + edad +
               ", Pago por hora: " + eurosHora + "€" +
               ", Horas mensuales: " + horasMensuales +
               ", Salario mensual:" + calcularSalario() + "€";
    }


}
