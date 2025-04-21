package biblioteca.model;

import biblioteca.interfaces.Prestamista;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Prestamista {
	private String id;
    private String nombre;
    private List<RecursoBiblioteca> recursosPrestados;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.recursosPrestados = new ArrayList<>();
    }
    
    @Override
    public void prestarRecurso(RecursoBiblioteca recurso) {
        if (recurso.getEstado().equals(biblioteca.enums.EstadoRecurso.DISPONIBLE)) {
            recurso.prestar();
            recursosPrestados.add(recurso);
        } else {
            System.out.println("No se puede prestar el recurso: " + recurso);
        }
    }
    
    @Override
    public void devolverRecurso(RecursoBiblioteca recurso) {
        if (recursosPrestados.contains(recurso)) {
            recurso.devolver();
            recursosPrestados.remove(recurso);
        } else {
            System.out.println("Este recurso no fue prestado por este usuario.");
        }
    }

    public String getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public boolean tienePrestado(RecursoBiblioteca recurso) {
        return recursosPrestados.contains(recurso);
    }

	

}
