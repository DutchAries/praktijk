package YCNextPraktijk.Praktijk.Rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import YCNextPraktijk.Praktijk.Model.CheckIn;
import YCNextPraktijk.Praktijk.Model.Gebruiker;
import YCNextPraktijk.Praktijk.Persistence.Gebruiker_Service;
import YCNextPraktijk.Praktijk.assembler.CheckinAssembler;
import YCNextPraktijk.Praktijk.assembler.GebruikerAssembler;
import YCNextPraktijk.Praktijk.dto.CheckinDTO;
import YCNextPraktijk.Praktijk.dto.GebruikerDTO;
import YCNextPraktijk.Praktijk.dto.LoginRequestDto;

@RestController
@RequestMapping("api/gebruikers")
public class Gebruiker_Endpoint {
	@Autowired
	private Gebruiker_Service gs;
	
	@Autowired
	private GebruikerAssembler ga;
	
	@Autowired
	private CheckinAssembler ca;
	
	@GetMapping
	public Iterable<Gebruiker> alleGebruikers() {
		return gs.alleGebruikers();
	}

	@PostMapping
	public void nieuweGebruiker(@RequestBody Gebruiker geb) {
		gs.slaGebruikerOp(geb);	
	}

	@GetMapping("{id}")
	public GebruikerDTO vindGebruikerBijId(@PathVariable long id) {
		return ga.assemble(gs.vindGebruiker(id));
	}

	@PutMapping("{id}")
	public void updateGebruiker(@RequestBody Gebruiker geb, @PathVariable long id) {
		gs.update(geb, id);
	}

	@DeleteMapping("{id}")
	public void deleteGebruiker(@PathVariable long id, @RequestHeader("Authentication") Long ingelogdGebruikersId ) {
		// Als ingelogdGebruikersId ingevuld is vind die gebruiker
		if (ingelogdGebruikersId != null) {
			Gebruiker ingelogdGebruiker = gs.vindGebruiker(ingelogdGebruikersId);

			// rechten checken zoals heeft diegene de juist rollen om te verwijderen

			if (ingelogdGebruiker.getId() == id) {
				gs.deleteGebruiker(id);
			}
		}
	}
	
	@GetMapping("vind/{naam}")
	public GebruikerDTO vindGebruiker(@PathVariable String naam) {
		return ga.assemble(gs.vindGebruikerPerDisplayNaam(naam).get());
	}
	
	@PostMapping("login")
	public GebruikerDTO login(@RequestBody LoginRequestDto loginRequestDto) {
		Optional<Gebruiker> optional = gs.login(loginRequestDto.getGebruikersnaam(), loginRequestDto.getWachtwoord());
		if (optional.isPresent()) {
			// Gebruikers naam / Wahtwoord combinatie klopt
			Gebruiker gebruiker = optional.get();

			return ga.assemble(gebruiker);
		} else {
			// Gebruikers naam / Wahtwoord combinatie bestaat niet

			return null;
		}
	}
	
	@GetMapping("allecheckins/{id}")
	public Iterable<CheckinDTO> alleCheckins(@PathVariable long id) {
		return ca.alleCheckinDTOs(gs.alleCheckins(id));	
	}
	
	@PostMapping("newcheckin/{id}")
	public void nieuweCheckin(@RequestBody CheckIn c, @PathVariable long id) {
		gs.newCheckIn(id, c);
	}
}
