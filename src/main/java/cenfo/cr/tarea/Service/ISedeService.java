package cenfo.cr.tarea.Service;


import cenfo.cr.tarea.Entity.Sede;

import java.util.List;

public interface ISedeService {

    Long saveSede(Sede nuevo);

    List<Sede> getSedes();

    Sede getSede(long id);

    void updateSede(Sede nuevoSede);

    void deleteSede(long id);
}
