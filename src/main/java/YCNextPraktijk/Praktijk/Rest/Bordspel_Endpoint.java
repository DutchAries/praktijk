package YCNextPraktijk.Praktijk.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import YCNextPraktijk.Praktijk.Model.Bordspel;
import YCNextPraktijk.Praktijk.Model.CheckIn;
import YCNextPraktijk.Praktijk.Persistence.Bordspel_Service;
import YCNextPraktijk.Praktijk.Persistence.Check_In_Service;

@RestController
@RequestMapping("api/bordspellen")
public class Bordspel_Endpoint {

	@Autowired
	private Bordspel_Service bs;

	@Autowired
	private Check_In_Service cs;
	
	@GetMapping
	public Iterable<Bordspel> alleBordspellen() {
		System.out.println("alle checkins");
		return bs.geefBordspellenTerug();
	}
	
	@GetMapping("rating")
	public float rating(@RequestParam String naam) {
		Iterable<CheckIn> cl = cs.zoekCheckin(naam);
		float total = 0, count = 0;
		for (CheckIn c : cl) {
			total += c.getRating();
			count++;
		}
		return total/count;	
	}
	
	@PostMapping
	public void bordspel(@RequestBody Bordspel bo) {
		bs.slaBordspelOp(bo);	
	}
}
