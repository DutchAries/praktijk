package YCNextPraktijk.Praktijk.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import YCNextPraktijk.Praktijk.Model.Bordspel;
import YCNextPraktijk.Praktijk.Persistence.Bordspel_Service;

@RestController
@RequestMapping("api/bordspellen")
public class Bordspel_Endpoint {

	@Autowired
	private Bordspel_Service bs;
	
	@GetMapping
	public Iterable<Bordspel> alleBordspellen() {
		System.out.println("alle checkins");
		return bs.geefBordspellenTerug();
	}
}
