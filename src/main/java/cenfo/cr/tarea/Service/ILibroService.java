package cenfo.cr.tarea.Service;

import cenfo.cr.tarea.Entity.Libro;

import java.util.List;

public interface ILibroService {
    Long saveLibro(Libro nuevo);

    List<Libro> getLibros();

    Libro getLibro(long id);

    void updateLibro(Libro nuevoLibro);

    void deleteLibro(long id);
}
