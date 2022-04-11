package YCNextPraktijk.Praktijk.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import YCNextPraktijk.Praktijk.Model.Bordspel;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Bordspel_Service {

	@Autowired
	private Bordspel_Repository br;
	
	public Iterable<Bordspel> geefBordspellenTerug() {
		/* als je Borspel_Repository erft van JPARepository krijg je hier een List terug
		 't Is beiden goed maar als je in de lijst nog wat wilt stoppen of sorteren
		 moet je een List hebben, anders is Iterable ok/zelfs beter want
		 dan kun je hem dus niet kapot maken
		 enfin: lees een keer het verschil door tussen JPARepository en CRUDRepository
		 link: https://www.geeksforgeeks.org/spring-boot-difference-between-crudrepository-and-jparepository/
		 */
		return br.findAll();
	}

	@Transactional
	public void slaBordspelOp(Bordspel bs) {
		br.save(bs);
		System.out.println(bs);
	}	
}
