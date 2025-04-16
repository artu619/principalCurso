package Erencias;

public class Empleado {
	protected String nombre;
	protected int edad;
	protected double salarioBase;
	
	public Empleado (String nombre, int edad, double salarioBase) {
		if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser menor que 0.");
            }
		this.nombre = nombre;
        this.edad = edad;
        this.salarioBase = salarioBase;
		
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Edad: " + edad + ", Salario base:" + salarioBase + "€ ";
	}
	
	

}
