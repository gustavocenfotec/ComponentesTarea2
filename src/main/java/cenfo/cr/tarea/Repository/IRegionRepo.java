package cenfo.cr.tarea.Repository;

import cenfo.cr.tarea.Entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegionRepo extends JpaRepository<Region, Long> {
}
