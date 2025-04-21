package biblioteca.model;

import biblioteca.enums.EstadoRecurso;


public class RecursoBiblioteca {
	 protected String id;
	    protected String titulo;
	    protected EstadoRecurso estado;

	    public RecursoBiblioteca(String id, String titulo) {
	        this.id = id;
	        this.titulo = titulo;
	        this.estado = EstadoRecurso.DISPONIBLE;
	    }

	    public String getId() {
	        return id;
	    }

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

	    @Override
	    public String toString() {
	        return "[" + id + "] " + titulo + " (" + estado + ")";
	    }
	   
	    
	    public String getTitulo() {
	        return titulo;
	    }

}
