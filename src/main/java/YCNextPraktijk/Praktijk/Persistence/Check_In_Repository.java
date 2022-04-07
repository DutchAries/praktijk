package YCNextPraktijk.Praktijk.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import YCNextPraktijk.Praktijk.Model.CheckIn;

@Component
public interface Check_In_Repository extends JpaRepository<CheckIn, Long> {
	List<CheckIn> findCheckInsByBordspel(String bordspel);
}
