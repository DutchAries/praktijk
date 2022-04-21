package YCNextPraktijk.Praktijk.Persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import YCNextPraktijk.Praktijk.Model.CheckIn;
import YCNextPraktijk.Praktijk.Model.Gebruiker;
import YCNextPraktijk.Praktijk.assembler.CheckinAssembler;
import YCNextPraktijk.Praktijk.dto.CheckinDTO;
import YCNextPraktijk.Praktijk.dto.GebruikerDTO;

@Service
public class Gebruiker_Service {
	@Autowired
	private Gebruiker_Repository gr;
	@Autowired
	private Check_In_Service cs;
	@Autowired
	private CheckinAssembler ca;
	
	
	public void slaGebruikerOp(Gebruiker geb) {
		System.out.println("Adding user " + geb.getGebruikersNaam());
		try {gr.save(geb);}
		catch (DataIntegrityViolationException e) {
			System.out.println(e);
		}
	}
	
	public Iterable<Gebruiker> alleGebruikers() {
		return gr.findAll();
	}
	
	public Optional<Gebruiker> login(String naam, String password) {
		Optional<Gebruiker> optional = gr.findByGebruikersNaam(naam);

		if (optional.isPresent()) {
			Gebruiker gevondenGebruiker = optional.get();
			
			if (gevondenGebruiker.getWachtwoord().equals(password)) {
				return optional;
			}
		}

		return Optional.empty();
	}
	
	public void deleteGebruiker(long id) {
		System.out.println("Deleting user "+gr.findById(id).get().getGebruikersNaam());
		for (CheckIn c : gr.findById(id).get().getCiList()) {
			System.out.println("Deleting CheckIn "+c.getId());
			cs.deleteCheck_In(c.getId());
		}
		gr.deleteById(id);
	}
	
	public void update(Gebruiker geb, long id) {
		Gebruiker geb2 = gr.findById(id).get();
		System.out.println("Updating user "+geb2.getGebruikersNaam());
		geb2.setGebruikersNaam(geb.getGebruikersNaam());
		geb2.setWachtwoord(geb.getWachtwoord());
		geb2.setDisplayNaam(geb.getDisplayNaam());
		geb2.setbeschrijving(geb.getbeschrijving());
		gr.save(geb2);
	}

	public void newCheckIn(long id, CheckIn c) {
		Gebruiker geb = gr.findById(id).get();
		c.setGebruiker(geb);
		cs.slaDezeCheck_InOp(c);
	}
	
	public Iterable<CheckIn> alleCheckins(long id) {
		Gebruiker geb = gr.findById(id).get();
		return geb.getCiList();
	}
	
	public Gebruiker vindGebruiker(long id) {
		return gr.findById(id).get();
	}
	
	public Optional<Gebruiker> vindGebruikerPerDisplayNaam(String dn) {
		return gr.findByDisplayNaam(dn);
	}
	
}
