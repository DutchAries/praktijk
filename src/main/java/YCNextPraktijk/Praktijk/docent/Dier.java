package YCNextPraktijk.Praktijk.docent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String biologischeNaam;
}
