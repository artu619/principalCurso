package biblioteca.model;

import biblioteca.enums.EstadoRecurso;

/**
 * Clase abstracta que representa un recurso genérico de la biblioteca.
 * Sirve como base para clases concretas como Libro, Revista y DVD.
 */


public class RecursoBiblioteca {
	protected String id;         // ID único del recurso (ej: L1, R2, D3)
    protected String titulo;     // Título del recurso (ej: "Don Quijote")
    protected EstadoRecurso estado; // Estado actual del recurso (DISPONIBLE, PRESTADO, RESERVADO)
    
    
    /**
     * Constructor para inicializar un recurso de la biblioteca.
     * @param id Identificador único del recurso.
     * @param titulo Título del recurso.
     */

	    public RecursoBiblioteca(String id, String titulo) {
	        this.id = id;
	        this.titulo = titulo;
	        this.estado = EstadoRecurso.DISPONIBLE;
	    }
	    /**
	     * Obtiene el ID del recurso.
	     * @return ID del recurso.
	     */

	    
	    public String getId() {
	        return id;
	    }
	    /**
	     * Obtiene el estado actual del recurso.
	     * @return Estado (DISPONIBLE, PRESTADO, RESERVADO).
	     */
	    

	    public EstadoRecurso getEstado() {
	        return estado;
	    }

	    public void prestar() {
	        if (estado == EstadoRecurso.DISPONIBLE) {
	            estado = EstadoRecurso.PRESTADO;
	            System.out.println(titulo + " ha sido prestado.");
	        } else {
	            System.out.println(titulo + " no está disponible para préstamo.");
	        }
	    }

	    public void devolver() {
	        if (estado == EstadoRecurso.PRESTADO) {
	            estado = EstadoRecurso.DISPONIBLE;
	            System.out.println(titulo + " ha sido devuelto.");
	        } else {
	            System.out.println(titulo + " no estaba prestado.");
	        }
	    }
	    /**
	     * Representación textual del recurso.
	     * Sobrescribe el método toString para mostrar info útil.
	     */

	    @Override
	    public String toString() {
	        return "[" + id + "] " + titulo + " (" + estado + ")";
	    }
	   
	    
	    public String getTitulo() {
	        return titulo;
	    }

}
