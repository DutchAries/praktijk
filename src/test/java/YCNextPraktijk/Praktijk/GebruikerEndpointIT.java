package YCNextPraktijk.Praktijk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import YCNextPraktijk.Praktijk.Model.Gebruiker;
import YCNextPraktijk.Praktijk.Rest.Gebruiker_Endpoint;
import YCNextPraktijk.Praktijk.dto.GebruikerDTO;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@ActiveProfiles("integrationtest")
public class GebruikerEndpointIT {

    @Autowired
    private Gebruiker_Endpoint gebruikerEndpoint;

    @Test
    public void test1InsertAGebruiker() {

        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setbeschrijving("Admin");
        gebruiker.setGebruikersNaam("franc");
        gebruiker.setDisplayNaam("Franc van der Laan");

        this.gebruikerEndpoint.nieuweGebruiker(gebruiker);
    }

    @Test
    public void test2HaalGebruikersOp() {
        Iterable<Gebruiker> gebruikers = this.gebruikerEndpoint.alleGebruikers();

        Gebruiker fetch = gebruikers.iterator().next();
        assertEquals("Admin", fetch.getbeschrijving());
    }

    @Test
    public void test3Haal1GebruikerOp() {
        GebruikerDTO fetch = this.gebruikerEndpoint.vindGebruiker("Franc van der Laan");
        assertEquals("Franc van der Laan", fetch.getDisplayNaam());
    }

    @Test
    public void test4Remove1Gebruiker() {

        // en remove
        long id = this.gebruikerEndpoint.login("franc");
        assertTrue(id != 0);
        this.gebruikerEndpoint.deleteGebruiker(id);


        Iterable<Gebruiker> iterable  = this.gebruikerEndpoint.alleGebruikers();
        iterable.forEach(c -> {
            Assertions.fail("Should be no element in the Iterable");
        });
    }
}
