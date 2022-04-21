package YCNextPraktijk.Praktijk.Persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import YCNextPraktijk.Praktijk.Model.Gebruiker;

@Component
public interface Gebruiker_Repository extends CrudRepository<Gebruiker, Long> {

	Optional<Gebruiker> findByGebruikersNaam(String gn);

	Optional<Gebruiker> findByDisplayNaam(String dn);

}
