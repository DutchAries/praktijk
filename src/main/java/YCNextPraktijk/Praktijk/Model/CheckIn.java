package YCNextPraktijk.Praktijk.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class CheckIn {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	private String bordspel;
	private String locatie;
	private Boolean win;
	
	@Column(nullable=false)
	private Float rating;
	private String review;
	
	@Lob
	@Column(length = 1000000000)
	private String foto;
	
	@ManyToOne
    @JoinColumn(name = "gebruiker_id")
    private PriveGebruiker gebruiker;
	
	public PriveGebruiker getGebruiker() {
		return gebruiker;
	}
	public void setGebruiker(PriveGebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
