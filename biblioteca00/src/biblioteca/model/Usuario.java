package biblioteca.model;

import biblioteca.interfaces.Prestamista;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un usuario que puede tomar prestados recursos de la biblioteca.
 * Implementa la interfaz Prestamista.
 */

public class Usuario implements Prestamista {
	private String id; // Identificador único del usuario
    private String nombre; // Nombre del usuario
    private List<RecursoBiblioteca> recursosPrestados; // Lista de recursos actualmente prestados por el usuario
    /**
     * Constructor para crear un nuevo usuario.
     * @param id Identificador del usuario.
     * @param nombre Nombre del usuario.
     */
    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.recursosPrestados = new ArrayList<>();
    }
    /**
     * Método para prestar un recurso.
     * Cambia el estado del recurso a PRESTADO y lo agrega a la lista del usuario.
     * @param recurso El recurso a prestar.
     */
    
    @Override
    public void prestarRecurso(RecursoBiblioteca recurso) {
        if (recurso.getEstado().equals(biblioteca.enums.EstadoRecurso.DISPONIBLE)) {
            recurso.prestar();
            recursosPrestados.add(recurso);
        } else {
            System.out.println("No se puede prestar el recurso: " + recurso);
        }
    }
    /**
     * Método para devolver un recurso.
     * Cambia el estado del recurso a DISPONIBLE y lo elimina de la lista del usuario.
     * @param recurso El recurso a devolver.
     */
    
    @Override
    public void devolverRecurso(RecursoBiblioteca recurso) {
        if (recursosPrestados.contains(recurso)) {
            recurso.devolver();
            recursosPrestados.remove(recurso);
        } else {
            System.out.println("Este recurso no fue prestado por este usuario.");
        }
    }
    /**
     * Devuelve el id del recurso.
     * @return id del recurso.
     */

    public String getId() {
        return id;
    }
    /**
     * Devuelve el nombre del usuario.
     * @return nombre del usuario.
     */
    
    public String getNombre() {
        return nombre;
    }
    /**
     * Verifica si este usuario tiene prestado un recurso específico.
     * @param recurso El recurso a comprobar.
     * @return true si lo tiene prestado, false si no.
     */

    public boolean tienePrestado(RecursoBiblioteca recurso) {
        return recursosPrestados.contains(recurso);
    }

	

}
