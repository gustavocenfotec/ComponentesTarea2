package cenfo.cr.tarea.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

    private String editorial;

    private int edicion;

    public Libro() {
    }

    public Libro(long id, String titulo, String autor, String fechaPublicacion, String editorial, int edicion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.edicion = edicion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    //    public int getFechaPublicacion() {
//        return fechaPublicacion;
//    }
//
//    public void setFechaPublicacion(int fechaPublicacion) {
//        this.fechaPublicacion = fechaPublicacion;
//    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", editorial='" + editorial + '\'' +
                ", edicion=" + edicion +
                '}';
    }
}
