package biblioteca.enums;
/**
 * Enum que representa el estado actual de un recurso en la biblioteca.
 * 
 * Los recursos pueden estar en tres posibles estados:
 * <ul>
 *   <li><b>DISPONIBLE</b>: El recurso está disponible para ser prestado.</li>
 *   <li><b>PRESTADO</b>: El recurso ha sido prestado a un usuario y no está disponible.</li>
 *   <li><b>RESERVADO</b>: El recurso ha sido reservado por un usuario y no está disponible para otros.</li>
 * </ul>
 */
public enum EstadoRecurso {
	DISPONIBLE,
    PRESTADO,
    RESERVADO
	
	

}
