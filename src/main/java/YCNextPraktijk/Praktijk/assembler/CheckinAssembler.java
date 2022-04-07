package YCNextPraktijk.Praktijk.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import YCNextPraktijk.Praktijk.Model.CheckIn;
import YCNextPraktijk.Praktijk.dto.CheckinDTO;

@Component
public class CheckinAssembler {

	public CheckinDTO assemble (CheckIn checkin) {
		
		CheckinDTO dto = new CheckinDTO();
		dto.setBordspel(checkin.getBordspel());
		dto.setLocatie(checkin.getLocatie());
		dto.setRating(checkin.getRating());
		dto.setReview(checkin.getReview());
		dto.setWin(checkin.getWin());
		dto.setFoto(checkin.getFoto());
		
		return dto;
	}

	public Iterable<CheckinDTO> alleCheckinDTOs(Iterable<CheckIn> it){
		List<CheckinDTO> DTOList = new ArrayList<>();
		
		for(CheckIn c: it) {
			CheckinDTO dto = assemble(c);
			DTOList.add(dto);
		}
	
		return DTOList;		// variable names in Java start with lowercase (e.g. dtoList)
	}
	
}
