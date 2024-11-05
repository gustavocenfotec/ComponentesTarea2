package cenfo.cr.tarea.Service.Impl;

import cenfo.cr.tarea.Entity.Region;
import cenfo.cr.tarea.Repository.IRegionRepo;
import cenfo.cr.tarea.Service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    IRegionRepo regionRepo;
    @Override
    public Long saveRegion(Region nuevo) {
        Region saved = regionRepo.save(nuevo);
        return saved.getId();
    }

    @Override
    public List<Region> getRegiones() {
        return regionRepo.findAll();
    }

    @Override
    public Region getRegion(long id) {
        return regionRepo.getReferenceById(id);
    }
}
