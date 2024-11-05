package cenfo.cr.tarea.Service.Impl;

import cenfo.cr.tarea.Entity.Libro;
import cenfo.cr.tarea.Repository.ILibroRepo;
import cenfo.cr.tarea.Service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService {

    @Autowired
    ILibroRepo libroRepo;
    @Override
    public Long saveLibro(Libro nuevo) {

        Libro saved = libroRepo.save(nuevo);
        return saved.getId();
    }

    @Override
    public List<Libro> getLibros() {

        return libroRepo.findAll();
    }

    @Override
    public Libro getLibro(long id) {
        return libroRepo.getReferenceById(id);
    }

    @Override
    public void updateLibro(Libro nuevoLibro) {
        libroRepo.save(nuevoLibro);

    }

    @Override
    public void deleteLibro(long id) {
        libroRepo.deleteById(id);

    }
}
