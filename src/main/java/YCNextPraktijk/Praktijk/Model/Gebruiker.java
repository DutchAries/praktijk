package YCNextPraktijk.Praktijk.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public abstract class Gebruiker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	@Column(unique=true)
	private String gebruikersNaam;
	private String wachtwoord; // TODO: Use security tools
	@Column(unique=true)
	private String displayNaam;
	private String beschrijving;
	private String profilePicture;
	//private String socialMedia;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGebruikersNaam() {
		return gebruikersNaam;
	}
	public void setGebruikersNaam(String gebruikersNaam) {
		this.gebruikersNaam = gebruikersNaam;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	public String getDisplayNaam() {
		return displayNaam;
	}
	public void setDisplayNaam(String displayNaam) {
		this.displayNaam = displayNaam;
	}
	public String getbeschrijving() {
		return beschrijving;
	}
	public void setbeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

}
