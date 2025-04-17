package Herencias;

public class EmpleadoTiempoParcial extends Empleado {
	private int horasTrabajadas;
	
	public EmpleadoTiempoParcial(String nombre, int edad, double salarioBase, int horasTrabajadas) {
        super(nombre, edad, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
    }
	public int getHorasTrabajadas() {
        return horasTrabajadas;
    }	

    public double calcularSalario() {
        return salarioBase * horasTrabajadas;
    }
    @Override
    public String toString() {
        return super.toString()
            + ", Horas trabajadas: " + horasTrabajadas
            + ", Salario calculado:" + calcularSalario() + "€";
    }
}
