package cenfo.cr.tarea.Service;

import cenfo.cr.tarea.Entity.Region;

import java.util.List;

public interface IRegionService {

    Long saveRegion(Region nuevo);

    List<Region> getRegiones();

    Region getRegion(long id);
}
