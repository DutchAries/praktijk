package YCNextPraktijk.Praktijk.Persistence;

import YCNextPraktijk.Praktijk.Model.Bordspel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bordspel_Repository extends CrudRepository<Bordspel, Long> {
}
