package YCNextPraktijk.Praktijk.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import YCNextPraktijk.Praktijk.Model.Gebruiker;
import YCNextPraktijk.Praktijk.dto.GebruikerDTO;

@Component
public class GebruikerAssembler {
	
	@Autowired 
	private CheckinAssembler ca;
	
	public GebruikerDTO assemble (Gebruiker gebruiker) {
		
		GebruikerDTO dto = new GebruikerDTO();
		dto.setGebruikersId(gebruiker.getId());
		dto.setBeschrijving(gebruiker.getbeschrijving());
		dto.setDisplayNaam(gebruiker.getDisplayNaam());
		dto.setProfilePicture(gebruiker.getProfilePicture());
		dto.setCheckins(ca.alleCheckinDTOs(gebruiker.getCiList()));
		
		return dto;
	}	
	
	public Iterable<GebruikerDTO> alleGebruikerDTOs(Iterable<Gebruiker> geb){
		List<GebruikerDTO> DTOList = new ArrayList<>();
		
		for(Gebruiker g: geb) {
			GebruikerDTO dto = assemble(g);
			DTOList.add(dto);
		}
	
		return DTOList;		
	}
	
	
}
