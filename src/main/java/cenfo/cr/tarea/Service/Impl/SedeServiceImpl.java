package cenfo.cr.tarea.Service.Impl;


import cenfo.cr.tarea.Entity.Sede;

import cenfo.cr.tarea.Repository.ISedeRepo;
import cenfo.cr.tarea.Service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SedeServiceImpl implements ISedeService {

    @Autowired
    ISedeRepo sedeRepo;

    @Override
    public Long saveSede(Sede nuevo) {
        Sede saved = sedeRepo.save(nuevo);
        return saved.getId();
    }

    @Override
    public List<Sede> getSedes() {
        return sedeRepo.findAll();
    }

    @Override
    public Sede getSede(long id) {
        return sedeRepo.getReferenceById(id);
    }

    @Override
    public void updateSede(Sede nuevoSede) {
        sedeRepo.save(nuevoSede);

    }

    @Override
    public void deleteSede(long id) {
        sedeRepo.deleteById(id);

    }
}
