package project.track;

/**
 * Enumeración que representa los diferentes tipos de pista en una carrera.
 * Cada tipo de pista tiene un número predeterminado de vueltas (defaultLaps).
 */

public enum TrackType {
	ROAD(1000),   // Pista de carretera con 1000 vueltas por defecto
    CIRCUIT(5000), // Circuito cerrado con 5000 vueltas por defecto
    OFFROAD(2000); // Terreno fuera de carretera con 2000 vueltas por defecto

    private final int defaultLaps;// Número predeterminado de vueltas
    
    /**
     * Constructor de la enumeración que asigna el número de vueltas por defecto.
     * @param defaultLaps Número de vueltas asociado al tipo de pista.
     */

    TrackType(int defaultLaps) {
        this.defaultLaps = defaultLaps;
    }
    /**
     * Obtiene el número de vueltas por defecto para el tipo de pista.
     * @return Número de vueltas predeterminado.
     */

    public int getDefaultLaps() {
        return defaultLaps;
    }
}