package YCNextPraktijk.Praktijk.dto;

public class GebruikerDTO {

	private long gebruikersId;
	private String displayNaam;
	private String beschrijving;
	private String profilePicture;
	
	public long getGebruikersId() {
		return gebruikersId;
	}
	
	public void setGebruikersId(long gebruikersId) {
		this.gebruikersId = gebruikersId;
	}

	public String getDisplayNaam() {
		return displayNaam;
	}
	public void setDisplayNaam(String displayNaam) {
		this.displayNaam = displayNaam;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
}
