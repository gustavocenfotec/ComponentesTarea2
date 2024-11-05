package cenfo.cr.tarea.Repository;

import cenfo.cr.tarea.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibroRepo extends JpaRepository<Libro, Long> {
}
