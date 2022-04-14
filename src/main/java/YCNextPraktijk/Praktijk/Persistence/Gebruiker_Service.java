package YCNextPraktijk.Praktijk.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import YCNextPraktijk.Praktijk.Model.CheckIn;
import YCNextPraktijk.Praktijk.Model.Gebruiker;
import YCNextPraktijk.Praktijk.Model.PriveGebruiker;
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
	
	public long findGebruikerID(String naam) {
		return gr.findByGebruikersNaam(naam).getId();
	}
	
	public void deleteGebruiker(long id) {
		Gebruiker geb = gr.findById(id).get();
		System.out.println("Deleting user "+gr.findById(id).get().getGebruikersNaam());
		if (geb instanceof PriveGebruiker) {
			PriveGebruiker pGeb = (PriveGebruiker)geb;
			for (CheckIn c : pGeb.getCiList()) {
				System.out.println("Deleting CheckIn "+c.getId());
				cs.deleteCheck_In(c.getId());
			}
		}
		gr.deleteById(id);
	}
	
	public void update(Gebruiker geb, long id) {
		if (gr.findById(id).get() instanceof PriveGebruiker) {
			PriveGebruiker geb2 = (PriveGebruiker)gr.findById(id).get();
			System.out.println("Updating user "+geb2.getGebruikersNaam());
			geb2.setGebruikersNaam(geb.getGebruikersNaam());
			geb2.setWachtwoord(geb.getWachtwoord());
			geb2.setDisplayNaam(geb.getDisplayNaam());
			geb2.setbeschrijving(geb.getbeschrijving());
			gr.save(geb2);
		}
	}

	public void newCheckIn(long id, CheckIn c) {
		if (gr.findById(id).get() instanceof PriveGebruiker) {
			PriveGebruiker geb = (PriveGebruiker)gr.findById(id).get();
			c.setGebruiker(geb);
			cs.slaDezeCheck_InOp(c);
		}
	}
	
	public Iterable<CheckIn> alleCheckins(long id) {
		if (gr.findById(id).get() instanceof PriveGebruiker) {
			PriveGebruiker geb = (PriveGebruiker)gr.findById(id).get();
			return geb.getCiList();
		}
		else return null;
	}
	
	public Gebruiker vindGebruiker(long id) {
		return gr.findById(id).get();
	}
	
	public Gebruiker vindGebruikerPerDisplayNaam(String dn) {
		return gr.findByDisplayNaam(dn);
	}
	
}
