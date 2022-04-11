package YCNextPraktijk.Praktijk.Persistence;

import YCNextPraktijk.Praktijk.Model.CheckIn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Check_In_Repository extends CrudRepository<CheckIn, Long> {
	List<CheckIn> findCheckInsByBordspel(String bordspel);
}
