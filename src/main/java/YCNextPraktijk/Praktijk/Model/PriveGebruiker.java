package YCNextPraktijk.Praktijk.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class PriveGebruiker extends Gebruiker {

	@OneToMany(mappedBy = "gebruiker")
	private List<CheckIn> ciList;
	
	public List<CheckIn> getCiList() {
		return ciList;
	}
	public void setCiList(List<CheckIn> ciList) {
		this.ciList = ciList;
	}
	
}
