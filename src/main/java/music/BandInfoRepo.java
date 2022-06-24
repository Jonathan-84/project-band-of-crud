package music;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BandInfoRepo extends CrudRepository<BandsInfo, Long> {
}
