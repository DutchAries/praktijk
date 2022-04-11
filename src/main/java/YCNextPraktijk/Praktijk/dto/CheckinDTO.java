package YCNextPraktijk.Praktijk.dto;

public class CheckinDTO {

	private String bordspel;
	private String locatie;
	private Boolean win;
	private Float rating;
	private String review;
	private String foto;
	
	public String getBordspel() {
		return bordspel;
	}
	public void setBordspel(String bordspel) {
		this.bordspel = bordspel;
	}
	public String getLocatie() {
		return locatie;
	}
	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}
	public Boolean getWin() {
		return win;
	}
	public void setWin(Boolean win) {
		this.win = win;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
