package biblioteca.model;
/**
 * Clase que representa un DVD como recurso dentro de la biblioteca.
 * 
 * Esta clase hereda de {@link RecursoBiblioteca} e implementa las características comunes
 * de un recurso físico específico del tipo DVD.
 */
public class DVD extends RecursoBiblioteca {

    /**
     * Crea un nuevo DVD con el ID y título especificados.
     *
     * @param id     ID único del DVD (por ejemplo, "D1").
     * @param titulo Título del DVD.
     */
    public DVD(String id, String titulo) {
        super(id, titulo);
    }
}