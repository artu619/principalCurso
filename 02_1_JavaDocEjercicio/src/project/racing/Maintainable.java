package project.racing;

/**
 * Interfaz que define el comportamiento de mantenimiento para vehículos de carreras.
 * Permite verificar si un vehículo necesita servicio y realizar mantenimiento preventivo.
 */

public interface Maintainable {
	/**
     * Realiza el mantenimiento del vehículo.
     * Dependiendo de la implementación, puede incluir cambios de aceite, revisión de frenos, etc.
     */
    void performMaintenance();
    /**
     * Verifica si el vehículo requiere servicio basado en condiciones específicas.
     * @return true si el vehículo necesita mantenimiento, false en caso contrario.
     */
    boolean needsService();
}